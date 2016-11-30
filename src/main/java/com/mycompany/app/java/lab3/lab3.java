package com.mycompany.app.java.lab3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

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

	MyThread(int num, ArrayList<String> urls, int s, int f) {
		this.num = num;
		int START =s;
		for(int i=0; i< f-s; i++)
		{
			data.add(urls.get(START));
			START++;
		}
	}

	public void run() {
		UsefulCode c1 = new UsefulCode(num, data);
	}
}

public class lab3 {
	public static void main(String[] args) throws IOException, InterruptedException {

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
//		webs.add("onet.pl");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("doubleclick.net");
//		webs.add("avito.ru");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("globo.com");
//		webs.add("ebay.co.uk");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("twitch.tv");
//		webs.add("vk.com");
//		webs.add("amazon.com");
//		webs.add("wikipedia.org");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("twitter.com");
//		webs.add("live.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("taobao.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("bing.com");
//		webs.add("linkedin.com");
//		webs.add("reddit.com");
//		webs.add("ebay.com");
//		webs.add("accuweather.com");
//		webs.add("avito.ru");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("minomos.ru");
//		webs.add("vk.com");
//		webs.add("vlgregedu.ru");
//		webs.add("vk.com");
//		webs.add("omsk.edu.ru");
//		webs.add("vk.com");
//		webs.add("webinar.pgsga.ru");
//		webs.add("vk.com");
//		webs.add("edu-murman.ru");
//		webs.add("vk.com");
//		webs.add("twitch.tv");
//		webs.add("vk.com");
//		webs.add("amazon.com");
//		webs.add("vk.com");
//		webs.add("wikipedia.org");
//		webs.add("vk.com");
//		webs.add("twitter.com");
//		webs.add("vk.com");
//		webs.add("avito.ru");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("minomos.ru");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vk.com");
//		webs.add("vlgregedu.ru");
		
		int N =8;
		int START =0;
		int FINISH = webs.size() / N;
		int RANGE = FINISH;
		
		ArrayList<Thread> listTread= new ArrayList<Thread>();
		for(int i=0; i< N; i++)
		{
			MyThread myThread = new MyThread(i+1, webs, START, FINISH);
			Thread thread = new Thread(myThread);
			listTread.add(thread);
			thread.start();
			
			START+=RANGE;
			FINISH+=RANGE;
		}
		
		for(int i=0; i< N; i++)
		{
			listTread.get(i).join();
		}
			
	}
}
