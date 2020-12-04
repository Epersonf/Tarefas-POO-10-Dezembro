package me.br.eperson.uff.ex2;

public class Counter {
	private int count;
	
	public Counter() {
		this.count = 0;
	}
	
	synchronized void increment() throws InterruptedException {
		sum(1);
	}
	
	synchronized void decrement() throws InterruptedException {
		sum(-1);
	}
	
	synchronized void sum(int v) throws InterruptedException {
		if ((v < 0 && count <= 0) || (v > 0 && count >= 3)) return; 
		count += v;
		System.out.println(count);	
	}
}
