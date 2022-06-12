package discounts;
import java.util.*;

public class Discounts {

	private static int cardCounter = 1;
	private static int purchaseCounter = 1;
	
	//R1
	public int issueCard(String name) {
		Card c = new Card(cardCounter, name);
		Directory.getInstance().addCard(c);
	    return cardCounter++;
	}
	
    public String cardHolder(int cardN) {
        return Directory.getInstance().getCardHolder(cardN);
    }
    

	public int nOfCards() {
	       return Directory.getInstance().getNumberOfCards();
	}
	
	//R2
	public void addProduct(String categoryId, String productId, double price)
			throws DiscountsException {
	
		Product p = new Product(categoryId, productId, price);
		Directory.getInstance().addProduct(p);
			
	}
	
	public double getPrice(String productId) 
			throws DiscountsException {
        return 	Directory.getInstance().getProduct(productId).getPrice();
	}

	public int getAveragePrice(String categoryId) throws DiscountsException {
        return (int)Directory.getInstance().computeAverageForCategory(categoryId);
	}
	
	//R3
	public void setDiscount(String categoryId, int percentage) throws DiscountsException {
		Directory.getInstance().addDiscount(categoryId, percentage);
	}

	public int getDiscount(String categoryId) {
        return Directory.getInstance().getDiscount(categoryId);
	}

	//R4
	public int addPurchase(int cardId, String... items) throws DiscountsException {
        Purchase p = new Purchase(purchaseCounter, true);
        p.SetCardId(cardId);
        Directory.getInstance().addPurchase(p, items);
		return purchaseCounter++;
	}

	public int addPurchase(String... items) throws DiscountsException {
		Purchase p = new Purchase(purchaseCounter, false);
		Directory.getInstance().addPurchase(p, items);
        return purchaseCounter++;
	}
	
	public double getAmount(int purchaseCode) {
        return Directory.getInstance().getPurchase(purchaseCode).getTotalDiscounted();
	}
	
	public double getDiscount(int purchaseCode)  {
        return Directory.getInstance().getPurchase(purchaseCode).computeTotalDiscount();
	}
	
	public int getNofUnits(int purchaseCode) {
        return Directory.getInstance().getPurchase(purchaseCode).getTotNum();
	}
	
	//R5
	public SortedMap<Integer, List<String>> productIdsPerNofUnits() {
        return Directory.getInstance().getproductIdsPerNofUnits();;
	}
	
	public SortedMap<Integer, Integer> totalPurchasePerCard() {
        return Directory.getInstance().getTotalPurchasePerCard();
	}
	
	public int totalPurchaseWithoutCard() {
        double res= Directory.getInstance().getTotalPurchaseWithoutCard();
        return (int) res;
	}
	
	public SortedMap<Integer, Integer> totalDiscountPerCard() {
		return Directory.getInstance().getTotalDiscountPerCard();
	}


}
