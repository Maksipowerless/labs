package com.mycompany.app.java.lab4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Random;

class MyThread implements Runnable {

	ArrayList<String> webs;
	int numOfThread;
	
	MyThread(int num,ArrayList<String> list) {

		webs = list;
		numOfThread = num;
	}

	public void run() {
		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 2222);
		SocketChannel crunchifyClient = null;
		try {
			crunchifyClient = SocketChannel.open(crunchifyAddr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log( "(" + numOfThread + ")" + "connecting to Server");

		while (true) {
			Random randNumber = new Random();
			int num = randNumber.nextInt(webs.size());
			byte[] message = new String(webs.get(num)).getBytes();
			ByteBuffer bufferWrite = ByteBuffer.wrap(message);
			try {
				crunchifyClient.write(bufferWrite);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log( "(" + numOfThread + ")" + "sending: " + webs.get(num));

			ByteBuffer bufferRead = ByteBuffer.allocate(256);
			try {
				crunchifyClient.read(bufferRead);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String strRead = new String(bufferRead.array());
			log( "(" + numOfThread + ")" + "got: " + strRead);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bufferWrite.clear();
			bufferRead.clear();
			
			if (webs.get(num).equals("Close")) {
				try {
					crunchifyClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
	}

	private static void log(String str) {
		System.out.println(str);
	}
}

public class MyClient {
	public static void main(String[] args) throws InterruptedException {

		ArrayList<String> webs = new ArrayList<String>();
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("vk.com");
		webs.add("Close");

		int numberOfThreads = 100;

		ArrayList<Thread> listOfThread = new ArrayList<Thread>();
		
		for (int i = 0; i < numberOfThreads; i++) {
			MyThread myThread = new MyThread(i+1, webs);
			Thread thread = new Thread(myThread);
			listOfThread.add(thread);
			thread.start();
		}
		
		for (int i = 0; i < numberOfThreads; i++) {
			listOfThread.get(i).join();
		}
	}
}
