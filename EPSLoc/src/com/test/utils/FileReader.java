package com.test.utils;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileReader {

	static int BUFSIZE = 256;

	public static void main(String[] args) {
		String inputFile = "./res/g";
		String cvsSplitBy = ",";
		
		try
		{
			FileInputStream in = new FileInputStream(inputFile);
			FileChannel ch = in.getChannel();
			ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);  // BUFSIZE = 256

			Charset cs = Charset.forName("ASCII"); // Or whatever encoding you want
			
			//String arr[] = s[i].split(cvsSplitBy);
			
			/* read the file into a buffer, 256 bytes at a time */
			int rd;
			while ( (rd = ch.read( buf )) != -1 ) {
				
				buf.rewind();
				CharBuffer chbuf = cs.decode(buf);
				for ( int i = 0; i < chbuf.length(); i++ ) {
					/* print each character */
					
					System.out.print(chbuf.get());
				}
				buf.clear();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
