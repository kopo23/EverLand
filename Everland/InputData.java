package Everland;

import java.util.ArrayList;
import java.util.Arrays;

public class InputData {
	String Type_name; //주간권 or 야간권
	String [] Type_C; String Age;
	int [] Type_cost; // 주간권 or 야간권에따른 금액
	int Orign_cost; // 금액을 배열에서 가져온것
	String DC_Name; // 할인 이름
	double DC_rate; // 할인적용률
	int count; // 표 장수
	int i_Total; // 최종가격
	int Total;
	ArrayList <String> DataSet = new ArrayList <String>(); // 현재 작업중인것만 가져옴
	
	
	InputData(int Type, int Security_num, int Count_ticket, int DC) {
		if(Type == 1) {
			Type_name = "주간권";
			Type_cost = Integer_C.Type_cost[0];
			
		} else {
			Type_name = "야간권";
			Type_cost = Integer_C.Type_cost[1];
		}

		Orign_cost = Type_cost[Security_num]; // 나이에따른 가격설정
		Age = Integer_C.Type[Security_num]; // 나이에따른 분류 이름
	
		this.count = Count_ticket; // 장 수
		DC_rate = Integer_C.DC_Rate[DC-1]; // 할인률
		DC_Name = Integer_C.DC_Type[DC-1]; // 할인 이름
		i_Total = (int) (Orign_cost*Count_ticket*DC_rate); // 개별 총액
		
		Integer_C.DataSet.add(Type_name);
		Integer_C.DataSet.add(Age);
		Integer_C.DataSet.add(Integer.toString(Count_ticket));
		Integer_C.DataSet.add(Integer.toString(i_Total));
		Integer_C.DataSet.add(DC_Name);
		
		DataSet.add(Type_name);
		DataSet.add(Age);
		DataSet.add(Integer.toString(Count_ticket));
		DataSet.add(Integer.toString(i_Total));
		DataSet.add(DC_Name);
		
	}

}