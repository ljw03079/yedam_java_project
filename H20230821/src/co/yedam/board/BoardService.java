package co.yedam.board;

import java.util.List;

//파일저장, DB저장 -> 규칙정해놓으면 해당되는 메소드로 기능구현
public interface BoardService {
	//등록(추가)
	public boolean add(Board board);
	//목록
	public List<Board> list(int page);
	public int getTotal();
	//수정: 글내용 수정
	public boolean modify(Board board);
	//삭제
	public boolean remove(int brdNo);
	//상세조회->글번호 기준
	public Board search(int brdNo);
	//종료, 파일 저장때문에 생성
	public void save();
}


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

//update board set brd_content = 'aaa'
//where brd_no = 5;