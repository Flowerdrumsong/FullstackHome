package com.hyemi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.*;


public class SubPagePanel extends Panel implements ActionListener {
	
	JTextField tf;
	static BufferedWriter bw; 
	static JPanel centerPanel;
	JButton sendBtn;
	static TextArea ta;
	Label msgla;
	JScrollPane scroll;
	Panel changingPanelSub;
	Socket sock;
	
	public SubPagePanel(Socket sock){
		this.sock=sock;
		changingPanelSub=new Panel();
		changingPanelSub.setLayout(new BorderLayout());
		Panel northPanel=new Panel();
		JLabel roomTitle=new JLabel("SARAMARA CHATTING ROOM");
		roomTitle.setAlignmentX(Label.CENTER_ALIGNMENT);
		northPanel.add(roomTitle);
		changingPanelSub.add(northPanel, BorderLayout.NORTH);
		centerPanel=new JPanel();
		ta=new TextArea();
		ta.setPreferredSize(new Dimension(280,460));
		centerPanel.add(ta);
		changingPanelSub.add(centerPanel, BorderLayout.CENTER);
		Panel southPanel=new Panel();
		tf=new JTextField();
		tf.setColumns(13);
		tf.addActionListener(this);
		sendBtn=new JButton("SEND");
		sendBtn.addActionListener(this);
		southPanel.add(tf);
		southPanel.add(sendBtn);
		changingPanelSub.add(southPanel, BorderLayout.SOUTH);
		add(changingPanelSub);
	}
	public static void sendMsg(String msg){
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		String msg=tf.getText();
		InputStream is=null;
		OutputStream os=null;
		InputStreamReader isr=null;
		OutputStreamWriter osw=null;
		BufferedReader br=null;
		try {
			is=IntroPageFrame.sock.getInputStream();
			os=IntroPageFrame.sock.getOutputStream();
			isr=new InputStreamReader(is);
			osw=new OutputStreamWriter(os);
			br=new BufferedReader(isr);
			bw=new BufferedWriter(osw);
			sendMsg(msg);
			Thread reader=new Reader(sock);
			reader.start();
			tf.setText("");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
