package L_10_Examples;

// ������ �� ������ ����� � ������ � ������ ���� ������ ��������� � �������������� ������ � 1 ��������

import java.io.*;

public class L10_7 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter out = null;
		try {
			// �������� �������� ���������� ������� ��� ������ � ������
			br = new BufferedReader( new FileReader("C:\\My\\numIsh.txt"),1024);
			out = new BufferedWriter(new FileWriter("C:\\My\\numRez.txt"));
			
			int lineCount = 0;
			String s;
			// ������������� ���������� �� ������ ����� � ������
			while((s = br.readLine())!= null) {
				lineCount++;
				System.out.println(lineCount + ":" + s);
				out.write(s);
				out.newLine();   // ������� �� ����� ������
			}
		}
		catch(IOException e) {
			System.out.println("������!!!");
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}