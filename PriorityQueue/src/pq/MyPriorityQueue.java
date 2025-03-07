//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 12 - Priority Queue
//Resources: none
package pq;

import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> {//a queue where the lowest value element will be removed first, and the highest value elements will be added to the end of the queue.
    private ArrayList<T> heap;
    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }
    //adds the element into the priority queue, then moves the element into the correct position by following the rules of the heap
    public void add(T t) {
        heap.add(t);
        int index = heap.size() - 1;
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parent)) < 0) { //while the index hasn't reached the parent, keep swapping upwards until in correct position.
            swap(index, parent); //swap upwards
            index = parent;
            parent = (index - 1) / 2; //set new parent
        }
    }
    //empties the queue, uses the arraylist clear method.
    public void clear() {
        heap.clear();
    }
    //returns if the element is in the queue, uses the arraylist contains method
    public boolean contains(Object o) {
        return heap.contains((T)o); //casts object to a generic before checking for the element
    }
    //returns the least value element in the queue
    public T peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }
    //removes the lowest element in the queue by swapping the last and first elements in the heap then moving the last element down the heap.
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }
        T root = heap.get(0); //saving highest priority element in the queue
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            int index = 0;
            boolean correctPos = false;
            while (!correctPos) {
                int parent = index;
                int left = index * 2 + 1;
                int right = index * 2 + 2;
                if (left < heap.size() && heap.get(left).compareTo(heap.get(parent)) < 0) {//check to make sure there is a left child and if the left child is less than the parent.
                    parent = left;
                }
                if (right < heap.size() && heap.get(right).compareTo(heap.get(parent)) < 0) {//check to make sure there is a right child and if the right child is less than the parent.
                    parent = right;
                }

                if (index == parent) {//if the parent hasn't changed positions, the process of trickling down is completed.
                    correctPos = true;
                }
                swap(index, parent);//move the element down, then set the index to the new index.
                index = parent;
            }
        }
        return root;
    }
    //return the number of elements in the queue.
    public int size() {
        return heap.size();
    }
    //helper method for swapping two elements of index a and b in the heap
    private void swap (int a, int b) {
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

}