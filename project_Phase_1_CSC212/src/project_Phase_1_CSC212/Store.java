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
	
	
}
