-- L'information sur la route
CREATE TABLE tablepoint (
	id NUMBER PRIMARY KEY,
	x NUMBER,
	y NUMBER
);

CREATE TABLE lalana (
	id NUMBER PRIMARY KEY,
	nom VARCHAR2(255) not null,
	pointArrivee NUMBER not null,
	pointDepart NUMBER not null,
	-- peut etre calculer dans l'application avec la formule de la distance euclidienne
	-- distance NUMBER not null, 
	largeur NUMBER not null,
	CONSTRAINT fk_lalana_pointArrivee FOREIGN KEY (pointArrivee) REFERENCES tablepoint(id),
	CONSTRAINT fk_lalana_pointDepart FOREIGN KEY (pointDepart) REFERENCES tablepoint(id)
);

CREATE TABLE sous_lalana_correspondance (
	id NUMBER PRIMARY KEY,
	idLalanaMere NUMBER not null,
	idLalanaFille NUMBER not null,
	idOrdApparition NUMBER not null,
	CONSTRAINT fk_sous_lalana_mere FOREIGN KEY (idLalanaMere) REFERENCES lalana(id),
	CONSTRAINT fk_sous_lalana_fille FOREIGN KEY (idLalanaFille) REFERENCES lalana(id)
);

-- left join 
CREATE TABLE obstacle (
	id NUMBER PRIMARY KEY,
	idLalanaMere NUMBER not null,
	pourcentageReduction NUMBER not null,
	distanceArrivee NUMBER not null,
	distanceDepart NUMBER not null,
	CONSTRAINT fk_obstacle_lalana FOREIGN KEY (idLalanaMere) REFERENCES lalana(id)
);

/*
CREATE SEQUENCE seq_tablepoint START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE
OR REPLACE TRIGGER trg_tablepoint_id BEFORE
INSERT
	ON tablepoint FOR EACH ROW
	WHEN (NEW.id IS NULL) BEGIN
SELECT
	seq_tablepoint.NEXTVAL INTO :NEW.id
FROM
	dual;

END;
/ 

CREATE SEQUENCE seq_lalana START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE
OR REPLACE TRIGGER trg_lalana_id BEFORE
INSERT
	ON lalana FOR EACH ROW
	WHEN (NEW.id IS NULL) BEGIN
SELECT
	seq_lalana.NEXTVAL INTO :NEW.id
FROM
	dual;

END;
/ 

CREATE SEQUENCE seq_sous_lalana_correspondance START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE
OR REPLACE TRIGGER trg_sous_lalana_correspondance_id BEFORE
INSERT
	ON sous_lalana_correspondance FOR EACH ROW
	WHEN (NEW.id IS NULL) BEGIN
SELECT
	seq_sous_lalana_correspondance.NEXTVAL INTO :NEW.id
FROM
	dual;

END;
/ 

CREATE SEQUENCE seq_obstacle START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE
OR REPLACE TRIGGER trg_obstacle_id BEFORE
INSERT
	ON obstacle FOR EACH ROW
	WHEN (NEW.id IS NULL) BEGIN
SELECT
	seq_obstacle.NEXTVAL INTO :NEW.id
FROM
	dual;

END;

/
*/