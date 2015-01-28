/**
 * 
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

/**
 * @author user
 *
 */
public class FileThreads {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File f1 = new File ("/home/user/workspace/workspace/src/io/file.txt");
		File f2 = new File ("/home/user/workspace/workspace/src/io/output.txt");
		
		try {
		    String fileName = "/home/user/workspace/workspace/src/io/file.txt";
		    InputStream inStream = null;
		    OutputStream outStream = null;

		    //Записываем в файл некоторое количество байт
		    long timeStart = System.currentTimeMillis();
		    outStream = new FileOutputStream(fileName);
		    outStream = new BufferedOutputStream(outStream);
		    for(int i=1000000; --i>=0;) {
		        outStream.write(i);
		    }
		    long time = System.currentTimeMillis() - timeStart;
		    System.out.println("Время записи: " + time + " миллисекунд");
		    outStream.close();

		    //Определяем время считывания без буферизации
		    timeStart = System.currentTimeMillis();
		    inStream = new FileInputStream(fileName);
		    while(inStream.read()!=-1){
		    }
		    time = System.currentTimeMillis() - timeStart;
		    inStream.close();
		    System.out.println("На чтение затрачено: " + (time) + " миллисекунд");

		    //Определяем время считывания с буферизацией
		    timeStart = System.currentTimeMillis();
		    inStream = new FileInputStream(fileName);
		    inStream = new BufferedInputStream(inStream);
		    while(inStream.read()!=-1){
		    }
		    time = System.currentTimeMillis() - timeStart;
		    inStream.close();
		    System.out.println("На буферизированное чтение затрачено: " + (time) + " миллисекунд");
		    } catch (IOException e) {
		        System.out.println("IOException: " + e.toString());
		        e.printStackTrace();
		    }
		
	  /* try {
		f2.createNewFile();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   String str ="asffasfa566565566____+++jjjJJJJKKKK";
	       FileReader rdr = new FileReader (f1);
	        //StringReader src = new StringReader(str);
	        FilterReader f = new UpperCaseConvertor(rdr);
	        FileWriter wrt = new FileWriter (f2);
	        int c;
	        try {
				while ((c = f.read()) != -1){
				    System.out.print((char)c);
				  
				  wrt.write((char)c);}
				wrt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println();*/
	        
		// TODO Auto-generated method stub
		/*File f1 = new File ("/home/user/workspace/workspace/src/io/file.txt");
		File f2 = new File ("/home/user/workspace/workspace/src/io/output.txt");
		
		char buffer[] =  new char[255];
		
		
		try {
			FileReader rdr = new FileReader (f1);
			FileWriter wrt = new FileWriter (f2);
			while(rdr.read(buffer)!=-1){
				wrt.write(buffer);
			}
			rdr.close();
			wrt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

}
