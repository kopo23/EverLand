package Everland_Analyze;

import java.io.IOException;
import java.util.ArrayList;

public class ShowResult {
	Analyze_CsvSaver save = new Analyze_CsvSaver();
	static int Day;
	static int D_0; static int D_1 ; static int D_2; static int D_3; static int D_4 ; 
	static int Day_sum ;
	
	static int Night ;
	static int N_0 ; static int N_1 ; static int N_2 ; static int N_3 ; static int N_4 ;
	static int Night_sum ;
	
	
	void ShowAll(String [][] Data) {
		System.out.println("=============================Everland.csv==============================");
		for (int i = 0; i < Data.length; i++) {
			for (int j = 0; j < Data[i].length; j++) {
				System.out.printf("%-12s", Data[i][j].trim());
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	void ShowType(String [][] Data) throws IOException {
		System.out.println("===============================권종 별 판매현황==============================");
		for (int i = 0; i < Data.length; i++) {
				if (Data[i][2].trim().equals("주간권")) {
					Day += Integer.parseInt(Data[i][4].trim());;
					Day_sum += Integer.parseInt(Data[i][5].trim().replace("원", ""))*Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("유아")) D_0 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("소인")) D_1 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("청소년")) D_2 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("대인")) D_3 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("노인")) D_4 += Integer.parseInt(Data[i][4].trim());
				}
				if (Data[i][2].trim().equals("야간권")) {
					Night += Integer.parseInt(Data[i][4].trim()); 	
					Night_sum += Integer.parseInt(Data[i][5].trim().replace("원", ""))*Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("유아")) N_0 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("소인")) N_1 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("청소년")) N_2 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("대인")) N_3 += Integer.parseInt(Data[i][4].trim());
					if (Data[i][3].trim().equals("노인")) N_4 += Integer.parseInt(Data[i][4].trim());
				}
				
		}
	
		System.out.printf("\n주간권: %d\n유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n",Day,D_0,D_1,D_2,D_3,D_4);
		System.out.printf("주간권 매출: %d원\n",Day_sum);
		System.out.printf("\n야간권: %d\n유아 %d매, 어린이 %d매, 청소년 %d매, 어른 %d매, 노인 %d매\n",Night,N_0,N_1,N_2,N_3,N_4);
		System.out.printf("야간권 매출: %d원\n",Night_sum);
		System.out.println("-----------------------------------------------------------------------");
		
		save.TypeSaver();
	}
	
	
	void ShowDay(String [][] Data) throws IOException {
		ArrayList <String> arr = new ArrayList();
		String [] Dates = new String [Data.length-1];
		System.out.println("============일자별 매출 현황==============");
		for (int i = 1; i < Dates.length+1; i++) {
			Dates[i-1] = Data[i][1].trim();
		}
		for (int i = 0; i < Dates.length; i++) {
			for (int j = i+1; j < Dates.length; j++) {
				if (Dates[i].equals(Dates[j])) {
					Dates[i] = "x";
				}
			}
			if (!Dates[i].equals("x")) {
				arr.add(Dates[i]);
			}
		}
		int [] total_sum = new int [arr.size()];
		for (int i = 0; i <Data.length; i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (Data[i][1].trim().equals(arr.get(j))) {
					total_sum[j] += Integer.parseInt(Data[i][5].trim().replace("원", ""));
				}
			}
		}
		for (int i = 0; i < total_sum.length; i ++) {
			System.out.printf("%s : 총매출 \t %d원\n",arr.get(i),total_sum[i]);
		}
		save.DaySaver(arr, total_sum);
		System.out.println("-----------------------------------");
	}
	
	
	void ShowDiscount (String [][] Data) throws IOException {
		System.out.println("============우대권 판매 현황==============");
		int Total = 0;
		int none = 0; int disable = 0; int patriot = 0; int multi_child = 0; int pregnant = 0;
		
		for (int i =0; i < Data.length; i ++) {
			if (Data[i][6].trim().equals("없음")) none += Integer.parseInt(Data[i][4].trim());
			if (Data[i][6].trim().equals("장애인")) disable += Integer.parseInt(Data[i][4].trim());
			if (Data[i][6].trim().equals("국가유공자")) patriot += Integer.parseInt(Data[i][4].trim());
			if (Data[i][6].trim().equals("다자녀")) multi_child += Integer.parseInt(Data[i][4].trim());
			if (Data[i][6].trim().equals("임산부")) pregnant += Integer.parseInt(Data[i][4].trim());
			Total = none + disable + patriot + multi_child + pregnant;
		}
		
		System.out.printf("총 판매 티켓 수    :   %d매\n",Total);
		System.out.printf("우대없음         :   %d매\n",none);
		System.out.printf("장애인          :   %d매\n",disable);
		System.out.printf("국가유공자        :   %d매\n",patriot);
		System.out.printf("다자녀          :   %d매\n",multi_child);
		System.out.printf("임산부          :   %d매\n",pregnant);
		System.out.println("-----------------------------------");
		
		save.DiscountSaver(Total,none,disable,patriot,multi_child,pregnant);
		
	}
}
