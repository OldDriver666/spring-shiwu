package edu.threads;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
	}

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread thread1 = new Thread(mr,"mythread1");
		Thread thread2 = new Thread(mr,"mythread2");
		thread1.start();
		thread2.start();
	}
}
