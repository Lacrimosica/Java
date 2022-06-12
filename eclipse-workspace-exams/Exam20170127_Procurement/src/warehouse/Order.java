package warehouse;

public class Order {
	private String code;
	private Supplier supplier;
	private Product product;
	private int quantity;
	private boolean delivered;
	
	public Order(int n, 
			Product prod, 
			Supplier supp, 
			int quan ) {
		this.code = "ORD" + n;
		this.product = prod;
		this.supplier = supp;
		this.quantity = quan;
		this.delivered = false;
	}
	public String getCode(){
		return code;
	}
	
	public boolean delivered(){
		return delivered;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setDelivered() throws MultipleDelivery {
		
		if(delivered) {
			throw new MultipleDelivery();
		}
		delivered = true;
		product.setQuantity(quantity + product.getQuantity());
//		Warehouse.getInstance().products.get(product.getCode()).setQuantity(product.getQuantity() + this.quantity);
	}
	
	@Override
	public String toString(){
		return "Order " + code + " for "
				+ quantity + " of product :"
				+product.getCode() + " " + product.getDescription() + " from "
				+ supplier.getName();
	}
}
