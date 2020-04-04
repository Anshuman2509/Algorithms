package test11;

public class Stack {
	int MAX=4;
	int[] stack=new int[MAX];
	int top=-1;
	
	public void push(int z) {
		if(top>=MAX-1) {
			System.out.println("Stack Overflow");
		}else {
			stack[++top]=z;
			System.out.println("Item added");
		}
	}
	
	public int pop() {
		if(top<0) {
			System.out.println("Stack Underflow");
			return -1;
		}else {
			int t=stack[top--];
			return t;
		}
	}
	
	public int peek() {
		if(top<0) {
			System.out.println("Stack UnderFlow");
			return -1;
		}else {
			return stack[top];
		}
	}
	
	public boolean isEmpty() {
		return top<0;
	}

	public static void main(String[] args) {
		Stack stack=new Stack();
		
		System.out.println(stack.peek());
		stack.push(20);
		stack.push(50);
		stack.push(30);
		stack.push(40);
		
		System.out.println(stack.peek());
		stack.push(20);
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
