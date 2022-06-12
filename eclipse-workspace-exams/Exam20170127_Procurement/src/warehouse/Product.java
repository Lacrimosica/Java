package warehouse;

import java.util.List;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Product {
	private String code;
	private String description;
	private int quantity;
	
	public Product(String code, String desc) {
		this.code = code;
		this.description = desc;
		this.quantity = 0;
		
	}
	public String getCode(){
		return code;
	}

	public String getDescription(){
		return description;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public void decreaseQuantity(){
		this.quantity -=1;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public List<Supplier> suppliers(){
		return null;
	}

	public List<Order> pendingOrders(){
		return Warehouse.getInstance().orders.values().stream()
				.filter(o -> o.getProduct().getCode().equals(this.getCode()))
					.sorted(comparing(Order::getQuantity).reversed())
						.collect(toList());
	}
}
