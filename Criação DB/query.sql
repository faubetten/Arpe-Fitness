-- 1. Exibir todos os exercícios com o nome da categoria e descrição
SELECT 
    e.exer_name, 
    e.exer_description, 
    ec.cat_name
FROM 
    exercise e
JOIN 
    exercise_category ec ON e.exer_cat_id = ec.cat_id
ORDER BY 
    ec.cat_name, e.exer_name;

-- 2. Exibir todos os treinos e os usuários associados a esses treinos
SELECT 
    t.train_name, 
    u.user_name
FROM 
    train t
JOIN 
    user_train ut ON t.train_id = ut.train_id
JOIN 
    user u ON ut.user_id = u.user_id
ORDER BY 
    t.train_name;

-- 3. Exibir todas as séries de exercícios com detalhes do exercício, treino e plano
SELECT 
    s.serie_order, 
    s.serie_rep, 
    ex.exer_name, 
    t.train_name, 
    p.plan_name
FROM 
    serie s
JOIN 
    exercise ex ON s.serie_exer_id = ex.exer_id
JOIN 
    serie_train st ON s.serie_id = st.serie_id
JOIN 
    train t ON st.train_id = t.train_id
JOIN 
    plan p ON s.plan_id = p.plan_id
ORDER BY 
    p.plan_name, s.serie_order;

-- 4. Exibir todos os usuários e os planos de treino aos quais estão associados
SELECT 
    u.user_name, 
    p.plan_name
FROM 
    user u
JOIN 
    user_plan up ON u.user_id = up.user_id
JOIN 
    plan p ON up.plan_id = p.plan_id
ORDER BY 
    u.user_name;

-- 5. Exibir todos os planos de treino com o número de exercícios por plano
SELECT 
    p.plan_name, 
    COUNT(s.serie_id) AS num_exercises
FROM 
    plan p
JOIN 
    serie s ON p.plan_id = s.plan_id
GROUP BY 
    p.plan_name
ORDER BY 
    num_exercises DESC;

-- 6. Exibir todos os treinos com o tempo de descanso entre os exercícios
SELECT 
    train_name, 
    train_rest_between_exercises
FROM 
    train
ORDER BY 
    train_name;

-- 7. Exibir todos os exercícios de uma categoria específica, por exemplo "Força"
SELECT 
    e.exer_name, 
    e.exer_description
FROM 
    exercise e
JOIN 
    exercise_category ec ON e.exer_cat_id = ec.cat_id
WHERE 
    ec.cat_name = 'Força'
ORDER BY 
    e.exer_name;

-- 8. Exibir o plano de treino com mais séries de exercícios
SELECT 
    p.plan_name, 
    COUNT(s.serie_id) AS num_series
FROM 
    plan p
JOIN 
    serie s ON p.plan_id = s.plan_id
GROUP BY 
    p.plan_name
ORDER BY 
    num_series DESC
LIMIT 1;

-- 9. Exibir todos os usuários que estão no plano "Plano Full Body"
SELECT 
    u.user_name
FROM 
    user u
JOIN 
    user_plan up ON u.user_id = up.user_id
JOIN 
    plan p ON up.plan_id = p.plan_id
WHERE 
    p.plan_name = 'Plano Full Body';

-- 10. Exibir todos os exercícios e o número de séries, pesos e repetições para um usuário específico
SELECT 
    u.user_name,
    e.exer_name,
    es.num_series,
    es.weight_kg,
    es.num_reps
FROM 
    user u
JOIN 
    user_train ut ON u.user_id = ut.user_id
JOIN 
    serie_train st ON ut.train_id = st.train_id
JOIN 
    exer_serie es ON st.serie_id = es.serie_id
JOIN 
    exercise e ON es.exer_id = e.exer_id
WHERE 
    u.user_name = 'João Silva'
ORDER BY 
    e.exer_name;
