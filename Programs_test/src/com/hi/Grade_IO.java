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
		System.out.println("성적관리프로그램");
		String input=null;
		while(true){
			System.out.print("1.입력 2.출력 3.수정 4.삭제 0.종료 >");
			input=sc.nextLine();
			if(input.equals("0")){
				System.out.println("프로그램이 종료됩니다.");
				break;
			}else if(input.equals("1")){//입력
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else if(input.equals("2")){//보기
				try {
					FileInputStream fis=new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}else if(input.equals("3")){//수정
				
			}else if(input.equals("4")){//삭제
				
			}else{
				System.out.println("메뉴를 보고 다시 입력하세요.");
			}

		}
		System.out.println("program closed.");
		
	}	

}
