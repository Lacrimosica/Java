package discounts;

import java.util.LinkedHashMap;
import java.util.Map;

public class Purchase {
	
	private int id;
	private double total;
	private int cardId;
	private double totalDiscounted ;
	private Map<Product, Integer> items;
	private boolean withCard;
	private int totNum;
	
	
	public Purchase(int id, boolean withcard) {
		items = new LinkedHashMap<>();
		this.id = id;
		this.withCard = withcard;
		this.total = 0;
		this.totalDiscounted = 0;
		this.totNum = 0;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public Map<Product, Integer> getItems() {
		return items;
	}

	public boolean isWithCard() {
		return withCard;
	}

	public void setWithCard(boolean withCard) {
		this.withCard = withCard;
	}

	public int getId() {
		return this.id;
	}
	
	public void SetCardId(int id) {
		this.cardId = id;
	}
	
	public double getTotalDiscounted() {
		return this.totalDiscounted;
	}
	
	public int getTotNum() {
		return this.totNum;
	}
	
	public void addItemToPurchase(Product prod , int qty) {
		this.items.put(prod, qty);
		if(prod.discounted()) {
			totalDiscounted += prod.getPrice() * qty * prod.getDiscount() / 100.0;
			total += prod.getPrice() * qty;
			totNum+= qty;
		}else {
			total += prod.getPrice() * qty;
			totalDiscounted += prod.getPrice() * qty;
			totNum+= qty;
		}
	}
	
	

	public int computeTotalDiscount() {
		return (int) (totalDiscounted/total *100);
	}

	public int getRoundedTotal() {
		int res = (int) getTotalDiscounted();
		return res;
	}
}
