package robert.rodriguez;

import java.util.concurrent.TimeUnit;

public class MyThread {

	public static void main(String[] args) {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("My thread: " + threadName);
		};
		
		//task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done");
		
		Runnable runnable  = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo: " + name);
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Bar: " + name);
			}catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		};
		
		Thread thead2 = new Thread(runnable);
		thead2.start();
	}
}
