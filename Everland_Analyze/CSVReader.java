package Everland_Analyze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVReader {
	ShowResult show = new ShowResult();
	File file =  new File("C:\\Users\\안찬혁\\Desktop\\EverLand\\EverLand.csv");
	FileInputStream fi;
	InputStreamReader ir;
	BufferedReader br;
	public static String [][] Data;
	ArrayList <String> lines = new ArrayList<String>();
	
	void FileReader() throws IOException {
		fi = new FileInputStream(file);
		ir = new InputStreamReader(fi, "MS949");
		br = new BufferedReader(ir);
		String Line;
		while ( (Line = br.readLine())!= null) {
			String [] field = Line.split(",");
			lines.add(Line);	
		}
		Data = new String [lines.size()][];
		for (int i = 0; i <lines.size(); i++) {
			Data[i] = lines.get(i).split(",");
		}
		show.ShowAll(Data);
		show.ShowType(Data);
		show.ShowDay(Data);
		show.ShowDiscount(Data);
	}
}
