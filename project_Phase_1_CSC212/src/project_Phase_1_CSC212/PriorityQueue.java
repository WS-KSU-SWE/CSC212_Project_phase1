package project_Phase_1_CSC212;

public class PriorityQueue <T> {

	private PQNode<T> head;
	
	private int length;
	
	public PriorityQueue() {
		
	}
	
	
	public PQElement<T> enquiry() {
		
		PQElement<T> elem = new PQElement<T>(head.data, head.priority);
		
		return elem;
	}
	
	
	public boolean full() {
		return false;
	}
	
	
	public int length() {
		return length;
	}
	
	
	public void enqueue(T data, int priority) {
		
		PQNode<T> newNode = new PQNode<T>(data, priority);
		PQNode<T> current = head;
		PQNode<T> previous = null;
		
		if (head == null || head.priority < priority) {
			newNode.next = head;
			head = newNode;
			
			length++;
			
			return;
		}
		
		// search for the correct location based on priority
		while ((current != null) && (current.priority >= priority)) {
			
			previous = current;
			current = current.next;
			
		}
		
		newNode.next = current;
		previous.next = newNode;
		
		length++;
	}
	
	
	public PQElement<T> serve() {
		
		PQElement<T> data = new PQElement<T>(head.data, head.priority);
		
		head = head.next;
		length--;
		
		return data;
	}
	
}
