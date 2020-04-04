package test1;

public class Tree {
	Node root;
	
	public void add(int data) {
		this.root=addNode(this.root,data);
	}
	public Node addNode(Node current,int value) {
		if(current==null)
			return new Node(value);
		else if(value>current.data)
			current.right=addNode(current.right, value);
		else if(value<current.data)
			current.left=addNode(current.left, value);
		
		return current;
	}
	
	public void disp(Node current) {
		if(current!=null) {
			disp(current.left);
			System.out.print(current.data+" ");
			disp(current.right);
		}
	}
	
	public int minNodeVal(Node current) {
		return current.left==null?current.data:minNodeVal(current.left);
	}
	
	public void delete(int key) {
		this.deleteNode(this.root, key);
	}
	public Node deleteNode(Node current,int key) {
		if(current==null)
			return null;
		if(current.data==key) {
			if(current.left==null && current.right==null) {
				System.out.println(current.data+" when currentleft and currentright is null");
				return null;
			}
			if(current.left==null)
				return current.right;
			if(current.right==null)
				return current.left;
			else {
				int minVal=minNodeVal(current.right);
				current.data=minVal;
				current.right=deleteNode(current.right, minVal);
			}
		}
		
		if(key<current.data)
			current.left=deleteNode(current.left, key);
		if(key>current.data)
			current.right=deleteNode(current.right, key);
		
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
		Tree tree=new Tree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        
        tree.disp(tree.root);
        System.out.println();
        
        System.out.println(tree.contains(8));
        System.out.println(tree.contains(15));
        tree.delete(6);
        System.out.println();
        tree.disp(tree.root);

	}

}
