/* 비콘지역정보 */
DROP TABLE REGION_INFO 
	CASCADE CONSTRAINTS;

/* 지역정보 */
DROP TABLE LOCAL_INFO 
	CASCADE CONSTRAINTS;

/* 사용자정보 */
DROP TABLE USER_INFO 
	CASCADE CONSTRAINTS;

/* 자료정보 */
DROP TABLE DATA_INFO 
	CASCADE CONSTRAINTS;

/* 비콘지역정보 */
CREATE TABLE REGION_INFO (
	REGION_NO INTEGER NOT NULL, /* 비콘번호 */
	REGION_NAME VARCHAR2(50) NOT NULL, /* 비콘지역이름 */
	UUID VARCHAR2(255) NOT NULL, /* UUID */
	MAJOR INTEGER NOT NULL, /* major */
	MINOR INTEGER NOT NULL, /* minor */
	LOCAL_NO INTEGER NOT NULL /* 지역번호 */
);

/* 지역정보 */
CREATE TABLE LOCAL_INFO (
	LOCAL_NO INTEGER NOT NULL, /* 지역번호 */
	MANAGER_ID VARCHAR(255) NOT NULL, /* 관리자ID */
	LOCAL_NAME VARCHAR2(50) NOT NULL, /* 지역이름 */
	GPS_X VARCHAR2(255) NOT NULL, /* GPS_X */
	GPS_Y VARCHAR2(255) NOT NULL /* GPS_Y */
);

/* 사용자정보 */
CREATE TABLE USER_INFO (
	USER_ID VARCHAR(255) NOT NULL, /* 사용자id */
	MOBILE_INFO VARCHAR2(255) NOT NULL, /* 기기정보 */
	LANGUAGE_INFO VARCHAR2(255) /* 언어정보 */
);

/* 자료정보 */
CREATE TABLE DATA_INFO (
	DATA_NO INTEGER NOT NULL, /* 자료번호 */
	DATA_PATH VARCHAR(255) NOT NULL, /* 파일경로 */
	DATA_TYPE INTEGER NOT NULL, /* 자료타입 */
	LOCAL_NO INTEGER NOT NULL, /* 지역번호 */
	REGION_NO INTEGER /* 비콘번호 */
);

