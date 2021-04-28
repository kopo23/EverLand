package Everland;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class InputConsole {
	Scanner scanner = new Scanner(System.in);
	PrintOut Prt = new PrintOut();
	
	int ChooseType() {
		Prt.ChooseType();
		return scanner.nextInt();
	}
	
	int SecurityNum() {
		Prt.SecurityNum();
		String num = scanner.next();
		if (num.length() < 13) {
			return 5;
		} else {
			int age = GetAge(num);
			return age;
		}
	}
	
	int Counts_ticket () {
		Prt.Counts_ticket();
		return scanner.nextInt();
	}
	
	int DisCount() {
		Prt.DisCount();
		return scanner.nextInt();
	}
	
	int GoStop() {
		
		return scanner.nextInt();
	}
	
	int GoStop(int i) {
		
		return scanner.nextInt();
	}
	
	int GetAge(String num) {
		SimpleDateFormat sdfy = new SimpleDateFormat("YYYY");
		SimpleDateFormat sdfm = new SimpleDateFormat("MMdd");
		Calendar cal = Calendar.getInstance();
		int age = 0;
		int Year = 0; int Month = 0; int D = 0; 
		int T_year = Integer.parseInt(sdfy.format(cal.getTime())); 
		int T_month = Integer.parseInt(sdfm.format(cal.getTime())); 
		try {  // 달에 생일계산까지
			Year = Integer.parseInt(num.substring(0,2));
			Month = Integer.parseInt(num.substring(2,6));
			D = Integer.parseInt(num.substring(6,7));
			if (D == 1 || D ==2) {
				age = T_year - (Year +1900) + 1; // 만나이를 한국나이로, 7번째가 1,2면 1900년대생
			} else {
				age = T_year - (Year+2000) + 1; // 그외는 2000년대생으로
			}
	
			if (Month <= T_month) {
				age += 1;
			}
		} catch(Exception e){
			return 5;
		}
		int Sec_num = 8;
		if (age >= 13 && age <= 18) Sec_num = 1;
		if (age >= 19 && age <= 64) Sec_num = 0;
		if (age > 2 && age < 13) Sec_num = 2;
		if (age >= 65) Sec_num = 3;
		if (age <= 2) Sec_num = 4;
		
		return Sec_num;
	}
	
	int TrueData1(int Type) {
		if (Type == 1 || Type ==2) {
			return Type;
		} else {
			System.out.println("올바르지 않은 메뉴입니다.");
			return -1;
		}
		
	}
	
	int TrueData2(int SecurityNum) {
		if (SecurityNum >= 5 ) {
			System.out.println("올바르지 않은 주민번호입니다.");
			return -1;
		} else {
			return SecurityNum;
		}
		
	}
	
	int TrueData3(int Counts_ticket) {
		if (Counts_ticket > 10 || Counts_ticket <= 0) {
			System.out.println("1회 주문 수량을 맞춰주세요.");
			return -1;
		} else {
			return Counts_ticket;
		}
		
	}
	
	int TrueData4(int DisCount) {
		if (DisCount >5) {
			System.out.println("올바르지 않은 메뉴입니다.");
			return -1;
		} else {
			return DisCount;
		}
		
	}
	
	
	
}