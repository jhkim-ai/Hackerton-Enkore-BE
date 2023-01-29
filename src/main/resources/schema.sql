-- 모든 테이블 지우기
DROP ALL OBJECTS;

-- 회원
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS COMMENT '회원' (
      USER_ID      VARCHAR(64)  NOT NULL    COMMENT '회원 ID'
    , USER_NAME    VARCHAR(30)  NOT NULL    COMMENT '회원명'
    , USER_TYPE    VARCHAR(10)              COMMENT '회원 유형'
    , USER_STAT    VARCHAR(10)              COMMENT '회원 상태'
    , PRIMARY KEY (USER_ID)
);
