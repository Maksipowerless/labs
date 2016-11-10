package com.mycompany.app.java.lab1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class MainClass{
	public static void main(String[] args) throws IOException{
	
		//создаем поток для ввода
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of file: ");
        
        //считываем имя файла и добавляем расширение
        String str = in.nextLine();
        String nameoffile = new String(str + ".txt");
        
        //считываем строку для записи в файл
        System.out.println("Enter the string: ");
        String data = in.nextLine();
        
        //создаем файл
     	File file = new File(nameoffile);
     	
     	//записываем в конец файла строку
		FileUtils.writeStringToFile(file, data, Charset.defaultCharset(), true);
		
		in.close();
	}  
}
