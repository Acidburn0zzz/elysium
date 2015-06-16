package org.elysium.test.integration;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Math.min;
import static javax.util.file.FileUtils.readFileAsString;
import static org.eclipse.emf.common.util.URI.createURI;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.util.file.FilenameExtensionFilter;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit.validation.AssertableDiagnostics;
import org.eclipse.xtext.resource.XtextResource;
import org.elysium.LilyPondConstants;
import org.elysium.lilypond.Assignment;
import org.elysium.lilypond.LilyPond;
import org.elysium.test.LilyPondTestWithValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;

@RunWith(value = Parameterized.class)
public class Integration extends LilyPondTestWithValidator {

	private static final Pattern pattern=Pattern.compile("[\\r\\n]+(\\w+)\\s=");

	private Iterable<Object> getErrors(String filePath) throws Exception {
		String model = readFileAsString(filePath);
		XtextResource resource = doGetResource(getAsStream(model), createURI("test"));
		lilyPondmodel=(LilyPond)resource.getContents().get(0);
		EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> parseErrors = resource.getErrors();
		AssertableDiagnostics validationDiagnostics = tester.validate(lilyPondmodel);
		Iterable<Diagnostic> validationErrors = filter(validationDiagnostics.getAllDiagnostics(), new Predicate<Diagnostic>() {
			@Override
			public boolean apply(Diagnostic input) {
				return input.getSeverity() == Diagnostic.ERROR;
			}
		});
		return concat(parseErrors, validationErrors);
	}

	private final String filePath;
	private LilyPond lilyPondmodel;

	public Integration(String filePath, String shortFilePath) {
		this.filePath = filePath;
	}

	private static final String[] DIRECTORY_NAMES = {
		"init",
		"snippets"
	};

	@Parameters(name = "{1}")
	public static Collection<Object[]> data() {
		Collection<Object[]> result = newArrayList();
		URI baseFileURI=new File(".").toURI();
		
		for (String directoryName : DIRECTORY_NAMES) {
			File directory = new File(directoryName);
			for (File file : directory.listFiles(new FilenameExtensionFilter(LilyPondConstants.EXTENSION))) {
				String shortFile = baseFileURI.relativize(file.toURI()).toString();
				result.add(new Object[] { file.getAbsolutePath(), shortFile});
			}
		}
		return result;
	}

	private static int getColumn(String[] lines, int line, int offset) {
		int lineOffset = 0;
		for (int i = 0; i < min(lines.length, line); i++) {
			lineOffset += lines[i].length() + 1;
		}
		return offset - lineOffset;
	}

	private List<String> getAssigmnetsFromModelString() throws IOException{
		ArrayList<String> result = new ArrayList<String>();
		Matcher matcher = pattern.matcher(readFileAsString(filePath));
		while(matcher.find()){
			result.add(matcher.group(1));
		}
		return result;
	}

	private List<String> getAssignmentsFromModel(){
		ArrayList<String> result = new ArrayList<String>();
		List<Assignment> assignemts = EcoreUtil2.getAllContentsOfType(lilyPondmodel, Assignment.class);
		for (Assignment assignment : assignemts) {
			result.add(assignment.getName());
		}
		return result;
	}

	private void copyCurrentFileToFailingTestsFolder() throws Exception{
		File currentFile = new File(filePath);
		Files.copy(currentFile, new File("failingIntegrationTests", currentFile.getName()));
	}

	@Test
	public void parse()  throws Exception{
		Iterable<Object> errors = getErrors(filePath);
		boolean hasErrors = errors.iterator().hasNext();
		if (hasErrors) {
			String[] lines = readFileAsString(filePath).split("\\r?\\n");
			for (Object error : errors) {
				if (error instanceof org.eclipse.xtext.diagnostics.Diagnostic) {
					org.eclipse.xtext.diagnostics.Diagnostic diagnostic = (org.eclipse.xtext.diagnostics.Diagnostic)error;
					int line = diagnostic.getLine() - 1;
					int column = getColumn(lines, line, diagnostic.getOffset());
					System.out.println(MessageFormat.format("{0}:{1}:{2}", filePath.substring(filePath.lastIndexOf('/') + 1), line + 1, column));
					System.out.println(lines[line]);
					System.out.println(String.format("%1$" + column + "s", "") + "^");
					System.out.println(diagnostic.getMessage());
					System.out.println();
				}
			}
			copyCurrentFileToFailingTestsFolder();
		}
		assertFalse(MessageFormat.format("{0} parse error(s)", Iterables.size(errors)), hasErrors);

		assertExpectedAssignmentsFoundInModel();
	}

	private void assertExpectedAssignmentsFoundInModel() throws Exception{
		List<String> missingAssignments = getAssigmnetsFromModelString();
		missingAssignments.removeAll(getAssignmentsFromModel());
		if(!missingAssignments.isEmpty()){
			System.out.println(MessageFormat.format("Expected assignments not found in {0}: {1}", new File(filePath).getName(), missingAssignments));
			copyCurrentFileToFailingTestsFolder();
			fail("missing assignments "+missingAssignments);
		}
	}

}
