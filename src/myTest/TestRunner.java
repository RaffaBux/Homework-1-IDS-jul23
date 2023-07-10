package myTest;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

/**
* @author Bussolotto Raffaele - n° mat.: 1224718
*/
public class TestRunner {
  
  public static void main(String[] args){
    System.out.println("\nSTARTING ALL THE TESTS\n");

    Result result = JUnitCore.runClasses(MapAdapterTest.class);
    for(Failure failures : result.getFailures()) {
      System.out.println(failures.toString());
    }
    
    System.out.println("\n--------------------------------------------------\n");
    System.out.println("MapAdapterTest - Tests run: " + result.getRunCount() + ", Failed: " + result.getFailureCount()+ ", Succeeded: " + (result.getRunCount() - result.getFailureCount()));
    System.out.println("\n--------------------------------------------------");

    result = JUnitCore.runClasses(MapAdapterEntrySetTest.class);
    for(Failure failures : result.getFailures()) {
      System.out.println(failures.toString());
    }

    System.out.println("\n--------------------------------------------------\n");
    System.out.println("MapAdapterEntrySetTest - Tests ran: " + result.getRunCount() + ", Failed: " + result.getFailureCount()+ ", Succeeded: " + (result.getRunCount() - result.getFailureCount()));
    System.out.println("\n--------------------------------------------------");

    result = JUnitCore.runClasses(MapAdapterValuesCollectionTest.class);
    for(Failure failures : result.getFailures()) {
      System.out.println(failures.toString());
    }

    System.out.println("\n--------------------------------------------------\n");
    System.out.println("MapAdapterValuesCollectionTest - Tests ran: " + result.getRunCount() + ", Failed: " + result.getFailureCount()+ ", Succeeded: " + (result.getRunCount() - result.getFailureCount()));
    System.out.println("\n--------------------------------------------------");

    result = JUnitCore.runClasses(MapAdapterKeySetTest.class);
    for(Failure failures : result.getFailures()) {
      System.out.println(failures.toString());
    }

    System.out.println("\n--------------------------------------------------\n");
    System.out.println("MapAdapterKeySetTest - Tests ran: " + result.getRunCount() + ", Failed: " + result.getFailureCount()+ ", Succeeded: " + (result.getRunCount() - result.getFailureCount()));
    System.out.println("\n--------------------------------------------------");

    System.out.println("\nALL TESTS ENDED\n");
  }

}
