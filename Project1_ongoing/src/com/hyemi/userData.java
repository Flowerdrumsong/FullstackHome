package com.hyemi;

import java.net.Socket;

public class userData {
	String userName;
	Socket sock;
	public userData(String userName, Socket sock){
		this.userName=userName;
		this.sock=sock;
	}
}
