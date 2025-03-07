//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 9 - Binary Search Tree
//Resources: none
package tree;


public class BinaryTree<T> {

    protected TreeNode<T> root = null;

    /* Tree Traversal methods */

    //HINT for three traversal methods: you can call toString() on the node's
    //     data when you are executing the "root" command on a given node
    //     (e.g. curNode.data.toString() + " ";) // Note the space added at the end

    public String getInOrder() {
        return getInOrder(root); // call getInOrder starting at the root!
    }
    private String getInOrder(TreeNode<T> curNode) {
        //TODO: return the in order traversal of this tree, space separated
        if (curNode == null) {
            return "";
        }
        return getInOrder(curNode.left) + curNode.data.toString() + " " + getInOrder(curNode.right);
    }


    public String getPreOrder() {
        return getPreOrder(root); // call getPreOrder starting at the root!
    }
    private String getPreOrder(TreeNode<T> curNode) {
        //TODO: return the pre order traversal of this tree, space separated
        if (curNode == null) {
            return "";
        }
        return curNode.data.toString() + " " + getPreOrder(curNode.left) + getPreOrder(curNode.right);
    }


    public String getPostOrder() {
        return getPostOrder(root);  // call getPostOrder starting at the root!
    }
    private String getPostOrder(TreeNode<T> curNode) {
        //TODO: return the post order traversal of this tree, space separated
        if (curNode == null) {
            return "";
        }
        return getPostOrder(curNode.left) + getPostOrder(curNode.right) + curNode.data.toString() + " ";
    }


    //------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE
    //------------------------------------------------------------------------

    /* A somewhat more pretty print method for debugging */
    public void printTree() {
        printTree(this.root, 0);
        System.out.println("\n\n");
    }
    private void printTree(TreeNode<T> curNode, int indentLev) {
        if(curNode == null) return;
        for(int i=0; i<indentLev; i++) {
            if(i == indentLev - 1) System.out.print("|-----");
            else System.out.print("      ");
        }
        System.out.println(curNode.data);
        printTree(curNode.left, indentLev+1);
        printTree(curNode.right, indentLev+1);
    }

    //TODO: Look at these methods and think about how they might be useful for this assignment
    public int height() {
        return height(root);
    }

    /* Computes the height of the tree on the fly */
    protected int height(TreeNode<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
