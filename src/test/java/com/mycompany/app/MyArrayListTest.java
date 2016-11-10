package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mycompany.app.java.lab1.MyArrayList;

public class MyArrayListTest {

	@Test
	public void testSize() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		arr.add(4);
		assertTrue(arr.size() == 2);
	}

	@Test
	public void testContains() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		arr.add(4);
		assertTrue(arr.contains(4) && !arr.contains(2));
	}

	@Test
	public void testGet() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		MyArrayList<String> arr2 = new MyArrayList<String>();
		arr2.add("hello");
		arr.add(5);
		arr.add(4);
		assertTrue(arr.get(1).equals(4) && arr2.get(0).equals("hello"));
	}

	@Test
	public void testIndexOf() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		arr.add(4);
		assertTrue(arr.indexOf(5) == 0 && arr.indexOf(6) == -1);
	}

	@Test
	public void testIsEmpty() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		assertTrue(arr.isEmpty());
	}

	@Test
	public void testRemove() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		arr.add(4);
		arr.add(1);
		assertTrue(arr.size() == 3 && arr.remove(1) == 4 && arr.size() == 2 && arr.get(1) == 1);
	}

	@Test
	public void testRemove1() {
		MyArrayList<String> arr = new MyArrayList<String>();
		arr.add("hello");
		arr.add("world");
		arr.add("java");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		assertTrue(arr.size() == 3 && arr.remove("world") && arr.size() == 2 && arr.get(1).equals("java"));
	}

	@Test
	public void testSet() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		arr.add(4);
		arr.add(1);
		assertTrue(arr.set(0, 4) == 4);
	}

	@Test
	public void resize() {
		MyArrayList<Integer> arr = new MyArrayList<Integer>();
		arr.add(5);
		assertTrue(arr.getCapacity() == 2);
		arr.add(4);
		arr.add(1);
		assertTrue(arr.getCapacity() == 5);
	}

}
