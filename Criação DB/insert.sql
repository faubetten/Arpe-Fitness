INSERT INTO exercise_category (cat_name) 
VALUES 
    ('Chest'), 
    ('Triceps'), 
    ('Back'), 
    ('Biceps'), 
    ('Shoulders'), 
    ('Abs'), 
    ('Leg');


INSERT INTO exercise (exer_name, exer_description, exer_cat_id, exer_photo_path) 
VALUES 
    ('Bench Press', 'Classic chest exercise using barbell', 1, 'path/to/bench_press.jpg'),
    ('Dumbbell Fly', 'Chest isolation exercise using dumbbells', 1, 'path/to/dumbbell_fly.jpg'),
    ('Seated Crucifix', 'Chest exercise targeting the pecs and shoulders', 1, 'path/to/seated_crucifix.jpg'),
    ('Push-Up', 'Bodyweight exercise for chest and triceps', 1, 'path/to/push_up.jpg'),
    ('Triceps Pushdown', 'Cable exercise for triceps', 2, 'path/to/triceps_pushdown.jpg'),
    ('Overhead Triceps Extension', 'Triceps stretch and strength exercise', 2, 'path/to/overhead_extension.jpg'),
    ('Close-Grip Bench Press', 'Compound exercise for chest and triceps', 2, 'path/to/close_grip_bench.jpg'),
    ('Lever Triceps Dips', 'Machine-based triceps dip exercise', 2, 'path/to/lever_dips.jpg'),
    ('Pulldown', 'Lat pulldown exercise for back', 3, 'path/to/pulldown.jpg'),
    ('Pull-Ups', 'Bodyweight back and biceps exercise', 3, 'path/to/pull_ups.jpg'),
    ('Face Pull', 'Cable exercise targeting rear delts and upper back', 3, 'path/to/face_pull.jpg'),
    ('Deadlift', 'Compound exercise for back, legs, and core', 3, 'path/to/deadlift.jpg'),
    ('Barbell Curl', 'Classic barbell exercise for biceps', 4, 'path/to/barbell_curl.jpg'),
    ('Dumbbell Hammer Curl', 'Biceps exercise with neutral grip', 4, 'path/to/dumbbell_hammer_curl.jpg'),
    ('Concentration Curl', 'Isolation exercise for biceps', 4, 'path/to/concentration_curl.jpg'),
    ('Preacher Curl', 'Seated biceps curl using a preacher bench', 4, 'path/to/preacher_curl.jpg'),
    ('Overhead Press', 'Compound exercise for shoulders', 5, 'path/to/overhead_press.jpg'),
    ('Lateral Raises', 'Isolation exercise for side delts', 5, 'path/to/lateral_raises.jpg'),
    ('Front Raises', 'Front shoulder exercise using weights', 5, 'path/to/front_raises.jpg'),
    ('Arnold Press', 'Shoulder press variation by Arnold Schwarzenegger', 5, 'path/to/arnold_press.jpg'),
    ('Crunches', 'Classic abdominal exercise', 6, 'path/to/crunches.jpg'),
    ('Plank', 'Core strengthening isometric exercise', 6, 'path/to/plank.jpg'),
    ('Bicycle Crunch', 'Dynamic ab exercise simulating cycling motion', 6, 'path/to/bicycle_crunch.jpg'),
    ('Leg Raises', 'Lower ab exercise for core strength', 6, 'path/to/leg_raises.jpg'),
    ('Squat', 'Compound exercise for legs and glutes', 7, 'path/to/squat.jpg'),
    ('Leg Press', 'Machine-based leg strength exercise', 7, 'path/to/leg_press.jpg'),
    ('Hamstrings', 'Hamstring isolation exercise', 7, 'path/to/hamstrings.jpg'),
    ('Leg Curl', 'Machine-based exercise for hamstrings', 7, 'path/to/leg_curl.jpg');


INSERT INTO train (train_name) 
VALUES 
    ('Hypertrophy'), 
    ('Muscle Definition'), 
    ('Lose Weight');


INSERT INTO user (user_name, user_password, user_bdate, user_gender, user_email, user_height, user_weight) 
VALUES 
    ('Ariel Doe', 'password123', '1990-05-12', 'M', 'arieldoe@example.com', 1.75, 80),
    ('Isabella Smith', 'securepassword', '1992-08-22', 'F', 'isabellasmith@example.com', 1.65, 58);


INSERT INTO user_train (user_id, train_id) 
VALUES 
    (1, 1),  
    (2, 2);  


INSERT INTO serie (serie_order, serie_rep) 
VALUES 
    (1, 12), 
    (2, 10),  
    (3, 15),  
    (4, 8);


INSERT INTO series_reps (serie_id, rep_order, rep_weight_kg, rep_num_reps, rest_time_seconds) 
VALUES 
    (1, 1, 50.0, 12, 60),  
    (1, 2, 55.0, 10, 60),  
    (2, 1, 60.0, 10, 90),  
    (3, 1, 40.0, 15, 60),  
    (4, 1, 0.0, 20, 30);   


INSERT INTO exer_serie (exer_id, serie_id, num_series, weight_kg, num_reps) 
VALUES 
    (1, 1, 4, 50.0, 12),  
    (1, 2, 3, 60.0, 10),  
    (2, 1, 4, 20.0, 15),  
    (3, 3, 4, 40.0, 8),   
    (4, 2, 4, 0.0, 20);   


INSERT INTO serie_train (serie_id, train_id, train_rest_between_exercises) 
VALUES 
    (1, 1, 120),  
    (2, 2, 90),   
    (3, 3, 150),  
    (4, 1, 90);   
