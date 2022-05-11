package L_10_Examples;

//			������ �� ������ ����� � ������ � ������ ���� ������ �����������

import java.io.*;

public class L10_6 {
	public static void main(String[] args) throws IOException{
		Reader in = null;
		Writer out = null;
		try {
			in = new FileReader("C:\\Papka1\\MyFile.txt"); // ���� ���� ������
			out = new FileWriter("C:\\Papka1\\MyFile2.txt",true); // ���� ���� ��� ������
			// ������ ����������� � ������������ ��������, ��� � ��� InputStream/OutputStream
			int oneByte; // ����������, � ������� ����������� ������
			while ((oneByte = in.read()) != -1) {
				// out.write((char)oneByte); // ������ � ������������ �����
				// ������������ ������
				out.append((char)oneByte); // ������ � ����������� ������ � �����
				System.out.print((char)oneByte);
				}
		}
		catch (IOException e) {
			System.out.println("������!!!!");
		}
		finally{
			in.close();
			out.close();
		}
	}
}