package lab1Test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Lab1Test{ 
	
	File f1 = new File("2.txt");
	File f2 = new File("3.txt");
	File f3 = new File("4.txt");
	String s1 = new String("Hello ");
	String s2 = new String("World!");
	
	@Before
	public void beforeTestMethod(){
		System.out.println("Before test:" + s1 + s2);
	}
	
	@After
	public void afterTestMethod() throws IOException {
		System.out.println("After test:" + FileUtils.readFileToString(f1, Charset.defaultCharset()));
	}
	
	@Test
	public void test1(){
		
		try {
			FileUtils.writeStringToFile(f1, s1, Charset.defaultCharset(), false);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			FileUtils.writeStringToFile(f1, s2,Charset.defaultCharset(), true);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			
			assertTrue(FileUtils.readFileToString(f1, Charset.defaultCharset()).equals(s1+s2));
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}
	
	@Test
	public void test2(){
		
		try {
			FileUtils.writeStringToFile(f2, s1,Charset.defaultCharset(), false);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			FileUtils.writeStringToFile(f2, s2,Charset.defaultCharset(), false);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			
			assertTrue(FileUtils.readFileToString(f2, Charset.defaultCharset()).equals(s2));
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}
	
	@Test
	public void test3(){
		
		try {
			FileUtils.writeStringToFile(f3, s1,Charset.defaultCharset(), false);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			FileUtils.writeStringToFile(f3, s2,Charset.defaultCharset(), true);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			FileUtils.writeStringToFile(f3, s1,Charset.defaultCharset(), true);
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
		try {
			
			assertTrue(FileUtils.readFileToString(f3, Charset.defaultCharset()).equals(s1+s2+s1));
		} catch (IOException e) {
			System.out.println("File doesn't exist");
		}
	}
}
