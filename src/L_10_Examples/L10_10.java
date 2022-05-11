package L_10_Examples;

// ��������� ������ �� ������ ����� � ������ � ������ ���� � �������������� ������ PrintWriter.

import java.io.*;

public class L10_10 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = null;
		PrintWriter out=null;
		try {
			// �������� �������
			br = new BufferedReader(new InputStreamReader(new FileInputStream("MyFile.txt"),"cp1251"));
			out = new PrintWriter("MyFile1.txt","cp1251");
			// ������������� ���������� �� ������ ����� � ������
			int lineCount = 0;
			String s;
			while ((s = br.readLine()) != null) {
			lineCount++;
			out.println(lineCount + ": " + s);
			}
		}
		catch (IOException e) {
			 System.out.println("������ !!!!!!!!");
		}
		finally {
			br.close();
			out.flush();
			out.close();
		}
	}
}