package week3.rlawjddbs.decorator.io_decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test2.txt")));

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			} // end while
		} catch(IOException ioe) {
			ioe.getMessage();
			ioe.printStackTrace();
		} // end catch

	} // main

} // class
