package com.hyemi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Chats extends JPanel implements ActionListener {
	
	JCheckBox jcb;
	JButton btn;
	int count=0;
	JLabel number;
	
	public Chats(String msg){
		JPanel pp=new JPanel();
		JCheckBox jcb=new JCheckBox();
		
		btn=new JButton("c"+count);
		btn.addActionListener(this);
		
		JLabel la=new JLabel(msg);
		pp.add(jcb);
		pp.add(btn);
		pp.add(la);
		add(pp);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==jcb){
			jcb.setEnabled(false);
		} 
		if(obj==btn){
			count++;
			btn.setText("c"+count);
			revalidate();
		}
		
	}
	
}
