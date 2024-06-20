-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT actor_id, first_name, last_name, last_update
FROM actor
WHERE first_name like "A%";

-- 2. film_list 테이블에서 category가 sci-fi 또는 family면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
SELECT title
FROM film_list
WHERE category in ("Sci-Fi", "Family") and rating = 'PG' and title like "%GO%";

-- 3. film 테이블에서 film_id가 7 이하면서 4, 6은 아닌 film_id, title 조회
SELECT FID, title
FROM film_list
WHERE FID <=7 and FID not in('4','6'); 

-- 4. film_list 테이블에서 가격(price)은 2 이상 4 이하이면서 category가 Documentary거나 
-- Animation이고 배우들(actors) 중 BOB가 포함되어 있는 영화 제목(title)만 조회
SELECT title
FROM film_list
WHERE price between 2 and 4 and category in ('Documentary', 'Animation') and actors like "%BOB%";

-- 5. address 테이블에서 거리(district)가 A로 시작하는 주소(address)만 앞에 숫자 제외 주소만 10개 조회 
SELECT substr(address, instr(address, ' '), char_length(address)) as address, district as ''
FROM address
WHERE district like 'A%' and district is not null
ORDER BY district
limit 10;

-- 6. customer 테이블에서 id가 6인 사람부터 10명 조회
SELECT customer_id as 'ID', concat(first_name,' ',last_name) as name
FROM customer
WHERE customer_id >=6
limit 10;

-- 7. actor 테이블에서 first_name이 J로 시작하는 사람의 last_name의 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)
SELECT concat(first_name,'',last_name) as 이름, char_length(concat(first_name,'',last_name)) AS 글자수
FROM actor
WHERE first_name like "J%"
ORDER BY char_length(last_name) DESC;
-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회
SELECT  distinct trim(both ' o' from substr(description, 1, instr(description, "of"))) as list
FROM film
order by list desc
limit 10;

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회
SELECT min(replacement_cost) as "최소 비용",max(replacement_cost) as"최대 비용"
FROM film;
