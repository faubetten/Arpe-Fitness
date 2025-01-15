-- Populando a tabela exercise_category
INSERT INTO exercise_category (cat_name) VALUES
('Chest'),
('Back'),
('Leg');

-- Populando a tabela exercise
INSERT INTO exercise (exer_name, exer_description, exer_cat_id, exer_photo_path) VALUES
('Bench Press', 'Classic chest exercise using barbell', 1, 'path/to/bench_press.jpg'),
('Pull-Ups', 'Bodyweight back and biceps exercise', 2, 'path/to/pull_ups.jpg'),
('Squat', 'Compound exercise for legs and glutes', 3, 'path/to/squat.jpg');

-- Populando a tabela train
INSERT INTO train (train_name) VALUES
('Hypertrophy'),
('Muscle Definition'),
('Lose Weight');

-- Populando a tabela user
INSERT INTO user (user_name, user_password, user_bdate, user_gender, user_email, user_height, user_weight) VALUES
('João Silva', 'senha123', '1990-01-15', 'M', 'joao.silva@gmail.com', 1.75, 80),
('Mariana Oliveira', 'senha456', '1985-06-20', 'F', 'mariana.oliveira@gmail.com', 1.65, 58),
('Carlos Pereira', 'senha789', '2000-03-05', 'M', 'carlos.pereira@hotmail.com', 1.80, 75);

-- Populando a tabela serie
INSERT INTO serie (serie_order, serie_rep) VALUES
(1, 12), 
(2, 10),  
(3, 15);

-- Populando a tabela series_reps
INSERT INTO series_reps (serie_id, rep_order, rep_weight_kg, rep_num_reps, rest_time_seconds) VALUES
(1, 1, 50.0, 12, 60),  
(2, 1, 60.0, 10, 90),
(3, 1, 40.0, 15, 60);

-- Populando a tabela exer_serie
INSERT INTO exer_serie (exer_id, serie_id, num_series, weight_kg, num_reps) 
VALUES
(1, 1, 4, 50.0, 12),  
(2, 2, 3, 60.0, 10),  
(3, 3, 4, 40.0, 15);

-- Populando a tabela serie_train
INSERT INTO serie_train (serie_id, train_id, train_rest_between_exercises) 
VALUES
(1, 1, 120), 
(2, 2, 90),   
(3, 3, 150);

-- Populando a tabela user_train
INSERT INTO user_train (user_id, train_id) 
VALUES
(1, 1),  
(2, 2),  
(3, 3);
