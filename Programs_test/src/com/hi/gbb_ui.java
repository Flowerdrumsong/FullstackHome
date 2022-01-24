package com.hi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;

public class gbb_ui extends Frame {

	gbb_ui(){
		Panel p=new Panel();
		BorderLayout layout=new BorderLayout();
		p.setLayout(layout);
		
		
		
		
		add(p);
		setBounds(100,100,400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new gbb_ui();
	}

}
