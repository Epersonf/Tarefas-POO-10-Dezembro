package me.br.eperson.uff.ex1;

import java.util.HashMap;

public class ThreadPrimos implements Runnable {
	private int n;
	private HashMap<Integer, Integer> hash;
	
	public ThreadPrimos() {
		hash = new HashMap<Integer, Integer>();
	}
	
	public void setValue(int n) {
		this.n = n;
	}
	
	private boolean ehPrimo(int n) {
		if (n <= 1) return false;
		else if (n == 2) return true;
		else if (n % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	private int calculaPrimos(int n) {
		if (n < 2) return 0;
		
		Integer v = hash.get(n);
		if (v != null) return v;
		
		int c = ehPrimo(n) ? 1 : 0;
		
		int amount = c + calculaPrimos(n - 1);
		
		hash.put(n, amount);
		
		return amount;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(calculaPrimos(this.n));
		} catch (StackOverflowError e) {
			System.out.println("A stack foi excedida, coloque mais valores no hash antes...");
		}
	}
	
}
