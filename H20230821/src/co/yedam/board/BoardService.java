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
	//글번호 입력 -> 작성자 반환
	public String getResponseUser(int brdNo);
}