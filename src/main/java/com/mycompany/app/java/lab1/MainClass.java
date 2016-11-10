package com.mycompany.app.java.lab1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class MainClass{
	public static void main(String[] args) throws IOException{
	
		//������� ����� ��� �����
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of file: ");
        
        //��������� ��� ����� � ��������� ����������
        String str = in.nextLine();
        String nameoffile = new String(str + ".txt");
        
        //��������� ������ ��� ������ � ����
        System.out.println("Enter the string: ");
        String data = in.nextLine();
        
        //������� ����
     	File file = new File(nameoffile);
     	
     	//���������� � ����� ����� ������
		FileUtils.writeStringToFile(file, data, Charset.defaultCharset(), true);
		
		in.close();
	}  
}
