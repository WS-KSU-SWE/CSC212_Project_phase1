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
	
}
