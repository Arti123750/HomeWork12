package com.abc.customarryalist;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArraylist<E> {

	private Object[] data;
	private int size;

	public CustomArraylist() {
		this(10);
	}

	public CustomArraylist(int initCapacity) {
		if (initCapacity > 0) {
			this.data = new Object[initCapacity];
		} else if (initCapacity == 0) {
			this.data = new Object[10];
		}

		else {
			throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
		}
	}

	public void addElement(E e) {
		ensureCapacity();
		data[size++] = e;
	}

	private void ensureCapacity() {
		if (data.length <= size) {
			int oldCapacity = data.length;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			data = Arrays.copyOf(data, newCapacity);
		}
	}
	

	public E get(int index) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(index);
		return (E) data[index];
	}

	public E set(int index, E element) {
		if (index >= size - 1)
			throw new ArrayIndexOutOfBoundsException(index);

		E oldValue = (E) data[index];
		data[index] = element;
		return oldValue;

	}

	public E remove(int index) {
		if (index >= size)
			throw new ArrayIndexOutOfBoundsException(index);
		E oldvalue = (E) data[index];

		int numMovoed = size - index - 1;

		if (numMovoed > 0)
			System.arraycopy(data, index + 1, data, index, numMovoed);
		data[--size] = null;
		return oldvalue;
	}

	public boolean remove(E obj) {
		int i = indexOf(obj);
		if (i >= 0) {
			remove(obj);
			return true;
		}
		return false;

	}

	private int indexOf(Object o) {
		return indexOf(o, 0);
	}

	private int indexOf(Object o, int index) {
		if (o == null) {
			for (int i = index; i < size; i++)
				if (data[i] == null)

					return i;
		} else {
			for (int i = index; i < size; i++)
				if (o.equals(data[i]))
					return i;
		}

		return -1;
	}

	public Iterator<E> iterator() {
		return new Itr();

	}
	public String toString() {
		Iterator<E> it = iterator();
		if (!it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			E e = it.next();
			sb.append(e == this ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.append(']').toString();
				sb.append(',');
		}

	}

	private class Itr implements Iterator<E> {
		int cursor;

		@Override
		public boolean hasNext() {

			return cursor != CustomArraylist.this.size;
		}

		@Override
		public E next() {
			return (E) CustomArraylist.this.data[cursor++];
		}

		public void remove() {
			CustomArraylist.this.remove(cursor);

		}

	}

}
