package com.hi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Grade_IO {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		File file=new File("grade_data.txt");
		System.out.println("�����������α׷�");
		String input=null;
		while(true){
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.���� >");
			input=sc.nextLine();
			if(input.equals("0")){
				System.out.println("���α׷��� ����˴ϴ�.");
				break;
			}else if(input.equals("1")){//�Է�
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else if(input.equals("2")){//����
				try {
					FileInputStream fis=new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}else if(input.equals("3")){//����
				
			}else if(input.equals("4")){//����
				
			}else{
				System.out.println("�޴��� ���� �ٽ� �Է��ϼ���.");
			}

		}
		System.out.println("program closed.");
		
	}	

}
