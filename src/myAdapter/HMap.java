package myAdapter;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
 * Refers to java.util.Map@1.4.2
 * @author Bussolotto Raffaele 1224718
 */
public interface HMap {

	/**
	 * Removes all mappings from this map.
	 */
	public void clear();

	/**
	 * Returns true if this map contains a mapping for the specified key. More formally, returns true if and only if this map contains at a mapping for a key k such that (key==null ? k==null : key.equals(k)).
	 * @param key key whose presence in this map is to be tested.
	 * @return true if this map contains a mapping for the specified key.
	 * @throws ClassCastException if the key is of an inappropriate type for this map
	 * @throws NullPointerException if the key is null and this map does not not permit null keys
	 */
	public boolean containsKey(Object key) throws ClassCastException, NullPointerException;

	/**
	 * Returns true if this map maps one or more keys to the specified value. More formally, returns true if and only if this map contains at least one mapping to a value v such that (value==null ? v==null : value.equals(v)). This operation will probably require time linear in the map size for most implementations of the Map interface.
	 * @param value value whose presence in this map is to be tested.
	 * @return true if this map maps one or more keys to the specified value.
	 * @throws ClassCastException if the value is of an inappropriate type for this map.
	 * @throws NullPointerException if the value is null and this map does not not permit null values.
	 */
	public boolean containsValue(Object value) throws ClassCastException, NullPointerException;
	
	/**
	 * Returns a set view of the mappings contained in this map. Each element in the returned set is a HMap.Entry. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
	 * @return a set view of the mappings contained in this map.
	 */
	public HSet entrySet();
	
	/**
	 * Compares the specified object with this map for equality. Returns true if the given object is also a map and the two Maps represent the same mappings. More formally, two maps t1 and t2 represent the same mappings if t1.entrySet().equals(t2.entrySet()). This ensures that the equals method works properly across different implementations of the Map interface.
	 * @param o object to be compared for equality with this map.
	 * @return true if the specified object is equal to this map.
	 */
	public boolean equals(Object o);
	
	/**
	 * Returns the value to which this map maps the specified key. Returns null if the map contains no mapping for this key. A return value of null does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly maps the key to null. The containsKey operation may be used to distinguish these two cases.
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can be at most one such mapping.)
	 * @param key key whose associated value is to be returned.
	 * @return the value to which this map maps the specified key, or null if the map contains no mapping for this key.
	 * @throws ClassCastException if the key is of an inappropriate type for this map.
	 * @throws NullPointerException key is null and this map does not not permit null keys.
	 */
	public Object get(Object key) throws ClassCastException, NullPointerException;
	
	/**
	 * Returns the hash code value for this map. The hash code of a map is defined to be the sum of the hashCodes of each entry in the map's entrySet view. This ensures that t1.equals(t2) implies that t1.hashCode()==t2.hashCode() for any two maps t1 and t2, as required by the general contract of Object.hashCode.
	 * @return the hash code value for this map.
	 */
	public int hashCode();
	
	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return true if this map contains no key-value mappings.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns a set view of the keys contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll retainAll, and clear operations. It does not support the add or addAll operations.
	 * @return a set view of the keys contained in this map.
	 */
	public HSet keySet();
	
	/**
	 * Associates the specified value with the specified key in this map (optional operation). If the map previously contained a mapping for this key, the old value is replaced by the specified value. (A map m is said to contain a mapping for a key k if and only if m.containsKey(k) would return true.))
	 * @param key key with which the specified value is to be associated.
	 * @param value value to be associated with the specified key.
	 * @return previous value associated with specified key, or null if there was no mapping for key. A null return can also indicate that the map previously associated null with the specified key, if the implementation supports null values.
	 * @throws ClassCastException if the class of the specified key or value prevents it from being stored in this map.
	 * @throws IllegalArgumentException if some aspect of this key or value prevents it from being stored in this map.
	 * @throws NullPointerException this map does not permit null keys or values, and the specified key or value is null.
	 */
	public Object put(Object key, Object value) throws ClassCastException, IllegalArgumentException, NullPointerException;
	
	/**
	 * Copies all of the mappings from the specified map to this map (optional operation). The effect of this call is equivalent to that of calling put(k, v) on this map once for each mapping from key k to value v in the specified map. The behavior of this operation is unspecified if the specified map is modified while the operation is in progress.
	 * @param t Mappings to be stored in this map.
	 * @throws ClassCastException if the class of a key or value in the specified map prevents it from being stored in this map.
	 * @throws IllegalArgumentException some aspect of a key or value in the specified map prevents it from being stored in this map.
	 * @throws NullPointerException the specified map is null, or if this map does not permit null keys or values, and the specified map contains null keys or values.
	 */
	public void putAll(HMap t) throws ClassCastException, IllegalArgumentException, NullPointerException;

	/**
	 * Removes the mapping for this key from this map if it is present (optional operation). More formally, if this map contains a mapping from key k to value v such that (key==null ? k==null : key.equals(k)), that mapping is removed. (The map can contain at most one such mapping.)
	 * Returns the value to which the map previously associated the key, or null if the map contained no mapping for this key. (A null return can also indicate that the map previously associated null with the specified key if the implementation supports null values.) The map will not contain a mapping for the specified key once the call returns.
	 * @param key key whose mapping is to be removed from the map.
	 * @return previous value associated with specified key, or null if there was no mapping for key.
	 * @throws ClassCastException if the key is of an inappropriate type for this map.
	 * @throws NullPointerException if the key is null and this map does not not permit null keys.
	 */
	public Object remove(Object key) throws ClassCastException, NullPointerException;
	
	/**
	 * Returns the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * @return the number of key-value mappings in this map. If the map contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 */
	public int size();
	
	/**
	 * Returns a collection view of the values contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress, the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Collection.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
	 * @return a collection view of the values contained in this map.
	 */
	public HCollection values();

	public static interface Entry {
		
		/**
		 * Compares the specified object with this entry for equality. Returns true if the given object is also a map entry and the two entries represent the same mapping.
		 * @param o object to be compared for equality with this map entry.
		 * @return true if the specified object is equal to this map entry.
		 */
		public boolean equals(Object o);
		
		/**
		 * Returns the key corresponding to this entry.
		 * @return the key corresponding to this entry.
		 */
		public Object getKey();
		
		/**
		 * Returns the value corresponding to this entry. If the mapping has been removed from the backing map (by the iterator's remove operation), the results of this call are undefined.
		 * @return the value corresponding to this entry.
		 */
		public Object getValue();
		
		/**
		 * Returns the hash code value for this map entry.
		 * @return the hash code value for this map entry.
		 */
		public int hashCode();
		
		/**
		 * Replaces the value corresponding to this entry with the specified value (optional operation). (Writes through to the map.) The behavior of this call is undefined if the mapping has already been removed from the map (by the iterator's remove operation).
		 * @param value new value to be stored in this entry.
		 * @return old value corresponding to the entry.
		 * @throws ClassCastException if the class of the specified value prevents it from being stored in the backing map.
		 * @throws IllegalArgumentException if some aspect of this value prevents it from being stored in the backing map.
		 * @throws NullPointerException the backing map does not permit null values, and the specified value is null.
		 */
		public Object setValue(Object value) throws ClassCastException, IllegalArgumentException, NullPointerException;
		
	}
	
}
