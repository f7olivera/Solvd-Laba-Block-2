-- Populate Persons
INSERT INTO Persons (name, age, national_id)
    VALUES -- Workers
           ('John Doe', 25, 1312), ('Peter Oliver', 35, 2221), ('Peter Smith', 35, 1245), ('Samuel Black', 25, 4423),
           ('Frank Perry', 42, 5423), ('Corey Willis', 22, 1236), ('Jacob Smith', 22, 1235), ('Michael Johnson', 35, 9876),
           -- Architects
           ('Andrew Davis', 50, 3456), ('Joseph Miller', 60, 2345), ('Christopher Wilson', 70, 1234), ('Daniel Moore', 80, 4321),
           -- Engineers
           ('Daniel Taylor', 40, 4567), ('Anthony Anderson', 30, 5678), ('Thomas Thomas', 30, 6789), ('Matthew Thompson', 30, 7890),
           -- Customers
           ('Matthew Williams', 18, 2468), ('Joshua Jones', 28, 1357), ('Daniel Brown', 40, 7654);
INSERT INTO Workers (person_id, position, salary)
    VALUES (1, 'Construction worker', 500),
           (2, 'Construction worker', 800),
           (3, 'Construction worker', 600),
           (4, 'Construction worker', 600),
           (5, 'Construction worker', 400),
           (7, 'Construction worker', 400),
           (8, 'Construction worker', 500),
           (9, 'Architect', 5000),
           (10, 'Architect', 3000),
           (11, 'Architect', 3600),
           (12, 'Architect', 4000),
           (13, 'Engineer', 3000),
           (14, 'Engineer', 4000),
           (15, 'Engineer', 1900),
           (16, 'Engineer', 2000);
INSERT INTO Customers (person_id, budget) VALUES (17, 10000), (18, 8000), (19, 500000);

-- Populate Items
INSERT INTO Items (name, price)
    VALUES ('Brick', 5), ('Cement', 20), ('Sand', 25), ('Wood', 30), ('Metal', 10),
           ('Paint', 15), ('Door', 30), ('Window', 20), ('Plaster', 20),
           ('Hammer', 4), ('Screwdriver', 3), ('Saw', 5), ('Nails', 1), ('Screws', 1),
           ('Cement mixer', 100), ('Truck', 200), ('Concrete pump', 150), ('Concrete Truck', 50);

-- Populate Buildings
INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)
    VALUES (50, 1000), (150, 3500), (300, 30000);
INSERT INTO Building_Timelines (construction_time, permit_process_time)
    VALUES (30, 30), (75, 50), (120, 80);
INSERT INTO Building_Types (capacity, floors, category, square_meters)
    VALUES (10, 1, 'Residential', 50), (200, 2, 'Residential', 500),
           (50, 1, 'Commercial', 50), (300, 2, 'Commercial', 800), (1000, 5, 'Commercial', 2500),
           (600, 2, 'Industrial', 1500), (1200, 3, 'Industrial', 3000), (3000, 3, 'Industrial', 5000),
           (300, 9, 'Office building', 500), (1200, 10, 'Office building', 900);
INSERT INTO Buildings (name, building_cost_id, building_timeline_id, building_type_id)
    VALUES ('Family House', 1, 1, 1), ('Apartment Building', 2, 2, 2),
           ('Small Store', 1, 1, 3), ('Medium Store', 2, 1, 4), ('Big Store', 3, 3, 5),
           ('Industrial Complex', 2, 2, 6), ('Second Industrial Complex', 3, 3, 7),
           ('Small Office Building', 2, 1, 9), ('Big Office Building', 3, 3, 10);
INSERT INTO Required_Items (required_amount, item_id, building_id)
VALUES (123, 1, 1), (12, 3, 1), (456, 2, 1), (78, 6, 1), (90, 9, 1),
       (31, 5, 2), (10, 1, 2), (20, 8, 2), (50, 7, 2), (100, 4, 2),
       (200, 11, 3), (300, 12, 3), (400, 13, 3), (500, 14, 3), (600, 15, 3),
       (700, 11, 4), (800, 12, 4), (900, 13, 4), (1000, 14, 4), (100, 15, 4),
       (200, 11, 5), (300, 12, 5), (40, 13, 5), (1500, 14, 5), (100, 15, 5),
       (700, 11, 6), (800, 12, 6), (900, 13, 6), (560, 14, 6), (400, 15, 6),
       (200, 11, 7), (300, 12, 7), (400, 13, 7), (500, 14, 7), (700, 15, 7),
       (700, 11, 8), (800, 12, 8), (900, 13, 8), (100, 14, 8), (500, 15, 8),
       (200, 11, 9), (300, 12, 9), (400, 13, 9), (500, 14, 9), (700, 15, 9);

-- Populate Inventory
INSERT INTO Inventory (available, item_id)
    VALUES (500, 1), (1000, 2), (2000, 3), (3000, 4), (4000, 5), (5000, 6), (1000, 7),
           (3000, 8), (2000, 9), (3000, 10), (4000, 11), (1000, 12), (2000, 13),
           (3000, 14), (5000, 15), (1000, 16), (3000, 17), (2000, 18), (3000, 19);

-- Populate Constructions
INSERT INTO Constructions (address, status, start_date, end_date)
    VALUES ('1234 Elm St, Anytown USA', 'In progress', '2022-01-01', '2022-01-31'),
           ('578 Oak Ave, Randomville USA', 'In progress', '2022-01-01', '2022-03-15'),
           ('911 Pine Blvd, Buildertown USA', 'In progress', '2022-01-01', '2022-01-31'),
           ('124 Cedar Rd, Hammerville USA', 'In progress', '2022-01-01', '2022-03-15');

-- Populate Orders
INSERT INTO Orders (is_paid, customer_id, building_id, construction_id)
    VALUES (0, 1, 1, 1), (0, 2, 2, 2), (0, 3, 3, 4), (0, 3, 4, 6);

-- Populate Construction_Items
INSERT INTO Construction_Items (amount, item_id, construction_id)
    VALUES (100, 1, 1), (200, 2, 1), (300, 3, 1), (400, 4, 1), (500, 5, 1),
           (600, 6, 1), (700, 7, 1), (800, 8, 1), (900, 9, 1), (1000, 10, 1),
           (200, 1, 2), (300, 2, 2), (400, 3, 2), (500, 4, 2), (600, 5, 2),
           (700, 6, 2), (800, 7, 2), (900, 8, 2), (1000, 9, 2), (1100, 10, 2),
           (300, 1, 3), (400, 2, 3), (500, 3, 3), (600, 4, 3), (700, 5, 3),
           (800, 6, 3), (900, 7, 3), (1000, 8, 3), (1100, 9, 3), (1200, 10, 3),
           (400, 1, 4), (500, 2, 4), (600, 3, 4), (700, 4, 4), (800, 5, 4),
           (900, 6, 4), (1000, 7, 4), (1100, 8, 4), (1200, 9, 4), (1300, 10, 4);

-- Populate Construction_Workers
INSERT INTO Construction_Workers (worker_id, construction_id)
    VALUES (1, 1), (2, 1), (9, 1), (10, 1),
           (3, 2), (4, 2), (11, 2), (12, 2),
           (5, 3), (6, 3), (13, 3), (14, 3),
           (7, 4), (8, 4), (15, 4), (16, 4);
