package L_10_Examples;

//			������� ���� �� �����, ������ �������� � ���������� ���������� ����� ������ � �������� �� � ���� � ������� UTF-8

import java.io.*;
import java.util.*;

public class L10_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.print("������� ��� ����� =>");
		String fileName = sc.nextLine();
		try {
			// ��������� ����
			File f1 = new File(fileName);
			f1.createNewFile();
			System.out.println("������ ���� �����: " + f1.getAbsolutePath());
			System.out.print("������� ���������� ����� ��� ������ � ���� =>");
			int n = sc2.nextInt();
			// ��������� ����� ��� ������ � ������ ���� ������ � DataOutputStream,
			// � ��� � �������� ��������� ���������� ����� FileOutputStream
			DataOutputStream dOut = new DataOutputStream( new FileOutputStream(f1));
//			sc.nextLine(); 		//������� ������
			for (int i = 0; i < n; i++) {
				System.out.print("������� ������ ��� ������ � ���� => ");
				String s = sc.nextLine();
				dOut.writeUTF(s + "\n");	 //������ ��������� �����
			}
			dOut.flush();	 // ���������� ������������� ������ �� ����
			dOut.close();	 // ��������� �����
			// ������ � ����� ������ �� ���������� �����
			DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
			while(true) {
				System.out.println(dIn.readUTF());
			}
		}
		catch(EOFException e) {
		}
		catch(Exception e) {
			System.out.println("" + e);
		}
	}
}