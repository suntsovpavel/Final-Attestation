USE HUMAN_FRIENDS;

-- 1. Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
-- Заполнить таблицы данными о животных, их командах и датами рождения.
CREATE TABLE pets_types(
	id INT PRIMARY KEY AUTO_INCREMENT,
	type CHAR(30)
);

CREATE TABLE pack_animals_types(
	id INT PRIMARY KEY AUTO_INCREMENT,
	type CHAR(30)
);

INSERT INTO pets_types(type) VALUES 
('cat'),('dog'),('hamster');

INSERT INTO pack_animals_types(type) VALUES 
('horse'),('camel'),('donkey');

CREATE TABLE table_packing_commands(
	id INT PRIMARY KEY AUTO_INCREMENT,
	packing_command CHAR(30)
);
INSERT INTO table_packing_commands(packing_command) VALUES ('load, unload'); 

CREATE TABLE pets(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_id INT,
    date_of_birth DATE,
	name CHAR(30),    
    commands TEXT,
    FOREIGN KEY (type_id) REFERENCES pets_types(id) ON DELETE CASCADE ON UPDATE CASCADE  
);

CREATE TABLE pack_animals(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_id INT,
    date_of_birth DATE,
	name CHAR(30),    
    commands TEXT,
    type_packing_commands INT,
    FOREIGN KEY (type_id) REFERENCES pack_animals_types(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (type_packing_commands) REFERENCES table_packing_commands(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets(type_id,date_of_birth,name,commands) VALUES
(1,'2021-02-02','jenny','meow, jump'),
(1,'2022-02-02','shexp','meow, jump'),
(2,'2022-05-12','max','woof, jump, sit, lie'),
(3,'2020-10-22','johnny','make sound, roll, spin');

INSERT INTO pack_animals(type_id,date_of_birth,name,commands,type_packing_commands) VALUES
(1,'2018-05-05','gulsary','rush, gallop, stop',1),
(2,'2021-07-30','arnold','move, stop',1),
(3,'2015-02-21','slay','move, stop, jump',1);

-- 2.Удалить записи о верблюдах 
DELETE pack_animals 
FROM pack_animals
INNER JOIN pack_animals_types ON type_id = pack_animals_types.id
WHERE type = 'camel'; 

-- 3.объединить таблицы лошадей и ослов:
SELECT type,
	date_of_birth,
    name, 
    commands, 
    packing_command
FROM pack_animals 
INNER JOIN pack_animals_types ON type_id = pack_animals_types.id
INNER JOIN table_packing_commands ON type_packing_commands = table_packing_commands.id
WHERE type = 'horse' OR type = 'donkey'; 

-- 4.Создать новую таблицу для животных в возрасте от 1 до 3 лет 
-- и вычислить их возраст с точностью до месяца
-- Создаем 2 функции, вычисляющие возраст животного 
-- и возвращающие соответственно строку(сколько лет и месяцев) и число(сколько лет)
DELIMITER $$
CREATE FUNCTION age_string (date_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, date_b, CURDATE()), ' years ',
            TIMESTAMPDIFF(MONTH, date_b, CURDATE()) % 12, ' month'
        );
	RETURN res;	
END $$ 
CREATE FUNCTION age_years (date_b DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE res INT DEFAULT 0;
	SET res = TIMESTAMPDIFF(YEAR, date_b, CURDATE());
	RETURN res;	
END $$
DELIMITER ;

-- Восстанавливаем записи о верблюдах
INSERT INTO pack_animals(type_id,date_of_birth,name,commands,type_packing_commands) VALUES
(2,'2023-01-07','shwarz','move, stop',1),
(2,'2022-07-30','arnold','move, stop',1);

-- Формируем таблицу животных с возрастом от 1 до 3 лет 
-- и выводим возраст с точностью до месяца (age)
CREATE TABLE animals_age_1_3 (
	id INT PRIMARY KEY AUTO_INCREMENT,    
	name CHAR(30),
    type CHAR(30),
    date_of_birth DATE,
    age TEXT
);

INSERT INTO animals_age_1_3(name, type, date_of_birth, age)
SELECT name, type, date_of_birth, age_string(date_of_birth)
FROM pets
INNER JOIN pets_types ON type_id = pets_types.id
WHERE age_years(date_of_birth) BETWEEN 1 AND 3
UNION ALL
SELECT name, type, date_of_birth, age_string(date_of_birth)
FROM pack_animals
INNER JOIN pack_animals_types ON type_id = pack_animals_types.id          
WHERE age_years(date_of_birth) BETWEEN 1 AND 3;

SELECT * FROM animals_age_1_3;

-- 5.Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
CREATE TABLE animals_all (
	id INT PRIMARY KEY AUTO_INCREMENT, 
    type_id INT,
	name CHAR(30),
    type CHAR(30),
    date_of_birth DATE,
	commands TEXT,
    id_packing_commands INT,
    packing_commands CHAR(30)
);

INSERT INTO animals_all(type_id, name, type, date_of_birth, commands, id_packing_commands, packing_commands)
SELECT type_id, name, type, date_of_birth, commands, NULL, NULL
FROM pets
INNER JOIN pets_types ON type_id = pets_types.id
UNION ALL
SELECT type_id, name, type, date_of_birth, commands, type_packing_commands, packing_command
FROM pack_animals
INNER JOIN pack_animals_types ON type_id = pack_animals_types.id
INNER JOIN table_packing_commands ON type_packing_commands = table_packing_commands.id;

SELECT * FROM animals_all;



   




