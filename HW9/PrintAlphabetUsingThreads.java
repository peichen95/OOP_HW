import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class PrintAlphabetUsingThreads{
	
	
	public static void main(String[] args) throws Exception{
		char[] array1 = {'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
		char[] array2 = {'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
		char[] array3 = {'C', 'G', 'K', 'O', 'S', 'W'};
		char[] array4 = {'D', 'H', 'L', 'P', 'T', 'X'};
		
		Thread thread1 = new Thread(new PrintLetters(array1));
		Thread thread2 = new Thread(new PrintLetters(array2));
		Thread thread3 = new Thread(new PrintLetters(array3));
		Thread thread4 = new Thread(new PrintLetters(array4));
		
		thread1.start();
		Thread.sleep(10);
		thread2.start();
		Thread.sleep(10);
		thread3.start();
		Thread.sleep(10);
		thread4.start();
	}
}

class PrintLetters implements Runnable{
	private char[] array;
	private static ReentrantLock lock = new ReentrantLock(true);
	
	public PrintLetters(){
		this.array = null;
	}
	
	public PrintLetters(char[] array){
		this.array = new char[array.length];
		for(int i = 0; i < array.length; i++){
			(this.array)[i] = array[i];
		}
	}
	
	public void run(){
		try{
			for(int i = 0; i < array.length; i++){
				lock.lock();
				System.out.printf("%c ", array[i]);
				lock.unlock();
				Thread.sleep(100);
			}
		}catch(Exception t){}
	}
	
}