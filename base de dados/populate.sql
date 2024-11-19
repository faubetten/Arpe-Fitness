-- Populando a tabela exercise_category
INSERT INTO exercise_category (cat_name) VALUES
('Cardio'),
('Força'),
('Flexibilidade');

-- Populando a tabela exercise
INSERT INTO exercise (exer_name, exer_description, exer_cat_id) VALUES
('Corrida na esteira', 'Corrida moderada por 30 minutos', 1),
('Supino reto', 'Fortalecimento do peitoral com barra', 2),
('Prancha abdominal', 'Fortalecimento do core e postura', 3);

-- Populando a tabela train
INSERT INTO train (train_name, train_rest_between_exercises) VALUES
('Treino de Cardio Intenso', 60),
('Treino Full Body', 120),
('Treino de Flexibilidade', 90);

-- Populando a tabela user
INSERT INTO user (user_name, user_password, user_bdate, user_gender, user_email) VALUES
('João Silva', 'senha123', '1990-01-15', 'M', 'joao.silva@gmail.com'),
('Mariana Oliveira', 'senha456', '1985-06-20', 'F', 'mariana.oliveira@gmail.com'),
('Carlos Pereira', 'senha789', '2000-03-05', 'M', 'carlos.pereira@hotmail.com');

-- Populando a tabela plan
INSERT INTO plan (plan_name, plan_desc, user_id) VALUES
('Plano Cardio para Iniciantes', 'Treino de cardio leve para iniciantes', 1),
('Plano de Fortalecimento Avançado', 'Fortalecimento muscular para avançados', 2),
('Plano Full Body', 'Treino completo para todo o corpo', 3);

-- Populando a tabela serie
INSERT INTO serie (serie_order, serie_rep, serie_exer_id, serie_train_id, plan_id) VALUES
(1, 10, 1, 1, 1), -- Corrida na esteira no plano de João
(2, 12, 2, 2, 2), -- Supino reto no plano de Mariana
(3, 5, 3, 3, 3);  -- Prancha abdominal no plano de Carlos

-- Populando a tabela user_plan
INSERT INTO user_plan (user_id, plan_id) VALUES
(1, 1), -- João associado ao plano Cardio para Iniciantes
(2, 2), -- Mariana associada ao plano de Fortalecimento Avançado
(3, 3); -- Carlos associado ao plano Full Body