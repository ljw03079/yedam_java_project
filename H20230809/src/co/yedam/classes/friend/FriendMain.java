package co.yedam.classes.friend;

public class FriendMain {
	public static void main(String[] args) {
		System.out.println(args[0]+args[1]+args[2]+args.length);
		//FriendApp.start(); //정적 메소드, static이 붙는 메소드
		//static이 없는 인스턴스 메소드는 호출해야 기능을 쓸 수 있음
		FriendApp app = new FriendApp();
		app.start();//정적 -> 인스턴스 메소드
	}
}
