--alter system set deferred_segment_creation = FALSE;

/* 게시판 */
DROP TABLE BOARD 
	CASCADE CONSTRAINTS;

/* 게시판리스트 */
DROP TABLE BOARD_LIST 
	CASCADE CONSTRAINTS;

/* 게시판형식 */
DROP TABLE BOARD_TYPE 
	CASCADE CONSTRAINTS;

/* 카테고리 */
DROP TABLE CATEGORY 
	CASCADE CONSTRAINTS;

/* 답변형게시판 */
DROP TABLE REBOARD 
	CASCADE CONSTRAINTS;

/* 사진게시판 */
DROP TABLE ALBUM 
	CASCADE CONSTRAINTS;

/* 자료실 */
DROP TABLE BBS 
	CASCADE CONSTRAINTS;

/* 메모글 */
DROP TABLE MEMO 
	CASCADE CONSTRAINTS;
	
DROP SEQUENCE BOARD_TYPE_SEQ;
DROP SEQUENCE CATEGORY_CSEQ;
DROP SEQUENCE BOARD_LIST_SEQ;
DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE REBOARD_RSEQ;
DROP SEQUENCE ALBUM_ASEQ;
DROP SEQUENCE BBS_BSEQ;
DROP SEQUENCE MEMO_MSEQ;

/* 게시판형식 */
CREATE TABLE BOARD_TYPE (
	BTYPE NUMBER NOT NULL, /* 게시판형식번호 */
	BTYPE_NAME VARCHAR2(100) /* 게시판형식이름 */
);

CREATE UNIQUE INDEX PK_BOARD_TYPE
	ON BOARD_TYPE (
		BTYPE ASC
	);

ALTER TABLE BOARD_TYPE
	ADD
		CONSTRAINT PK_BOARD_TYPE
		PRIMARY KEY (
			BTYPE
		);

COMMENT ON TABLE BOARD_TYPE IS '게시판형식';

COMMENT ON COLUMN BOARD_TYPE.BTYPE IS '게시판형식번호';

COMMENT ON COLUMN BOARD_TYPE.BTYPE_NAME IS '게시판형식이름';

CREATE SEQUENCE BOARD_TYPE_SEQ
START WITH 1 INCREMENT BY 1 NOCACHE;

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '공지사항');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '방명록');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '한줄게시판');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '일반게시판');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '답변게시판');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '앨범게시판');

INSERT INTO BOARD_TYPE (BTYPE, BTYPE_NAME)
VALUES (BOARD_TYPE_SEQ.NEXTVAL, '자료실');

COMMIT;


/* 카테고리 */
CREATE TABLE CATEGORY (
	CCODE NUMBER NOT NULL, /* 카테고리번호 */
	CNAME VARCHAR2(100) /* 카테고리이름 */
);

CREATE UNIQUE INDEX PK_CATEGORY
	ON CATEGORY (
		CCODE ASC
	);

ALTER TABLE CATEGORY
	ADD
		CONSTRAINT PK_CATEGORY
		PRIMARY KEY (
			CCODE
		);

COMMENT ON TABLE CATEGORY IS '카테고리';

COMMENT ON COLUMN CATEGORY.CCODE IS '카테고리번호';

COMMENT ON COLUMN CATEGORY.CNAME IS '카테고리이름';

CREATE SEQUENCE CATEGORY_CSEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


INSERT INTO CATEGORY (CCODE, CNAME)
VALUES(CATEGORY_CSEQ.NEXTVAL, '갤럭시S10');

INSERT INTO CATEGORY (CCODE, CNAME)
VALUES(CATEGORY_CSEQ.NEXTVAL, '갤럭시NOTE2');

INSERT INTO CATEGORY (CCODE, CNAME)
VALUES(CATEGORY_CSEQ.NEXTVAL, '아이폰XS'); 


/* 게시판리스트 */
CREATE TABLE BOARD_LIST (
	BCODE NUMBER NOT NULL, /* 게시판번호 */
	BNAME VARCHAR2(100), /* 게시판이름 */
	BTYPE NUMBER, /* 게시판형식번호 */
	CCODE NUMBER /* 카테고리번호 */
);

CREATE UNIQUE INDEX PK_BOARD_LIST
	ON BOARD_LIST (
		BCODE ASC
	);

ALTER TABLE BOARD_LIST
	ADD
		CONSTRAINT PK_BOARD_LIST
		PRIMARY KEY (
			BCODE
		);

COMMENT ON TABLE BOARD_LIST IS '게시판리스트';

COMMENT ON COLUMN BOARD_LIST.BCODE IS '게시판번호';

COMMENT ON COLUMN BOARD_LIST.BNAME IS '게시판이름';

COMMENT ON COLUMN BOARD_LIST.BTYPE IS '게시판형식번호';

COMMENT ON COLUMN BOARD_LIST.CCODE IS '카테고리번호';

