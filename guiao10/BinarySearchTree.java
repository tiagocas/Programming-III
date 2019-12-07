package guiao10;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public void insert(T value) {
		root = insert(value, root);
	}
	
	public void remove(T value) {
		root = remove(value, root);
	}
	
	public boolean contains(T value) {
		return valueOf(find(value, root)) != null;
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> node){
		if(node == null) {
			return null;
		}
		double comparator = value.compareTo(node.element);
		if(comparator < 0) {
			node.left = remove(value, node.left);
			return node;
		}
		else if(comparator > 0) {
			node.right = remove(value, node.right);
			return node;
		}
		else {
			
			
		}
		return null;
	}
	
	private T valueOf(BSTNode<T> node) {
		return node.element;
	}
	
	private BSTNode<T> find(T value, BSTNode<T> node){
		if(node == null) {
			return null;
		}
		double comparator = value.compareTo(node.element);
		if(comparator < 0) {
			node.left = insert(value, node.left);
		}
		else if(comparator > 0) {
			node.right = insert(value, node.right);
		}
		else {
			return node;
		}
		return null;
	}
	
	private BSTNode<T> insert(T value, BSTNode<T> node) {
		if(node == null) {
			return new BSTNode<T>(value);
		}
		int comparator = value.compareTo(node.element);
		if(comparator < 0) {
			node.left = insert(value, node.left);
		}
		else if(comparator > 0) {
			node.right = insert(value, node.right);
		}
		return node;
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator(root);
	}
	
	private class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		
		BSTNode(T e) {
			element = e;
			left = right = null;
		}
	}
	
	private class BSTIterator<T> implements Iterator<T> {
		Stack<BSTNode<T>> stack;

		public BSTIterator(BSTNode<T> node) {
			while(root != null) {
				stack.push(node);
				node = node.left;
			}
		}
		
		@Override
		public boolean hasNext() {
			
			return false;
		}

		@Override
		public T next() {
			
			return null;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
