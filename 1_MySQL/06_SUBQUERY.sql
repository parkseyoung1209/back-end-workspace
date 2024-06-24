/*
	SUBQUERY(서브쿼리), 중첩쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SQL문
    -서브쿼리를 수행한 결과값이 몇 행 몇 열이냐에 따라 분류 
    -서브쿼리 종류에 따라 서브 쿼리와 사용하는 연산자가 달라짐
    
    1. 단일 행 서브쿼리(SINGLE ROW SUBQUERY)
    - 서브쿼리의 조회 결과값의 개수가 오로지 1개일 때(한 행 한 열)
    - 일반 비교연산자 사용 가능 : =, !=, <>, >=, <=, ...
*/

-- 노옹철 사원과 같은 부서원들을 조회
-- 1) 노옹철 사원의 부서코드 조회
SELECT dept_code
FROM employee
WHERE emp_name = "노옹철"; -- D9

-- 2) 부서코드가 'D9'인 사원들 조회
SELECT *
FROM employee
WHERE dept_code = "D9"; 

-- 3) 위의 2단계를 하나의 쿼리문으로!
SELECT *
FROM employee
WHERE dept_code= (SELECT dept_code
FROM employee
WHERE emp_name = "노옹철");

-- 전 직원의 평균 급여보다 더 많은 급여를 받는 사원들의 사번, 사원명 ,직급코드, 급여 조회
SELECT emp_id as 사번, emp_name as 사원, dept_code as 직급코드, concat(format(salary, 0), "원") as 월급
FROM employee
WHERE salary > (SELECT avg(salary) FROM employee);
-- 전지연 사원이 속해있는 부서원들의 사번, 직원명, 전화번호, 직급명, 부서명, 입사일 조회(전지연은 제외)
SELECT emp_id, emp_name, phone, job_name, dept_title, hire_date
FROM employee
JOIN job USING (job_code)
JOIN department ON (dept_code = dept_id)
WHERE dept_code = (SELECT dept_code
FROM employee
WHERE emp_name='전지연') and emp_name != '전지연';


-- 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합 조회

SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
order by 2 DESC
LIMIT 1;

-- 서브쿼리 특징! 쿼리 자체는 직관적!
-- 쿼리 속도 중요시! 서브쿼리는 상대적으로 느리다
-- 가급적으로 서브쿼리를 사용하지 않아도 되는 거면 안쓰고 하는 걸 추천!
SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code) as dept_sum;

SELECT dept_code, sum(salary)
FROM employee
GROUP BY dept_code
having sum(salary) = (SELECT max(sum_sal)
FROM (SELECT dept_code, sum(salary) sum_sal
FROM employee
GROUP BY dept_code) as dept_sum);

/*
	2. 다중행 서브쿼리
    - 서브쿼리의 조회 결과 값의 개수가 여러 행일 때 (여러행 한열)
    
    IN 서브쿼리 : 여러 개의 결과값 중에서 한개라도 일치하는 값이 있다면
*/

-- 각 부서별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
SELECT emp_name, job_code, dept_code, salary 
FROM employee
WHERE salary IN (SELECT max(salary)
FROM employee
GROUP BY dept_code);

-- 직원에 대한 사번, 이름, 부서코드, 구분(사수/사원) 조회
SELECT emp_id, emp_name, dept_code, 
if(emp_id IN (SELECT DISTINCT manager_id
FROM employee
WHERE manager_id is not null), "사수" ,"사원") 구분
FROM employee;

/*
	컬럼 > ANY (서브쿼리) : 여러 개의 결과값 중에서 "한개라도" 클 경우
    컬럼 < ANY (서브쿼리) : 여러 개의 결과값 중에서 "한개라도" 작을 경우
    --> OR
*/
-- 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 과장 직급들의 급여
SELECT salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = '과장';


SELECT emp_id, emp_name, job_name, salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = "대리" and salary > ANY (SELECT salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = '과장'
);
/*
	컬럼 > ALL (서브쿼리) : 여러개의 "모든" 결과값들보다 클 경우
    컬럼 < ALL (서브쿼리) : 여러개의 "모든" 결과값들보다 작을 경우
    --> AND
*/
SELECT salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = '차장'; -- 280, 155, 249, 248

SELECT salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = '과장'; -- 220, 250, 376

SELECT emp_id, emp_name, job_name, salary
FROM employee
JOIN job USING (job_code)
WHERE job_name =  "과장" and salary > ALL (SELECT salary
FROM employee
JOIN job USING (job_code)
WHERE job_name = '차장'
); -- 가장 높은 값과 비교하여 조건을 만족한 값을 출력
/*
	3. 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 한 행이지만 컬럼이 여러개일 때(한 행 여러 열)
*/
-- 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들의 사원명, 부서코드, 조회

SELECT job_code, emp_name, dept_code
FROM employee
JOIN job USING (job_code)
WHERE emp_name = '하이유';

SELECT job_code, emp_name, dept_code
FROM employee
JOIN job USING (job_code)
WHERE job_code = (SELECT job_code
FROM employee
JOIN job USING (job_code)
WHERE emp_name = '하이유') and dept_code = (SELECT dept_code
FROM employee
JOIN job USING (job_code)
WHERE emp_name = '하이유');

-- 다중열 서브쿼리
SELECT job_code, emp_name, dept_code
FROM employee
JOIN job USING (job_code)
WHERE (dept_code, job_code) = (SELECT dept_code, job_code
FROM employee
JOIN job USING (job_code)
WHERE emp_name = '하이유');

SELECT distinct manager_id
FROM employee
WHERE manager_id is not null;


SELECT emp_id, emp_name, job_code, manager_id
FROM employee
WHERE (job_code, manager_id) = (
SELECT job_code, manager_id
FROM employee
WHERE emp_name = "박나라" and manager_id is not null);
/*
	4. 다중행 다중열 서브쿼리
    - 서브쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT job_name, min(salary)
FROM employee
JOIN job USING (job_code)
GROUP BY job_name;

SELECT emp_id, emp_name, job_code, salary
FROM employee
WHERE (job_code, salary) IN (SELECT job_code, min(salary)
FROM employee
JOIN job USING (job_code)
GROUP BY job_code);


-- 각 부서별 최대 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회 (부서없음 명시)
SELECT emp_id, max(salary)
FROM employee
group by emp_id;


SELECT emp_id, emp_name, ifnull(dept_code, "부서없음"), salary
FROM employee
WHERE (ifnull(dept_code, "부서없음"), salary) IN (SELECT ifnull(dept_code, "부서없음"), max(salary)
FROM employee
group by emp_id);