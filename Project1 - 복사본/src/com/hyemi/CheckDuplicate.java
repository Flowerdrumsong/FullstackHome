package com.hyemi;

import java.io.*;
import java.net.Socket;

public class CheckDuplicate {
	
	Socket sock;
	String getUserName;
	
	public static void writeUserName(Socket sock, String getUserName){
		OutputStream is;
		OutputStreamWriter osw;
		BufferedWriter bw;
		try {
			is=sock.getOutputStream();
			osw=new OutputStreamWriter(is);
			bw=new BufferedWriter(osw);
			
			bw.write(getUserName);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
