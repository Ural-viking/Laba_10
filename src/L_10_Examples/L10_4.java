package L_10_Examples;

/*			������� ������ ���� �� ����� � �������� � ���� �������� ���������� ������������ �����.
 * 			����� ������� ������ ���� � ���������� � ���� ��� ����� �� ������� �����.  */

import java.io.*;
import java.util.*;

public class L10_4 {
	public static void main(String[] args) {
		try {
			// �������� ����� My � ����� numIsh.txt, �������������� � ���, � ������� ��� ������ � ���� ����� ���� float
			File f1 = new File("C:\\My\\numIsh.txt");
			f1.createNewFile();
			Scanner sc =new Scanner(System.in,"cp1251");
			// �������� ������� ������ DataOutputStream. �������� ������ ������ ������ ������ ��� ������ ������ � ��������� ����� ����.
			DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsoluteFile()));
			// ��������� � ������������
			System.out.println("������� ������������ ����� �������� � ����?");
			// ������� ����� ����� �������� ������������
			int count = sc.nextInt();
			// ������������ ������ �����, ������� ����� ��� ����� � ��������� ������
			System.out.println("������� �����: ");
			for(int i=0;i<count;i++) {
				wr.writeFloat(sc.nextFloat());
			}
			wr.flush(); // ����� flush - ������������ ��� �������������� ������ ������ � ������� �����
			wr.close();
			
			// �������� ����� numRez.txt � ������������� � ���� ����� �� numIsh.txt
			File f2 = new File("C:\\My\\numRez.txt");
			f2.createNewFile();
			// ����� ��� ������ �� ��������� ����� numIsh.txt
			DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));
			// ����� ��� ������ � �������������� ���� numRez.txt
			wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));
			
			try {
				while(true) {
					float number = rd.readFloat();
					wr.writeFloat(number);
					System.out.println("����� " + (float)number);
				}
			}
			catch(EOFException e) {
				wr.flush();
				wr.close();
				rd.close();
			}
		}
			catch(IOException e) {
				System.out.println("End of file");
			}
	}
}