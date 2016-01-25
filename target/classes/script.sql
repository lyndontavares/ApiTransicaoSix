--dica mysql
SELECT 0 INTO @x;
select (@x:=@x+1) as rownumber FROM tab_localidade


CREATE TABLE APP_SEQ_STORE
(
	APP_SEQ_NAME VARCHAR(255) NOT NULL,
	APP_SEQ_VALUE BIGINT NOT NULL,
	PRIMARY KEY(APP_SEQ_NAME)
);

INSERT INTO APP_SEQ_STORE VALUES ('API_TABLE.PK', 0);
INSERT INTO APP_SEQ_STORE VALUES ('API_CAMPO.PK', 0);
INSERT INTO APP_SEQ_STORE VALUES ('TAB_LOCALIDADE.PK', 0);

-- Create table
create table API_TABLE
(
  id             INT not null,
  tabela_origem  VARCHAR(100) not null,
  tabela_destino VARCHAR(100) not null,
  sincronizar    int,
  chave_primaria VARCHAR(100)
);

create table  API_CAMPO
(
  id               int not null,
  tabela_id        int not null,
  nome_origem      VARCHAR(50) not null,
  nome_destino     VARCHAR(50) not null,
  tipo_origem      VARCHAR(20) not null,
  tipo_destino     VARCHAR(20) not null,
  tamanho_origem   int,
  tamanho_destino  int,
  precisao_origem  int,
  precisao_destino int,
  chave_primaria   int
);





select * from tab_localizacao

alter table API_TABLE add SINCRONIZAR number(1)
alter table API_TABLE add chave_primaria varchar2(100)

alter table api_campo add chave_primaria number(1);

SELECT * FROM API_CAMPO
SELECT * FROM API_TABLE

INSERT INTO 
API_CAMPO (
ID,  TABELA_ID, NOME_ORIGEM, TAMANHO_ORIGEM, TIPO_ORIGEM, NOME_DESTINO, TAMANHO_DESTINO, TIPO_DESTINO, CHAVE_PRIMARIA )
VALUES
( 1, 1, 'NCODILOCA', 10 ,'NUMBER' ,'id' , 10,'NUMBER', 1)


INSERT INTO 
API_CAMPO (
ID,  TABELA_ID, NOME_ORIGEM, TAMANHO_ORIGEM, TIPO_ORIGEM, NOME_DESTINO, TAMANHO_DESTINO, TIPO_DESTINO, CHAVE_PRIMARIA )
VALUES
( 2, 1, 'CNOMELOCA', 100 ,'STRING' ,'DESCRICAO' , 100,'STRING', 0)

UPDATE API_TABLE SET SINCRONIZAR=1;
UPDATE API_TABLE SET chave_primaria='NCODILOCA'
UPDATE API_CAMPO SET CHAV

drop sequence API_TABLE_SEQ
drop table api_table
drop trigger TAI_API_TABLE

create sequence API_TABLE_SEQ start  // with 1 increment by 1 nocache nocycle
 
create table API_TABLE ( 
 ID numeric not null  API_TABLE_SEQ.NEXTVAL primary key,
 TABELA_ORIGEM varchar2(100) not null,
 TABELA_DESTINO varchar2(100) not null
)

CREATE TRIGGER TAI_API_TABLE
  BEFORE INSERT ON API_TABLE
  FOR EACH ROW
BEGIN
   select API_TABLE_SEQ.nextval into :new.id from dual;
END;

commit

 
 
 insert into API_TABLE ( ID, TABELA_ORIGEM, TABELA_DESTINO) values ( 1, 'CFGENTIDAD', 'TAB_ENTIDADE' )
 
 select * from API_TABLE
 
 select API_TABLE_SEQ from dual
 
 commit
 
 select * from API_TABLE
 
 
 create table API_CAMPO ( 
       ID NUMBER NOT NULL PRIMARY KEY, 
       TABELA_ID NUMBER NOT NULL,
       NOME_ORIGEM VARCHAR2(50) NOT NULL,
       NOME_DESTINO VARCHAR2(50) NOT NULL,
       TIPO_ORIGEM VARCHAR2(20) NOT NULL,
       TIPO_DESTINO VARCHAR2(20) NOT NULL,
       TAMANHO_ORIGEM NUMBER,
       TAMANHO_DESTINO NUMBER,
       PRECISAO_ORIGEM NUMBER,
       PRECISAO_DESTINO NUMBER );
       