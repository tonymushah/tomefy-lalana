-- Insert test data into tablepoint
INSERT INTO tablepoint (id, x, y) VALUES (1, 10.0, 20.0);
INSERT INTO tablepoint (id, x, y) VALUES (2, 15.5, 25.5);
INSERT INTO tablepoint (id, x, y) VALUES (3, 30.2, 45.8);
INSERT INTO tablepoint (id, x, y) VALUES (4, 40.0, 50.0);
INSERT INTO tablepoint (id, x, y) VALUES (5, 50.5, 70.5);

-- Insert test data into lalana
INSERT INTO lalana (id, nom, pointArrivee, pointDepart, distance, largeur) 
VALUES (1, 'Route A', 1, 2, 5.5, 10.0);
INSERT INTO lalana (id, nom, pointArrivee, pointDepart, distance, largeur) 
VALUES (2, 'Route B', 2, 3, 15.0, 8.0);
INSERT INTO lalana (id, nom, pointArrivee, pointDepart, distance, largeur) 
VALUES (3, 'Route C', 3, 4, 7.5, 12.0);
INSERT INTO lalana (id, nom, pointArrivee, pointDepart, distance, largeur) 
VALUES (4, 'Route D', 4, 5, 10.0, 6.5);

-- Insert test data into sous_lalana_correspondance
INSERT INTO sous_lalana_correspondance (id, idLalanaMere, idLalanaFille, idOrdApparition) 
VALUES (1, 1, 2, 1);
INSERT INTO sous_lalana_correspondance (id, idLalanaMere, idLalanaFille, idOrdApparition)
VALUES (2, 2, 3, 2);
INSERT INTO sous_lalana_correspondance (id, idLalanaMere, idLalanaFille, idOrdApparition)
VALUES (3, 3, 4, 1);

-- Insert test data into obstacle
INSERT INTO obstacle (id, idLalanaMere, pourcentageReduction, distanceArrivee, distanceDepart) 
VALUES (1, 1, 10.0, 2.0, 1.0);
INSERT INTO obstacle (id, idLalanaMere, pourcentageReduction, distanceArrivee, distanceDepart) 
VALUES (2, 2, 20.0, 5.0, 3.0);
INSERT INTO obstacle (id, idLalanaMere, pourcentageReduction, distanceArrivee, distanceDepart) 
VALUES (3, 3, 15.0, 3.5, 2.5);