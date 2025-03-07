//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 11 - HashTable
//Resources: none
package hash;

import java.util.ArrayList;

/**
 * Hash Table implementation.
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements SimpleMap<K,V>{

    private static final int INITIAL_CAP = 5;  // a default initial capacity (set low for initial debugging)
    private int currentCapacity = INITIAL_CAP;
    private int size;
    private ArrayList<HashNode<K,V>> table;
    /*
     * Here are some hints about how to declare your hash table.
     * If you're using an ArrayList, it might look like this:
     * 		private ArrayList<HashNode<K, V>> table;
     * Note that you cannot declare an array of generics (i.e., an array of HashNodes) like this:
     *          private LinkedList<HashNode<K,V>>[] table;
     * but see here https://programming.guide/java/generic-array-creation.html for workarounds.
     */

    /* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */


    public HashTable() {  // default constructor sets capacity to default value
        this.table = new ArrayList<>(INITIAL_CAP);
        for (int i = 0; i < INITIAL_CAP; i++) {
            table.add(null);
        }
        this.size = 0;
    }

    public HashTable(int capacity) {  // constructor sets capacity to given value
        /* TODO: IMPLEMENT THIS METHOD */

        /*
         * Here are some hints about how to allocate memory for your hash table.
         * If you're using an array, it might look like this:
         * 		this.table = (HashNode<K,V>[]) new HashNode<?,?>[initialCapacity];
         * If you're using an ArrayList, it might look like this:
         * 		this.table = new ArrayList<>(capacity); // sets list's initial capacity
         */
        this.table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
        this.currentCapacity = capacity;
        this.size = 0;
    }

    public int getSize() { return size; }

    // insert() adds a new key/value pair if the key is not found, otherwise it replaces
    //    the existing key's value
    @Override
    public void insert(K key, V value) {
        /* TODO: IMPLEMENT THIS METHOD */
        int index = Math.abs(key.hashCode()) % currentCapacity;
        HashNode<K,V> curNode = table.get(index);
        HashNode<K,V> newNode = new HashNode<>(key, value);
        while (curNode != null) {
            if (curNode.equals(newNode)) {
                curNode.setValue(value);
                return;
            }
            curNode = curNode.next;
        }
        curNode = table.get(index);
        newNode.next = curNode;
        table.set(index, newNode);
        size++;
        if ((double) size / currentCapacity > 0.75) {
            ArrayList<HashNode<K, V>> oldTable = this.table;
            this.currentCapacity *= 2;
            this.table = new ArrayList<>(currentCapacity);
            for (int i = 0; i < currentCapacity; i++) {
                this.table.add(null);
            }
            this.size = 0;

            for (HashNode<K, V> node : oldTable) {
                while (node != null) {
                    insert(node.getKey(), node.getValue());
                    node = node.next;
                }
            }
        }
    }

    @Override
    public V retrieve(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        int index = Math.abs(key.hashCode()) % currentCapacity;
        HashNode<K,V> curNode = table.get(index);
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                return curNode.getValue();
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        int index = Math.abs(key.hashCode()) % currentCapacity;
        HashNode<K,V> curNode = table.get(index);
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    @Override
    public void remove(K key) {
        /* TODO: IMPLEMENT THIS METHOD */
        int index = Math.abs(key.hashCode()) % currentCapacity;
        HashNode<K,V> curNode = table.get(index);
        HashNode<K,V> prevNode = null;
        while (curNode != null) {
            if (curNode.getKey().equals(key)) {
                size--;
                if (prevNode == null) {
                    table.set(index, curNode.next);
                }
                else {
                    prevNode.next = curNode.next;
                }
                break;
            }
                prevNode = curNode;
                curNode = curNode.next;
            }
        }



    /*
     * OPTIONAL HELPER METHODS: The next two methods will let you print out your
     * entire hash table, or let you make sure all keys that hash to a single
     * bucket's index get stored as they should in your table. You'll need to
     * implement the second method; it depends on how you store entries and
     * handle collisions. This is NOT required, but you may find it helpful when
     * debugging and testing your code.
     */

    public void printHashTable() {
        for (int idx=0; idx < this.currentCapacity; ++idx) {
            System.out.print(idx + ": ");
            printEntriesByIndex(idx);
        }
    }

    private void printEntriesByIndex(int idx) {
        /*
         * To implement this method to help print out one bucket of your hash table, you need to determine:
         * a) If there are no key/value pairs in the bucket idx, print "no entries"
         * b) If there are key/value pairs at that bucket, use a loop to print each one.
         *    Best to use System.out.print() and not println() so they're all on one line.
         * c) At the end of that loop, do System.out.println() to print a new line.
         */
        System.out.println("Not yet implemented...");
    }

}

