package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Client client = new Client();
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		client.setName(sc.nextLine());
		System.out.print("Email: ");
		client.setEmail(sc.nextLine());
		System.out.print("Birth date (DD/MM/YYYY): ");
		client.setBirthDate(sdf.parse(sc.nextLine()));
		
		Order order = new Order();
		order.setClient(client);
		System.out.println("Enter order data:");
		order.setMoment(new Date());
		System.out.print("Status: ");
		order.setStatus(OrderStatus.valueOf(sc.nextLine()));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		Product product;
		OrderItem item;
		double price;
		
		for(int i = 1; i < n+1; ++i) {
			product = new Product();
			item = new OrderItem();
			item.setProduct(product);
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			product.setName(sc.nextLine());
			System.out.print("Product price: ");
			price = sc.nextDouble();
			product.setPrice(price);
			item.setPrice(price);
			System.out.print("Quantity: ");
			item.setQuantity(sc.nextInt());
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
		sc.close();

	}

}
