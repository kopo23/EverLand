package Everland;

import java.io.IOException;

public class Process {
	Integer_C Integ = new Integer_C();
	InputData InData ;
	InputConsole InCon = new InputConsole();
	PrintOut Prt = new PrintOut();
	CsvSaver Csv = new CsvSaver();
	
	public void Processing() throws IOException {
		Csv.Header();
		while(true) {
			Csv.FileCount();
			int Type = InCon.TrueData1(InCon.ChooseType()); if (Type == -1) continue;
			int Security_Num = InCon.TrueData2(InCon.SecurityNum()); if (Security_Num == -1) continue;
			int Counts_ticket = InCon.TrueData3(InCon.Counts_ticket()); if (Counts_ticket == -1) continue;
			int DisCount = InCon.TrueData4(InCon.DisCount()); if (DisCount == -1) continue;
			InData = new InputData(Type, Security_Num, Counts_ticket, DisCount);
			
			//InData = new InputData(InCon.ChooseType(),InCon.SecurityNum(),InCon.Counts_ticket(),InCon.DisCount());//생성자
			Csv.Write(InData); 
			Prt.GoStop(InData); 
			if (InCon.GoStop() == 2) { // 1. 계속발권 / 2. 종료
				Prt.ShowResult(); // 중간계산 
				if (InCon.GoStop(1)==2) { // 1. 새로운 발권 / 2. 프로그램 종료
					break;
				} else {
					Integer_C.DataSet.clear(); // 여기까지왔으면 일단 배열 reset
				}
			} 
		}
		Csv.FileClose();
	}
	
	
}