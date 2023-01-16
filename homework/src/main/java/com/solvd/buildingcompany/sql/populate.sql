INSERT INTO Persons (name, age, national_id)
VALUES ('John Doe', 25, 1312), ('Peter Oliver', 35, 2221), ('Peter Smith', 35, 1245), ('Samuel Black', 25, 4423), ('Frank Perry', 42, 5423), ('Corey Willis', 22);
INSERT INTO Workers (person_id, position, salary)
VALUES (1, 'Engineer', 1000), (2, 'Engineer', 800), (3, 'Construction worker', 300), (4, 'Construction worker', 300), (5, 'Construction worker', 300);
INSERT INTO Customers (person_id, budget) VALUES (1, 10000), (2, 5000), (3, 1000);
INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)
VALUES (10, 1000), (20, 2000), (30, 3000);
INSERT INTO Building_Timelines (construction_time, permit_process_time) VALUES (10, 30), (20, 25), (100, 60);
