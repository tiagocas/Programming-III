package guiao09;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class VectorPessoas {
	private Pessoa[] pessoas;
	private int size;
	private Iterator iterator;
	
	
	public VectorPessoas(int size) {
		this.size = 0;
		this.pessoas = new Pessoa[size];
		iterator = new VectorIterator();
	}
	public VectorPessoas() {
		this(20);
	}
	
	public boolean addPessoa(Pessoa p) {
		if(size < pessoas.length) {
			this.pessoas[size++] = p;
			return true;
		}
		return false;
	}
	
	public int totalPessoas() {
		return size;
	}
	
	public Iterator iterator() {
		return this.iterator;
	}
	
	public class VectorIterator implements Iterator<Pessoa> {
		int pointer = 0;
		
		public boolean hasNext() {
			return pointer < size;
		}
		public Pessoa next() {
			if(pointer >= size) {
				throw new NoSuchElementException();
			}			
			return (Pessoa) pessoas[pointer++];
		}
	}
	
	
	
}
