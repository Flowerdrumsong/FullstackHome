package com.hyemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CheckUserNameData {

	public static String checkUserNamedata(String msg) {
		File file = new File("UserNameData.bin");
		FileReader fr=null;
		BufferedReader br=null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		String temp=null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr = new FileReader(file);
			br=new BufferedReader(fr);
			fw=new FileWriter(file, true);
			bw=new BufferedWriter(fw);
			if((temp=br.readLine())==null){
				bw.write(msg);
				bw.newLine();
				bw.flush();
				String returnMsg="Welcome!";
				return returnMsg;
			}else {
				while(true){
					String temp2=br.readLine();
					if(msg.equals(temp)||msg.equals(temp2)){
						String returnMsg="same name in usernamedata";
						return returnMsg;
					}else{
						bw.write(msg);
						bw.newLine();
						bw.flush();
						String returnMsg="Welcome!";
						return returnMsg;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String returnMsg="Try to connect again.";
		return returnMsg;
		
		
	}
}
