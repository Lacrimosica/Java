package warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;

public class Supplier {
	private String code;
	private String name;
	private Map<String, Product> suppliedProducts;
	
	public Supplier(String c, String n) {
		this.code  =c;
		this.name = n;
		suppliedProducts = new HashMap<>();
	}
	
	public String getCode(){
		return this.code;
	}

	public String getName(){
		return this.name;
	}
	
	public void newSupply(Product product){
		this.suppliedProducts.put(product.getCode(), product);
	}
	
	public List<Product> supplies(){
		return new ArrayList<>(suppliedProducts.values());
		//Alternatice using Streams
//		return suppliedProducts.values().stream().collect(toList());
	}
}
