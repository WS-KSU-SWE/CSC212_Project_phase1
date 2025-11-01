package project_Phase_1_CSC212;

public class Order {

	private int orderId;
    private double totalPrice;
    private Date orderDate;
    private String status;
    private Customer customerReference;
    private DoubleLinkedList<Product> productList;

    public Order(int orderId, double totalPrice, Date orderDate, String status, Customer customerReference) {
    	
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        this.customerReference = customerReference;
        this.productList = new DoubleLinkedList<Product>();
    
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(Customer customerReference) {
        this.customerReference = customerReference;
    }

    public DoubleLinkedList<Product> getProductList() {
        return productList;
    }

    public void setProductList(DoubleLinkedList<Product> productList) {
        this.productList = productList;
    }

	
}
