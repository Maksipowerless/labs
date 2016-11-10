package com.mycompany.app.java.lab1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

class UsefulCode {
	public UsefulCode(int num) {

		ArrayList<String> webs = new ArrayList<String>();
		webs.add("onet.pl");
		webs.add("doubleclick.net");
		webs.add("avito.ru");
		webs.add("globo.com");
		webs.add("ebay.co.uk");
		webs.add("twitch.tv");

		long start = System.currentTimeMillis();
		for (String str : webs) {
			InetAddress[] addresses = null;
			try {
				addresses = InetAddress.getAllByName(str);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (InetAddress address : addresses) {
				try {
					if (address.isReachable(1000)) {
						System.out.println("(" + num + ") " + "Connected " + address);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		long finish = System.currentTimeMillis();
		long timeConsumedMillis = finish - start;
		System.out.println("Hello from " + num + " thread. Time: " + timeConsumedMillis);
	}
}

class MyThread implements Runnable {

	int num;

	MyThread(int num) {
		this.num = num;
	}

	public void run() {
		UsefulCode c1 = new UsefulCode(num);
	}
}

public class lab3 {
	public static void main(String[] args) throws IOException, InterruptedException {

		MyThread sm = new MyThread(1);
		MyThread sm2 = new MyThread(2);
		MyThread sm3 = new MyThread(3);
		MyThread sm4 = new MyThread(4);

		Thread th1 = new Thread(sm);
		Thread th2 = new Thread(sm2);
		Thread th3 = new Thread(sm3);
		Thread th4 = new Thread(sm4);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		th1.join();
		th2.join();
		th3.join();
		th4.join();
		// 35893 - 1 threads
		// 18191 - 2 threads
		//  9176 - 3 threads
	}
}
/*
 * webs.add("amazon.com"); webs.add("wikipedia.org"); webs.add("twitter.com");
 * webs.add("live.com"); webs.add("taobao.com");
 * 
 * webs.add("bing.com"); webs.add("linkedin.com"); webs.add("reddit.com");
 * webs.add("ebay.com"); webs.add("accuweather.com");
 * 
 * webs.add("wikipedia.org"); webs.add("twitter.com"); webs.add("live.com");
 * webs.add("taobao.com");
 * 
 * webs.add("onet.pl"); webs.add("doubleclick.net"); webs.add("avito.ru");
 * webs.add("globo.com"); webs.add("ebay.co.uk"); webs.add("twitch.tv");
 * 
 */