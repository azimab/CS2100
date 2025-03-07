//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//HW 10 - AVL Trees
//Resources : none
package tree;

/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{

	@Override
	public void insert(T data) {
		this.root = insert(data, this.root);
	}
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//TODO: Implement this method
		curNode = super.insert(data, curNode);

		curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;

		curNode = balance(curNode);

		return curNode;
	}


	@Override
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);

		/* Handle the case when remove returns null */
		if(curNode == null) return null;

		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;

		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);

		return curNode;
	}


	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param node
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//TODO: Implement this method
		if (balanceFactor(curNode) > 1) {
            if (balanceFactor(curNode.left) < 0) {
                curNode.left = rotateLeft(curNode.left);
            }
            return rotateRight(curNode);
        }
		if (balanceFactor(curNode) < -1) {
            if (balanceFactor(curNode.right) > 0) {
                curNode.right = rotateRight(curNode.right);
            }
            return rotateLeft(curNode);
        }
		return curNode;
	}

	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		//TODO: Implement this method
		TreeNode<T> root = curNode.left;
		curNode.left = root.right;
		root.right = curNode;
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		root.height = Math.max(height(root.left), height(root.right))+1;
		return root;
	}

	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		//TODO: Implement this method
		TreeNode<T> root = curNode.right;
		curNode.right = root.left;
		root.left = curNode;
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		root.height = Math.max(height(root.left), height(root.right))+1;
		return root;
	}

	private int balanceFactor(TreeNode<T> node) {
		if (node == null) return 0;
		return height(node.left) - height(node.right);
	}


}
