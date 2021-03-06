package com.hyemi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import java.util.ArrayList;
import java.io.*;


public class IntroPageFrame extends Frame implements ActionListener, WindowListener{
	
	final static int SERVER_PORT= 8888;
	static Socket sock;
	static Panel pIntro;
	static Dialog checkUserName;
	static String getUserName=null;
	static Panel changingPanel;
	JTextField userName;
	Button btnEnter;
	Button btnInuse;
	Label laInuse;
	
	public IntroPageFrame(){
		changingPanel=PanelSet.changingPanel;
		pIntro=new Panel();
		pIntro.add(PanelSet.changingPanel);
		changingPanel.setLayout(new BorderLayout());
		
		Panel pIntroNorth=new Panel();
		JLabel title=new JLabel("saramara");
		Font fontTitle=new Font("Malgun Gothic",Font.BOLD,20);
		title.setFont(fontTitle);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBorder(BorderFactory.createEmptyBorder(100 , 0, 50 , 0));
		pIntroNorth.add(title);
		
		Panel pIntroCenter=new Panel();
		pIntroCenter.setLayout(new BorderLayout());
		JLabel laName=new JLabel("NAME");
		laName.setHorizontalAlignment(JLabel.CENTER);
		laName.setBorder(BorderFactory.createEmptyBorder(0 , 100, 20 , 100));
		userName=new JTextField(16);
		pIntroCenter.add(laName, BorderLayout.NORTH);
		pIntroCenter.add(userName, BorderLayout.CENTER);
		userName.addActionListener(this);
		
		Panel pIntroSouth=new Panel();
		btnEnter=new Button("ENTER");
		btnEnter.setBackground(Color.lightGray);
		btnEnter.addActionListener(this);
		JLabel laNone=new JLabel();
		laNone.setBorder(BorderFactory.createEmptyBorder(0 , 0, 280 , 0));
		pIntroSouth.add(btnEnter);		
		pIntroSouth.add(laNone);
		
		changingPanel.add(pIntroNorth, BorderLayout.NORTH);
		changingPanel.add(pIntroCenter, BorderLayout.CENTER);
		changingPanel.add(pIntroSouth, BorderLayout.SOUTH);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension dim=tool.getScreenSize();
		
		/*dialog------------------*/
		checkUserName=new Dialog(this, "Check UserName", true);
		Panel pCheckUserName=new Panel();
		pCheckUserName.setLayout(new BorderLayout());
		laInuse=new Label("This name is already in use.");
		laInuse.setAlignment(Label.CENTER);
		pCheckUserName.add(laInuse, BorderLayout.NORTH);
		btnInuse=new Button("OK");
		btnInuse.addActionListener(this);
		pCheckUserName.add(btnInuse, BorderLayout.CENTER);
		checkUserName.add(pCheckUserName);
		checkUserName.setBounds(dim.width/2-(250/2),dim.height/2-(100/2),250,100);
		checkUserName.setVisible(false);
		
		add(pIntro);
		addWindowListener(this);
		setBounds(dim.width/2-(300/2),dim.height/2-(600/2),300,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		PanelSet.changingPanelSub=new Panel();
		PanelSet.changingPanel=new Panel();
		new IntroPageFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		String getUserName=userName.getText();
		if(obj==btnEnter||obj==userName){
			if(getUserName.length()>0){
				OutputStream os;
				OutputStreamWriter osw;
				BufferedWriter bw;
				
				InputStream is;
				InputStreamReader isr;
				BufferedReader br;
				try {
					sock=new Socket("127.0.0.1", SERVER_PORT);		
					os = sock.getOutputStream();
					osw=new OutputStreamWriter(os);
					bw=new BufferedWriter(osw);
					CheckDuplicate.writeUserName(sock, getUserName);
					is=sock.getInputStream();
					isr=new InputStreamReader(is);
					br=new BufferedReader(isr);
					String returnedMsg=br.readLine();
					String wcMsg="Welcome!";
					if(returnedMsg.equals(wcMsg)){
						laInuse.setText(returnedMsg);
						checkUserName.setVisible(true);
						
						bw.write(getUserName);
						bw.newLine();
						bw.flush();
						
						pIntro.removeAll();
						PanelSet.changingPanelSub=new SubPagePanel(sock);
						pIntro.add(PanelSet.changingPanelSub);
						pIntro.revalidate();
					} else {
						laInuse.setText(returnedMsg);
						checkUserName.setVisible(true);
					}
					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}else{
				laInuse.setText("Enter your name.");
				checkUserName.setVisible(true);
			}
		}
		if(obj==btnInuse){
			checkUserName.setVisible(false);
		}	
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if(sock.isConnected()){
				sock.close();				
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dispose();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

}
