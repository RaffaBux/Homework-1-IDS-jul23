package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.MapAdapter;

public class MapAdapterKeySetTest {
  
  private MapAdapter mapAdapter1;
  private MapAdapter mapAdapter2;
  private MapAdapter mapAdapter3;

  @Before
  public void init() {
    mapAdapter1 = new MapAdapter();
    mapAdapter1.put("A", 1);
    mapAdapter1.put("B", 2);
    mapAdapter1.put("C", 3);

    mapAdapter2 = new MapAdapter();
    mapAdapter2.put("A", 1);
    mapAdapter2.put("B", 2);
    mapAdapter2.put("C", 3);

    mapAdapter3 = new MapAdapter();
    mapAdapter3.put("D", 1);
    mapAdapter3.put("E", 2);
    mapAdapter3.put("F", 3);
  }

  @Test
  public void containsTest() {
    Assert.assertTrue(mapAdapter1.keySet().contains("A"));
    Assert.assertFalse(mapAdapter1.keySet().contains("D"));
  }

  @Test
  public void removeTest() {
    Assert.assertTrue(mapAdapter1.keySet().contains("B"));
    mapAdapter1.remove("B");
    Assert.assertFalse(mapAdapter1.keySet().contains("B"));
    Assert.assertEquals(2, mapAdapter1.keySet().size());
  }

  @Test
  public void toArrayTest() {
    Object[] array = mapAdapter1.keySet().toArray();
    Assert.assertEquals(3, array.length);
  }

  @Test
  public void equalsTest() {
    Assert.assertTrue(mapAdapter1.keySet().equals(mapAdapter2.keySet()));
    Assert.assertFalse(mapAdapter1.keySet().equals(mapAdapter3.keySet()));
  }

  @Test
  public void iteratorTest() {
		Assert.assertNotNull(mapAdapter1.keySet().iterator());
    Assert.assertEquals("A", mapAdapter1.keySet().iterator().next());
  }

}
