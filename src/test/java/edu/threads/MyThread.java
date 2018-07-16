package edu.threads;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
	}

	public static void main(String[] args) {
		MyThread myThread1 = new MyThread("111");
		MyThread myThread2 = new MyThread("222");
		myThread1.start();
		myThread2.start();
	}
}
