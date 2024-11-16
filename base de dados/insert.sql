INSERT INTO exercise_category (cat_name) 
VALUES 
    ('Chest'), 
    ('Triceps'), 
    ('Back'), 
    ('Biceps'), 
    ('Shoulders'), 
    ('Abs'), 
    ('Leg');


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Bench Press', 'Classic chest exercise using barbell', 1),
    ('Dumbbell Fly', 'Chest isolation exercise using dumbbells', 1),
    ('Seated Crucifix', 'Chest exercise targeting the pecs and shoulders', 1),
    ('Push-Up', 'Bodyweight exercise for chest and triceps', 1);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Triceps Pushdown', 'Cable exercise for triceps', 2),
    ('Overhead Triceps Extension', 'Triceps stretch and strength exercise', 2),
    ('Close-Grip Bench Press', 'Compound exercise for chest and triceps', 2),
    ('Lever Triceps Dips', 'Machine-based triceps dip exercise', 2);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Pulldown', 'Lat pulldown exercise for back', 3),
    ('Pull-Ups', 'Bodyweight back and biceps exercise', 3),
    ('Face Pull', 'Cable exercise targeting rear delts and upper back', 3),
    ('Deadlift', 'Compound exercise for back, legs, and core', 3);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Barbell Curl', 'Classic barbell exercise for biceps', 4),
    ('Dumbbell Hammer Curl', 'Biceps exercise with neutral grip', 4),
    ('Concentration Curl', 'Isolation exercise for biceps', 4),
    ('Preacher Curl', 'Seated biceps curl using a preacher bench', 4);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Overhead Press', 'Compound exercise for shoulders', 5),
    ('Lateral Raises', 'Isolation exercise for side delts', 5),
    ('Front Raises', 'Front shoulder exercise using weights', 5),
    ('Arnold Press', 'Shoulder press variation by Arnold Schwarzenegger', 5);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Crunches', 'Classic abdominal exercise', 6),
    ('Plank', 'Core strengthening isometric exercise', 6),
    ('Bicycle Crunch', 'Dynamic ab exercise simulating cycling motion', 6),
    ('Leg Raises', 'Lower ab exercise for core strength', 6);


INSERT INTO exercise (exer_name, exer_description, exer_cat_id) 
VALUES 
    ('Squat', 'Compound exercise for legs and glutes', 7),
    ('Leg Press', 'Machine-based leg strength exercise', 7),
    ('Hamstrings', 'Hamstring isolation exercise', 7),
    ('Leg Curl', 'Machine-based exercise for hamstrings', 7);


INSERT INTO train (train_name) 
VALUES 
    ('Full Body'), 
    ('Upper Body'), 
    ('Lower Body');


INSERT INTO user (user_name, user_password, user_bdate, user_gender, user_email) 
VALUES 
    ('John Doe', 'password123', '1990-05-12', 'M', 'johndoe@example.com'),
    ('Jane Smith', 'securepassword', '1992-08-22', 'F', 'janesmith@example.com');


INSERT INTO plan (plan_name, plan_desc, user_id) 
VALUES 
    ('Beginner Strength Plan', 'A simple plan to build strength', 1),
    ('Advanced Bodybuilding Plan', 'An advanced plan for muscle gain', 2);


INSERT INTO serie (serie_order, serie_rep, serie_exer_id, serie_train_id, plan_id) 
VALUES 
    (1, 12, 1, 1, 1), 
    (2, 10, 2, 1, 1),  
    (3, 15, 3, 2, 2),  
    (4, 8, 4, 2, 2);   


INSERT INTO user_plan (user_id, plan_id) 
VALUES 
    (1, 1),  
    (2, 2);