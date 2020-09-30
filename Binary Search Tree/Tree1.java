package test;

import java.util.LinkedList;
import java.util.Queue;

public class Tree1 {
	Node root;

	public void add(int data) {
		this.root = addNode(this.root, data);
	}

	public Node addNode(Node current, int data) {
		if (current == null) {
			return new Node(data);
		} else if (data > current.data) {
			current.right = addNode(current.right, data);
		} else if (data < current.data) {
			current.left = addNode(current.left, data);
		}
		return current;
	}

	/*
	 * Depth-first search is a type of traversal that goes deep as much as possible
	 * in every child before exploring the next sibling.There are several ways to
	 * perform a depth-first search: in-order, pre-order and post-order
	 */
	/*
	 * The in-order traversal consists of first visiting the left sub-tree, then the
	 * root node, and finally the right sub-tree
	 */
	public void inOrder(Node current) {
		if (current != null) {
			inOrder(current.left);
			System.out.print(current.data + " ");
			inOrder(current.right);
		}
	}

	/*
	 * Pre-order traversal visits first the root node, then the left subtree, and
	 * finally the right subtree:
	 */
	public void preOrder(Node current) {
		if (current != null) {
			System.out.print(current.data + " ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}

	/*
	 * Post-order traversal visits the left subtree, the right subtree, and the root
	 * node at the end:
	 */
	public void postOrder(Node current) {
		if (current != null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.data + " ");
		}
	}

	/*
	 * Breadth-First Search This is another common type of traversal that visits all
	 * the nodes of a level before going to the next level.This kind of traversal is
	 * also called level-order and visits all the levels of the tree starting from
	 * the root, and from left to right.For the implementation, we'll use a Queue to
	 * hold the nodes from each level in order. We'll extract each node from the
	 * list, print its values, then add its children to the queue:
	 */
	public void traverseLevelOrder() {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	/* Height of a tree */
	public int maxDepth(Node current) {
		if (current == null) {
			return 0;
		} else {
			int lDepth = maxDepth(current.left);
			int rDepth = maxDepth(current.right);
			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}

	public void printLeafNodes(Node current) {
		if (current != null) {
			printLeafNodes(current.left);
			if (current.left == null && current.right == null)
				System.out.print(current.data + " ");
			printLeafNodes(current.right);
		}
	}

	public int minNodeValue(Node current) {
		return current.left == null ? current.data : minNodeValue(current.left);
	}

	public void delete(int key) {
		this.root = deleteNode(this.root, key);
	}

	public Node deleteNode(Node current, int key) {
		if (current == null) {
			return null;
		}
		if (current.data == key) {
			if (current.left == null && current.right == null) {
				return null;
			} else if (current.left == null) {
				return current.right;
			} else if (current.right == null) {
				return current.left;
			} else {
				int min = minNodeValue(current.right);
				current.data = min;
				current.right = deleteNode(current.right, min);
			}
		}
		if (key > current.data) {
			current.right = deleteNode(current.right, key);
		}
		if (key < current.data) {
			current.left = deleteNode(current.left, key);
		}
		return current;
	}
	
	public boolean contains(int key) {
		return containsNode(this.root, key);
	}
	public boolean containsNode(Node current,int key) {
		if(current==null)
			return false;
		if(current.data==key)
			return true;
		else
			return key>current.data?containsNode(current.right, key):containsNode(current.left, key);
	}

	public static void main(String[] args) {
		Tree1 tree = new Tree1();
		tree.add(6);
		tree.add(4);
		tree.add(8);
		tree.add(3);
		tree.add(5);
		tree.add(7);
		tree.add(9);
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.traverseLevelOrder();
		System.out.println();
		
		tree.printLeafNodes(tree.root);

		System.out.println();
		System.out.println(tree.maxDepth(tree.root));
		
		tree.delete(6);
		tree.inOrder(tree.root);
	}

}
