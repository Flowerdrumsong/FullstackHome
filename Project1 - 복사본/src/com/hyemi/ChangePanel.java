package com.hyemi;

import java.awt.Panel;

public class ChangePanel {
	public static void mainToSub(Panel nowPanel){
		IntroPageFrame.pIntro.removeAll();
		IntroPageFrame.pIntro.add(nowPanel);
		IntroPageFrame.pIntro.revalidate();
		
	}
//	public static void subToMain(){
//		IntroPageFrame.pIntro.removeAll();
//		IntroPageFrame.pIntro.add(PanelSet.changingPanelMain);
//		IntroPageFrame.pIntro.revalidate();
//	}
}