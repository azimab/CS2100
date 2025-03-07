//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 7 - LinkedList Queue
//N/A
package list;

public class ListIterator<T> { 
	protected ListNode<T> curNode;  /* Current node (of type ListNode) */
	
        /* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		this.curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy tail node? */
		return (curNode.next == null);
	}
	
	public boolean isPastBeginning() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		return (curNode.prev == null);
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
		if (!isPastEnd() && !isPastBeginning()) {
			return curNode.getData();
		}
		return null;
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move forward before you do! */
                /*       (Otherwise, do not move at all) */
		if (!isPastEnd()) {
			curNode = curNode.next;
		}
	}
	
	public void moveBackward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
		if (!isPastBeginning()) {
			curNode = curNode.prev;
		}
	}
}


