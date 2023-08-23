package co.yedam.board;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

//요청처리 기능만 담음, 사용자가 보는 화면
public class BoardApp {
	
	Scanner scn = new Scanner(System.in);
	//BoardService service = new BoardServiceImpl();//파일저장, DB저장 구현 클래스 각각 생성 후 적용
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceJdbc();
	ReplyService rservice = new ReplyServiceJdbc();
	
	String logId;
	
	public void start() {
		//id, pw

		while(true) {
			String id = printString("id");
			String pw = printString("pass");
			User user = new User();
			user.setUserId(id);
			user.setUserPw(pw);
			user = uservice.checkLogin(user);
			if(user != null) {
				System.out.println(user.getUserName()+", 환영합니다");
				logId = id;
				break;
			}
			System.out.println("로그인 실패");
		}
		boolean run = true;
		
		while(run) {
			System.out.println("================================================================");
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 6.댓글등록 7.댓글목록 8.댓글삭제 9.종료");
			System.out.println("================================================================");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt(); scn.nextLine();
			
			switch(menu) {
			case 1://등록
				register();
				break;
			case 2://목록
				boardList();
				break;
			case 3://수정
				modify();
				break;
			case 4://삭제
				remove();
				break;
			case 5://상제조회
				search();
				break;
			case 6:
				rpRegister();
				break;
			case 7:
				rpList();
				break;
			case 8:
				rpRemove();
				break;
			case 9:
				System.out.println("종료합니다.");
				service.save();
				rservice.rpSave();
				run = false;
			}
		}
		System.out.println("end of prog.");
	}//end of start
	
	private String printString(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
	
	void register() {
		String title = printString("제목입력");
		String content = printString("내용입력");
		String writer = logId;//printString("작성자입력");
		
		Board board = new Board(title, content, writer);
		
		if(service.add(board)) {
			System.out.println("<<등록성공!!>>");
		}else {
			System.out.println("<<등록실패!!>>");
		}
		
	}
	
	void boardList() {
		int page = 1;
		while(true) {
			List<Board> list = service.list(page);
			for(Board b : list) {
				System.out.println(b.listInfo());
			}
			// 4 > 1page, 9 > 2page, 19 > 4page
			int totalCnt = service.getTotal();
			int lastPage = (int) Math.ceil(totalCnt/5.0);//5.0으로 해주어야 소수점까지 계산
			for(int i=1; i<=lastPage; i++) {
				if(i == page) {
				System.out.printf("[%d]",i);
				} else {
					System.out.printf(" %d ",i);
				}
			}
			System.out.println();
			System.out.print("조회페이지 입력(exit: 9)>> ");
			page = scn.nextInt();
			if(page == 9) {
				break;
			}
		}
	}
	
	void modify() {
		String brdNo = printString("번호입력");
		if(!service.getResponseUser(Integer.parseInt(brdNo)).equals(logId)) {
			System.out.println("<<권한없음!!>>");
			return;//메소드 중지
		}
		String content = printString("내용입력");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if(service.modify(brd)) {
			System.out.println("<<수정성공!!>>");
		}
	}
	
	void remove() {
		String brdNo = printString("번호입력");
		if(!service.getResponseUser(Integer.parseInt(brdNo)).equals(logId)) {
			System.out.println("<<권한없음!!>>");
			return;//메소드 중지
		}
		if(service.remove(Integer.parseInt(brdNo))) {
			System.out.println("<<삭제성공!!>>");
		}
	}
	
	void search() {
		String brdNo = printString("번호입력");
		Board result = service.search(Integer.parseInt(brdNo));
		if(result == null) {
			System.out.println("<<해당글번호가 없습니다.>>");
		} else {
			System.out.println(result.showInfo());
			ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
			rapp.ReplyStart(); //등록,목록,삭제 기능
		}
		
//		System.out.println("===== 댓글 =====");
//		boolean rpResult = rservice.rpSearch(Integer.parseInt(brdNo));
//		System.out.println("===============");
//		if(!rpResult) {
//			System.out.println("해당댓글이 없습니다.");
//		}
	}
	
	void rpRegister() {
		int brdNo = Integer.parseInt(printString("원본글번호입력"));
		String rpContent = printString("댓글내용입력");
		String rpWriter = logId;
		
		Reply reply = new Reply(brdNo, rpContent, rpWriter);
		System.out.println(reply.showInfo());
		if(rservice.rpAdd(reply)) {
			System.out.println("댓글등록성공");
		}else {
			System.out.println("댓글등록실패");
		}
	}
	void rpList() {
		int brdNo = Integer.parseInt(printString("원본글번호입력"));
		List<Reply> rList = rservice.rpList();
		for(int i=0; i<rList.size(); i++) {
			if(rList.get(i).getBrdNo() == brdNo) {
				System.out.println(rList.get(i).showInfo());
			}
		}
		
	}
	void rpRemove() {
		int rpNo = Integer.parseInt(printString("댓글번호입력"));
		if(rservice.rpRemove(rpNo)) {
			System.out.println("삭제성공!!");
		}else {
			System.out.println("삭제실패!!");
		}
	}
	
	class ReplyApp{
		//search 메소드에 아래 코드 입력
		//ReplyApp rapp = new ReplyApp(Integer.parseInt(brdNo));
		//rapp.ReplyStart(); //등록,목록,삭제 기능
		
		//필드
		private ReplyService rservice = new ReplyServiceImpl();
		private int brdNo;//중첩클래스는 반드시 원본클래스의 필드가 있어야함.
		
		//생성자
		ReplyApp(int brdNo){
			this.brdNo = brdNo;
		}
		
		//메소드
		public void ReplyStart() {
			boolean run = true;
			
			while(run) {
				System.out.println("1.댓글등록 2.댓글목록 3.댓글삭제 4.이전메뉴");
				int menu = Integer.parseInt(printString("선택"));
				
				switch(menu) {
				case 1:
					rpRegister();
					break;
				case 2:
					rpList();
					break;
				case 3:
					rpRemove();
					break;
				case 4:
					System.out.println("이전메뉴로 돌아갑니다.");
					rservice.rpSave();
					run = false;
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
			}
		}
		
		void rpRegister() {
			String rpContent = printString("댓글내용입력");
			String rpWriter = logId;
			
			Reply reply = new Reply(brdNo, rpContent, rpWriter);
			System.out.println(reply.showInfo());
			if(rservice.rpAdd(reply)) {
				System.out.println("댓글등록성공");
			}else {
				System.out.println("댓글등록실패");
			}
		}
		
		void rpList() {
			List<Reply> rList = rservice.rpList();
			for(int i=0; i<rList.size(); i++) {
				if(rList.get(i).getBrdNo() == brdNo) {
					System.out.println(rList.get(i).showInfo());
				}
			}
		}
		
		void rpRemove() {
			int rpNo = Integer.parseInt(printString("댓글번호입력"));
			if(rservice.rpRemove(rpNo)) {
				System.out.println("삭제성공!!");
			}else {
				System.out.println("삭제실패!!");
			}
		}
	}
}

//writeDate, updateDate: 현재시간
//lastUpdate 필드 생성 후 수정할때마다 updateDate 수정되도록
//목록, 상세조회 수정
