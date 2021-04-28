package Everland;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class notes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdfy = new SimpleDateFormat("YYYY");
		SimpleDateFormat sdfm = new SimpleDateFormat("MMdd");
		Calendar cal = Calendar.getInstance();
		String num = "2004273";
		int age = 0;
		int Year = 0; int Month = 0; int D = 0; 
		int T_year = Integer.parseInt(sdfy.format(cal.getTime())); 
		int T_month = Integer.parseInt(sdfm.format(cal.getTime())); 

			Year = Integer.parseInt(num.substring(0,2));
			Month = Integer.parseInt(num.substring(2,6));
			D = Integer.parseInt(num.substring(6));
			
			if (D == 1 || D ==2) {
				age = T_year - (Year +1900);
			} else {
				age = T_year - (Year+2000);
			}
			
			if (Month < T_month) {
				age += 1;
			}
			int Sec_num = 0;
			if (age <= 2) Sec_num = 4;
			if (age > 2 && age < 13) Sec_num = 2;
			if (age >=65) Sec_num = 3;
			if (age >=19 && age <=64) Sec_num = 0;
			if (age >=13 && age <=18) Sec_num = 1;
			
		System.out.println(T_month);	
		System.out.println(age);	
		System.out.println(Sec_num);
	}

}
