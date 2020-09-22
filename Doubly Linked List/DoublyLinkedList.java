package test1;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	public void insertFirst(int data) {
		Node node=new Node(data);
		node.next=head;
		node.previous=null;
		if(head!=null)
			head.previous=node;
		head=node;
		if(tail==null)
			tail=node;
		size++;		
	}
	
	public void insertLast(int data) {
		Node node=new Node(data);
		node.previous=tail;
		node.next=null;
		if(tail!=null)
			tail.next=node;
		tail=node;
		if(head==null)
			head=node;
		size++;
	}
	
	public Node deleteFirst() {
		if(size==0)
			throw new RuntimeException("Doubly Linked List is already empty");
		Node current=head;
		head=head.next;
		head.previous=null;
		size--;
		return current;
	}
	
	public Node deleteLast() {
		if(size==0)
			throw new RuntimeException("Doubly Linkded List is already empty");
		Node current=tail;
		tail=tail.previous;
		tail.next=null;
		size--;
		return current;
	}
	
	public void printLinkedListForward() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public void printLinkedListBackward() {
		Node current=tail;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.previous;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		 DoublyLinkedList doublyLinkedList=new DoublyLinkedList();
		 doublyLinkedList.insertFirst(100);
		 doublyLinkedList.insertFirst(200);
		 doublyLinkedList.insertFirst(300);
		 doublyLinkedList.insertFirst(400);
		 
		 doublyLinkedList.printLinkedListForward();
		 doublyLinkedList.printLinkedListBackward();
		 
		 doublyLinkedList.insertLast(500);
		 doublyLinkedList.insertLast(600);
		 
		 doublyLinkedList.printLinkedListForward();
		 
		 doublyLinkedList.insertFirst(5000);
		 doublyLinkedList.printLinkedListForward();
		 doublyLinkedList.deleteFirst();
		 doublyLinkedList.printLinkedListForward();
		 
		 doublyLinkedList.insertLast(9000);
		 doublyLinkedList.printLinkedListBackward();
		 doublyLinkedList.deleteLast();
		 doublyLinkedList.printLinkedListBackward();

	}

}
