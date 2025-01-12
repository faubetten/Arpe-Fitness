-- Categorias de Exercícios
INSERT INTO exercise_category (cat_name) 
VALUES 
    ('Chest'), 
    ('Triceps'), 
    ('Back'), 
    ('Biceps'), 
    ('Shoulders'), 
    ('Abs'), 
    ('Leg');

-- Exercícios
INSERT INTO exercise (exer_name, exer_description, exer_cat_id, exer_photo_path) 
VALUES 
    ('Bench Press', 'Classic chest exercise using barbell', 1, 'https://gymvisual.com/img/p/1/7/5/5/2/17552.gif'),
    ('Dumbbell Fly', 'Chest isolation exercise using dumbbells', 1, 'https://gymvisual.com/img/p/2/0/7/3/8/20738.gif'),
    ('Cable Crossover', 'Chest exercise targeting the pecs and shoulders', 1, 'https://burnfit.io/wp-content/uploads/2023/11/CROSS_OVER.gifC'),
    ('Push-Up', 'Bodyweight exercise for chest and triceps', 1, 'https://gymvisual.com/img/p/9/1/0/1/9101.gif'),
    ('Triceps Pushdown', 'Cable exercise for triceps', 2, 'https://gymvisual.com/img/p/7/0/7/3/7073.gif'),
    ('Overhead Triceps Extension', 'Triceps stretch and strength exercise', 2, 'https://gymvisual.com/img/p/4/9/2/7/4927.gif'),
    ('Close-Grip Bench Press', 'Compound exercise for chest and triceps', 2, 'https://gymvisual.com/img/p/8/8/0/5/8805.gif'),
    ('Lever Triceps Dips', 'Machine-based triceps dip exercise', 2, 'https://gymvisual.com/img/p/5/5/3/8/5538.gif'),
    ('Pulldown', 'Lat pulldown exercise for back', 3, 'https://gymvisual.com/img/p/9/2/0/0/9200.gif'),
    ('Pull-Ups', 'Bodyweight back and biceps exercise', 3, 'https://media.tenor.com/bOA5VPeUz5QAAAAM/noequipmentexercisesmen-pullups.gif'),
    ('Face Pull', 'Cable exercise targeting rear delts and upper back', 3, 'https://gymvisual.com/img/p/2/4/8/0/6/24806.gif'),
    ('Deadlift', 'Compound exercise for back, legs, and core', 3, 'https://gymvisual.com/img/p/2/0/8/3/1/20831.gif'),
    ('Barbell Curl', 'Classic barbell exercise for biceps', 4, 'https://gymvisual.com/img/p/2/2/6/4/6/22646.gif'),
    ('Dumbbell Hammer Curl', 'Biceps exercise with neutral grip', 4, 'https://fitnessprogramer.com/wp-content/uploads/2021/02/Hammer-Curl.gif'),
    ('Concentration Curl', 'Isolation exercise for biceps', 4, 'https://gymvisual.com/img/p/2/8/1/1/8/28118.gif'),
    ('Preacher Curl', 'Seated biceps curl using a preacher bench', 4, 'https://gymvisual.com/img/p/2/1/9/2/8/21928.gif'),
    ('Overhead Press', 'Compound exercise for shoulders', 5, 'https://gymvisual.com/img/p/4/8/2/7/4827.gif'),
    ('Lateral Raises', 'Isolation exercise for side delts', 5, 'https://gymvisual.com/img/p/3/3/8/4/2/33842.gif'),
    ('Front Raises', 'Front shoulder exercise using weights', 5, 'https://gymvisual.com/img/p/2/6/4/2/2/26422.gif'),
    ('Arnold Press', 'Shoulder press variation by Arnold Schwarzenegger', 5, 'https://gymvisual.com/img/p/8/7/3/9/8739.gif'),
    ('Crunches', 'Classic abdominal exercise', 6, 'https://gymvisual.com/img/p/1/4/9/7/9/14979.gif'),
    ('Plank', 'Core strengthening isometric exercise', 6, 'https://gymvisual.com/img/p/2/1/8/6/0/21860.gif'),
    ('Bicycle Crunch', 'Dynamic ab exercise simulating cycling motion', 6, 'https://gymvisual.com/img/p/2/5/8/3/3/25833.gif'),
    ('Leg Raises', 'Lower ab exercise for core strength', 6, 'https://gymvisual.com/img/p/2/2/8/8/7/22887.gif'),
    ('Squat', 'Compound exercise for legs and glutes', 7, 'https://media.tenor.com/Pfj8vy41k-0AAAAM/gym.gif'),
    ('Leg Press', 'Machine-based leg strength exercise', 7, 'https://media.tenor.com/e0qeS17dv7QAAAAM/legpress45-leg-press.gif'),
    ('Hamstrings', 'Hamstring isolation exercise', 7, 'https://media.tenor.com/fj_cZPprAyMAAAAM/gym.gif'),
    ('Leg Curl', 'Machine-based exercise for hamstrings', 7, 'https://media.tenor.com/ZElx6PviDq0AAAAM/gym.gif');

