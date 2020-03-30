package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem i : itens) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Order moment: " + sdf.format(moment) + "\n");
		str.append("Order status: " + status + "\n");
		str.append(client);
		str.append("Order items:\n");
		
		for(OrderItem i : itens) {
			str.append(i);
		}
		
		str.append(String.format("Total price: $%.2f\n", total()));
		return str.toString();
	}
}
