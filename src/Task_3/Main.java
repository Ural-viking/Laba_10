package Task_3;

/*	������� ������, ����������� �� ������ ���������� �����, ����������� ��������� ����� (��� String)
	������� ��������������� ������ �� ������� ����� (������, ��������� ��� ������ ���������� �������),
	��������� ���������� � ������ ��������� ���� ����� ������������ � ��������� ����.
		����������:
					� ����� �� ����������� �������� ������� split();
					� � ����� ����� ������� ������� ����� ������, � ������� ������� ����� ���������� � �������� �����;
					� ��� ������ ������ ������� ���������� ��������� ����. */

import java.io.*;

public class Main {
	public static void main(String[] args) {
		File in = new File("poem.txt");	//����� ����� �� �������� ������ ������
		File out = new File("result.txt");	//����� ����� � ������� ���������� ������
		int lineCounter = 0;
		int wordsCounter;
		String buffer = "";
		char[] consonants = {'�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'};
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(in),"UTF-8"));BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out),"UTF-8"))) {
			for(;;) {
				buffer = br.readLine();
				wordsCounter = 0;
				lineCounter ++;
				if(buffer==null) {
					break;
				}
				else {
					bw.write("Line " + lineCounter + ": ");
					String[] words = buffer.split(" ");
					for(int i=0;i<words.length;i++) {
						char c = words[i].charAt(0);
						for(int j=0;j<consonants.length;j++) {
							if(c==consonants[j]) {
								wordsCounter ++;
								bw.write(words[i] + " ");
							}
						}
					}
				bw.write(" Words starting with a consonant in a line - " + wordsCounter + System.lineSeparator());	
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}