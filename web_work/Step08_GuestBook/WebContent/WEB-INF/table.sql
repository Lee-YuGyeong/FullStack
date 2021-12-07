CREATE TABLE guest_book(
   num NUMBER PRIMARY KEY,
   writer VARCHAR2(20) NOT NULL,
   title VARCHAR2(30),
   content CLOB,
   pwd VARCHAR2(20),
   regdate DATE
);

CREATE SEQUENCE guest_book_seq;