CREATE SEQUENCE BOARD_LIST_SEQ
START WITH 1 INCREMENT BY 1 NOCACHE;

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시S10 공지사항', 1, 1);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시S10 일반게시판', 4, 1);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시S10 묻고답하기', 5, 1);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시S10 자랑하기', 6, 1);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시S10 자료실', 7, 1);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 공지사항', 1, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 한줄메모', 3, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 일반게시판', 4, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 답변게시판', 5, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 사진자랑', 6, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '갤럭시NOTE2 자료공유', 7, 2);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '아이폰XS 한줄메모', 3, 3);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '아이폰XS QNA', 5, 3);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '아이폰XS 폰인증', 6, 3);

INSERT INTO BOARD_LIST (BCODE, BNAME, BTYPE, CCODE)
VALUES (BOARD_LIST_SEQ.NEXTVAL, '아이폰XS 앱공유', 7, 3);

COMMIT; 


/* 게시판 */
CREATE TABLE BOARD (
	SEQ NUMBER NOT NULL, /* 글번호 */
	NAME VARCHAR2(10), /* 작성자이름 */
	ID VARCHAR2(16) NOT NULL, /* 작성자아이디 */
	EMAIL VARCHAR2(50), /* 작성자이메일 */
	SUBJECT VARCHAR2(100) NOT NULL, /* 제목 */
	CONTENT CLOB, /* 내용 */
	HIT NUMBER DEFAULT 0, /* 조회수 */
	LOGTIME DATE DEFAULT SYSDATE, /* 작성일자 */
	BCODE NUMBER /* 게시판번호 */
);

CREATE UNIQUE INDEX PK_BOARD
	ON BOARD (
		SEQ ASC
	);

ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD
		PRIMARY KEY (
			SEQ
		);

COMMENT ON TABLE BOARD IS '게시판';

COMMENT ON COLUMN BOARD.SEQ IS '글번호';

COMMENT ON COLUMN BOARD.NAME IS '작성자이름';

COMMENT ON COLUMN BOARD.ID IS '작성자아이디';

COMMENT ON COLUMN BOARD.EMAIL IS '작성자이메일';

COMMENT ON COLUMN BOARD.SUBJECT IS '제목';

COMMENT ON COLUMN BOARD.CONTENT IS '내용';

COMMENT ON COLUMN BOARD.HIT IS '조회수';

COMMENT ON COLUMN BOARD.LOGTIME IS '작성일자';

COMMENT ON COLUMN BOARD.BCODE IS '게시판번호';

CREATE SEQUENCE BOARD_SEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


/* 답변형게시판 */
CREATE TABLE REBOARD (
	RSEQ NUMBER NOT NULL, /* 답변게시판번호 */
	SEQ NUMBER, /* 글번호 */
	REF NUMBER, /* 그룸번호 */
	LEV NUMBER, /* 들여쓰기 */
	STEP NUMBER, /* 답변정렬 */
	PSEQ NUMBER, /* 원글번호 */
	REPLY NUMBER DEFAULT 0 /* 답변갯수 */
);

CREATE UNIQUE INDEX PK_REBOARD
	ON REBOARD (
		RSEQ ASC
	);

ALTER TABLE REBOARD
	ADD
		CONSTRAINT PK_REBOARD
		PRIMARY KEY (
			RSEQ
		);

COMMENT ON TABLE REBOARD IS '답변형게시판';

COMMENT ON COLUMN REBOARD.RSEQ IS '답변게시판번호';

COMMENT ON COLUMN REBOARD.SEQ IS '글번호';

COMMENT ON COLUMN REBOARD.REF IS '그룸번호';

COMMENT ON COLUMN REBOARD.LEV IS '들여쓰기';

COMMENT ON COLUMN REBOARD.STEP IS '답변정렬';

COMMENT ON COLUMN REBOARD.PSEQ IS '원글번호';

COMMENT ON COLUMN REBOARD.REPLY IS '답변갯수';

CREATE SEQUENCE REBOARD_RSEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


/* 사진게시판 */
CREATE TABLE ALBUM (
	ASEQ NUMBER NOT NULL, /* 사진게시판번호 */
	SEQ NUMBER, /* 글번호 */
	ORIGN_PICTURE VARCHAR2(100), /* 원본사진이름 */
	SAVE_PICTURE VARCHAR2(100), /* 저장사진이름 */
	SAVEFOLDER VARCHAR2(30), /* 저장폴더 */
	TYPE NUMBER(1) DEFAULT 0 /* 사진타입 */
);

CREATE UNIQUE INDEX PK_ALBUM
	ON ALBUM (
		ASEQ ASC
	);

ALTER TABLE ALBUM
	ADD
		CONSTRAINT PK_ALBUM
		PRIMARY KEY (
			ASEQ
		);

COMMENT ON TABLE ALBUM IS '사진게시판';

