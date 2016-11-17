package com.mycompany.app.java.lab1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ServerExample {
	public static void main(String[] args) throws IOException{
		/*int port = 12345;
		ServerSocket serverSocket = new ServerSocket(port);
		Socket acceptSocket = serverSocket.accept();
		DataInputStream is = new DataInputStream(acceptSocket.getInputStream());
		String data = is.readUTF();
		System.out.println("Client sent string: " + data);*/
		
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.remove(new Integer(2));
		System.out.println(arr);
		
	}

}
