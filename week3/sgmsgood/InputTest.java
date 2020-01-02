package week3.practice;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class InputTest {
	public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\USER\\Documents\\DesignPatternStudy\\week3\\sgmsgood\\test.txt")));

            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
            
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