COMMENT ON COLUMN ALBUM.ASEQ IS '사진게시판번호';

COMMENT ON COLUMN ALBUM.SEQ IS '글번호';

COMMENT ON COLUMN ALBUM.ORIGN_PICTURE IS '원본사진이름';

COMMENT ON COLUMN ALBUM.SAVE_PICTURE IS '저장사진이름';

COMMENT ON COLUMN ALBUM.SAVEFOLDER IS '저장폴더';

COMMENT ON COLUMN ALBUM.TYPE IS '사진타입';

CREATE SEQUENCE ALBUM_ASEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


/* 자료실 */
CREATE TABLE BBS (
	BSEQ NUMBER NOT NULL, /* 자료실게시판번호 */
	SEQ NUMBER, /* 글번호 */
	ORIGN_FILE VARCHAR2(100), /* 원본파일이름 */
	SAVE_FILE VARCHAR2(100), /* 저장파일이름 */
	FILESIZE NUMBER, /* 파일크기 */
	SAVEFOLDER VARCHAR2(30) /* 저장폴더 */
);

CREATE UNIQUE INDEX PK_BBS
	ON BBS (
		BSEQ ASC
	);

ALTER TABLE BBS
	ADD
		CONSTRAINT PK_BBS
		PRIMARY KEY (
			BSEQ
		);

COMMENT ON TABLE BBS IS '자료실';

COMMENT ON COLUMN BBS.BSEQ IS '자료실게시판번호';

COMMENT ON COLUMN BBS.SEQ IS '글번호';

COMMENT ON COLUMN BBS.ORIGN_FILE IS '원본파일이름';

COMMENT ON COLUMN BBS.SAVE_FILE IS '저장파일이름';

COMMENT ON COLUMN BBS.FILESIZE IS '파일크기';

COMMENT ON COLUMN BBS.SAVEFOLDER IS '저장폴더';

CREATE SEQUENCE BBS_BSEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


/* 메모글 */
CREATE TABLE MEMO (
	MSEQ NUMBER NOT NULL, /* 메모글번호 */
	SEQ NUMBER, /* 글번호 */
	ID VARCHAR2(16), /* 작성자아이디 */
	NAME VARCHAR2(10), /* 작성자이름 */
	MCONTENT VARCHAR2(500), /* 메모내용 */
	MTIME DATE DEFAULT SYSDATE /* 메모작성일 */
);

CREATE UNIQUE INDEX PK_MEMO
	ON MEMO (
		MSEQ ASC
	);

ALTER TABLE MEMO
	ADD
		CONSTRAINT PK_MEMO
		PRIMARY KEY (
			MSEQ
		);

COMMENT ON TABLE MEMO IS '메모글';

COMMENT ON COLUMN MEMO.MSEQ IS '메모글번호';

COMMENT ON COLUMN MEMO.SEQ IS '글번호';

COMMENT ON COLUMN MEMO.ID IS '작성자아이디';

COMMENT ON COLUMN MEMO.NAME IS '작성자이름';

COMMENT ON COLUMN MEMO.MCONTENT IS '메모내용';

COMMENT ON COLUMN MEMO.MTIME IS '메모작성일';

CREATE SEQUENCE MEMO_MSEQ
START WITH 1 INCREMENT BY 1 NOCACHE;


ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_BOARD_LIST_TO_BOARD
		FOREIGN KEY (
			BCODE
		)
		REFERENCES BOARD_LIST (
			BCODE
		);

ALTER TABLE BOARD_LIST
	ADD
		CONSTRAINT FK_BOARD_TYPE_TO_BOARD_LIST
		FOREIGN KEY (
			BTYPE
		)
		REFERENCES BOARD_TYPE (
			BTYPE
		);

ALTER TABLE BOARD_LIST
	ADD
		CONSTRAINT FK_CATEGORY_TO_BOARD_LIST
		FOREIGN KEY (
			CCODE
		)
		REFERENCES CATEGORY (
			CCODE
		);

ALTER TABLE REBOARD
	ADD
		CONSTRAINT FK_BOARD_TO_REBOARD
		FOREIGN KEY (
			SEQ
		)
		REFERENCES BOARD (
			SEQ
		);

ALTER TABLE ALBUM
	ADD
		CONSTRAINT FK_BOARD_TO_ALBUM
		FOREIGN KEY (
			SEQ
		)
		REFERENCES BOARD (
			SEQ
		);

ALTER TABLE BBS
	ADD
		CONSTRAINT FK_BOARD_TO_BBS
		FOREIGN KEY (
			SEQ
		)
		REFERENCES BOARD (
			SEQ
		);

ALTER TABLE MEMO
	ADD
		CONSTRAINT FK_BOARD_TO_MEMO
		FOREIGN KEY (
			SEQ
		)
		REFERENCES BOARD (
			SEQ
		);

