package project_Phase_1_CSC212;

public class Product {

	private DoubleLinkedList<Review> reviewList;
	
	private int prdouctId;
	private String name;
	private double price;
	private int stock;
	
	
	public Product(int productId, String name, double price, int stock) {
		
		this.prdouctId = productId;
		this.name = name;
		setPrice(price);
		setStock(stock);
		
	}
	
	
	public boolean isOutOfStock() {
		return stock == 0;
	}
	
	// adds a review to the head of the review list
	public boolean addReview(int rating, String comment, Customer reviewer) {
		
		Review review = new Review(rating, comment, reviewer);
		
		reviewList.insertFirst(review);
		
		return true;
	}
	
	// edits the review that is being pointed at by current
	public boolean editReview(int rating, String comment, Customer reviewer) {
		
		if (reviewList.empty()) {
			return false;
		}
		
		Review review  = reviewList.retrive();
		
		review.setRating(rating);
		review.setComment(comment);
		review.setReviewer(reviewer);
		
		return true;
	}
	
	
	public double getAverageRating() {
		
		int count = reviewList.getLength();
		double sum = 0;
		double avg;
		
		
		if (count == 0) {
			return 0;
		}
		
		reviewList.findFirst();
		
		for (int i = 0; i < count; ++i) {
			
			sum += reviewList.retrive().getRating();
			reviewList.findNext();
		
		}
		
		avg = sum / count;
		
		return avg;
	}
	
	
	public int getProductId() {
		return prdouctId;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	
	public int getStock() {
		return stock;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setPrice(double price) {
		
		if (price < 0) {
			throw new NegativeValueException("Price cannot be negative!");
		}
		
		this.price = price;
	}
	
	
	public void setStock(int stock) {
		
		if (stock < 0) {
			throw new NegativeValueException("Stock cannot be negative!");
		}
		
		this.stock = stock;
	}
	
}
