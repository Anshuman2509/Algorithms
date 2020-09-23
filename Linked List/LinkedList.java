package test7;

public class LinkedList {
	Node head;
	int size;
	
	public void insert(int data) {
		Node node=new Node(data);
		node.next=null;
		if(head==null) {
			head=node;
		}else {
			Node current=head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=node;
		}
		size++;
	}
	
	public void disp() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}
	
	public int elementAt(int position) {
		if(position>=size) {
			System.out.print("Position greater than size of the list ");
			return -1;
		}else {
			Node current=head;
			int counter=0;
			while(current!=null && counter!=position) {
				current=current.next;
				counter++;
			}
			if(current!=null) {
				return current.data;
			}
			
			return -1;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtPosition(int position,int data) {
		if(position>size) {
			System.out.println("Position cannot be greater than size");
			return;
		}
		Node node=new Node(data);
		Node current=head,previous=null;
		int counter=0;
		while(current!=null && counter!=position) {
			previous=current;
			current=current.next;
			counter++;
		}
		previous.next=node;
		node.next=current;
	}
	
	public void delete(int position) {
		if(position>size) {
			System.out.println("Position cannot be greater than size");
			return;
		}
		Node current=head,previous=null;
		int counter=0;
		while(current!=null && counter!=position) {
			previous=current;
			current=current.next;
			counter++;
		}
		if(current!=null) {
			previous.next=current.next;
		}
	}
	
	public void reverse() {
		Node current=head,previous=null,next=null;
		while(current!=null) {
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
	}
	
	public static void main(String[] args) {
		 LinkedList linkedList=new LinkedList();
		 linkedList.insert(100);
		 linkedList.insert(200);
		 linkedList.insert(300);
		 linkedList.insert(400);
		 linkedList.disp();
		 System.out.println(linkedList.getSize());
		 System.out.println(linkedList.elementAt(4));
		 linkedList.disp();
		 linkedList.insertAtPosition(2, 650);
		 linkedList.disp();
		 linkedList.delete(2);
		 linkedList.disp();
		 linkedList.reverse();
		 linkedList.disp();

	}

}
