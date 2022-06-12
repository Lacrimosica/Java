package warehouse;

public class InvalidSupplier extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InvalidSupplier() {
    	super("generic supplier Error");
    }
    
    public  InvalidSupplier(String desc) {
    	super(desc);
    }
}
