package Task_2;

/*	Создать проект, позволяющий из одного, предварительно созданного программными средствами файла, переписать данные,
	соответствующие условию - в исходном файле содержится две строки в формате UTF-8 и 5 чисел типа double.
	В результирующий файл переписать вторую строку и положительные числа. */

import java.io.*;

public class Main {
	public static void main(String[] args) {
		File in = new File("input.txt");	//адрес файла из которого читаем данные
		File out = new File("output.txt");	//адрес файла в который записываем данные
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
					String[]array = buffer.split(" "); //разделение строки на отдельные строки в массив
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