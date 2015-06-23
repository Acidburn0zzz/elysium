%% DO NOT EDIT this file manually; it is automatically
%% generated from LSR http://lsr.dsi.unimi.it
%% Make any changes in LSR itself, or in Documentation/snippets/new/ ,
%% and then run scripts/auxiliar/makelsr.py
%%
%% This file is in the public domain.
\version "2.16.0"

\header {
  lsrtags = "text, vocal-music"

  texidoc = "
By default, lyrics syllables that start a melisma are left aligned on
their note.  The alignment can be altered using the
@code{lyricMelismaAlignment} property.

"
  doctitle = "Aligning syllables with melisma"
} % begin verbatim

\score {
  <<
    \new Staff {
      \relative c''
      \new Voice = "vocal" {
        c d~^\markup default  d e
        c d~^\markup "right aligned" d e
        c d~^\markup "center aligned" d e
        c d~^\markup "reset to default" d e
      }
    }
    \new Lyrics \lyricsto "vocal" \lyricmode {
      word word word
      \set lyricMelismaAlignment = #RIGHT
      word word word
      \set lyricMelismaAlignment = #CENTER
      word word word
      \unset lyricMelismaAlignment
      word word word
    }
  >>
}