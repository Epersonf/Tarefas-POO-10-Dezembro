package me.br.eperson.uff.ex2;

public class CounterUser {
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		ThreadSum tS_1 = new ThreadSum(1, counter);
		ThreadSum tS_2 = new ThreadSum(-1, counter);
		
		new Thread(tS_1).start();
		new Thread(tS_2).start();
	}
	
}
