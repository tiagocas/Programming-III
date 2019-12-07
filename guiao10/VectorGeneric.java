package guiao10;

import java.util.Iterator;

public class VectorGeneric<T> {
	private T[] lst;
	private int size;
	private int block = 20;
	
	public VectorGeneric(int max){
		this.size = 0;
		this.lst = (T[]) new Object[max];
	}
	
	public VectorGeneric() {
		this(20);
	}
	
	public boolean addElem(T elem) {
		if(size >= lst.length-1) {
			T[] aux = (T[]) new Object[lst.length + block];
			System.arraycopy(this.lst, 0, aux, 0, lst.length);
			this.lst = aux;
		}
		this.lst[size++] = elem;
		return true;
	}
	
	public boolean removeElem(T elem) {
		for(int i=0;i<this.lst.length;i++) {
			try {
				if(this.lst[i] == elem) {
					this.lst[i] = null;
					size++;
					return true;
				}
			}
			catch(Exception e) {
			}
		}
		return false;
	}
	
	public int totalElem() {
		return this.size;
	}
	
	public Iterator iterator() {
		return new VectorIterator();
	}
	
	private class VectorIterator implements Iterator<T> {
		private int pointer = 0;
		
		@Override
		public boolean hasNext() {
			return size-1 >= pointer;
		}

		@Override
		public T next() {
			return lst[pointer++];
		}
	}	
}
