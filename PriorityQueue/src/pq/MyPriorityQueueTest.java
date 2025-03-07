package pq;

import java.util.Random;

public class MyPriorityQueueTest {
    public static void main(String[] args) {
        // Create a priority queue for integers
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();

        System.out.println("Comprehensive Testing of MyPriorityQueue with integers...");

        // Test 1: Adding a small number of elements
        System.out.println("\nTest 1: Adding a small number of elements...");
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(15);
        System.out.println("Queue size after additions: " + pq.size());
        System.out.println("Peek (expected 5): " + pq.peek());

        // Test 2: Removing elements to validate heap property
        System.out.println("\nTest 2: Removing elements...");
        while (pq.size() > 0) {
            System.out.println("Removed: " + pq.remove());
        }
        System.out.println("Queue size after all removals: " + pq.size());

        // Test 3: Adding elements in descending order
        System.out.println("\nTest 3: Adding elements in descending order...");
        for (int i = 20; i > 0; i -= 5) {
            pq.add(i);
            System.out.println("Added: " + i + ", Peek: " + pq.peek());
        }

        // Test 4: Adding elements in ascending order
        System.out.println("\nTest 4: Adding elements in ascending order...");
        pq.clear();
        for (int i = 5; i <= 25; i += 5) {
            pq.add(i);
            System.out.println("Added: " + i + ", Peek: " + pq.peek());
        }

        // Test 5: Stress test with random numbers
        System.out.println("\nTest 5: Stress test with 100 random numbers...");
        pq.clear();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randNum = random.nextInt(1000);
            pq.add(randNum);
        }
        System.out.println("Queue size after adding 100 random elements: " + pq.size());
        System.out.println("Peek (minimum element): " + pq.peek());

        System.out.println("\nRemoving first 10 elements from the priority queue:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Removed: " + pq.remove());
        }
        System.out.println("Queue size after removing 10 elements: " + pq.size());

        // Test 6: Edge case with duplicate values
        System.out.println("\nTest 6: Adding duplicate values...");
        pq.clear();
        pq.add(42);
        pq.add(42);
        pq.add(42);
        pq.add(10);
        System.out.println("Peek (expected 10): " + pq.peek());
        while (pq.size() > 0) {
            System.out.println("Removed: " + pq.remove());
        }

        // Test 7: Edge case with a single element
        System.out.println("\nTest 7: Edge case with a single element...");
        pq.clear();
        pq.add(99);
        System.out.println("Peek (expected 99): " + pq.peek());
        System.out.println("Removed (expected 99): " + pq.remove());
        System.out.println("Queue size (expected 0): " + pq.size());

        // Test 8: Edge case with an empty queue
        System.out.println("\nTest 8: Edge case with an empty queue...");
        System.out.println("Peek (expected null): " + pq.peek());
        System.out.println("Remove (expected null): " + pq.remove());

        // Final Test: Stress test with large dataset
        System.out.println("\nFinal Test: Adding 10,000 random numbers...");
        pq.clear();
        for (int i = 0; i < 10000; i++) {
            pq.add(random.nextInt(1000000));
        }
        System.out.println("Queue size after adding 10,000 elements: " + pq.size());
        System.out.println("Peek (minimum element): " + pq.peek());
        System.out.println("Removing first 20 elements:");
        for (int i = 0; i < 20; i++) {
            System.out.println("Removed: " + pq.remove());
        }
        System.out.println("Queue size after removing 20 elements: " + pq.size());

        System.out.println("\nAll tests completed.");
    }
}
