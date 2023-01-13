INSERT INTO Persons ('name', 'age') VALUES ('John', 25), ('Peter', 35), ('Mary', 15);
INSERT INTO Workers ('person_id', 'position', 'salary') VALUES (1, 'Manager', 1000), (2, 'Engineer', 800), (3, 'Intern', 300);
INSERT INTO Customers ('person_id', 'budget') VALUES (1, 10000), (2, 5000), (3, 1000);
INSERT INTO 'Buildings costs' ('cost_per_square_meter', 'permit_cost', 'Buildings costscol')
VALUES (100, 1000, 10000), (200, 2000, 20000), (300, 3000, 30000);
INSERT INTO 'Buildings timelines' ('construction_time', 'permit_process_time') VALUES (10, 30), (20, 25), (100, 50);