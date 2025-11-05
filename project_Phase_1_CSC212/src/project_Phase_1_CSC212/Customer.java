package project_Phase_1_CSC212;

public class Customer {
	private int customerId;
	private String name;
	private String email;

	DoubleLinkedList<Order> orderList = new DoubleLinkedList<Order>();

	public Customer(String name, String email, int customerID) {

		this.customerId = customerId;
		this.email = email;
		this.name = name;

	}

	public void addToOrderList(Order order) {
		this.orderList.insert(order);
	}

	public void viewOrderHistory() {
		if (orderList.empty()) {
			System.out.println("There is no orders ");
			return;
		}

		orderList.findFirst();
		Order currentorder = orderList.retrive();
		while (orderList.last() == false) {

			System.out.println("ID: " + currentorder.getOrderId() + " status: " + currentorder.getStatus()
					+ " total price: " + currentorder.getTotalPrice());
			orderList.findNext();
			currentorder = orderList.retrive();
		}
		System.out.println("ID: " + currentorder.getOrderId() + " status: " + currentorder.getStatus()
				+ " total price: " + currentorder.getTotalPrice());

	}

	public void makeReview(int rating, String comment, Product product) {
		product.addReview(rating, comment, this);
	}

	public boolean editreview(int rating, String comment, Product product) {
		Node current = product.getReviews().getHead();
		while (current != null) {

			Review newReview = current.getData();
			if (newReview.getReviewer() == this) {
				newReview.setRating(rating);
				newReview.setComment(comment);
				System.out.println("The review is updated successfuly");
				return true;
			}
			current = current.next;

		}
		System.out.println("The review is not found");
		return false;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DoubleLinkedList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(DoubleLinkedList<Order> orderList) {
		this.orderList = orderList;
	}

}
