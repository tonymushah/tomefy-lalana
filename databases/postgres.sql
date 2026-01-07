-- L'information sur la voiture :

create table voiture_type(
    id int ,
    libele
-- 4*4 , caterelle ...
)
create table voiture (
    id int,
    idVoitureType int foreign key(voiture_type id),
    largeur number ,
    longueur number ,
    vitesseMax number
);