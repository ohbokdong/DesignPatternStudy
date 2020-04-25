package week14.younggeun0.chainofresponsibility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CORDrive { // Chain Of Responsibility(역할 사슬) 패턴 예제

	public static void main(String[] args) {
		/* 
		 * 1. 이메일 목록을 한 줄씩 읽음(csv 가데이터)
		 * 2. Spam 핸들러 생성
		 * 3. HandleRequest호출해서 역할 사슬을 타도록 함
		 */
		
		try {
			InputStream is = new FileInputStream(new File("D:/dev/eclipse-workspace/local_dp_study/src/week14/younggeun0/chainofresponsibility/csv.txt"));
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String temp = "";
			while((temp = br.readLine()) != null){
				System.out.println(temp);
				Handler handler = new SpamHandler(temp);
				handler.handleRequest();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
