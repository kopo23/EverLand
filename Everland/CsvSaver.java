package Everland;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CsvSaver {
	File file =  new File("C:\\Users\\안찬혁\\Desktop\\EverLand\\EverLand.csv");
	private FileWriter fw;
	private BufferedWriter bw;
	private FileOutputStream fo;
	private OutputStreamWriter ow;
	public static int count;
	
	
	public void Header() throws IOException { // 헤더를 찍는데 최초 1회만찍어준다.
		if (file.exists() == false) { // 파일이 존재 안하면 찍고 하면 안찍음
			fo = new FileOutputStream(file,true);
			ow = new OutputStreamWriter(fo, "MS949");
			bw = new BufferedWriter(ow);
			bw.write(String.format("%s, %s, %s, %s, %s, %s, %s","거래번호","날짜","권종","연령구분","수량","가격","우대사항"));
			bw.newLine();
			bw.flush();
		}
	}
	
	public void Write(InputData dt) throws IOException {
		FileCount();
		fo = new FileOutputStream(file,true);
		ow = new OutputStreamWriter(fo, "MS949"); //인코딩땜시...
		bw = new BufferedWriter(ow);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
		Calendar cal = Calendar.getInstance();
		
		for (int i = 0; i <dt.DataSet.size(); i+=5) {
			String n = String.format("%d, %s, %s, %s, %s, %s원, %s",count,sdf.format(cal.getTime()), dt.DataSet.get(i),dt.DataSet.get(i+1),dt.DataSet.get(i+2),
					dt.DataSet.get(i+3),dt.DataSet.get(i+4));
			
			bw.write(n);
			bw.newLine();
			bw.flush();
			
		}
	}
	
	public void FileCount() throws IOException {
		if (file.exists() == true) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			count = 0;
			String n;
			while ((n=br.readLine()) != null){
				count ++;
			}
		
			} else {
				count = 1;
			}
		
	}
	
	public void FileClose() {
		try {
			bw.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}