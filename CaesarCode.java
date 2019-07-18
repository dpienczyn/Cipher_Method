package Szyfr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCode {

	public void start() {
		System.out.println("Program obs³uguje dwa pliki. Z jednego pobiera dane które szyfruje liczba któr¹ wprowadzisz na ekran w konsoli. Nastepnie zaszyfrowane dane zapisuje do pliku drugiego");
		System.out.println("¯ycze udanej zabawy!");
	}
	
	public String words() throws FileNotFoundException{
		String Filepath = "C:/Users/Dominika/eclipse-workspace/Tasks/bin/Szyfr/tekst.txt";
		File f = new File(Filepath);
		Scanner load = new Scanner(f);
		String word;
		word = load.nextLine();
		load.close();
		return word;
	}
	
	public byte[] replace(String word) {
		byte[] b = word.getBytes();
		return b;
	}
	
	public int key() {
		Scanner read = new Scanner(System.in);
		System.out.println("Podaj klucz w postaci cyfry od 1 do 26..");
		int key = read.nextInt();
		return key;
	}
	
	public void compare(int key) {
		if(key>26||key<1) {
			System.out.println("Wybierz klucz z przedzia³u od 1 do 26");
			System.exit(0);
		}
	}
	
	public void writeEncode(byte[] b, int key) throws FileNotFoundException{
		String FilePathEncode = "C:/Users/Dominika/eclipse-workspace/Tasks/bin/Szyfr/zakodowany.txt";
		PrintWriter write = new PrintWriter(FilePathEncode);
		for(byte n:b) {
			int h = 0;
			int keyOne = 65 - key;
			int keyTwo = 97 - key;
			if(n==32){
				h = n;
			}
			if(n>=65&&n<=90) {
				h=65+(n-keyOne)%26;
			}
			if(n>=97&&n<=122) {
				h=97+(n-keyTwo)%26;
			}
			write.print((char)h);
		}
		write.close();
	}
	
	public char question() {
		Scanner read = new Scanner(System.in);
		System.out.println("Czy chcesz odkodowaæ zadanie? Jeœli tak to wciœnij 't' jeœli nie to wciœnij 'n'");
		char t = read.next().charAt(0);
		return t;
	}
	
	public void wordDecode(char t, int key) throws FileNotFoundException{
		String FilePathDecode = "C:/Users/Dominika/eclipse-workspace/Tasks/bin/Szyfr/zakodowany.txt";
		String FilePathWrite = "C:/Users/Dominika/eclipse-workspace/Tasks/bin/Szyfr/odkodowany.txt";
		if(t=='t'){
			File file = new File(FilePathDecode);
			Scanner read = new Scanner(file);
			Scanner p = new Scanner(System.in);
			String word = read.nextLine();
			byte[] j = word.getBytes();
			PrintWriter write = new PrintWriter(FilePathWrite);	
			for(byte character: j){
				int a = 0;
				int k;
				k= 26-key;
				int keyThree = 65-k;
				int keyFour = 97-k;
				
				if(character==32)
				{
					a = character;
				}
				if(character>=65&&character<=90)
				{
					a=65+(character-keyThree) % 26;
				}
				if(character>=97&&character<=122)
				{
					a=97+(character-keyFour)%26;
				}
				
				write.print((char)a);
			}
			p.close();
			write.close();
			}
			else 
			{
				System.out.println("Koniec kodowania");
			}
	}	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		CaesarCode code = new CaesarCode();
		code.start();
		String w = code.words();
		byte[] v = code.replace(w);
		int key = code.key();
		code.compare(key);
		code.writeEncode(v, key);
		char c = code.question();
		code.wordDecode(c, key);
	}
}

