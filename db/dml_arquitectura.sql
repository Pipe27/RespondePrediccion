/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     17/02/2019 9:17:53 p. m.                     */
/*==============================================================*/

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
INSERT INTO categoria (categoria) VALUES ('Fútbol'); --1
INSERT INTO categoria (categoria) VALUES ('Ciclimo'); --2
INSERT INTO categoria (categoria) VALUES ('Noticias'); --3
INSERT INTO categoria (categoria) VALUES ('Tecnología'); --4
INSERT INTO categoria (categoria) VALUES ('Ocio'); --5
INSERT INTO categoria (categoria) VALUES ('Clima'); --6
INSERT INTO categoria (categoria) VALUES ('Gimnasios'); --7
INSERT INTO categoria (categoria) VALUES ('Películas'); --8

/*==============================================================*/
/* Table: PREGUNTA                                              */
/*==============================================================*/
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuántos títulos de la UEFA Champions League tiene el Real Madrid?'); --1
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuántos subtítulos de la UEFA Champions League tiene el Real Madrid?'); --2
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál es el segundo equipo con más títulos de la UEFA Champions League?'); --3
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuántos títulos tiene el Barcelona F.C. de la UEFA Champions League?'); --4
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más partidos jugados en toda la historia de la UEFA?'); --5
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más goles en toda la historia de la UEFA?'); --6
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más asistencias en toda la historia de la UEFA?'); --7
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más penales anotados en toda la historia de la UEFA?'); --8
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más tarjetas rojas en toda la historia de la UEFA?'); --9
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido el jugador con más tarjetas amarillas en toda la historia de la UEFA?'); --10
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuáles han sido los años en que el América de Cali ha quedado en primer lugar de la Liga?'); --11
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido la mayor goleada a favor del América de Cali?'); --12
INSERT INTO pregunta (id_categoria, pregunta) VALUES (1,'¿Cuál ha sido la mayor goleada en contra del América de Cali?'); --13
INSERT INTO pregunta (id_categoria, pregunta) VALUES (2,'¿En qué año, Nairo Quintana quedó en primer lugar en el Giro de Italia?'); --14
INSERT INTO pregunta (id_categoria, pregunta) VALUES (2,'¿En qué año, Nairo Quintana quedó en primer lugar en la Vuelta a España?'); --15
INSERT INTO pregunta (id_categoria, pregunta) VALUES (8,'¿En qué fecha se estrenará la película Rápido y Furioso 9?'); --16

/*==============================================================*/
/* Table: RESPUESTA                                             */
/*==============================================================*/
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (1, '13 Títulos');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (2, '3 Subtítulos');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (3, 'A.C. Milan');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (4, '5 Títulos');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (5, 'Iker Casillas');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (6, 'Cristiano Ronaldo');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (7, 'Cristiano Ronaldo');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (8, 'Cristiano Ronaldo');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (9, 'Zlatan Ibrahimović');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (10, 'Sergio Ramos');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (11, 'En los años  1979, 1982, 1983, 1984, 1985, 1986, 1990, 1992, 1996/97, 2000, 2001, 2002-I, 2008-II');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (12, 'El 9-0 frente al Cúcuta Deportivo el 29 de agosto de 1990');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (13, 'El 7-2 contra Deportes Quindío el 25 de mayo de 1958');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (14, 'En 2014');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (15, 'En 2016');
INSERT INTO respuesta (id_pregunta, respuesta) VALUES (16, 'El 10 de abril de 2020');