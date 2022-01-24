package com.hyemi;

import java.util.ArrayList;

public class ThrWrite extends Thread {
	
	static ArrayList<String> userMsgs=new ArrayList<>();
	static ArrayList<userData> list=new ArrayList<>();

	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(userMsgs.size()>0){
				SayAll.sayAll(userMsgs.get(0));
				userMsgs.remove(0);
			}
		}
	}
}
