-- Insert test data into voiture_type
INSERT INTO voiture_type (id, libele) VALUES (1, 'Berline');
INSERT INTO voiture_type (id, libele) VALUES (2, 'SUV');
INSERT INTO voiture_type (id, libele) VALUES (3, 'Coupé');
INSERT INTO voiture_type (id, libele) VALUES (4, 'Cabriolet');
INSERT INTO voiture_type (id, libele) VALUES (5, 'Break');

-- Insert test data into voiture
INSERT INTO voiture (id, idVoitureType, largeur, longueur, vitesseMax) 
VALUES (1, 1, 1.8, 4.5, 220.0);
INSERT INTO voiture (id, idVoitureType, largeur, longueur, vitesseMax) 
VALUES (2, 2, 1.9, 4.7, 200.0);
INSERT INTO voiture (id, idVoitureType, largeur, longueur, vitesseMax) 
VALUES (3, 3, 1.85, 4.2, 230.0);
INSERT INTO voiture (id, idVoitureType, largeur, longueur, vitesseMax) 
VALUES (4, 4, 1.9, 4.4, 240.0);
INSERT INTO voiture (id, idVoitureType, largeur, longueur, vitesseMax) 
VALUES (5, 5, 1.78, 4.6, 210.0);
