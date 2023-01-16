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
