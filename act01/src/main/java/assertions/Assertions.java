/*
 * Copyright 2020 Roger Jaffe
 * All rights reserved
 */

package assertions;

/**
 * Contains static assertions methods for unit testing
 */
public class Assertions {
  
  private static int passes = 0;
  private static int fails = 0;
  
  /**
   * Print beginning header
   */
  public static void begin(String module) {
    System.out.println();
    System.out.println("-------------------------------------------------");
    System.out.println("BEGIN TEST");
    System.out.println("-------------------------------------------------");
    System.out.println();    
  }
  
  /**
   * Print summary header
   */
  public static void summary() {
    System.out.println();
    System.out.println("-------------------------------------------------");
    System.out.println("PASSES: "+passes);
    System.out.println("FAILS:  "+fails);
  }

  /**
   * Prints "Pass" on console
   * @param testSubject 
   */
  private static void sayPass(String testSubject) {
    System.out.println("Pass!   "+testSubject);
    passes++;
  }

  /**
   * Prints "Fail" on console
   * @param testSubject 
   */
  private static void sayFail(String testSubject) {
    System.out.println("FAIL!   "+testSubject);
    fails++;
  }
  
  /**
   * assertEqual tests for equality between the two integer parameters
   * @param testSubject Printed with test result
   * @param a
   * @param b 
   */
  public static void assertEquals(String testSubject, int a, int b) {
    if (a == b) sayPass(testSubject);
    else sayFail(testSubject);
  }

  /**
   * assertEqual tests for equality between the two String parameters
   * @param testSubject Printed with test result
   * @param a
   * @param b 
   */
  public static void assertEquals(String testSubject, String a, String b) {
    if (a == null || b == null) {
      sayFail(testSubject);
      return;
    }
    if (a.equals(b)) sayPass(testSubject);
    else sayFail(testSubject);
  }

  /**
   * assertEqual tests for equality between the two double parameters
   * @param testSubject Printed with test result
   * @param a
   * @param b 
   * @param delta Tolerance
   */
  public static void assertEquals(String testSubject, double a, double b, double delta) {
    if (Math.abs(a-b) < delta) sayPass(testSubject);
    else sayFail(testSubject);
  }
  
  /**
   * AssertNotEquals test for non-equality between the two integer parameters
   * @param testSubject
   * @param a
   * @param b 
   */
  public static void assertNotEquals(String testSubject, int a, int b) {
    if (a != b) sayPass(testSubject);
    else sayFail(testSubject);
  }

  /**
   * AssertNotEquals test for non-equality between the two String parameters
   * @param testSubject
   * @param a
   * @param b 
   */
  public static void assertNotEquals(String testSubject, String a, String b) {
    if (!a.equals(b)) sayPass(testSubject);
    else sayFail(testSubject);
  }

  /**
   * AssertNotEquals test for non-equality between the two double parameters
   * @param testSubject
   * @param a
   * @param b 
   * @param delta Tolerance
   */
  public static void assertNotEquals(String testSubject, double a, double b, double delta) {
    if (Math.abs(a-b) >= delta) sayPass(testSubject);
    else sayFail(testSubject);
  }
  
  /**
   * AssertTrue test for a true parameter
   * @param testSubject
   * @param b 
   */
  public static void assertTrue(String testSubject, boolean b) {
    if (b) sayPass(testSubject);
    else sayFail(testSubject);
  }

  /**
   * AssertTrue test for a false parameter
   * @param testSubject
   * @param b 
   */
  public static void assertFalse(String testSubject, boolean b) {
    assertTrue(testSubject, !b);
  }

}
