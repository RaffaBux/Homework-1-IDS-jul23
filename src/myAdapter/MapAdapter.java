package myAdapter;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

/**
 * This MapAdapter class use an Hashtable instance as adaptee to implement a Map
 * @author Bussolotto Raffaele 1224718
 */
public class MapAdapter implements HMap {
	
	private Hashtable hashTable;
	
	public MapAdapter() {
		hashTable = new Hashtable();
	}

	public void clear() {
		hashTable.clear();
	}

	public boolean containsKey(Object key) throws NullPointerException {
		checkIsNotNull(key);
		return hashTable.containsKey(key);
	}

	public boolean containsValue(Object value) throws NullPointerException {
		checkIsNotNull(value);
		return hashTable.contains(value);
	}

	public HSet entrySet() {
		return new EntrySet();
	}

	public Object get(Object key) throws NullPointerException {
		checkIsNotNull(key);
		return hashTable.get(key);
	}

	public boolean isEmpty() {
		return hashTable.isEmpty();
	}

	public HSet keySet() {
		return new KeySet();
	}

	public Object put(Object key, Object value) throws NullPointerException {
		return hashTable.put(key, value);
	}

	public void putAll(HMap newEntries) throws NullPointerException {
		checkIsNotNull(newEntries);
		HSet e = newEntries.entrySet();
		HIterator iterator = e.iterator();
		while(iterator.hasNext()) {
			HMap.Entry entry = (HMap.Entry)iterator.next();
			checkIsNotNull(entry);
			put(entry.getKey(), entry.getValue());
		}
	}

	public Object remove(Object key) throws NullPointerException {
		checkIsNotNull(key);
		return hashTable.remove(key);
	}

	public int size() {
		return hashTable.size();
	}

	public HCollection values() {
		return new ValuesCollection();
	}
	
	public boolean equals(Object obj) {
		try {
			
			if(obj == null) { 
				return false;
			}
			
			MapAdapter tmp = (MapAdapter)obj;
			if(tmp.size() != size()) {
				return false;
			}
			
			HIterator iterator = tmp.entrySet().iterator();
			while(iterator.hasNext()) {
				HMap.Entry entry = (HMap.Entry)iterator.next();
				Object value = get(entry.getKey());
				if((value == null) || (!value.equals(tmp.get(entry.getKey())))) {
					return false;
				}
			}
			
			return true;
			
		} catch (ClassCastException error) {
			return false;
		}
	};
	
	public int hashCode() {
		int hashCode = 7;
		HIterator iterator = entrySet().iterator();
		while(iterator.hasNext()) {
		    Object obj = iterator.next();
		    hashCode = 79*hashCode + (obj==null ? 0 : obj.hashCode());
		}
		return hashCode;
	}
	
	private void checkIsNotNull(Object value) throws NullPointerException {
		if(value == null) {
			throw new NullPointerException();
		}
	}
	
	public static class Entry implements HMap.Entry {
		
		private Object key;
		private Object value;
		
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public Object setValue(Object value) throws NullPointerException {
			Object old = this.value;
			this.value = value;
			return old;
		}
		
		public boolean equals(Object obj) {
			try {
				HMap.Entry entry = (HMap.Entry)obj;
				return (getKey().equals(entry.getKey())) && (getValue().equals(entry.getValue()));
			} catch (ClassCastException error) {
				return false;
			}
		}
		
		public int hashCode() {
			return getKey().hashCode() + getValue().hashCode();
		}
		
	}
	
	private class EntrySet implements HSet {

		public boolean add(Object obj) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public boolean addAll(HCollection c) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public void clear() {
			MapAdapter.this.clear();
		}

		public boolean contains(Object obj) throws ClassCastException, NullPointerException {
			checkIsNotNull(obj);
			HMap.Entry cntdEntry = (HMap.Entry)obj;
			Object res = get(cntdEntry.getKey());
			if(res == null) {
				return false;
			}
			return res.equals(cntdEntry.getValue());
		}

		public boolean containsAll(HCollection c) throws ClassCastException, NullPointerException {
			checkIsNotNull(c);
			HIterator iterator = c.iterator();
			while(iterator.hasNext()) {
				if(!contains(iterator.next())) {
					return false;
				}
			}
			return true;
		}

		public boolean isEmpty() {
			return MapAdapter.this.isEmpty();
		}

		public HIterator iterator() {
			return new EntrySetIterator(hashTable.keys());
		}

