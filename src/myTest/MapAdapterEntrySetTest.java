package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.HSet;
import myAdapter.HIterator;
import myAdapter.MapAdapter;
import myAdapter.HCollection;
import myAdapter.MapAdapter.Entry;

public class MapAdapterEntrySetTest {
	
	private MapAdapter mapAdapter;
	private MapAdapter mapAdapterF;
	private MapAdapter mapAdapterF2;
	private HSet entrySet;
	private HSet entrySetF;
	private HSet entrySetF2;
	
	@Before
	public void init() {
		mapAdapter = new MapAdapter();
		entrySet = mapAdapter.entrySet();
		mapAdapterF = new MapAdapter();
		mapAdapterF.put("k", "e");
		entrySetF = mapAdapterF.entrySet();
		mapAdapterF2 = new MapAdapter();
		mapAdapterF2.put("k", "e");
		entrySetF2 = mapAdapterF2.entrySet();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addTest() {
		entrySet.add("k");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void addAllTest() {
		entrySet.addAll(null);
	}
	
	@Test
	public void addParentTest() {
		int prevSize = mapAdapterF.size();
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
		mapAdapterF.put("kk", "ee");
		Assert.assertEquals(prevSize+1, mapAdapterF.size());
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
	}
	
	@Test
	public void clearTest() {
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
		entrySetF.clear();
		Assert.assertEquals(0, mapAdapterF.size());
		Assert.assertEquals(mapAdapterF.size(), entrySetF.size());
	}
	
	@Test
	public void containsTest() {
		mapAdapter.put("k", "e");
		Assert.assertTrue(entrySet.contains(new MapAdapter.Entry("k", "e")));
		Assert.assertFalse(entrySet.contains(new MapAdapter.Entry("k", "e1")));
		Assert.assertFalse(entrySet.contains(new MapAdapter.Entry("k1", "e")));
	}

	@Test(expected = ClassCastException.class)
	public void containsClassTest() {
		entrySet.contains("k");
	}

	@Test(expected = NullPointerException.class)
	public void containsNullTest() {
		entrySet.contains(null);
	}
	
	@Test
	public void containsAllTest() {
		for(int i = 0; i < 5; i++) {
			mapAdapterF2.put("k" + i, "e" + i);
		}
		Assert.assertTrue(entrySetF2.containsAll(entrySetF));
		mapAdapterF.put("kk", "ee");
		Assert.assertFalse(entrySetF2.containsAll(entrySetF));
	}

	@Test(expected = ClassCastException.class)
	public void containsAllClassTest() {
		MapAdapter ma = new MapAdapter();
		ma.put(4, "el");
		entrySet.containsAll((HCollection) ma);
	}

	@Test(expected = NullPointerException.class)
	public void containsAllNullTest() {
		entrySet.containsAll(null);
	}
	
	@Test
	public void isEmptyTest() {
		Assert.assertTrue(entrySet.isEmpty());
		mapAdapter.put("k", "e");
		Assert.assertFalse(entrySet.isEmpty());
	}
	
	@Test
	public void iteratorTest() {
		HIterator it = entrySetF.iterator();
		Assert.assertNotNull(it);
		Assert.assertTrue(it.hasNext());
		Assert.assertNotNull(it.next());
		int prevSize = entrySetF.size();
		it.remove();
		Assert.assertEquals(prevSize - 1, entrySetF.size());
	}

	@Test(expected = IllegalStateException.class)
	public void iteratorIllTest(){
		HIterator it = entrySetF.iterator();
		it.remove();
	}
	
	@Test
	public void removeTest() {
		Assert.assertTrue(entrySet.isEmpty());
		mapAdapter.put("k", "e");
		Assert.assertFalse(entrySet.isEmpty());
		entrySet.remove(new MapAdapter.Entry("k", "e"));
		Assert.assertTrue(entrySet.isEmpty());
	}

	@Test(expected = ClassCastException.class)
	public void removeClassTest() {
		entrySet.remove("k");
	}

	@Test(expected = NullPointerException.class)
	public void removeNullTest() {
		entrySet.remove(null);
	}
	
	@Test
	public void removeAllTest() {
		Assert.assertFalse(entrySetF.isEmpty());
		entrySetF.removeAll(entrySetF2);
		Assert.assertTrue(entrySetF.isEmpty());
	}

	@Test(expected = NullPointerException.class)
	public void removeAllNullTest() {
		entrySet.removeAll(null);
	}
	
	@Test
	public void retainAllTest() {
		for(int i = 2; i < 7; i++) {
			mapAdapterF.put("k" + i, "e" + i);
		}
		entrySetF.retainAll(entrySetF2);
		Assert.assertTrue(entrySetF.contains(new Entry("k", "e")));
		for(int i = 2; i < 7; i++) {
			Assert.assertFalse(entrySetF.contains(new Entry("k" + i, "e" + i)));
		}
	}

	@Test(expected = NullPointerException.class)
	public void retainAllNullTest() {
		entrySet.retainAll(null);
	}

	@Test
	public void toArrayTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		
		Object[] o = entrySet.toArray();
		int i;
		for(i = 0; i < o.length; i++) {
			Assert.assertTrue(entrySet.contains(o[i]));
		}
		Assert.assertEquals(i, entrySet.size());
	}

	@Test
	public void toArrayParamTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		
		Object[] test = new Object[entrySet.size()];
		Assert.assertTrue(entrySet.toArray(test)==test);
		
		Object[] test2 = new Object[entrySet.size() - 1];
		Assert.assertFalse(entrySet.toArray(test2)==test2);
	}

	@Test
	public void equalsTest(){
		Assert.assertTrue(entrySetF.equals(entrySetF2));
		
		entrySetF.clear();
		Assert.assertFalse(entrySetF.equals(entrySetF2));
		
		Assert.assertFalse(entrySetF.equals(null));
		Assert.assertFalse(entrySetF.equals("el"));
	}

	@Test
	public void hashCodeTest(){
		Assert.assertEquals(mapAdapterF.hashCode(), mapAdapterF2.hashCode());
		mapAdapterF2.put("k", "el");
		Assert.assertNotEquals(mapAdapterF.hashCode(), mapAdapterF2.hashCode());
	}

}
