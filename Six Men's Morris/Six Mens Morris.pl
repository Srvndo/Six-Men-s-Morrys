%Cuadrado Externo.
trans(q1, q2).
trans(q2, q3).
trans(q3, q4).
trans(q4, q5).
trans(q5, q6).
trans(q6, q7).
trans(q7, q8).
trans(q8, q1).

%Laterales, Superior e Inferior.
   %Lateral Izquierdo.
    trans(q8, q9).
   %Lateral Derecho.
    trans(q4, q13).
   %Superior.
    trans(q2, q11).
   %Inferior.
    trans(q6, q15).

%Cuadro Interno.
trans(q9, q10).
trans(q10, q11).
trans(q11, q12).
trans(q12, q13).
trans(q13, q14).
trans(q14, q15).
trans(q15, q16).
trans(q16, q9).

trans(X, Y) :- trans(Y, X).

%Tres en linea cuadro externo.
linea(q1,q2,q3).
  linea(q1,q3,q2).
  linea(q2,q1,q3).
  linea(q2,q3,q1).
  linea(q3,q1,q2).
  linea(q3,q2,q1).

linea(q3,q4,q5).
  linea(q3,q5,q4).
  linea(q4,q3,q5).
  linea(q4,q5,q3).
  linea(q5,q3,q4).
  linea(q5,q4,q3).

linea(q5,q6,q7).
  linea(q5,q7,q6).
  linea(q6,q7,q5).
  linea(q6,q5,q7).
  linea(q7,q5,q6).
  linea(q7,q6,q5).

linea(q7,q8,q1).
  linea(q7,q1,q8).
  linea(q8,q7,q1).
  linea(q8,q1,q7).
  linea(q1,q8,q7).
  linea(q1,q7,q8).

%Tres en linea cuadro interno.
linea(q10,q11,q12).
  linea(q10,q12,q11).
  linea(q11,q10,q12).
  linea(q11,q12,q10).
  linea(q12,q10,q11).
  linea(q12,11,q10).

linea(q12,q13,q14).
  linea(q12,q14,q13).
  linea(q13,q12,q14).
  linea(q13,q14,q12).
  linea(q14,q12,q13).
  linea(q14,13,q12).

linea(q14,q15,q16).
  linea(q14,q16,q15).
  linea(q15,q14,q16).
  linea(q15,q16,q14).
  linea(q16,q14,q15).
  linea(q16,15,q14).

linea(q16,q9,q10).
  linea(q16,q10,q9).
  linea(q9,q16,q10).
  linea(q9,q10,q16).
  linea(q10,q9,q16).
  linea(q10,16,q9).

%Jugadas.
%Posiciones Bloqueadas (Absolute Win).
 %Cuadro Exterior
  bloqueo(q1, [q2,q8]).
  bloqueo(q2, [q1, q3, q11]).
  bloqueo(q3, [q2, q4]).
  bloqueo(q4, [q3, q5, q13]).
  bloqueo(q5, [q4, q6]).
  bloqueo(q6, [q5, q7, q15]).
  bloqueo(q7, [q6, q8]).
  bloqueo(q8, [q1, q7, q9]).
 %Cuadro Interior
  bloqueo(q9, [q10,q8, 16]).
  bloqueo(q10, [q9, q11]).
  bloqueo(q11, [q2, q10, q12]).
  bloqueo(q12, [q11, q13]).
  bloqueo(q13, [q4, q12, q13]).
  bloqueo(q14, [q13, q15]).
  bloqueo(q15, [q6, q14, q16]).
  bloqueo(q16, [q9, q15]).

%Tres en linea
insertar(X,L,R):-
	select(X,R,L), linea(R).

checkLinea([X|L1],[X|L2]):-
	checkLinea(L1,L2).

sublista(L1,L2):- append(_L3,L4,L2), append(L1,_L5,L4).

permutacion([],[]).
permutacion(L1,[X|L2]):- select(X,L1,L3), permutacion(L3,L2).











