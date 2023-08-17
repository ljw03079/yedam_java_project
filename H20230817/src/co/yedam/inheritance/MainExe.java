package co.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		CellPhone cell = new CellPhone();
		cell.setModel("SM1100");
		cell.setColor("black");
		cell.turnOn(); //부모 기능
		cell.turnOff();

		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("DMb1100");
		dmb.setColor("white");
		dmb.turnOn(); //자식 기능
		dmb.turnOff();

		dmb.turnOnDmb();

		CellPhone cell2 = new DmbCellPhone(); // promotion 내부적인 행변환(데이터타입 변환)이 일어남
		cell2.turnOn();
		// cell2.turnOnDmb();//불가, 부모클래스가 가지고 있는 메소드만 사용가능

		if (cell2 instanceof DmbCellPhone) {
			DmbCellPhone dmb2 = (DmbCellPhone) cell2; // casting 강제 변환, cell2는 Dmb클래스의 인스턴스이기에 가능
			dmb2.turnOnDmb(); // 자식클래스에 정의된 기능 사용가능
		}

		if (cell instanceof DmbCellPhone) {
			DmbCellPhone dmb3 = (DmbCellPhone) cell; // 문법상 오류는 없지만 ClassCastException 발생, if구문 사용
			dmb3.turnOnDmb();
		}
		
		//
		CellPhone[] phones = new CellPhone[5];
		phones[0] = cell;
		phones[1] = dmb; //자동 promotion 자식도 배열에 담을 수 있음
		
		phones[0].turnOn(); //CellPhone 인스턴스
		phones[1].turnOn(); //DmbCellPhone 인스턴스
		//같은 실행방식이지만 결과가 다름 -> 다형성
		
		
		
	}
}