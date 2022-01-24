package com.hyemi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AcceptSocket extends Thread {
	
	Socket sock=null;
	ServerSocket server=null;

	public AcceptSocket(){
		UserManager.userList=new ArrayList<E>();
		try {
			while(true){
				server=new ServerSocket(8888);
				AcceptSocket thr=new AcceptSocket();
				thr.sock=server.accept();
				Reader reader=new Reader(sock);
				reader.userInfo();	
				thr.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
