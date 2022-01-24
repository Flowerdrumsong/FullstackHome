package com.hyemi;

import java.io.*;
import java.net.Socket;

public class Reader extends Thread {
	
	Socket sock;
	public Reader(Socket sock){
		this.sock=sock;
	}
	public void run(){
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		String msg;
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			while(true){
				msg=br.readLine();
				SubPagePanel.ta.append(msg+"\n");
				SubPagePanel.ta.revalidate();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
