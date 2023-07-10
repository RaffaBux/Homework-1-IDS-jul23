package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.MapAdapter;

public class MapAdapterTest {
	
	private MapAdapter mapAdapter;
	private MapAdapter mapAdapterF;
	
	@Before
	public void init() {
		mapAdapter = new MapAdapter();
		mapAdapterF = new MapAdapter();
		for(int i = 0; i < 5; i++) {
			mapAdapterF.put("k" + i, "e" + i);
		}
	}

	@Test
	public void sizeTest(){
		Assert.assertEquals(0, mapAdapter.size());
		mapAdapter.put("k1", "e1");
		Assert.assertEquals(1, mapAdapter.size());
		mapAdapter.put("k2", "e2");
		mapAdapter.put("k3", "e3");
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
		mapAdapter.remove("k3");
		Assert.assertEquals(3, mapAdapter.size());
	}

	@Test
	public void valuesTest(){
		Object valuesCollection = mapAdapter.values();
		Assert.assertNotNull(valuesCollection);
	}

	@Test
	public void isEmptyTest(){
		Assert.assertTrue(mapAdapter.isEmpty());
		mapAdapter.put("k1", "e1");
		Assert.assertFalse(mapAdapter.isEmpty());
	}

	@Test
	public void containsKeyTest(){
		Assert.assertFalse(mapAdapter.containsKey("k1"));
		mapAdapter.put("k1", "e1");
		Assert.assertTrue(mapAdapter.containsKey("k1"));
	}

	@Test(expected = NullPointerException.class)
	public void containsKeyNullTest(){
		mapAdapter.containsKey(null);
	}

	@Test
	public void containsValueTest(){
		Assert.assertFalse(mapAdapter.containsValue("e1"));
		mapAdapter.put("k1", "e1");
		Assert.assertTrue(mapAdapter.containsValue("e1"));
	}

	@Test(expected = NullPointerException.class)
	public void containsValueNullTest(){
		mapAdapter.containsValue(null);
	}

	@Test
	public void getTest(){
		Assert.assertNull(mapAdapter.get("k4"));
		mapAdapter.put("k1", "e1");
		Assert.assertNotNull(mapAdapter.get("k1"));
		Assert.assertEquals("e1", mapAdapter.get("k1"));
	}

	@Test(expected = NullPointerException.class)
	public void getNullTest(){
		mapAdapter.get(null);
	}

	@Test
	public void putTest(){
		Assert.assertEquals(0, mapAdapter.size());
		mapAdapter.put("k1", "e1");
		Assert.assertEquals(1, mapAdapter.size());
		mapAdapter.put("k2", "e2");
		mapAdapter.put("k3", "e3");
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
		mapAdapter.put("k4", "e4");
		Assert.assertEquals(4, mapAdapter.size());
	}

	@Test(expected = NullPointerException.class)
	public void putNullTest(){
		mapAdapter.put(null, null);
	}

	@Test(expected = NullPointerException.class)
	public void putNullValueTest(){
		mapAdapter.put("k", null);
	}

	@Test(expected = NullPointerException.class)
	public void putNullKeyTest(){
		mapAdapter.put(null, "el");
	}

	@Test
	public void removeTest(){
		for(int i = 0; i < 5; i++) {
			mapAdapter.put("k" + i, "e" + i);
		}
		Assert.assertEquals(5, mapAdapter.size());
		for(int i = 0; i < 5; i++) {
			Assert.assertEquals("e" + i, mapAdapter.remove("k" + i));
		}
		Assert.assertEquals(0, mapAdapter.size());
	}

	@Test(expected = NullPointerException.class)
	public void removeNullTest(){
		mapAdapter.remove(null);
	}

	@Test
	public void putAllTest(){
		mapAdapter.putAll(mapAdapterF);
		Assert.assertEquals(mapAdapterF.size(), mapAdapter.size());
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals("e" + i, mapAdapter.get("k" + i));
		}
	}

	@Test(expected = NullPointerException.class)
	public void putAllNullTest(){
		mapAdapter.putAll(null);
	}

	@Test
	public void clearTest(){
		Assert.assertNotEquals(0, mapAdapterF.size());
		mapAdapterF.clear();
		Assert.assertEquals(0, mapAdapterF.size());
	}

	@Test
	public void keySetTest(){
		Assert.assertNotNull(mapAdapter.keySet());
	}

	@Test
	public void valuestTest(){
		Assert.assertNotNull(mapAdapter.values());
	}

	@Test
	public void entrySetTest(){
		Assert.assertNotNull(mapAdapter.entrySet());
	}

	@Test
	public void equalsTest(){
		MapAdapter ma = new MapAdapter();
		Assert.assertTrue(mapAdapter.equals(ma));
		for(int i = 0; i < 5; i++) {
			ma.put("k" + i, "e" + i);
		}
		Assert.assertFalse(mapAdapter.equals(ma));
		mapAdapter.putAll(ma);
		Assert.assertTrue(mapAdapter.equals(ma));
		mapAdapter.remove("k1");
		Assert.assertFalse(mapAdapter.equals(ma));
	}

	@Test
	public void hashCodeTest(){
		MapAdapter ma = new MapAdapter();
		for(int i = 0; i < 5; i++) {
			ma.put("k" + i, "e" + i);
		}
		mapAdapter.putAll(ma);
		Assert.assertEquals(mapAdapter.hashCode(), ma.hashCode());
		mapAdapter.remove("k1");
		Assert.assertNotEquals(mapAdapter.hashCode(), ma.hashCode());
	}

}