-- Treinos
INSERT INTO train (train_name, train_goal) 
VALUES 
    ('Hypertrophy', 'Hypertrophy'), 
    ('Muscle Definition', 'Muscle Definition'), 
    ('To Lose Weight', 'To lose weight');

-- Níveis de Treino
INSERT INTO train_level (train_id, train_level) 
VALUES 
    (1, 'Beginner'),
    (1, 'Intermediate'),
    (1, 'Advanced'),
    (2, 'Beginner'),
    (2, 'Intermediate'),
    (2, 'Advanced'),
    (3, 'Beginner'),
    (3, 'Intermediate'),
    (3, 'Advanced');

-- Séries
INSERT INTO serie (serie_order, serie_rep) 
VALUES 
    (1, 12), 
    (2, 10), 
    (3, 15), 
    (4, 8);

-- Associação de Exercícios às Séries
INSERT INTO exer_serie (exer_id, serie_id, num_series, weight_kg, num_reps) 
VALUES 
    (1, 1, 3, 50.0, 12),  
    (2, 2, 3, 40.0, 10),  
    (3, 3, 3, 60.0, 8),   
    (4, 4, 3, 0.0, 15);

-- Configuração de Séries por Nível
INSERT INTO serie_train (serie_id, train_id, level_id, train_rest_between_exercises, num_series, num_reps, weight_kg) 
VALUES 
    -- Beginner
    (1, 1, 1, 120, 3, 12, 50.0),  
    (2, 1, 1, 120, 3, 10, 40.0),
    -- Intermediate
    (1, 1, 2, 90, 4, 10, 60.0),  
    (2, 1, 2, 90, 4, 8, 50.0),
    -- Advanced
    (1, 1, 3, 60, 5, 8, 70.0),  
    (2, 1, 3, 60, 5, 6, 60.0);

-- Usuários
INSERT INTO user (user_name, user_password, user_bdate, user_gender, user_email, user_height, user_weight, user_goal, user_experience) 
VALUES 
    ('Ariel Doe', 'password123', '1990-05-12', 'M', 'arieldoe@example.com', 1.75, 80, 'Hypertrophy', 'Beginner'),
    ('Isabella Smith', 'securepassword', '1992-08-22', 'F', 'isabellasmith@example.com', 1.65, 58, 'To Lose Weight', 'Intermediate'),
    ('Pedro', 'securepassword', '1992-08-22', 'M', 'pedro@email.com', 1.65, 58, 'Muscle Definition', 'Advanced');

-- Associação Usuários-Treinos
INSERT INTO user_train (user_id, train_id, is_custom) 
VALUES 
    (1, 1, FALSE),  
    (2, 3, FALSE),
    (3, 1, FALSE);
