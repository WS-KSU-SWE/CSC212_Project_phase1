package project_Phase_1_CSC212;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Store store = new Store();

		store.readCSV();

		int choise = 0;
		while (choise != 8) {
			System.out.println("Welcome to the store");
			System.out.println("1-Add product:         2-Add customer:       3-place an order");
			System.out.println();
			System.out.println("4-search for product : 5-view orders between two dates:  6-show two common products:");
			System.out.println();
			System.out.println("7-view top 3 products:  8-exit");
			System.out.println("Enter your choise: ");
			choise = in.nextInt();

			switch (choise) {
			case 1:
				System.out.println("Enter the product ID,name,price and stock: ");
				int id = in.nextInt();
				String name = in.next();
				double price = in.nextDouble();
				int stock = in.nextInt();
				store.addProduct(id, name, price, stock);
				break;
			case 2:
				System.out.println("Enetr the customer ID,name and email ");
				int customerID = in.nextInt();
				String customerName = in.next();
				String email = in.next();
				store.registerCustomer(customerID, customerName, email);
				break;
			case 3:
				System.out.println("Enetr odrer ID , customer ID, number of products,");
				break;
			case 4:
				System.out.println("Do you want to search for the product by Id or name?");

				String ch = in.next();
				if (ch.equals("name")) {
					System.out.println("Enetr the name of the product:");
					String n = in.next();
					boolean found = store.searchProduct(n);
					
					if (!found) {
						System.out.println("Could not find product!");
						break;
					}

					System.out.println("choose operation");

					System.out.println("1-Update prodect: \n 2-Remove product: 3-Add review  4-Exit");
					int ch2 = in.nextInt();
					switch (ch2) {
					case 1:
						System.out.println("Enetr the product name,price and stock ");
						String Updatename = in.next();
						double Updateprice = in.nextDouble();
						int UpdateStock = in.nextInt();
						store.updateProduct(Updatename, Updateprice, UpdateStock);
						break;
					case 2:
						store.removeProduct();
					case 3:
						System.out.println();
						break;

					}
				}
				if (ch.equals("Id")) {
					System.out.println("Enter the ID of the product:");
					int Pid = in.nextInt();
					boolean found = store.searchProduct(Pid);
					
					if (!found) {
						System.out.println("Could not find product!");
						break;
					}
					
					System.out.println("choose operation");

					System.out.println("1-Update prodect: \n 2-Remove product: 3-Add review:  4-Exit");
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
					case 3:
						System.out.println();
						break;
						
					}
					
					
				}
				break;
			case 5:
				System.out.println("Enter the day , month and year of strat date ");
				Date start = new Date(in.nextInt(), in.nextInt(), in.nextInt());
				System.out.println("Enter the day , month and year of end date ");
				Date end = new Date(in.nextInt(), in.nextInt(), in.nextInt());
				store.getOrderBetweenDates(start, end);
				break;
			case 6:
				System.out.println("Eneter the first and the second customer ID");
				int fid=in.nextInt();
				int sid=in.nextInt();
				store.commonProducts(fid,sid);
				break;
			case 7:
				System.out.println("The top 3 products are:");
				store.getTop3Products();
				break;

			}

		}
	}

}
