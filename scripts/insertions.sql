DELETE FROM Game_Country WHERE TRUE;
DELETE FROM Country WHERE TRUE;
DELETE FROM Game WHERE TRUE;
DELETE FROM Stadium WHERE TRUE;


# STADIUMS

INSERT INTO Stadium(id, location, name, capacity)
VALUES
    (1, 'Al Wakrah', 'Al Janoub Stadium', 40000),
    (2, 'Al Wakrah', 'Khalifa International Stadium', 40000),
    (3, 'Al Rayyan', 'Education City Stadium', 44740),
    (4, 'Al Rayyan', 'Ahmad bin Ali Stadium', 45350),
    (5, 'Doha', 'Al Thumama Stadium', 40000),
    (6, 'Doha', 'Stadium 974', 40000),
    (7, 'Al Khor', 'Al Bayt Stadium', 60000),
    (8, 'Lusail', 'Lusail Iconic Stadium', 80000)
;

# COUNTRIES

INSERT INTO Country(`grouping`, name)
VALUES
    ('A', 'Qatar'),
    ('A', 'Ecuador'),
    ('A', 'Senegal'),
    ('A', 'Netherlands'),

    ('B', 'England'),
    ('B', 'Iran'),
    ('B', 'USA'),
    ('B', 'Wales'),

    ('C', 'Argentina'),
    ('C', 'Saudi Arabia'),
    ('C', 'Mexico'),
    ('C', 'Poland'),

    ('D', 'Peru'),
    ('D', 'France'),
    ('D', 'Denmark'),
    ('D', 'Tunisia'),

    ('E', 'Spain'),
    ('E', 'New Zealand'),
    ('E', 'Germany'),
    ('E', 'Japan'),

    ('F', 'Belgium'),
    ('F', 'Canada'),
    ('F', 'Morocco'),
    ('F', 'Croatia'),

    ('G', 'Brazil'),
    ('G', 'Serbia'),
    ('G', 'Switzerland'),
    ('G', 'Cameroon'),

    ('H', 'Uruguay'),
    ('H', 'Ghana'),
    ('H', 'Portugal'),
    ('H', 'South Korea')
;

# GAMES

INSERT INTO Game(id, stadium_id,time,date)
VALUES
    (1, 7,'19:00:00','2022-11-21'),
    (2, 5,'13:00:00','2022-11-21'),
    (3, 2,'16:00:00','2022-11-21'),
    (4, 4,'22:00:00','2022-11-21'),

    (5, 1,'22:00:00','2022-11-22'),
    (6, 3,'16:00:00','2022-11-22'),
    (7, 6,'19:00:00','2022-11-22'),
    (8, 8,'13:00:00','2022-11-22'),

    (9, 4,'22:00:00','2022-11-23'),
    (10, 5,'19:00:00','2022-11-23'),
    (11, 2,'16:00:00','2022-11-23'),
    (12, 7,'13:00:00','2022-11-23'),

    (13, 1,'13:00:00','2022-11-24'),
    (14, 3,'16:00:00','2022-11-24'),
    (15, 6,'19:00:00','2022-11-24'),
    (16, 8,'22:00:00','2022-11-24'),

    (17, 4,'13:00:00','2022-11-25'),
    (18, 5,'16:00:00','2022-11-25'),
    (19, 2,'19:00:00','2022-11-25'),
    (20, 7,'22:00:00','2022-11-25'),

    (21, 1,'13:00:00','2022-11-26'),
    (22, 3,'16:00:00','2022-11-26'),
    (23, 6,'19:00:00','2022-11-26'),
    (24, 8,'22:00:00','2022-11-26'),

    (25, 4,'13:00:00','2022-11-27'),
    (26, 5,'16:00:00','2022-11-27'),
    (27, 2,'19:00:00','2022-11-27'),
    (28, 7,'22:00:00','2022-11-27'),

    (29, 1,'13:00:00','2022-11-28'),
    (30, 3,'16:00:00','2022-11-28'),
    (31, 6,'19:00:00','2022-11-28'),
    (32, 8,'22:00:00','2022-11-28'),

    (33, 4,'22:00:00','2022-11-29'),
    (34, 5,'22:00:00','2022-11-29'),
    (35, 2,'18:00:00','2022-11-29'),
    (36, 7,'18:00:00','2022-11-29'),

    (37, 1,'18:00:00','2022-11-30'),
    (38, 3,'18:00:00','2022-11-30'),
    (39, 6,'22:00:00','2022-11-30'),
    (40, 8,'22:00:00','2022-11-30'),

    (41, 4,'18:00:00','2022-12-1'),
    (42, 5,'18:00:00','2022-12-1'),
    (43, 2,'22:00:00','2022-12-1'),
    (44, 7,'22:00:00','2022-12-1'),

    (45, 1,'18:00:00','2022-12-2'),
    (46, 3,'18:00:00','2022-12-2'),
    (47, 6,'22:00:00','2022-12-2'),
    (48, 8,'22:00:00','2022-12-2');



