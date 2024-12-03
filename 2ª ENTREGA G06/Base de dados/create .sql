CREATE TABLE exercise_category (
    cat_id INT NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(40) NOT NULL, 
    PRIMARY KEY (cat_id)
);


CREATE TABLE exercise (
    exer_id INT NOT NULL AUTO_INCREMENT,
    exer_name VARCHAR(60) NOT NULL, 
    exer_description VARCHAR(100) NOT NULL,
    exer_cat_id INT NOT NULL, 
    exer_photo_path VARCHAR(255),  
    PRIMARY KEY (exer_id),
    FOREIGN KEY (exer_cat_id) REFERENCES exercise_category(cat_id)
);


CREATE TABLE serie (
    serie_id INT NOT NULL AUTO_INCREMENT,
    serie_order INT NOT NULL,     
    serie_rep INT NOT NULL,       
    PRIMARY KEY (serie_id)
);


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


CREATE TABLE train (
    train_id INT NOT NULL AUTO_INCREMENT,
    train_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (train_id)
);


CREATE TABLE serie_train (
    serie_id INT NOT NULL,                    
    train_id INT NOT NULL,                    
    train_rest_between_exercises INT NOT NULL DEFAULT 120, 
    PRIMARY KEY (serie_id, train_id),         
    FOREIGN KEY (serie_id) REFERENCES serie(serie_id), 
    FOREIGN KEY (train_id) REFERENCES train(train_id)  
);


CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(60) NOT NULL, 
    user_password VARCHAR(30),
    user_bdate DATE NOT NULL,
    user_gender CHAR(1) NOT NULL, 
    user_email VARCHAR(30),
    user_height DECIMAL(5,2), 
    user_weight DECIMAL(5,2), 
    PRIMARY KEY (user_id)
);


CREATE TABLE user_train (
    user_id INT NOT NULL,
    train_id INT NOT NULL,
    PRIMARY KEY (user_id, train_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (train_id) REFERENCES train(train_id)
);