		public boolean remove(Object obj) throws ClassCastException, NullPointerException {
			HMap.Entry rmvdEntry = (HMap.Entry)obj;
			boolean res = get(rmvdEntry.getKey()).equals(rmvdEntry.getValue());
			if(res) {
				MapAdapter.this.remove(rmvdEntry.getKey());
			}
			return res;
		}

		public boolean removeAll(HCollection c) throws ClassCastException, NullPointerException {
			checkIsNotNull(c);
			HIterator iterator = iterator();
			boolean res = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				if(c.contains(obj)) {
					remove(obj);
					res = true;
				}
			}
			return res;
		}

		public boolean retainAll(HCollection c) throws ClassCastException, NullPointerException {
			checkIsNotNull(c);
			HIterator iterator = iterator();
			boolean res = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				if(!c.contains(obj)) {
					remove(obj);
					res = true;
				}
			}
			return res;
		}
		
		public boolean equals(Object obj) {
			if(obj==null) {
				return false;
			}
			EntrySet temp;
			try {
				temp = (EntrySet)obj;
			} catch (ClassCastException error) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tmpIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tmpIterator.next())) {
					return false;
				}
			}
			return true;
		};

		public int hashCode() {
			int hashCode = 7;
			HIterator iterator = iterator();
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				hashCode = 79*hashCode + (obj==null ? 0 : obj.hashCode());
			}
			return hashCode;
		};

		public int size() {
			return MapAdapter.this.size();
		}

		public Object[] toArray() {
			return toArray(new HMap.Entry[size()]);
		}

		public Object[] toArray(Object[] obj) throws NullPointerException {
			checkIsNotNull(obj);
			if(obj.length >= size()) {
				HIterator iterator = iterator();
				int index = 0;
				while(iterator.hasNext()) {
					obj[index] = iterator.next();
					index++;
				}
				for(int i = size(); i < obj.length; i++) {
					obj[i] = null;
				}
				return obj;
			}
			return toArray();
		}
		
		private class EntrySetIterator implements HIterator {
			
			private Enumeration keys;
			private Object prev;
			
			public EntrySetIterator(Enumeration keys) {
				this.keys = keys;
				prev = null;
			}

			public boolean hasNext() {
				return keys.hasMoreElements();
			}

			public Object next() throws NoSuchElementException {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				prev = keys.nextElement();
				return new Entry(prev, get(prev));
			}

			public void remove() throws IllegalStateException {
				if(prev == null) {
					throw new IllegalStateException();
				}
				MapAdapter.this.remove(prev);
				prev = null;
			}
			
		}
		
	}
	
	private class KeySet extends EntrySet {
		
		public boolean contains(Object obj) throws NullPointerException {
			checkIsNotNull(obj);
			return MapAdapter.this.containsKey(obj);
		}
		
		public boolean remove(Object obj) throws NullPointerException {
			return !MapAdapter.this.remove(obj).equals(null);
		}

		public Object[] toArray() {
			return toArray(new Object[size()]);
		}
		
		public boolean equals(Object obj) {
			KeySet temp;
			try {
				temp = (KeySet)obj;
			} catch (ClassCastException error) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tmpIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tmpIterator.next())) {
					return false;
				}
			}
			return true;
		};
		
		public HIterator iterator() {
			return new KeySetIterator(hashTable.keys());
		}
		
		private class KeySetIterator extends EntrySet.EntrySetIterator {
			
			public KeySetIterator(Enumeration keys) {
				super(keys);
			}

			public Object next() throws NoSuchElementException {
				return ((HMap.Entry)super.next()).getKey();
			}
			
		}
		
	}
	
	private class ValuesCollection extends EntrySet {
		
		public boolean contains(Object obj) throws NullPointerException {
			checkIsNotNull(obj);
			return MapAdapter.this.containsValue(obj);
		}
		
		public boolean remove(Object obj) throws NullPointerException {
			return !MapAdapter.this.remove(obj).equals(null);
		}

		public Object[] toArray() {
			return toArray(new Object[size()]);
		}
		
		public boolean equals(Object obj) {
			ValuesCollection temp;
			try {
				temp = (ValuesCollection)obj;
			} catch (ClassCastException error) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tmpIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tmpIterator.next())) {
					return false;
				}
			}
			return true;
		};

		public HIterator iterator() {
			return new ValuesCollIterator(hashTable.keys());
		}
		
		private class ValuesCollIterator extends EntrySet.EntrySetIterator {
			
			public ValuesCollIterator(Enumeration keys) {
				super(keys);
			}

			public Object next() throws NoSuchElementException {
				return ((HMap.Entry)super.next()).getValue();
			}
			
		}
		
	}

}