INSERT INTO Game_Country(games_id,countries_name)
VALUES
    (1, 'Qatar'),
    (1, 'Ecuador'),
    (2, 'Senegal'),
    (2, 'Netherlands'),
    (3, 'England'),
    (3, 'Iran'),
    (4, 'USA'),
    (4, 'Wales'),
    (5, 'France'),
    (5, 'Peru'),
    (6, 'Denmark'),
    (6, 'Tunisia'),
    (7, 'Mexico'),
    (7, 'Poland'),
    (8, 'Argentina'),
    (8, 'Saudi Arabia'),
    (9, 'Belgium'),
    (9, 'Canada'),
    (10, 'Spain'),
    (10, 'New Zealand'),
    (11, 'Germany'),
    (11, 'Japan'),
    (12, 'Morocco'),
    (12, 'Croatia'),
    (13, 'Switzerland'),
    (13, 'Cameroon'),
    (14, 'Uruguay'),
    (14, 'South Korea'),
    (15, 'Portugal'),
    (15, 'Ghana'),
    (16, 'Brazil'),
    (16, 'Serbia'),
    (17, 'Iran'),
    (17, 'Wales'),
    (18,'Qatar'),
    (18,'Senegal'),
    (19,'Netherlands'),
    (19,'Ecuador'),
    (20,'England'),
    (20,'USA'),
    (21,'Tunisia'),
    (21,'Peru'),
    (22,'Poland'),
    (22,'Saudi Arabia'),
    (23,'France'),
    (23,'Denmark'),
    (24,'Argentina'),
    (24,'Mexico'),
    (25,'Japan'),
    (25,'New Zealand'),
    (26,'Belgium'),
    (26,'Morocco'),
    (27,'Croatia'),
    (27,'Canada'),
    (28,'Spain'),
    (28,'Germany'),
    (29,'Serbia'),
    (29,'Cameroon'),
    (30,'South Korea'),
    (30,'Ghana'),
    (31,'Brazil'),
    (31,'Switzerland'),
    (32,'Portugal'),
    (32,'Uruguay'),
    (33,'England'),
    (33,'Wales'),
    (34,'Iran'),
    (34,'USA'),
    (35,'Ecuador'),
    (35,'Senegal'),
    (36,'Netherlands'),
    (36,'Qatar'),
    (37,'Denmark'),
    (37,'Peru'),
    (38,'Tunisia'),
    (38,'France'),
    (39,'Poland'),
    (39,'Argentina'),
    (40,'Saudi Arabia'),
    (40,'Mexico'),
    (41,'Croatia'),
    (41,'Belgium'),
    (42,'Canada'),
    (42,'Morocco'),
    (43,'Japan'),
    (43,'Spain'),
    (44,'New Zealand'),
    (44,'Germany'),
    (45,'Ghana'),
    (45,'Uruguay'),
    (46,'South Korea'),
    (46,'Portugal'),
    (47,'Serbia'),
    (47,'Switzerland'),
    (48,'Brazil'),
    (48,'Cameroon');
