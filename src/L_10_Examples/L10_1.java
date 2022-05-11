package L_10_Examples;

import java.io.*;

// ������ 1. �������� ������ � �����

public class L10_1 {
	public static void main(String[] args) {
		// ������ � ������� ������ ����� ��������� � ������ try-catch
		try {
			//�������� ����� � ������� �����( ��� ���������� ���� L10_1.java)
			File f1 = new File("MyFile1.txt"); // ������� ������ ������ File , �� ��������� ��� �� ���������� 
			f1.createNewFile(); // ����� createNewFile() - ������� ����
			if(f1.exists()) { // �����  exists() - ���������� true, ���� ���� � ����� ������ ���������� �� ����� ���������� 
				System.out.println("������!!!");
				System.out.println("������ ���� �����:  " + f1.getAbsolutePath()); // ����� getAbsolutePath() - ���������� ������ ���� ����� �� ����� ���������������
			}
			
			//�������� ����� �� ����� C � ����� ������� ����
			File f2 = new File("C:\\Papka1\\MyFile2.txt");
			f2.createNewFile();
			System.out.println("������ ���� �����:  " + f2.getAbsolutePath());
			
			//�������� ���������� ��������� �����
			File f3 = new File("C:\\Papka1\\Papka2\\Papka3");
			f3.mkdirs(); // ����� mkdirs - ������� ���������� � ��� �������������
			System.out.println("������ ���� �����:  " + f3.getAbsolutePath());
		}
		catch(Exception e) { 
			System.out.println("������!!! " + e);
		}
	}
}