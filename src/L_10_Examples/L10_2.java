package L_10_Examples;

			/* ��������� � ������� �� ����� ���������� �� ���� ����������: 
					- ����� �� �����;
					- ��������-��������;
					- ������� ���� byte. */

import java.io.*;
import java.net.*;

public class L10_2 {
	
// ����� ��� ������ ������ �� ������ �� ������ � �������
	public static void readAllByByte (InputStream in) throws IOException {
		while(true) {
			int oneByte = in.read(); // ������ 1 ����
			if(oneByte != -1) {      // ������� ���������� ����� �����
				System.out.print((char)oneByte);
			}
			else {
				System.out.print("\n" + "end");
				break;
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		try {
			
			// � ������� ������ ����
			InputStream inFile = new FileInputStream("MyFile.txt"); // ���������� ����� InputStream, ������� ������ ����� ������ � ��������� ������ �� ���� ����������� ��� ������
			readAllByByte(inFile); // ���������� ����� readAllByByte
			System.out.print("\n\n\n"); 
			inFile.close(); // ���������� ����� close ��� �������� �����
			
			// � ������� ������� ��������-��������
			InputStream inUrl = new URL("http://google.com").openStream(); // ������� ������ URL � ����� � �������� � ���������� ����� openStream - ������� ������� ����� ��� ������ ����� �������, ���������� � ��������� �������� ������ URL
			readAllByByte(inUrl);
			System.out.print("\n\n\n");
			inUrl.close();
			
			// � ������� ������ ������ ���� byte
			InputStream inArray = new ByteArrayInputStream(new byte [] {7,9,3,7,4}); // ����� ByteArrayInputStream - ����� ������ �����, ������� ������ �� ������� ���� byte
			readAllByByte(inArray);
			System.out.print("\n\n\n");
			inArray.close();
		}
		catch(IOException e) { // ��������� ���������� ������ IOException
			System.out.println("������!!!" + e);
		}
	}

}
