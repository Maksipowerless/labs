package com.mycompany.app.java.lab4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.Set;

public class MyServer {
	public static void main(String[] args) throws IOException {

		Selector selector = Selector.open();

		ServerSocketChannel crunchifySocket = ServerSocketChannel.open();
		InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 2222);

		crunchifySocket.bind(crunchifyAddr);
		crunchifySocket.configureBlocking(false);

		int ops = crunchifySocket.validOps();
		SelectionKey selectKy = crunchifySocket.register(selector, ops, null);

		while (true) {

			log("i'm a server !!!");
			selector.select();

			Set<SelectionKey> crunchifyKeys = selector.selectedKeys();
			Iterator<SelectionKey> crunchifyIterator = crunchifyKeys.iterator();

			while (crunchifyIterator.hasNext()) {
				SelectionKey myKey = crunchifyIterator.next();

				if (myKey.isAcceptable()) {
					SocketChannel crunchifyClient = crunchifySocket.accept();
					crunchifyClient.configureBlocking(false);

					crunchifyClient.register(selector, SelectionKey.OP_READ);
					log("Connection Accepted: " + crunchifyClient.getLocalAddress() + "\n");

				} else if (myKey.isReadable()) {

					SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
					ByteBuffer bufferRead = ByteBuffer.allocate(256);
					crunchifyClient.read(bufferRead);
					String result = new String(bufferRead.array()).trim();
					log("Message received: " + result);
					bufferRead.clear();

					if (result.equals("Close")) {
						ByteBuffer bufferWrite = ByteBuffer.allocate(256);
						String resultW = "Bye";
						bufferWrite = ByteBuffer.wrap(resultW.getBytes());
						crunchifyClient.write(bufferWrite);

						bufferWrite.clear();
						crunchifyClient.close();
						log("\nIt's time to close connection");
						log("\nServer will keep running. Try running client again to establish new connection");
					}

					else {
						InetAddress[] addresses = null;
						addresses = InetAddress.getAllByName(result);

						ByteBuffer bufferWrite = ByteBuffer.allocate(256);
						boolean isWrote = true;
						for (InetAddress address : addresses) {

							if (address.isReachable(1000) && isWrote) {
								log("Connected: " + address);
								result = "Address is reachable\n";
								bufferWrite = ByteBuffer.wrap(result.getBytes());
								isWrote = false;
								crunchifyClient.write(bufferWrite);
								bufferWrite.clear();
							}
						}
					}
				}
				crunchifyIterator.remove();
			}
		}
	}

	private static void log(String str) {
		System.out.println(str);
	}
}
