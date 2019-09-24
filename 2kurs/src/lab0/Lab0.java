package lab0;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab0 {
	static final String FILE_NAME = "lab.txt";

	public static void main(String[] args) {
		File file=new File(FILE_NAME);
		System.out.println("Размер данных в файле: " +file.length() + " байт");
		tablePrint(FILE_NAME);
	
	}

	public static ArrayList<String> getText(String fileName) {

		ArrayList<String> text = new ArrayList<>();
		try {
			String str = null;
			BufferedReader br = new BufferedReader(new FileReader(fileName));			
			while ((str = br.readLine()) != null) {

				text.addAll(Arrays.asList(str.split(" ")));
			}
			br.close();

		} catch (IOException exc) {
			System.out.println("IO error!" + exc);

		}
		return text;
	}

	public static int getSymbCount(String word) {
		return word.length();
	}

	public static int getByteWord(String word) {
		byte[] utf8Bytes = null;
		try {
			utf8Bytes = word.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return utf8Bytes.length;
	}

	public static boolean isPalindrome(String word) {
		int n = word.length();
		for (int i = 0; i < (n / 2); ++i) {
			if (word.charAt(i) != word.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static double getBitHartly(String word) {
		{
			ArrayList<Character> alph = new ArrayList<Character>();
			for (int i = 0; i < word.length(); i++) {
				char symb = word.charAt(i);
				if (alph.contains(symb)==false) {
					alph.add(symb);
				}
			}
			return getSymbCount(word) * Math.log(alph.size()) / Math.log(2.0);
		}
	}

	public static double getBitShennon(String word) {
		double result = 0;
		int temp = 0;
		ArrayList<Character> alph = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++) {
			char symb = word.charAt(i);

			if (alph.contains(symb)==false) {
				alph.add(symb);
			}
		}
		for (char ch : alph) {
			temp = 0;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == ch) {
					temp++;
				}
			}
			result += -(double) temp / word.length() * Math.log((double) temp / word.length()) / Math.log(2.0);
		}
		return result;
	}

	public static void tablePrint(String fileName) {
		String strings = new String(new char[130]).replace('\0', '-');
		NumberFormat formatter = new DecimalFormat("#0.00");

		System.out.print(strings);
		System.out.println();
		System.out.printf("%-4s%-57s%-11s%-53s", " №", "| слово", "|", "|              Количество информации");
		System.out.println();
		System.out.print(strings);
		System.out.println();
		System.out.printf("%-4s%-57s%-11s%-11s%14s%14s%14s", " ", "| ", "| кол-во", "|", "| байт,размер |", "бит, |",
				"бит,");
		System.out.println();
		System.out.printf("%-4s%-57s%-11s%-11s%14s%14s%14s", " ", "| ", "|  символов", "| палидром", "| в программе |",
				"по Хартли |", "по Шеннону");
		System.out.println();

		for (int i = 0; i < getText(fileName).size(); i++) {
			System.out.print(strings);
			System.out.println();
			System.out.printf("%-4d%-57s%-11s%-11s|%14s%14s%14s", i, "| " + getText(fileName).get(i),
					"| " + (getSymbCount(getText(fileName).get(i))),
					"| " + ((isPalindrome(getText(fileName).get(i)) == true) ? "+" : "-"),
					(getByteWord(getText(fileName).get(i))) + " |",
					formatter.format(getBitHartly(getText(fileName).get(i))) + " |",
					getBitShennon(getText(fileName).get(i)));

			System.out.println();
		}
		System.out.println(strings);
	}

}
