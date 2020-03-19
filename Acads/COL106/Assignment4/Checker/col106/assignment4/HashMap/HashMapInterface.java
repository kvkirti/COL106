package col106.assignment4.HashMap;
import java.util.Vector;

/**
 * DO NOT EDIT THIS FILE.
 */
public interface HashMapInterface<V> {//Here key will always be of type String
    /**
     * @param key,value
     * @return vlaue added/updated
     */
    public V put(String key, V value);

    /**
     * @param key
     * @return value associated with the given key
     */
    public V get(String key);

    /**
     * @param key
     * @return Boolean indicating if the specified key has been removed or not
     */
    public boolean remove(String key);

    /**
     * @param key
     * @return Boolean indicating if the specified key exist or not
     */
    public boolean contains(String key);

    /**
     * @return Return the set of keys stored in the HashMap, in the order they are stored in the underlying ArrayList 
     */
    public Vector<String> getKeysInOrder();
}
