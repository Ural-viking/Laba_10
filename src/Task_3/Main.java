package Task_3;

/*	Создать проект, позволяющий из одного текстового файла, содержащего несколько строк (тип String)
	заранее подготовленного текста на русском языке (Пушкин, Лермонтов или другой российсмки классик),
	построчно переписать в другой текстовый файл слова начинающиеся с согласных букв.
		Требования:
					– слова из предложения выделять методом split();
					– в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
					– для каждой строки указать количество выбранных слов. */

import java.io.*;

public class Main {
	public static void main(String[] args) {
		File in = new File("poem.txt");	//адрес файла из которого читаем данные
		File out = new File("result.txt");	//адрес файла в который записываем данные
		int lineCounter = 0;
		int wordsCounter;
		String buffer = "";
		char[] consonants = {'Б','б','В','в','Г','г','Д','д','Ж','ж','З','з','Й','й','К','к','Л','л','М','м','Н','н','П','п','Р','р','С','с','Т','т','Ф','ф','Х','х','Ц','ц','Ч','ч','Ш','ш','Щ','щ'};
		
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