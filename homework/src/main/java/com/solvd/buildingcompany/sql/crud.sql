INSERT INTO Persons (name, age)
VALUES ('John Doe', 25), ('Peter Oliver', 35), ('Peter Smith', 35), ('Samuel Black', 25), ('Frank Perry', 42), ('Corey Willis', 22);
INSERT INTO Workers (person_id, position, salary)
VALUES (1, 'Engineer', 1000), (2, 'Engineer', 800), (3, 'Construction worker', 300), (4, 'Construction worker', 300), (5, 'Construction worker', 300);
INSERT INTO Customers (person_id, budget) VALUES (1, 10000), (2, 5000), (3, 1000);
INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)
VALUES (100, 1000), (200, 2000), (300, 3000);
INSERT INTO Building_Timelines (construction_time, permit_process_time) VALUES (10, 30), (20, 25), (100, 50);

UPDATE Persons SET age = 30 WHERE id = 1;
UPDATE Persons SET age = 40 WHERE name = 'Peter%';
UPDATE Persons SET age = 40 WHERE age > 30;
UPDATE Customers SET budget = 15000 WHERE id = 1;
UPDATE Customers JOIN Persons ON Customers.person_id = Persons.id
SET Customers.budget = 20000 WHERE name = 'John Doe';
UPDATE Customers JOIN Persons ON Customers.person_id = Persons.id
SET Customers.budget = 50000 WHERE name = 'Corey Willis';
UPDATE Building_Costs SET cost_per_square_meter = 150 WHERE permit_cost = 2000;

DELETE FROM Persons WHERE age = 15;
DELETE FROM Building_Costs WHERE cost_per_square_meter = 300;
DELETE FROM Building_Timelines WHERE construction_time = 100;
DELETE customers FROM Customers customers JOIN Persons ON customers.person_id = Persons.id WHERE name = 'Peter Smith';
DELETE customers FROM Customers customers JOIN Persons ON customers.person_id = Persons.id WHERE age > 30;
