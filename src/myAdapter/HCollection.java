package myAdapter;

/**
 * A collection represents a group of objects, known as its elements. 
 * Some collections allow duplicate elements and others do not. Some are ordered and others unordered.
 * Refers to java.util.Collection@1.4.2
 * @author Bussolotto Raffaele 1224718
 */
public interface HCollection {

  /**
   * Appends the specified element to the end of this list.
   * Lists that support this operation may place limitations on what elements may be added to this list. 
   * In particular, some lists will refuse to add null elements, and others will impose restrictions on the type of elements that may be added.
   * List classes should clearly specify in their documentation any restrictions on what elements may be added.
   * @param o - element to be appended to this list.
   * @return true (as per the general contract of the Collection.add method).
   * @throws UnsupportedOperationException add is not supported by this collection.
   * @throws ClassCastException class of the specified element prevents it from being added to this collection.
   * @throws NullPointerException if the specified element is null and this collection does not support null elements.
   * @throws IllegalArgumentException some aspect of this element prevents it from being added to this collection.
   */
  public boolean add(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;

  /**
   * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator. 
   * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress. 
   * (Note that this will occur if the specified collection is this list, and it's nonempty.)
   * @param c - collection whose elements are to be added to this list.
   * @return true if this list changed as a result of the call.
   * @throws UnsupportedOperationException if this collection does not support the addAll method.
   * @throws ClassCastException if the class of an element of the specified collection prevents it from being added to this collection.
   * @throws NullPointerException if the specified collection contains one or more null elements and this collection does not support null elements, or if the specified collection is null.
   * @throws IllegalArgumentException some aspect of an element of the specified collection prevents it from being added to this collection.
   */
  public boolean addAll(HCollection c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;

  /**
   * Removes all of the elements from this collection. 
   * This collection will be empty after this method returns unless it throws an exception.
   * @throws UnsupportedOperationException if the clear method is not supported by this collection.
   */
  public void clear() throws UnsupportedOperationException;

  /**
   * Returns true if this collection contains the specified element. 
   * More formally, returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
   * @param o - element whose presence in this collection is to be tested.
   * @return true if this collection contains the specified element
   * @throws ClassCastException if the type of the specified element is incompatible with this collection.
   * @throws NullPointerException if the specified element is null and this collection does not support null elements.
   */
  public boolean contains(Object o) throws ClassCastException, NullPointerException;

  /**
   * Returns true if this collection contains all of the elements in the specified collection.
   * @param c - collection to be checked for containment in this collection.
   * @return true if this collection contains all of the elements in the specified collection
   * @throws ClassCastException if the types of one or more elements in the specified collection are incompatible with this collection.
   * @throws NullPointerException if this collection contains one or more null elements and the specified collection does not support null elements or the specified collection is null.
   */
  public boolean containsAll(HCollection c) throws ClassCastException, NullPointerException;

  /**
   * Compares the specified object with this collection for equality.
   * @param o - Object to be compared for equality with this collection.
   * @return true if the specified object is equal to this collection
   */
  public boolean equals(Object o);

  /**
   * Returns the hash code value for this collection. 
   * While the Collection interface adds no stipulations to the general contract for the Object.hashCode method, 
   * programmers should take note that any class that overrides the Object.equals method must also override the Object.hashCode method 
   * in order to satisfy the general contract for the Object.hashCodemethod. 
   * In particular, c1.equals(c2) implies that c1.hashCode()==c2.hashCode().
   * @return the hash code value for this collection
   */
  public int hashCode();

  /**
   * Returns true if this collection contains no elements.
   * @return true if this collection contains no elements
   */
  public boolean isEmpty();

  /**
   * Returns an iterator over the elements in this collection. 
   * There are no guarantees concerning the order in which the elements are returned 
   * (unless this collection is an instance of some class that provides a guarantee).
   * @return an Iterator over the elements in this collection
   */
  public HIterator iterator();

  /**
   * Removes a single instance of the specified element from this collection, if it is present. 
   * More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains one or more such elements. 
   * Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
   * @param o - element to be removed from this collection, if present.
   * @return true if this collection changed as a result of the call
   * @throws ClassCastException if the types of one or more elements in the specified collection are incompatible with this collection.
   * @throws NullPointerException if the specified collection is null.
   * @throws UnsupportedOperationException remove is not supported by this collection.
   */
  public boolean remove(Object o) throws ClassCastException, NullPointerException, UnsupportedOperationException;

  /**
   * Removes all this collection's elements that are also contained in the specified collection. 
   * After this call returns, this collection will contain no elements in common with the specified collection.
   * @param c - elements to be removed from this collection.
   * @return true if this collection changed as a result of the call
   * @throws ClassCastException if the types of one or more elements in the specified collection are incompatible with this collection.
   * @throws NullPointerException if this collection contains one or more null elements and the specified collection does not support null elements or the specified collection is null.
   * @throws UnsupportedOperationException if the removeAll method is not supported by this collection.
   */
  public boolean removeAll(HCollection c) throws ClassCastException, NullPointerException, UnsupportedOperationException;

  /**
   * Retains only the elements in this collection that are contained in the specified collection. 
   * In other words, removes from this collection all of its elements that are not contained in the specified collection.
   * @param c - elements to be retained in this collection.
   * @return true if this collection changed as a result of the call
   * @throws ClassCastException if the types of one or more elements in this collection are incompatible with the specified collection.
   * @throws NullPointerException if this collection contains one or more null elements and the specified collection does not support null elements or the specified collection is null.
   * @throws UnsupportedOperationException if the retainAll method is not supported by this Collection.
   */
  public boolean retainAll(HCollection c) throws ClassCastException, NullPointerException, UnsupportedOperationException;

  /**
   * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
   * @return the number of elements in this collection
   */
  public int size();

  /**
   * Returns an array containing all of the elements in this collection. 
   * If the collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
   * @return an array containing all of the elements in this collection
   */
  public Object[] toArray();

  /**
   * Returns an array containing all of the elements in this collection; 
   * the runtime type of the returned array is that of the specified array. 
   * If the collection fits in the specified array, it is returned therein. 
   * Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection.
   * @param a - the array into which the elements of this collection are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
   * @return an array containing the elements of this collection
   * @throws ArrayStoreException the runtime type of the specified array is not a supertype of the runtime type of every element in this collection.
   * @throws NullPointerException if the specified array is null.
   */
  public Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException;

}