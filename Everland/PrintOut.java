package Everland;

public class PrintOut {
	
	void ChooseType() {
		System.out.printf("\t\t\t\t   거래번호: %03d\n",CsvSaver.count);
		System.out.println("==================에버랜드======================");
		System.out.println("권종을 선택하세요.");
		System.out.printf("1.%s\n2.%s","주간권", "야간권");
	}
	
	void SecurityNum() {
		System.out.println("주민번호를 입력하세요.");
	}
	
	void Counts_ticket() {
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
	}
	
	void DisCount() {
		for (int i = 0; i < Integer_C.DC_Type.length; i++) {
			System.out.printf("%d. %s\n",i+1,Integer_C.DC_Type[i]);
		}
	}
	
	void GoStop(InputData dt) {
		System.out.printf("가격은 %d원 입니다.",dt.i_Total);
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료");
		
	}
	
	void ShowResult() {
		System.out.println("티켓 발권을 종료합니다. 감사합니다.");
		System.out.println("==================에버랜드======================");
		int sum = 0;
		for (int i = 0; i <Integer_C.DataSet.size(); i+=5) {
			System.out.printf("%s  %8.6s  X %2.2s%10.10s원  *우대적용 %s\n", Integer_C.DataSet.get(i),Integer_C.DataSet.get(i+1),Integer_C.DataSet.get(i+2),
					Integer_C.DataSet.get(i+3),Integer_C.DataSet.get(i+4));
			sum += Integer.parseInt(Integer_C.DataSet.get(i+3));
		}
		
		System.out.printf("\n입장료 총액은 %d원 입니다.\n", sum);
		System.out.println("==================에버랜드======================");
		System.out.println("\n계속진행(1: 새로운 주문, 2: 프로그램 종료) :");
	}
	
	
}