DROP TABLE IF EXISTS livre;
CREATE TABLE livre(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titre VARCHAR(50) NOT NULL,
    content VARCHAR(255) NOT NULL,
    genre VARCHAR(50),
    auteur VARCHAR(50),
    maison_edition VARCHAR(50),
    date_publication VARCHAR(50) NOT NULL
);
INSERT INTO livre(titre, content, date_publication) VALUES
('Le Petit Prince', 'Un conte poétique et philosophique', '1943-04-06'),
('1984', 'Un roman dystopique sur un futur totalitaire', '1949-06-08'),
('Le Meilleur des mondes', 'Un roman de science-fiction sur une société futuriste', '1932-08-31');

CREATE USER flo PASSWORD '1234' ADMIN;