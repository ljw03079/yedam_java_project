package co.yedam.board;

public class SQLquery {
	//게시판 앱
	//글쓰기, 수정, 삭제, 목록(페이징) 종료 -> 파일 저장, 시작하면 파일 로드
	//
	//항목:
	//글번호/ 제목/ 내용/ 작성자/ 작성일자/ 수정일자
	//
	//jdbc 활용
	//
	//<sql 관리자>
	//create user proj identified by proj;
	//alter user proj default tablespace users
	//quota unlimited on users;
	//grant connect, resource to proj;
	//
	//<proj>
	//create table board(
	// brd_no number primary key,
	// brd_title varchar2(50) not null,
	// brd_content varchar2(500) not null,
	// brd_writer varchar2(30) not null,
	// write_date date default sysdate,
	// update_date date default sysdate
	//);
//
	//update board set brd_content = 'aaa'
	//where brd_no = 5;
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (1, 'test1', 'content1', 'user1');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (2, 'test2', 'content2', 'user2');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (3, 'test3', 'content3', 'user3');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (4, 'test4', 'content4', 'user1');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (5, 'test5', 'content5', 'user2');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (6, 'test6', 'content6', 'user3');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (7, 'test7', 'content7', 'user1');
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values (8, 'test8', 'content8', 'user2');
//
//	commit;
//
//	select *
//	from board;
//
//	select nvl(max(brd_no),0)+1 from board;
//
//	insert into board (brd_no, brd_title, brd_content, brd_writer)
//	values ((select nvl(max(brd_no),0)+1 from board), 'test', 'content', 'user1');
//
//	select * 
//	from (select rownum rn, a.*
//	      from (select * from board
//	            order by brd_no) a
//	      where rownum <= (page * 5)) b
//	where b.rn > (page-1)*5;
//
//	select count(*) as cnt from board;
//
//	create table users (
//	 user_id varchar2(30) primary key,
//	 user_pw varchar2(10) not null,
//	 user_nm varchar2(50) not null
//	);
//
//	insert into users(user_id, user_pw, user_nm)
//	values ('user1', '1111', '홍길동');
//
//	insert into users(user_id, user_pw, user_nm)
//	values ('user2', '2222', '박길동');
//
//	insert into users(user_id, user_pw, user_nm)
//	values ('user3', '3333', '김길동');
//
//	insert into users(user_id, user_pw, user_nm)
//	values ('user4', '4444', '최길동');
//
//	commit;
//
//	select * from users;
//	
//	--댓글
//	3번 테스트 user3
//	 1. 첫번째 댓글입니다. user2
//	 2. 두번째 댓글입니다. user1
//	 5. 다섯번째 댓글입니다. user1
//	 8. 여덟번째 댓글입니다. user1
//	 ...
//	(항목: 댓글번호, 원본글번호, 댓글내용(상세보기에 표시되도록), 작성자) - Reply.java 클래스 선언
//	(기능: 댓글등록, 댓글목록, 댓글삭제)	   - ReplyService.java 인터페이스 선언(파일, Jdbc 두개)
//								   - ReplyServiceImpl or ReplyServiceJdbc
}
