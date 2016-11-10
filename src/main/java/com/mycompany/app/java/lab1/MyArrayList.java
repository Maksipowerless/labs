package com.mycompany.app.java.lab1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {

	private Object[] data;
	private int size;
	private int capacity;

	public MyArrayList() {
		size = 0;
		capacity = 2;
		data = new Object[capacity];
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean add(T data) {
		resize();
		this.data[size] = data;
		size++;
		return true;
	}

	public void resize() {
		if (size == capacity) {
			int newcapacity = (int) (size + size * 1.5);
			Object temp[] = new Object[newcapacity];

			for (int i = 0; i < size; i++)
				temp[i] = data[i];

			data = new Object[newcapacity];
			for (int i = 0; i < size; i++)
				data[i] = temp[i];

			capacity = newcapacity;
		}
	}

	public boolean contains(Object data) {

		return indexOf(data) >= 0;
	}

	public T get(int num) {
		return (T) data[num];
	}

	public int indexOf(Object data) {
		for (int i = 0; i < size; i++) {
			if (this.data[i].equals(data))
				return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T set(int num, T data) {
		this.data[num] = data;
		return (T) this.data[num];
	}

	public int size() {
		return size;
	}

	public boolean remove(Object data) {

		Object temp[] = new Object[size];

		int j = 0;
		boolean b = false;
		for (int i = 0; i < size; i++) {
			if (this.data[i].equals(data)) {
				size--;
				j++;
				b = true;
			}
			temp[i] = this.data[j];
			j++;
		}

		for (int i = 0; i < size; i++)
			this.data[i] = temp[i];

		return b;
	}

	public T remove(int num) {

		Object temp[] = new Object[size];
		for (int i = 0; i < num; i++)
			temp[i] = data[i];

		Object tob = data[num];

		for (int i = num; i < size - 1; i++)
			temp[i] = data[i + 1];

		for (int i = 0; i < size; i++)
			data[i] = temp[i];

		size--;
		return (T) tob;
	}

	public void clear() {
		size = 0;
	}

	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int arg0, T arg1) {
		// TODO Auto-generated method stub

	}

	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
