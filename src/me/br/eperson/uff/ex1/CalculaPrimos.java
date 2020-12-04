package me.br.eperson.uff.ex1;

import java.util.Scanner;

public class CalculaPrimos {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ThreadPrimos threadPrimos = new ThreadPrimos();
		
		int n = 3;
		while (n > 2) {
			n = scan.nextInt();
			threadPrimos.setValue(n);
			new Thread(threadPrimos).start();
		}
		
		scan.close();
	}
	
}
