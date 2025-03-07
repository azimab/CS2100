//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 7 - LinkedList Queue
//N/A

package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */
		head = new ListNode<>(null);
		tail = new ListNode<>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public int size() {
		/* TODO: Implement this method */  
		return size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */
		head.next = tail;
		tail.prev = head;
		size =  0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<>(data);
		ListNode<T> prevNode = tail.prev;
		prevNode.next = newNode;
		newNode.prev = prevNode;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode = new ListNode<>(data);
		ListNode<T> nextNode = head.next;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		newNode.prev = head;
		head.next = newNode;
		size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method */
		if (index >= 0 && index <= size) {
			ListIterator<T> it = new ListIterator<>(head);
			for (int i = 0; i < index; i++) {
				it.moveForward();
			}
			ListNode<T> prevNode = it.curNode;
			ListNode<T> newNode = new ListNode<>(data);
			ListNode<T> nextNode = prevNode.next;

			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			size++;
		}
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */
		ListNode<T> prevNode = it.curNode;
		ListNode<T> newNode = new ListNode<>(data);
		ListNode<T> nextNode = prevNode.next;

		prevNode.next = newNode;
		newNode.prev = prevNode;
		newNode.next = nextNode;
		nextNode.prev = newNode;
		size++;

	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */
		if (tail.prev != head) {
			ListNode<T> removedNode = tail.prev;
			ListNode<T> prevNode = removedNode.prev;
			prevNode.next = tail;
			tail.prev = prevNode;
			size--;
			return removedNode.getData();
		}
		return null;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */
		if (head.next != tail) {
			ListNode<T> removedNode = head.next;
			ListNode<T> nextNode = removedNode.next;
			nextNode.prev = head;
			head.next = nextNode;
			size--;
			return removedNode.getData();
		}
		return null;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */
		if(it.curNode != head || it.curNode != tail) {
			ListNode<T> removedNode = it.curNode;
			ListNode<T> prevNode = removedNode.prev;
			ListNode<T> nextNode = removedNode.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			size--;
			it.curNode = nextNode;
			return removedNode.getData();
		}
		return null;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		/* TODO: Implement this method */
		ListIterator<T> it = new ListIterator<>(head.next);
		int index = 0;
		while (!it.isPastEnd()) {
			if (it.curNode.getData().equals(data)) {
				return index;
			}
			it.moveForward();
			index++;
		}
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */
		if (index >= 0 && index <= size && head.next != tail) {
			ListIterator<T> it = new ListIterator<>(head);
			for (int i = 0; i <= index; i++) {
				it.moveForward();
			}
			return it.curNode.getData();
		}
		return null;
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */
		ListIterator<T> it = new ListIterator<>(head.next);
		return it;
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */
		ListIterator<T> it = new ListIterator<>(tail.prev);
		return it;
	}
	
	
}
