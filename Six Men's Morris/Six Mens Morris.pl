%Cuadrado Externo.
trans(q1, a, q2).
trans(q2, a, q3).
trans(q3, a, q4).
trans(q4, a, q5).
trans(q5, a, q6).
trans(q6, a, q7).
trans(q7, a, q8).
trans(q8, a, q1).

trans(q2, a, q1).
trans(q3, a, q2).
trans(q4, a, q3).
trans(q5, a, q4).
trans(q6, a, q5).
trans(q7, a, q6).
trans(q7, a, q8).
trans(q1, a, q8).

%Lista de espacios libres.


%Laterales, Superior e Inferior.
   %Lateral Izquierdo.
    trans(q8, a, q9).
    trans(q9, a, q8).
   %Lateral Derecho.
    trans(q4, a, q13).
    trans(q13, a, q4).
   %Superior.
    trans(q2, a, q11).
    trans(q11, a, q2).
   %Inferior.
    trans(q6, a, q15).
    trans(q15, a, q6).

%Cuadro Interno.
trans(q9, a, q10).
trans(q10, a, q11).
trans(q11, a, q12).
trans(q12, a, q13).
trans(q13, a, q14).
trans(q14, a, q15).
trans(q15, a, q16).
trans(q16, a, q9).

trans(q10, a, q9).
trans(q11, a, q10).
trans(q12, a, q11).
trans(q13, a, q12).
trans(q14, a, q13).
trans(q15, a, q14).
trans(q16, a, q15).
trans(q9, a, q16).

%Tres en linea cuadro externo.
linea(q1,q2,q3).
linea(q3,q4,q5).
linea(q5,q6,q7).
linea(q7,q8,q1).

linea(q1,q8,q7).
linea(q7,q6,q5).
linea(q5,q4,q3).
linea(q3,q2,q1).

%Tres en linea cuadro interno.
linea(q10,q9,q16).
linea(q10,q11,q12).
linea(q12,q13,q14).
linea(q14,q15,q16).

linea(q16,q9,q10).
linea(q16,q15,q14).
linea(q14,q13,q12).
linea(q12,q11,q10).


%Jugadas.
%Posiciones Bloqueadas (Absolute Win).
 %Cuadro Exterior
  bloqueo(q1, [q2,q8], 0).
  bloqueo(q2, [q1, q3, q11], 0).
  bloqueo(q3, [q2, q4], 0).
  bloqueo(q4, [q3, q5, q13], 0).
  bloqueo(q5, [q4, q6], 0).
  bloqueo(q6, [q5, q7, q15], 0).
  bloqueo(q7, [q6, q8], 0).
  bloqueo(q8, [q1, q7, q9], 0).
 %Cuadro Interior
  bloqueo(q9, [q10,q8, 16], 0).
  bloqueo(q10, [q9, q11], 0).
  bloqueo(q11, [q2, q10, q12], 0).
  bloqueo(q12, [q11, q13], 0).
  bloqueo(q13, [q4, q12, q13], 0).
  bloqueo(q14, [q13, q15], 0).
  bloqueo(q15, [q6, q14, q16], 0).
  bloqueo(q16, [q9, q15], 0).















