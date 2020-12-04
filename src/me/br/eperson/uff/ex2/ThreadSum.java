package me.br.eperson.uff.ex2;

public class ThreadSum implements Runnable {
	
	private int sign;
	private Counter counter;
	private boolean cancel;
	
	public void cancel() {
		cancel = true;
	}
	
	public ThreadSum(int sign, Counter counter) {
		this.sign = sign;
		this.counter = counter;
		cancel = false;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				if (sign > 0) counter.increment();
				else counter.decrement();
				Thread.sleep((long) (Math.random()/2));
				if (cancel) break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
