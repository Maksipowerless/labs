package com.mycompany.app.java.lab1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

class UsefulCode {
	public UsefulCode(int num, ArrayList<String> urls) {

		long start = System.currentTimeMillis();
		for (String str : urls) {
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
	ArrayList<String> data = new ArrayList<String>();

	MyThread(int num, ArrayList<String> urls) {
		this.num = num;
		data = urls;
		System.out.println("constructor " + num + " " + data);
	}

	public void run() {
		UsefulCode c1 = new UsefulCode(num, data);
	}
}

// 1 thread - 24516 seconds
// 2 thread - 14809 seconds
// 4 thread - 9155 seconds
public class lab3 {
	public static void main(String[] args) throws IOException, InterruptedException {

		ArrayList<String> webs = new ArrayList<String>();
		webs.add("onet.pl");
		webs.add("doubleclick.net");
		webs.add("avito.ru");
		webs.add("globo.com");
		webs.add("ebay.co.uk");
		webs.add("twitch.tv");
		MyThread sm = new MyThread(1, webs);

		ArrayList<String> webs1 = new ArrayList<String>();
		webs1.add("amazon.com");
		webs1.add("wikipedia.org");
		webs1.add("twitter.com");
		webs1.add("live.com");
		webs1.add("taobao.com");
		webs1.add("bing.com");
		MyThread sm2 = new MyThread(2, webs1);

		ArrayList<String> webs2 = new ArrayList<String>();
		webs2.add("linkedin.com");
		webs2.add("reddit.com");
		webs2.add("ebay.com");
		webs2.add("accuweather.com");
		webs2.add("avito.ru");
		webs2.add("vk.com");
		MyThread sm3 = new MyThread(3, webs2);

		ArrayList<String> webs3 = new ArrayList<String>();
		webs3.add("minobr.khb.ru");
		webs3.add("minomos.ru");
		webs3.add("vlgregedu.ru");
		webs3.add("omsk.edu.ru");
		webs3.add("webinar.pgsga.ru");
		webs3.add("edu-murman.ru");
		MyThread sm4 = new MyThread(4, webs3);

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
	}
}
