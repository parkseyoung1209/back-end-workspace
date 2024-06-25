/*
	TCL(Transaction Control Language)
    - 트랜잭션을 제어하는 언어
    - 데이터베이스는 데이터 변경 사항(INSERT, UPDATE, DELETE)
		하나의 트랜잭션에 담아서 처리
        
	트랜잭션(Transaction)
    - 하나의 논리적인 작업 단위
    ex) ATM에서 현금 출력
    1. 카드 삽입
    2. 메뉴 선택
    3. 금액 확인
    4. 인증 - 비밀번호 입력
    5. 실제 계좌에서 금액만큼 인출
    6. 현금 인출
    7. 완료
    -- > 각각의 업무들을 묶어서 하나의 작업 단위로 만드는 것을 트랜직션이라고 한다.
    
    COMMIT : 모든 작업들을 정상적으로 처리하겠다고 확정하는 구문
    ROLLBACK : 모든 작업들을 취소하겠다고 확정하는 구문 (마지막 COMMIT 시점으로 돌아간다.)
*/
-- MySQL에서는 기본적으로 autocommit 모드가 활성화되어 있음
-- 비활성화
set autocommit = 0;

-- 트랜잭션 시작!
START transaction;

CREATE TABLE dept_copy
SELECT * FROM kh.department;

CREATE TABLE emp_salary
SELECT emp_id, emp_name, dept_code, salary, bonus
	FROM kh.employee;

-- dept_copy 테이블에서 dept_id가 'D9'인 부서명을 '전략기획팀'으로 수정
-- UPDATE 테이블명 SET 변경할 내용 WHERE 조건
DROP TABLE dept_copy;
DROP TABLE emp_salary;
UPDATE dept_copy 
SET dept_title = '전략기획팀'
WHERE dept_id = 'D9';


ROLLBACK;
SELECT * FROM dept_copy;
COMMIT;

-- emp_salary 테이블에서 노옹철 사원의 급여를 3000000원으로 변경 O
UPDATE emp_salary
SET salary = 3000000
WHERE emp_name = '노옹철';
-- emp_salary에서 emp_id가 213, 218인 사원 삭제 o
-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM emp_salary WHERE emp_id in (213, 218);

DELETE FROM emp_salary
WHERE emp_id = 200;

rollback;
SELECT *
FROM emp_salary;
-- DDL 구문을 실행하는 순간 임시 저장된 변경사항들을 무조건 반영!
CREATE TABLE test(
tid INT
);





