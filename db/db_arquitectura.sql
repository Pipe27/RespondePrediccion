/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     17/02/2019 10:19:32 p. m.                    */
/*==============================================================*/


drop table CATEGORIA;

drop table PREGUNTA;

drop table RESPUESTA;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA (
   ID_CATEGORIA         SERIAL not null,
   CATEGORIA            VARCHAR(500)         not null,
   constraint PK_CATEGORIA primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: PREGUNTA                                              */
/*==============================================================*/
create table PREGUNTA (
   ID_PREGUNTA          SERIAL not null,
   ID_CATEGORIA         INT4                 null,
   PREGUNTA             VARCHAR(500)         not null,
   constraint PK_PREGUNTA primary key (ID_PREGUNTA)
);

/*==============================================================*/
/* Table: RESPUESTA                                             */
/*==============================================================*/
create table RESPUESTA (
   ID_RESPUESTA         SERIAL not null,
   ID_PREGUNTA          INT4                 null,
   RESPUESTA            VARCHAR(500)         not null,
   constraint PK_RESPUESTA primary key (ID_RESPUESTA)
);

alter table PREGUNTA
   add constraint FK_PREGUNTA_REFERENCE_CATEGORI foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA)
      on delete restrict on update restrict;

alter table RESPUESTA
   add constraint FK_RESPUEST_REFERENCE_PREGUNTA foreign key (ID_PREGUNTA)
      references PREGUNTA (ID_PREGUNTA)
      on delete restrict on update restrict;

