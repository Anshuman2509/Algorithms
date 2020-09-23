package test2;

public class CircularLinkedList {
	int size=0;
	Node head;
	Node tail;
	
	public void addNodeAtStart(int data) {
		Node node=new Node(data);
		if(size==0) {
			head=node;
			tail=node;
			node.next=head;
		}else {
			node.next=head;
			head=node;
			tail.next=head;
		}
		size++;
	}
	
	public void addNodeAtEnd(int data) {
		if(size==0) {
			addNodeAtStart(data);
		}else {
			Node node=new Node(data);
			tail.next=node;
			tail=node;
			tail.next=head;
			size++;
		}
	}
	
	public void deleteFromStart() {
		if(size==0) {
			System.out.println("Linked List is empty");
		}else {
			head=head.next;
			tail.next=head;
			size--;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void print() {
		Node current=head;
		do {
			System.out.print(current.data+" ");
			current=current.next;
		}while(current!=head);
		System.out.println();
	}
	
	public int elementAt(int position) {
		if(position>size)
			return -1;
		else {
		Node current=head;
		int counter=0;
		do {
			current=current.next;
			counter++;			
		}while(current!=head && counter!=position);
		
		if(current==null)
			return -1;
		else
			return current.data;
		}
	}

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList=new CircularLinkedList();
		circularLinkedList.addNodeAtStart(120);
		circularLinkedList.addNodeAtStart(280);
		circularLinkedList.addNodeAtStart(390);
		circularLinkedList.addNodeAtEnd(470);
		circularLinkedList.print();
		System.out.println(circularLinkedList.elementAt(2));
		System.out.println(circularLinkedList.getSize());
		circularLinkedList.deleteFromStart();
		circularLinkedList.print();
		

	}

}
