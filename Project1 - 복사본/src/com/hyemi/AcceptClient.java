package com.hyemi;

import java.io.IOException;
import java.net.*;

public class AcceptClient {
	
	final static int SERVER_PORT= 8888;
	static Socket sock=null;
	static ServerSocket serve=null;

	public AcceptClient(){
		try {
			serve=new ServerSocket(SERVER_PORT);
			
			ThrWrite thrWrite=new ThrWrite();
			thrWrite.start();
			while(true){
				ThrRead thrRead=new ThrRead();
				System.out.println("Server > Wating for the client.");
				thrRead.sock=serve.accept();
				CheckName.checkDuplicates(thrRead.sock);
				System.out.println("Server > Client has entered..");
				thrRead.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}


