package com.hi;

import java.util.ArrayList;
import java.util.Scanner;

public class Grade_program {
	// �ݷ��� �����ӿ�ũ�� �����������α׷� �����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		String input;
		String data="";
		System.out.println("�����������α׷�");

		while (true) {
			System.out.print("1.�Է� 2.��� 3.���� 4.���� 0.���� >");
			input = sc.nextLine();
			if (input.equals("0")) { // ����
				break;
			} else if (input.equals("1")) { // �Է�
				System.out.print("�й� >");
				data+="\n" + sc.nextLine()+"\t";
				System.out.print("���� >");
				data+=sc.nextLine() + "\t";
				System.out.print("���� >");
				data+=sc.nextLine() + "\t";
				System.out.print("���� >");
				data+=sc.nextLine();
				list.add(data);
			} else if (input.equals("2")) { // ���
				System.out.println("------------------------------");
				System.out.println("�й�\t����\t����\t����");
				System.out.print("------------------------------");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i));
				}
				System.out.println();
				System.out.println("------------------------------");
			} else if (input.equals("3")) { // ����
				System.out.print("������ �й� >");
				input = sc.nextLine();
				String modifyNum = "\n" + input+ "\t";
				//////////////////////////////////////////////////////////////
				boolean flag=false;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).contains(modifyNum)) {
						System.out.print("���� >");
						modifyNum += (sc.nextLine()+"\t");
						System.out.print("���� >");
						modifyNum += (sc.nextLine()+"\t");
						System.out.print("���� >");
						modifyNum += (sc.nextLine());
						list.set(i, modifyNum);
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println("�����й��Դϴ�.");
				}
			} else if (input.equals("4")) { // ����
				System.out.println("������ �й� >");
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
					System.out.println("���� �й��Դϴ�.");
				}
				//////////////////////////////////////////////////////////////
			} else {
				System.out.println("�޴��� Ȯ���ϰ� �ٽ� �Է��ϼ���.");
			}
		}
		System.out.println("program closed.");
	}

}