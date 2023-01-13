INSERT INTO Persons ('name', 'age') VALUES ('John Doe', 25), ('Peter Oliver', 35), ('Peter Smith', 35) ('Mary Jane', 25);
INSERT INTO Workers ('person_id', 'position', 'salary') VALUES (1, 'Manager', 1000), (2, 'Engineer', 800), (3, 'Intern', 300);
INSERT INTO Customers ('person_id', 'budget') VALUES (1, 10000), (2, 5000), (3, 1000);
INSERT INTO 'Buildings costs' ('cost_per_square_meter', 'permit_cost')
VALUES (100, 1000), (200, 2000), (300, 3000);
INSERT INTO 'Buildings timelines' ('construction_time', 'permit_process_time') VALUES (10, 30), (20, 25), (100, 50);

UPDATE Persons SET age = 30 WHERE id = 1;
UPDATE Persons SET age = 40 WHERE 'name' = 'Peter%';
UPDATE Persons SET age = 40 WHERE age > 30;
UPDATE Customers SET budget = 15000 WHERE id = 1;
UPDATE Customers JOIN Persons ON Customers.person_id = Persons.id
SET Customers.budget = 20000 WHERE name = 'John Doe';
UPDATE Customers JOIN Persons ON Customers.person_id = Persons.id
SET Customers.budget = 50000 WHERE name = 'Mary Jane';
UPDATE 'Buildings costs' SET cost_per_square_meter = 150 WHERE 'permit_cost' = 2000;

DELETE FROM Persons WHERE age = 15;
DELETE FROM 'Buildings costs' WHERE 'cost_per_square_meter' = 300;
DELETE FROM 'Buildings timelines' WHERE 'construction_time' = 100;
DELETE Customers JOIN Persons ON Customers.person_id = Persons.id WHERE name = 'Peter Smith';
DELETE Customers JOIN Persons ON Customers.person_id = Persons.id WHERE age > 30;