-- Sakila : DVD 대여 및 영화 정보와 관련된 데이터 포함

SELECT * FROM category; -- 영화 카테고리 정보 : category_id
SELECT * FROM rental; -- DVD 대여 정보 : customer_id, inventory_id
SELECT * FROM inventory; -- DVD 대여점에서 관리하는 정보 : inventory_id, film_id
SELECT * FROM film; -- 영화 정보 : film_id
SELECT * FROM actor; -- 영화 배우 정보 : actor_id

SELECT * FROM film_category; -- film과 category 연결 : film_id, category_id
SELECT * FROM film_actor; -- film과 actor 연결 : film_id, actor_id

-- DVD 대여 고객 정보 : customer_id, address_id, first_name, last_name
SELECT * FROM customer; 

SELECT * FROM address; -- 고객 주소 정보 : address_id, city_id, address, district
SELECT * FROM city; -- city_id, country_id, city
SELECT * FROM country; -- country_id, country

-- 1. customer 테이블의 first_name이 TRACY인 사람들 조회 
SELECT country, city, address, district, first_name, last_name
FROM customer
JOIN address USING (address_id)
JOIN city USING (city_id)
JOIN country USING (country_id)
WHERE first_name = "TRACY";

-- 2. 배우 JULIA MCQUEEN이 찍은 영화 제목 조회 (title 기준 정렬 10개까지)
SELECT first_name, last_name, title
FROM film
JOIN film_actor USING (film_id)
JOIN actor USING (actor_id)
WHERE first_name = "JULIA" AND last_name = "MCQUEEN"
ORDER BY title
LIMIT 0,10;


-- 3. 영화 NOON PAPI에 나오는 배우들의 이름 조회
SELECT distinct first_name, last_name
FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE title = "NOON PAPI";
-- 4. 각 카테고리별 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 빌린 DVD 대여 수 조회
SELECT name as category, count(name) as count
FROM customer
JOIN rental USING (customer_id)
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
JOIN film_category USING (film_id)
JOIN category USING (category_id)
WHERE email = "JOYCE.EDWARDS@sakilacustomer.org"
GROUP BY name;
-- 5. 이메일이 JOYCE.EDWARDS@sakilacustomer.org인 고객이 가장 최근에 빌린 영화 제목과 영화 내용을 조회 

SELECT title, description
FROM customer
JOIN rental USING (customer_id)
JOIN inventory USING (inventory_id)
JOIN film USING (film_id)
JOIN film_category USING (film_id)
JOIN category USING (category_id)
WHERE email = "JOYCE.EDWARDS@sakilacustomer.org" and rental_date = (SELECT max(rental_date)
FROM customer
JOIN rental USING (customer_id)
WHERE email ="JOYCE.EDWARDS@sakilacustomer.org" );

