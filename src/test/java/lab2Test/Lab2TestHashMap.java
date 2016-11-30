package lab2Test;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Lab2TestHashMap{
	
	@Test
	public void testEmpty(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		assertTrue(map.size() == 1);
	}
	
	@Test
	public void testRepetition(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(1, "value");
		assertTrue(map.size() == 1);
	}
	
	@Test
	public void testClear(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(2, "world");
		map.put(4, "java");
		map.clear();
		assertTrue(map.isEmpty());
	}
	
	@Test
	public void testContainsKey(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(3, "value");
		assertTrue(map.containsKey(1));
	}
	
	@Test
	public void testRemove(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(3, "value");
		map.put(5, "world");
		map.remove(3);
		assertTrue(!map.containsValue("value"));
	}
	
	@Test
	public void testReplace(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(3, "value");
		map.put(5,"c++");
		map.replace(3, "value", "newValue");
		assertTrue(map.containsValue("newValue") && !map.containsValue("value"));
	}
	
	@Test
	public void testEquals(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(3, "value");
		
		Map<Integer, String> map2 = new LinkedHashMap<Integer, String>();
		map2.put(1, "hello");
		map2.put(3, "value");
		
		assertTrue(map.equals(map2));
	}
	
	@Test
	public void testSequence(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "hello");
		map.put(3, "value");
		map.put(5, "java");
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		
		assertTrue(map.keySet().equals(set));
	}
}