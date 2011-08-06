%% DO NOT EDIT this file manually; it is automatically
%% generated from LSR http://lsr.dsi.unimi.it
%% Make any changes in LSR itself, or in Documentation/snippets/new/ ,
%% and then run scripts/auxiliar/makelsr.py
%%
%% This file is in the public domain.
\version "2.14.0"

\header {
  lsrtags = "text, keyboards, template"

%% Translation of GIT committish: 615cbf212fdaf0b220b3330da417d0c3602494f2
  texidoces = "
En lugar de tener un pentagrama dedicado a la melodía y la letra, ésta
se puede centrar entre los pentagramas de un sistema de piano.

"
  doctitlees = "Plantilla de piano con letra centrada"


%% Translation of GIT committish: fa1aa6efe68346f465cfdb9565ffe35083797b86
  texidocja = "
旋律と歌詞のための譜表を持つ代わりに、歌詞をピアノ譜の 2 つの譜の間に置くことができます。
"

%% Translation of GIT committish: 0a868be38a775ecb1ef935b079000cebbc64de40
  texidocde = "
Anstatt ein eigenes System für Melodie und Text zu schreiben, können
Sie den Text auch zwischen die beiden Klaviersysteme schreiben
(und damit das zusätzliche System für die Gesangstimme auslassen).
"


%% Translation of GIT committish: bdfe3dc8175a2d7e9ea0800b5b04cfb68fe58a7a
  texidocfr = "
Lorsque la mélodie est doublée au piano, cela ne nécessite pas forcément
une portée spécifique.  Les paroles peuvent s'insérer entre les deux
portées de la partition pour piano.

"
  doctitlefr = "Piano et paroles entre les portées"

  texidoc = "
Instead of having a full staff for the melody and lyrics, lyrics can be
centered between the staves of a piano staff.

"
  doctitle = "Piano template with centered lyrics"
} % begin verbatim

upper = \relative c'' {
  \clef treble
  \key c \major
  \time 4/4

  a4 b c d
}

lower = \relative c {
  \clef bass
  \key c \major
  \time 4/4

  a2 c
}

text = \lyricmode {
  Aaa Bee Cee Dee
}

\score {
  \new GrandStaff <<
    \new Staff = upper { \new Voice = "singer" \upper }
    \new Lyrics \lyricsto "singer" \text
    \new Staff = lower { \lower }
  >>
  \layout {
    \context {
      \GrandStaff
      \accepts "Lyrics"
    }
    \context {
      \Lyrics
      \consists "Bar_engraver"
    }
  }
  \midi { }
}
