package com.hyemi;

import java.net.Socket;

public class UserManager {
	static ArrayList <UserEach> userList;
	public UserManager(Socket sock){	
		new UserEach(sock, nickname);
		add()
			
	}
	
	
	public static void add(UserEach toAdd){
		userList.add(toAdd);
	}
	
}
