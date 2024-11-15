CREATE TABLE exercise (
    exer_id INT NOT NULL AUTO_INCREMENT,
    exer_name VARCHAR(60) NOT NULL, 
    exer_description VARCHAR(100) NOT NULL,
    exer_cat_id INT, 
    PRIMARY KEY (exer_id),
    FOREIGN KEY (exer_cat_id) REFERENCES exercise_category(cat_id)
);


CREATE TABLE exercise_category (
    cat_id INT NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(40) NOT NULL, 
    PRIMARY KEY (cat_id)
);


CREATE TABLE train (
    train_id INT NOT NULL AUTO_INCREMENT,
    train_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (train_id)
);


CREATE TABLE user (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(60) NOT NULL, 
    user_password VARCHAR(30),
    user_bdate DATE NOT NULL,
    user_gender CHAR(1) NOT NULL, 
    user_email VARCHAR(30),
    PRIMARY KEY (user_id)
);


CREATE TABLE plan (
    plan_id INT NOT NULL AUTO_INCREMENT,
    plan_name VARCHAR(40) NOT NULL,
    plan_desc VARCHAR(100),
    user_id INT NOT NULL,
    PRIMARY KEY (plan_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);


CREATE TABLE serie (
    serie_id INT NOT NULL AUTO_INCREMENT,
    serie_order INT NOT NULL,        
    serie_rep INT NOT NULL,            
    serie_exer_id INT NOT NULL,        
    serie_train_id INT NOT NULL,       
    plan_id INT NOT NULL,              
    PRIMARY KEY (serie_id),
    FOREIGN KEY (serie_exer_id) REFERENCES exercise(exer_id),
    FOREIGN KEY (serie_train_id) REFERENCES train(train_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);


CREATE TABLE user_plan (
    user_id INT NOT NULL,
    plan_id INT NOT NULL,
    PRIMARY KEY (user_id, plan_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (plan_id) REFERENCES plan(plan_id)
);