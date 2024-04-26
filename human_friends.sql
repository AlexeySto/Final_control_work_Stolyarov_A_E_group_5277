-- Создать таблицы с иерархией из диаграммы в БД
-- Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения

DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

DROP TABLE IF EXISTS Dogs;
CREATE TABLE Dogs (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Dogs (animal_name, birth_date, commands) VALUES
('Fido', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', '2018-12-10', 'Sit, Paw, Bark'),
('Bella', '2019-11-11', 'Sit, Stay, Roll');

DROP TABLE IF EXISTS Cats;
CREATE TABLE Cats (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Cats (animal_name, birth_date, commands) VALUES
('Whiskers', '2019-05-15', 'Sit, Pounce'),
('Smudge', '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', '2020-06-30', 'Meow, Scratch, Jump');

DROP TABLE IF EXISTS Hamsters;
CREATE TABLE Hamsters (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Hamsters (animal_name, birth_date, commands) VALUES
('Hammy', '2021-03-10', 'Roll, Hide'),
('Peanut', '2021-08-01', 'Roll, Spin');

DROP TABLE IF EXISTS Horses;
CREATE TABLE Horses (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Horses (animal_name, birth_date, commands) VALUES
('Thunder', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', '2014-05-05', 'Trot, Canter'),
('Blaze', '2016-02-29', 'Trot, Jump, Gallop');

DROP TABLE IF EXISTS Camels;
CREATE TABLE Camels (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Camels (animal_name, birth_date, commands) VALUES
('Sandy', '2016-11-03', 'Walk, Carry Load'),
('Dune', '2018-12-12', 'Walk, Sit'),
('Sahara', '2015-08-14', 'Walk, Run');

DROP TABLE IF EXISTS Donkeys;
CREATE TABLE Donkeys (
	id SERIAL PRIMARY KEY,
    animal_name VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO Donkeys (animal_name, birth_date, commands) VALUES
('Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', '2019-01-23', 'Walk, Bray, Kick');

-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DROP TABLE IF EXISTS Camels;

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	id SERIAL PRIMARY KEY, 
    animal_name VARCHAR(50),
    animal_type VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO pack_animals (animal_name, animal_type, birth_date, commands)
SELECT animal_name, animal_type, birth_date, commands FROM(
	SELECT animal_name, 'Horse' AS animal_type, birth_date, commands FROM Horses
	UNION ALL
	SELECT animal_name, 'Donkey' AS animal_type, birth_date, commands FROM Donkeys
)tmp;

-- Объединить все созданные таблицы в одну, сохраняя информацию о
-- принадлежности к исходным таблицам.

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	id SERIAL PRIMARY KEY, 
    animal_name VARCHAR(50),
    animal_type VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120)
);

INSERT INTO pets (animal_name, animal_type, birth_date, commands)
SELECT animal_name, animal_type, birth_date, commands FROM(
	SELECT animal_name, 'Dog' AS animal_type, birth_date, commands FROM Dogs
	UNION ALL
	SELECT animal_name, 'Cat' AS animal_type, birth_date, commands FROM Cats
    UNION ALL
	SELECT animal_name, 'Hamster' AS animal_type, birth_date, commands FROM Hamsters
)tmp;

DROP TABLE IF EXISTS human_friends;
CREATE TABLE human_friends (
	id SERIAL PRIMARY KEY, 
    animal_name VARCHAR(50),
    animal_type VARCHAR(50),
    birth_date DATE,
    commands VARCHAR(120),
    table_source VARCHAR(50)
);

INSERT INTO human_friends (animal_name, animal_type, birth_date, commands, table_source)
SELECT animal_name, animal_type, birth_date, commands, table_source FROM(
	SELECT animal_name, animal_type, birth_date, commands, 'pets' AS table_source FROM pets
	UNION ALL
	SELECT animal_name, animal_type, birth_date, commands, 'pack_animals' AS table_source FROM pack_animals
)tmp;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить
-- их возраст с точностью до месяца.

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (
	id SERIAL PRIMARY KEY, 
    animal_name VARCHAR(50),
    animal_type VARCHAR(50),
    birth_date DATE,
    age_in_months BIGINT UNSIGNED NOT NULL,
    commands VARCHAR(120),
    table_source VARCHAR(50)
);

INSERT INTO young_animals (animal_name, animal_type, birth_date, age_in_months, commands, table_source)
SELECT animal_name, animal_type, birth_date, DATEDIFF(CURDATE(), birth_date) DIV 30 AS age_in_months,commands, table_source FROM human_friends WHERE DATEDIFF(CURDATE(), birth_date) DIV 30 > 11 AND DATEDIFF(CURDATE(), birth_date) DIV 30 < 37;
