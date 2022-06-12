package taxi;

/**
 * Represents an item with a relative stat value
 */
public interface InfoI extends Comparable<InfoI> {
    /**
     * 
     * @return identifier of the stat item
     */
    String getId();

    /**
     * 
     * @return value relative to the item
     */
    int getValue();
}
