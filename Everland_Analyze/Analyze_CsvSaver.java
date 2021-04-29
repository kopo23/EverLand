package Everland_Analyze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Analyze_CsvSaver {
	File file;
	private FileWriter fw;
	private OutputStreamWriter ow;
	private BufferedWriter bw;
	private FileOutputStream fo;
	
	void DaySaver(ArrayList D, int[] T) throws IOException {
		file = new File("EverLand_Day.csv");
		fo = new FileOutputStream(file);
		ow = new OutputStreamWriter(fo, "MS949");
		bw = new BufferedWriter(ow);
		bw.write("날짜, 총매출");
		bw.newLine();
		for (int i = 0; i < D.size(); i++) {
			String n = String.format("%s, %d", D.get(i),T[i]);
			bw.write(n);
			bw.newLine();
			bw.flush();
		}
	}
	
	void TypeSaver() throws IOException {
		ShowResult sh = new ShowResult();
		file = new File("EverLand_Type.csv");
		fo = new FileOutputStream(file);
		ow = new OutputStreamWriter(fo, "MS949");
		bw = new BufferedWriter(ow);
		bw.write("구분,주간권,야간권");
		bw.newLine();
		String l1 = String.format("유아,%d,%d", sh.D_0,sh.N_0); bw.write(l1); bw.newLine();
		String l2 = String.format("어린이,%d,%d", sh.D_1,sh.N_1); bw.write(l2); bw.newLine();
		String l3 = String.format("청소년,%d,%d", sh.D_2,sh.N_2); bw.write(l3); bw.newLine();
		String l4 = String.format("어른,%d,%d", sh.D_3,sh.N_3); bw.write(l4); bw.newLine();
		String l5 = String.format("노인,%d,%d", sh.D_4,sh.N_4); bw.write(l5); bw.newLine();
		String l6 = String.format("합계,%d,%d", sh.Day,sh.Night); bw.write(l6); bw.newLine();
		String l7 = String.format("매출,%d,%d", sh.Day_sum,sh.Night_sum); bw.write(l7); bw.newLine();
		bw.flush();
	}
	
	void DiscountSaver(int Total, int none, int disable, int patriot, int multi_child, int pregnant) throws IOException {
		file = new File("EverLand_Discount.csv");
		fo = new FileOutputStream(file);
		ow = new OutputStreamWriter(fo, "MS949");
		bw = new BufferedWriter(ow);
		bw.write("구분,티켓수");
		bw.newLine();
		bw.write("우대없음,"+none);bw.newLine();
		bw.write("장애인,"+disable);bw.newLine();
		bw.write("국가유공자,"+patriot);bw.newLine();
		bw.write("다자녀,"+multi_child);bw.newLine();
		bw.write("임산부,"+pregnant);bw.newLine();
		bw.write("총판매 티켓수,"+Total);bw.newLine();
		bw.flush();
	}
}
	
