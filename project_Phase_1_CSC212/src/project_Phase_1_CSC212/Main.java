package project_Phase_1_CSC212;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Store store = new Store();

		store.readCSV();

		int choise = 0;
		
		System.out.println("Welcome to the store");
		
		//store.getOrderBetweenDates(new Date(2, 3, 2025), new Date(2, 12, 2025)).printList();
		
		while (choise != 14) {
			
			System.out.println("1-Add product:         2-Add customer:       3-place an order");
			System.out.println();
			System.out.println("4-search for product : 5-view orders between two dates:  6-show two common high rating products:");
			System.out.println();
			System.out.println("7-view top 3 products:  8-search for customer: 9-search for order:");
			System.out.println();
			System.out.println("10-view all customers:  11-view all orders:  12-view all products:");
			System.out.println();
			System.out.println("13- view all reviews of currently selected customer:   14-exit:");
			System.out.print("Enter your choice: ");
			choise = in.nextInt();

			switch (choise) {
			case 1:
				System.out.print("Enter the product ID,name,price and stock: ");
				int id = in.nextInt();
				String name = in.next();
				double price = in.nextDouble();
				int stock = in.nextInt();
				store.addProduct(id, name, price, stock);
				break;
			case 2:
				System.out.print("Enetr the customer ID,name and email ");
				int customerID = in.nextInt();
				String customerName = in.next();
				String email = in.next();
				store.registerCustomer(customerID, customerName, email);
				break;
			case 3:
				
				System.out.print("Enter order ID: ");
				
				int oId = in.nextInt();
				
				System.out.print("Enter customer ID: ");
				
				int cId = in.nextInt();
				
				System.out.print("Enter the number of products: ");
				
				int prodCount = in.nextInt();
				
				int[] prodIds = new int[prodCount];
				
				int totalPrice = 0;
				
				int currentProd = store.getProducts().retrive().getProductId();
				
				for (int i = 0; i < prodCount; ++i) {
					
					System.out.print("Enter product id " + i + ": ");
					
					prodIds[i] = in.nextInt();
					
					store.searchProduct(prodIds[i]);
					
					totalPrice += store.getProducts().retrive().getPrice();
					
				}
				
				System.out.print("Enter the day , month and year of start date (seperate by space): ");
				Date ordDate = new Date(in.nextInt(), in.nextInt(), in.nextInt());
			
				store.placeOrder(oId, prodIds, totalPrice, ordDate, cId, "Pending");
				
				
				break;
			case 4:
				System.out.print("Do you want to search for the product by 1: Id  or 2: name?");

				int ch = in.nextInt();
				if (ch == 2) {
					System.out.print("Enter the name of the product:");
					String n = in.next();
					boolean found = store.searchProduct(n);
					
					if (!found) {
						System.out.println("Could not find product!");
						break;
					}
					System.out.println("The product was found and is currently selected for operatons.");
					System.out.println("choose operation");

					System.out.println(" 1-Update prodect: \n 2-Remove product: \n 3-Add review \n 4-Exit");
					int ch2 = in.nextInt();
					switch (ch2) {
					case 1:
						System.out.println("Enter the product name,price and stock ");
						String Updatename = in.next();
						double Updateprice = in.nextDouble();
						int UpdateStock = in.nextInt();
						store.updateProduct(Updatename, Updateprice, UpdateStock);
						break;
					case 2:
						store.removeProduct();
						break;
					case 3:
						System.out.print("Enter the rating: ");
						int rating = in.nextInt();
						
						in.nextLine();
						
						System.out.print("Enter text comment: ");
						
						String comment = in.nextLine();
						
						Product prod = store.getProducts().retrive();
						
						store.getCustomers().retrive().makeReview(rating, comment, prod);
						
						break;

					}
				}
				if (ch == 1) {
					System.out.print("Enter the ID of the product:");
					int Pid = in.nextInt();
					boolean found = store.searchProduct(Pid);
					
					if (!found) {
						System.out.println("Could not find product!");
						break;
					}
					
					System.out.println("choose operation");

					System.out.println(" 1-Update prodect: \n 2-Remove product: \n 3-Add review: \n 4-Exit");
					int ch3 = in.nextInt();
					switch (ch3) {
					case 1:
						System.out.println("Enter the product name,price and stock ");
						String Updatename = in.next();
						double Updateprice = in.nextDouble();
						int UpdateStock = in.nextInt();
						store.updateProduct(Updatename, Updateprice, UpdateStock);
						break;
					case 2:
						store.removeProduct();
						break;
					case 3:
						System.out.print("Enter the rating: ");
						int rating = in.nextInt();
						
						in.nextLine();
						
						System.out.print("Enter text comment: ");
						
						String comment = in.nextLine();
						
						Product prod = store.getProducts().retrive();
						
						store.getCustomers().retrive().makeReview(rating, comment, prod);
						
						break;
						
					}
					
					
				}
				break;
			case 5:
				System.out.print("Enter the day , month and year of start date (seperate by space): ");
				Date start = new Date(in.nextInt(), in.nextInt(), in.nextInt());
				System.out.print("Enter the day , month and year of end date (seperate by space): ");
				Date end = new Date(in.nextInt(), in.nextInt(), in.nextInt());
				store.getOrderBetweenDates(start, end).printList();
				break;
			case 6:
				System.out.print("Enter the first and the second customer ID: ");
				int fid=in.nextInt();
				int sid=in.nextInt();
				
				DoubleLinkedList<Product> common = store.commonProducts(fid, sid);
				
				if (common.empty()) {
					System.out.println("No common products");
				}
				else {
					common.printList();
				}
				
				
				break;
			case 7:
				System.out.println("The top 3 products are:");
				store.getTop3Products().printList();;
				break;
			case 8:
				System.out.print("Enter the customer id:");
				if (store.searchCustomer(in.nextInt())) {
					
					System.out.println("The customer was found and is selected for future operations.");
				}
				else {
					System.out.println("The customer with the provided id does not exist.");
				}
				break;
			case 9:
				System.out.println("Enter the order ID: ");
				
				if (store.searchOrder(in.nextInt())) {
					
					System.out.println("The order was found and is selected for future operations.");
				}
				else {
					System.out.println("The order with the provided id does not exist.");
				}
					
				break;
			case 10:
				store.printCustomers();
				break;
			case 11:
				store.printOrders();
				break;
			case 12:
				store.printProducts();
			break;
			case 13:
				store.getCustomerReviews().printList();
			break;
			
			}

		}
	}

}
