package myTest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import myAdapter.MapAdapter;

public class MapAdapterValuesCollectionTest {
  
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
    mapAdapter3.put("A", 10);
    mapAdapter3.put("B", 20);
    mapAdapter3.put("C", 30);
  }

  @Test
  public void containsTest() {
    Assert.assertTrue(mapAdapter1.values().contains(1));
    Assert.assertFalse(mapAdapter1.values().contains(4));
  }

  @Test
  public void removeTest() {
    Assert.assertTrue(mapAdapter1.values().contains(2));
    mapAdapter1.remove("B");
    Assert.assertFalse(mapAdapter1.values().contains(2));
    Assert.assertEquals(2, mapAdapter1.values().size());
  }

  @Test
  public void toArrayTest() {
    Object[] array = mapAdapter1.values().toArray();
    Assert.assertEquals(3, array.length);
    Assert.assertArrayEquals(new Integer[]{1, 3, 2}, array);
  }

  @Test
  public void equalsTest() {
    Assert.assertTrue(mapAdapter1.values().equals(mapAdapter2.values()));
    Assert.assertFalse(mapAdapter1.values().equals(mapAdapter3.values()));
  }

  @Test
  public void iteratorTest() {
		Assert.assertNotNull(mapAdapter1.values().iterator());
    Assert.assertEquals(1, mapAdapter1.values().iterator().next());
  }

}
