package lab2Test;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class Lab2TestLHashSet {
	
	@Test
	public void testEmpty(){
		Set<Integer> set = new LinkedHashSet<Integer>();
		assertTrue(set.isEmpty());
	}
	
	@Test
	public void testAdd(){
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(3);
		assertTrue(set.size() == 2);
	}
	
	@Test
	public void testContains(){
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(3);
		assertTrue(!set.contains(4));
	}
	
	@Test
	public void testRetain(){
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(3);
		
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		set2.add(1);
		set2.add(6);
		
		set.retainAll(set2);
		assertTrue(set.contains(1) && set.size() == 1);
	}
		
		@Test
		public void testHashCode(){
			Set<Integer> set = new LinkedHashSet<Integer>();
			set.add(1);
			set.add(3);
			
			Set<Integer> set2 = new LinkedHashSet<Integer>();
			set2.add(1);
			set2.add(3);
			assertTrue(set.hashCode() == set2.hashCode());
	}
}