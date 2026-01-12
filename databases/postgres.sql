-- L'information sur la voiture :

create table voiture_type(
    id serial primary key,
    libele text not null
    -- 4*4 , caterelle ...
);

create table voiture (
    id serial primary key,
    idVoitureType int references voiture_type(id) not null,
    largeur numeric not null,
    longueur numeric not null,
    vitesseMax numeric not null
);