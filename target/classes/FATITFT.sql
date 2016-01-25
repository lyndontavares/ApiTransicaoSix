--<ScriptOptions statementTerminator=";"/>

CREATE TABLE FATITFT (
		NCODIFATU NUMBER(8 , 0) NOT NULL,
		NNUMEITFT NUMBER(3 , 0) NOT NULL,
		NCODIMERC NUMBER(6 , 0) NOT NULL,
		NQUANITFT NUMBER(15 , 4) NOT NULL,
		NVLUNITFT NUMBER(19 , 8) DEFAULT 0

 NOT NULL,
		COBS_ITFT VARCHAR2(4000),
		NVLIDITFT NUMBER(19 , 8) DEFAULT 0  NOT NULL,
		CTPEBITFT VARCHAR2(1) DEFAULT 'F'  NOT NULL,
		NVLIVITFT NUMBER(19 , 8) DEFAULT 0  NOT NULL,
		NCODICIVA NUMBER NOT NULL,
		NVLISITFT NUMBER(19 , 8) DEFAULT 0  NOT NULL,
		NCODITBPR NUMBER(3 , 0),
		NCUOPITFT NUMBER(17 , 6),
		NPCFIITFT NUMBER(5 , 2),
		NVLBOITFT NUMBER(17 , 6),
		NQTBOITFT NUMBER(17 , 6),
		NPCOMITFT NUMBER(6 , 2),
		NVLTBITFT NUMBER(15 , 6),
		NVMPRITFT NUMBER(17 , 6)
	);

CREATE UNIQUE INDEX PK_FATITFT ON FATITFT (NCODIFATU ASC, NNUMEITFT ASC);

CREATE INDEX FK_FATITFT_NCODICIVA ON FATITFT (NCODICIVA ASC);

CREATE INDEX IFK_NCODIMERC_FATITFT ON FATITFT (NCODIMERC ASC);

CREATE INDEX IFK_NCODIFATU_FATITFT ON FATITFT (NCODIFATU ASC);

ALTER TABLE FATITFT ADD CONSTRAINT PK_FATITFT PRIMARY KEY (NCODIFATU, NNUMEITFT);

ALTER TABLE FATITFT ADD CONSTRAINT FK_FATITFT_NCODICIVA FOREIGN KEY (NCODICIVA)
	REFERENCES CFGCIVA (NCODICIVA)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE FATITFT ADD CONSTRAINT FK_NCODIFATU_FATITFT FOREIGN KEY (NCODIFATU)
	REFERENCES FATFATU (NCODIFATU)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

ALTER TABLE FATITFT ADD CONSTRAINT FK_NCODITBPR_FATTBPR FOREIGN KEY (NCODITBPR)
	REFERENCES FATTBPR (NCODITBPR)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE FATITFT ADD CONSTRAINT FK_NCODIMERC_FATITFT FOREIGN KEY (NCODIMERC)
	REFERENCES FATMERC (NCODIMERC)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

