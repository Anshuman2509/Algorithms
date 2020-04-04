package test11;

public class Queue {
	int capacity;
	int arr[];
	int rear=-1;
	int front=0;
	int count;
	
	public Queue(int capacity) {
		this.capacity=capacity;
		arr=new int[capacity];
	}
	
	public void enqueue(int item) {
		if(count==capacity) {
			System.out.println("Queue Overflow");
			return;
		}
		rear=(rear+1)%capacity;
		arr[rear]=item;
		count++;
	}
	
	public void dequeue() {
		if(count==0) {
			System.out.println("Queue Underflow");
			return;
		}
		System.out.println("Removing "+arr[front]);
		front=(front+1)%capacity;
		count--;
	}
	
	public int peek() {
		if(count==0) {
			System.out.println("Underflow condition");
			return 0;
		}
		return arr[front];
	}
	
	public static void main(String[] args) {
		Queue queue=new Queue(6);
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(90);
		
		System.out.println(queue.peek());
		
		queue.enqueue(100);
		queue.enqueue(90);
		queue.enqueue(450);
		queue.enqueue(15);
		
		queue.dequeue();
		System.out.println(queue.peek());
		queue.enqueue(55);
		queue.enqueue(99);
		

	}

}
