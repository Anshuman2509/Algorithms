package test7;

public class LinkedList {
	Node head;
	
	public void insert(LinkedList l,int data) {
		Node newNode=new Node(data);
		newNode.next=null;
		if(l.head==null) {
			l.head=newNode;
		}else {
			Node current=l.head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=newNode;
		}
	}
	
	public void disp(LinkedList l) {
		Node current=l.head;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public void delete(LinkedList l,int key) {
		Node current=l.head,prev=null;
		if(current.data==key) {
			l.head=current.next;
		}else {
			while(current!=null && current.data!=key) {
				prev=current;
				current=current.next;
			}
			if(current!=null) {
				prev.next=current.next;
			}
			else{
				System.out.println("Node not found");
			}
			
		}
	}
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.insert(l, 500);
		l.insert(l, 300);
		l.insert(l, 200);
		
		l.disp(l);
		l.delete(l, 300);
		l.disp(l);
		l.delete(l, 900);
		

	}

}
