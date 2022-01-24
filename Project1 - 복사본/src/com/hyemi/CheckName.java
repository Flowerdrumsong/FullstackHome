package com.hyemi;

import java.io.*;
import java.net.Socket;

public class CheckName {
	Socket sock;
	public static void checkDuplicates(Socket sock) {
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		OutputStream os;
		OutputStreamWriter osw;
		BufferedWriter bw;
			try {
				is = sock.getInputStream();
				isr=new InputStreamReader(is);
				br=new BufferedReader(isr);
				os=sock.getOutputStream();
				osw=new OutputStreamWriter(os);
				bw=new BufferedWriter(osw);
				
				String msg=br.readLine();
				String returnMsg=CheckUserNameData.checkUserNamedata(msg);
				bw.write(returnMsg);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
}
