package lab2Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Lab2TestsLList {
	
	@Test
	public void testAdd(){
		
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertTrue(list.size() == 4);
		
	}
	
	@Test
	public void testAddInPos(){
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(14);
		list.add(1,5);
		assertTrue(list.get(1).equals(5));
	}
	
	@Test
	public void testSequence(){
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(6);
		assertTrue(list.get(0).equals(4) && list.get(1).equals(2) && list.get(2).equals(1) && list.get(3).equals(6) );
	}
	
	
	@Test
	public void testContains(){
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(6);
		assertTrue(list.contains(2));
	}
	
	@Test
	public void testClear(){
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(6);
		list.clear();
		assertTrue(list.size() == 0 );
	}
	
	@Test
	public void testRemove(){
		
		List<String> list = new LinkedList<String>();
		list.add("hello");
		list.add("world");
		list.remove("hello");
		assertTrue(!list.contains("hello"));
	}
	
	@Test
	public void testIndexOfLast(){
		
		List<Integer> list = new LinkedList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(6);
		assertTrue(list.lastIndexOf(2) == 3 && list2.lastIndexOf(2) == -1);
	}
	
	@Test
	public void testSet(){
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(6);
		list.set(list.size() - 1, 2);
		assertTrue(list.get(list.size() -1 ) == 2);
	}
	
}
