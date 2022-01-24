package com.hyemi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SayAll {

	public static void sayAll(String msg) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		for (int i = 0; i < ThrWrite.list.size(); i++) {
			Socket sock = ThrWrite.list.get(i).sock;
			try {
				os = sock.getOutputStream();
				osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				bw.write(msg);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
