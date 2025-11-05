package project_Phase_1_CSC212;

public class Store {

	private DoubleLinkedList<Product> products;
	private DoubleLinkedList<Customer> customers;
	private DoubleLinkedList<Order> orders;
	
	
	public DoubleLinkedList<Product> getProducts() {
		return products;
	}


	public DoubleLinkedList<Customer> getCustomers() {
		return customers;
	}


	public DoubleLinkedList<Order> getOrders() {
		return orders;
	}
	
	
	public boolean searchProduct(int productId) {
		
		products.findFirst();
		
		for (int i = 0; i < products.getLength(); ++i) {
			
			if (products.retrive().getProductId() == productId) {
				return true;
			}
			
			products.findNext();
		}
		
		return false;
	}
	
	
	public boolean searchProduct(String name) {
		
		products.findFirst();
		
		for (int i = 0; i < products.getLength(); ++i) {
			
			if (products.retrive().getName().equals(name)) {
				return true;
			}
			
			products.findNext();
		}
		
		return false;
	}
	
	
	public boolean searchCustomer(int customerId) {
		
		customers.findFirst();
		
		for (int i = 0; i < customers.getLength(); ++i) {
			
			if (customers.retrive().getCustomerId() == customerId) {
				return true;
			}
			
			customers.findNext();
		}
		
		return false;
	}
	
	
	public DoubleLinkedList<Product> outOfStockProducts() {
		
		DoubleLinkedList<Product> outOfStock = new DoubleLinkedList<Product>();
		
		products.findFirst();
		
		for (int i = 0; i < products.getLength(); ++i) {
			
			Product product = products.retrive();
			
			if (product.isOutOfStock()) {
				outOfStock.insert(product);
			}
			
			products.findNext();
		}
		
		products.findFirst();
		
		
		return outOfStock;
	}
	
	
	public boolean placeOrder(int orderId, int[] productIds, double totalPrice, Date orderDate, int customerId) {
		
		Order order;
		
		DoubleLinkedList<Product> orderProd = new DoubleLinkedList<Product>();
		
		for (int i = 0; i < productIds.length; ++i) {
			
			if (!searchProduct(productIds[i])) {
				return false;
			}		
			orderProd.insert(products.retrive());
	
		}
		
		if (!searchCustomer(customerId)) {
			return false;
		}
		
		order = new Order(orderId, totalPrice, orderDate, "Pending", customers.retrive(), orderProd);
		
		orders.insertFirst(order);
		
		return true;
	}
	
	
	public void cancelOrder() {
		orders.retrive().setStatus("Cancelled");
	}
	
	
	public boolean searchOrder(int orderId) {
		
		orders.findFirst();
		
		for (int i = 0; i < orders.getLength(); ++i) {
			
			if (orders.retrive().getOrderId() == orderId) {
				return true;
			}
			
			orders.findNext();
		}
		
		return false;
	}
	
	
	public DoubleLinkedList<Review> getCustomerReviews() {
		
		int currentProdId = products.retrive().getProductId();
		Customer customer = customers.retrive();
		DoubleLinkedList<Review> customerReviews = new DoubleLinkedList<Review>();
		
		
		products.findFirst();
		
		for (int i = 0; i < products.getLength(); ++i) {
			
			Product product = products.retrive();
			CustomPriorityQueue<Review> reviewList = product.getReviewList();
			
			reviewList.findFirst();
			
			for (int j = 0; j < reviewList.length(); ++i) {
				
				Customer reviewer = reviewList.retrive().getReviewer();
				
				if (reviewer.equals(customer)) {
					customerReviews.insert(reviewList.retrive());
				}
				
				reviewList.findNext();
			}
			
			products.findNext();
		}
		
		searchProduct(currentProdId);
		
		return customerReviews;
	}
	
	public DoubleLinkedList<Order> getOrderBetweenDates(Date startDate, Date endDate) {
		
		DoubleLinkedList<Order> ordersBetween = new DoubleLinkedList<Order>();
		
		orders.findFirst();
		
		for (int i = 0; i < orders.getLength(); ++i) {
			
			Order order = orders.retrive();
			Date date = order.getOrderDate();
			
			
			if (date.getIntDate() > startDate.getIntDate() && date.getIntDate() < endDate.getIntDate()) {
				ordersBetween.insertFirst(order);
			}
				
			orders.findNext();
		}
		
		return orders;
	}
	
	
	DoubleLinkedList<Product> commonProducts(int customerId1, int customerId2) {
		
		DoubleLinkedList<Product> products1 = new DoubleLinkedList<Product>();
		DoubleLinkedList<Product> products2 = new DoubleLinkedList<Product>();
		DoubleLinkedList<Product> commonProducts = new DoubleLinkedList<Product>();
		
		DoubleLinkedList<Order> orderList;
		
		
		// get all products related to customer 1
		if (!searchCustomer(customerId1)) {
			return null;
		}
		
		orderList = customers.retrive().getOrderList();
		
		orderList.findFirst();
		for (int i = 0; i < orderList.getLength(); ++i) {
			
			DoubleLinkedList<Product> products = orderList.retrive().getProductList();
			
			products.findFirst();
			
			for (int j = 0; j < products.getLength(); ++j) {
				
				products1.insertFirst(products.retrive());
				products.findNext();
			}
			
			orderList.findNext();
		}
		
		// get all products related to customer 2
		if (!searchCustomer(customerId2)) {
			return null;
		}
		
		orderList = customers.retrive().getOrderList();
		
		orderList.findFirst();
		for (int i = 0; i < orderList.getLength(); ++i) {
			
			DoubleLinkedList<Product> products = orderList.retrive().getProductList();
			
			products.findFirst();
			
			for (int j = 0; j < products.getLength(); ++j) {
				
				products1.insertFirst(products.retrive());
				products.findNext();
			}
			
			orderList.findNext();
		}
		
		// finding common products with an average rating greater than 4
		
		// no need to do find first for product1
		
		for (int i = 0; i < products1.getLength(); ++i) {
			
			products2.findFirst();
			
			for (int j = 0; j < products2.getLength(); ++j) {
				
				Product prod1 = products1.retrive();
				Product prod2 = products2.retrive();
				
				if (prod1.equals(prod2) && prod1.getAverageRating() > 4) {
					commonProducts.insert(prod1);
				}
				
			}
			
			
		}
		
		
		return commonProducts;
	}
	
	
	public DoubleLinkedList<Product> getTop3Products() {
		
		DoubleLinkedList<Product> top3 = new DoubleLinkedList<Product>();
		
		CustomPriorityQueue<Product> temp = new CustomPriorityQueue<Product>();
		
		
		products.findFirst();
		
		for (int i = 0; i < products.getLength(); ++i) {
			
			Product product = products.retrive();
			
			int ratting = (int) Math.ceil(product.getAverageRating());
			
			temp.enqueue(product, ratting);
		
			products.findNext();
		}
		
		// this is done to avoid issues when products has less than 3 elements
		for (int i = 0; i < products.getLength(); ++i) {
			
			if (i >= 3) {
				break;
			}
			
			PQElement<Product> topProduct = temp.serve();
			
			top3.insert(topProduct.getData());
			
		}
		
		
		return top3;
	}
	
}
