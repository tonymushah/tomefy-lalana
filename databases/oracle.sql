-- L'information sur la route

create table tablepoint(
    id int,
    x number,
    y number
);
create table lalana(
    id int ,
    nom text ,
    pointArrivee foreign key(tablepoint id),
    pointDepart foreign key(tablepoint id),
    distance number,
    largeur number,
);

create table sous_lalana_correspondance(
    id int ,
    idLalanaMere foreign key(lalana id),
    idLalanaFille foreign key(lalana id),
    idOrdApparition int 
);

-- left join 
create table obstacle(
    id int,
    idLalanaMere foreign key(lalana id),
    pourcentageReduction number ,
    distanceArrivee number ,
    distanceDepart number ,
);

