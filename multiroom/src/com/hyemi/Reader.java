package com.hyemi;

import java.net.Socket;

public class Reader {
	Socket sock;
	public Reader(Socket sock){
		this.sock=sock;
		userInfo(sock);
		//io작업 nickname 받아오기
		//io-nickname
	}

	
	public static void userInfo(Socket sock){
			UserEach newUser=new UserEach(sock, nickname);
			UserManager.add(newUser);
	}
	
}
