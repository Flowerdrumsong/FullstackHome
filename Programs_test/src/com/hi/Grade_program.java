package com.hi;

import java.util.ArrayList;
import java.util.Scanner;

public class Grade_program {
	// 콜렉션 프레임워크로 성적관리프로그램 만들기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		String input;
		String data="";
		System.out.println("성적관리프로그램");

		while (true) {
			System.out.print("1.입력 2.출력 3.수정 4.삭제 0.종료 >");
			input = sc.nextLine();
			if (input.equals("0")) { // 종료
				break;
			} else if (input.equals("1")) { // 입력
				System.out.print("학번 >");
				data+="\n" + sc.nextLine()+"\t";
				System.out.print("국어 >");
				data+=sc.nextLine() + "\t";
				System.out.print("영어 >");
				data+=sc.nextLine() + "\t";
				System.out.print("수학 >");
				data+=sc.nextLine();
				list.add(data);
			} else if (input.equals("2")) { // 출력
				System.out.println("------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.print("------------------------------");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
				}
				System.out.println();
				System.out.println("------------------------------");
			} else if (input.equals("3")) { // 수정
				System.out.print("수정할 학번 >");
				input = sc.nextLine();
				String modifyNum = "\n" + input+ "\t";
				//////////////////////////////////////////////////////////////
				boolean flag=false;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(modifyNum)) {
						System.out.print("국어 >");
						modifyNum += (sc.nextLine()+"\t");
						System.out.print("영어 >");
						modifyNum += (sc.nextLine()+"\t");
						System.out.print("수학 >");
						modifyNum += (sc.nextLine());
						list.set(i, modifyNum);
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println("없는학번입니다.");
				}
			} else if (input.equals("4")) { // 삭제
				System.out.println("삭제할 학번 >");
				input=sc.nextLine();
				String modifyNum = "\n" + input;
				boolean flag=false;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(modifyNum)) {
						list.remove(i);
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println("없는 학번입니다.");
				}
				//////////////////////////////////////////////////////////////
			} else {
				System.out.println("메뉴를 확인하고 다시 입력하세요.");
			}
		}
		System.out.println("program closed.");
	}

}
