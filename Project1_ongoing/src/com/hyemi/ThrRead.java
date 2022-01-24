package com.hyemi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ThrRead extends Thread {
		
	Socket sock;

	public void run() {
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		String userName;
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			userName=br.readLine();
			if(true){
			ThrWrite.list.add(new userData(userName, sock));	
				while(true){
					String msg=br.readLine();
					if(msg==null){System.out.println("null");}
					ThrWrite.userMsgs.add(userName+"> "+msg);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
