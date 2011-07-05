package org.elysium.importuri;

import java.io.File;
import java.net.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import com.google.inject.Inject;

/**
 * Resolves importURIs by first searching in LilyPond's default include path.
 */
public class LilyPondImportUriResolver extends ImportUriResolver {

	@Inject
	private ILilyPondPathProvider lilyPondPathProvider;

	@Override
	public String resolve(EObject object) {
		String importUri = super.resolve(object);
		if (importUri != null) {
			String path = lilyPondPathProvider.get();
			URI pathUri = new File(path).toURI();
			URI resolvedImportUri = pathUri.resolve("../share/lilypond/current/ly/").resolve(importUri); //$NON-NLS-1$
			File importedFile = new File(resolvedImportUri);
			if (importedFile.exists()) {
				return resolvedImportUri.toString();
			}
		}
		return importUri;
	}

}
