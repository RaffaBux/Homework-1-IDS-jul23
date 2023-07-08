package myTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  MapAdapterTest.class,
  MapAdapterEntrySetTest.class
})

public class TestRunner {

	@BeforeClass
  public static void setUp() {
    System.out.println("\nSTARTING ALL THE TESTS\n");
  }

  @AfterClass
  public static void tearDown() {
    System.out.println("\nALL TESTS ENDED\n\nRESULTS (check TestCasesExecutionRecord.html for more infos):");
  }

}
