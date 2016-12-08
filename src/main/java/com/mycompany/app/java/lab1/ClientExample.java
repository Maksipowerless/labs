package com.mycompany.app.java.lab1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

public class ClientExample {
	public static void main(String[] args) throws IOException{
		int port = 12345;
		String address ="127.0.0.1";
		InetAddress ipAddress = InetAddress.getByName(address);
		//Socket s = new Socket(ipAddress, port);
		//SocketChannel channel = new SocketChannel(ipAddress);
	}
}
