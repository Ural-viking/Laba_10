package Task_2;

/*	������� ������, ����������� �� ������, �������������� ���������� ������������ ���������� �����, ���������� ������,
	��������������� ������� - � �������� ����� ���������� ��� ������ � ������� UTF-8 � 5 ����� ���� double.
	� �������������� ���� ���������� ������ ������ � ������������� �����. */

import java.io.*;

public class Main {
	public static void main(String[] args) {
		File in = new File("input.txt");	//����� ����� �� �������� ������ ������
		File out = new File("output.txt");	//����� ����� � ������� ���������� ������
		int lineCounter = 0;
		String buffer = "";
		
		try(BufferedReader br = new BufferedReader(new  FileReader(in));BufferedWriter bw = new BufferedWriter(new FileWriter(out))){
			for(;;) {
				buffer = br.readLine();
				lineCounter ++;
				if(buffer==null) {
					break;
				}
				if(lineCounter == 2) {
					bw.write(buffer + System.lineSeparator());
				}
				if(lineCounter > 2) {
					String[]array = buffer.split(" "); //���������� ������ �� ��������� ������ � ������
					for(int i=0;i<array.length;i++) {
						double j = Double.parseDouble(array[i]);
						if(j>0) {
							bw.write(j + " ");
						}
					}
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}