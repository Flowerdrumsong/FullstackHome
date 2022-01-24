package com.hyemi;

import java.net.Socket;

public class RoomManager {
	public static void makeNewRoom(Socket sock){
		new Room(sock);
	}
	public static void removeRoom(){
		
	}
}
