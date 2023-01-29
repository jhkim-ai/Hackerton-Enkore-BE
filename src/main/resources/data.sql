-- 사용자
DELETE FROM USERS CASCADE;

INSERT INTO USERS
VALUES (1, '이수경', 'NORMAL', 'RESIGN')
     , (2, '최상면', 'ENTERPRISE', 'ACTIVE')
     , (3, '강재석', 'NORMAL', 'ACTIVE')
     , (4, '김구현', 'NORMAL', 'ACTIVE')
     , (5, '홍길동', 'NORMAL', 'ACTIVE')
     , (6, '홍길순', 'NORMAL', 'ACTIVE')
;
