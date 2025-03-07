package tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeTest {

    public static void main(String[] args) {
        // Create a new AVL tree
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Test insertion (should trigger balancing)
        System.out.println("Inserting 10:");
        avlTree.insert(10);
        printTree(avlTree.root);

        System.out.println("\nInserting 20:");
        avlTree.insert(20);
        printTree(avlTree.root);

        System.out.println("\nInserting 30 (this should trigger a left rotation):");
        avlTree.insert(30);
        printTree(avlTree.root);

        System.out.println("\nInserting 25 (this should trigger a left-right rotation):");
        avlTree.insert(25);
        printTree(avlTree.root);

        System.out.println("\nInserting 5:");
        avlTree.insert(5);
        printTree(avlTree.root);

        // Test removal (should also trigger balancing)
        System.out.println("\nRemoving 10 (should trigger balancing):");
        avlTree.remove(10);
        printTree(avlTree.root);

        System.out.println("\nRemoving 20:");
        avlTree.remove(20);
        printTree(avlTree.root);

        System.out.println("\nRemoving 30 (this should trigger a right rotation):");
        avlTree.remove(30);
        printTree(avlTree.root);
    }

    // Helper method to print the tree level by level (BFS traversal)
    public static void printTree(TreeNode<Integer> root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }
}