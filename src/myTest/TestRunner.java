package myTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runner.JUnitCore;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  MapAdapterTest.class,
  MapAdapterEntrySetTest.class,
  MapAdapterValuesCollectionTest.class,
  MapAdapterKeySetTest.class
})

public class TestRunner {

	@BeforeClass
  public static void setUp() {
    System.out.println("\nSTARTING ALL THE TESTS\n");
  }

  @AfterClass
  public static void tearDown() {
    System.out.println("\nALL TESTS ENDED\n");
  }

  public static void main(String[] args) {
    JUnitCore.main("myTest.MapAdapterTest");
    JUnitCore.main("myTest.MapAdapterEntrySetTest");
    JUnitCore.main("myTest.MapAdapterValuesCollectionTest");
    JUnitCore.main("myTest.MapAdapterKeySetTest");
  }

}
