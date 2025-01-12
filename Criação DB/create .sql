-- Tabela de Categorias de Exercícios
CREATE TABLE exercise_category (
    cat_id INT NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(40) NOT NULL, 
    PRIMARY KEY (cat_id)
);

-- Tabela de Exercícios
CREATE TABLE exercise (
    exer_id INT NOT NULL AUTO_INCREMENT,
    exer_name VARCHAR(60) NOT NULL, 
    exer_description VARCHAR(255) NOT NULL,
    exer_cat_id INT NOT NULL, 
    exer_photo_path VARCHAR(255),  
    PRIMARY KEY (exer_id),
    FOREIGN KEY (exer_cat_id) REFERENCES exercise_category(cat_id)
);

-- Tabela de Séries
CREATE TABLE serie (
    serie_id INT NOT NULL AUTO_INCREMENT,
    serie_order INT NOT NULL,     
    serie_rep INT NULL,       
    PRIMARY KEY (serie_id)
);

-- Tabela de Repetições por Série
CREATE TABLE series_reps (
    rep_id INT NOT NULL AUTO_INCREMENT,      
    serie_id INT NOT NULL,                    
    rep_order INT NOT NULL,                  
    rep_weight_kg DECIMAL(5,2),          
    rep_num_reps INT NOT NULL,               
    rest_time_seconds INT NOT NULL,           
    PRIMARY KEY (rep_id),                     
    FOREIGN KEY (serie_id) REFERENCES serie(serie_id)  
);

-- Associação entre Exercícios e Séries
CREATE TABLE exer_serie (
    exer_id INT NOT NULL,                     
    serie_id INT NOT NULL,                   
    num_series INT NOT NULL,                  
    weight_kg DECIMAL(5,2),                   
    num_reps INT NOT NULL,                    
    PRIMARY KEY (exer_id, serie_id),      
    FOREIGN KEY (exer_id) REFERENCES exercise(exer_id),  
    FOREIGN KEY (serie_id) REFERENCES serie(serie_id)     
);

-- Tabela de Treinos
CREATE TABLE train (
    train_id INT NOT NULL AUTO_INCREMENT,
    train_name VARCHAR(40) NOT NULL,
    train_goal ENUM('Hypertrophy', 'Muscle Definition', 'To lose weight') NOT NULL,
    PRIMARY KEY (train_id)
);

-- Tabela de Níveis de Treino
CREATE TABLE train_level (
    level_id INT NOT NULL AUTO_INCREMENT,
    train_id INT NOT NULL, 
    train_level ENUM('Beginner', 'Intermediate', 'Advanced') NOT NULL,
    PRIMARY KEY (level_id),
    FOREIGN KEY (train_id) REFERENCES train(train_id)
);

-- Associação entre Séries e Treinos por Nível
CREATE TABLE serie_train (
    serie_id INT NOT NULL,
    train_id INT NOT NULL,
    level_id INT NOT NULL,
    train_rest_between_exercises INT NOT NULL DEFAULT 120,
    num_series INT NOT NULL,
    num_reps INT NOT NULL,
    weight_kg DECIMAL(5,2),
    PRIMARY KEY (serie_id, train_id, level_id),
    FOREIGN KEY (serie_id) REFERENCES serie(serie_id),
    FOREIGN KEY (train_id) REFERENCES train(train_id),
    FOREIGN KEY (level_id) REFERENCES train_level(level_id)
);

-- Tabela de Usuários
CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(60) NOT NULL, 
    user_password VARCHAR(60) NOT NULL,
    user_bdate DATE NULL,
    user_gender CHAR(1) NOT NULL, 
    user_email VARCHAR(30),
    user_height DECIMAL(5,2) NULL, 
    user_weight DECIMAL(5,2) NULL, 
    user_goal ENUM('Hypertrophy', 'Muscle Definition', 'To lose weight') NOT NULL,
    user_experience ENUM('Beginner', 'Intermediate', 'Advanced') NOT NULL,
    PRIMARY KEY (user_id)
);

-- Associação entre Usuários e Treinos
CREATE TABLE user_train (
    user_id INT NOT NULL,
    train_id INT NOT NULL,
    is_custom BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (user_id, train_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (train_id) REFERENCES train(train_id)
);
