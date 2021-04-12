/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */

package utilities;

/**
 *
 */
public class Utilities {
  
  public static void sayPass() {
    System.out.println("Pass!");
  }
  
  public static void sayFail() {
    System.out.println("*** FAIL ***");
  }
  
  /**
   * assertEqual tests for equality between the two parameters
   * @param a
   * @param b 
   */
  public static void assertEquals(int a, int b) {
    if (a == b) sayPass();
    else sayFail();
  }

  public static void assertEquals(String a, String b) {
    if (a.equals(b)) sayPass();
    else sayFail();
  }

  public static void assertEquals(double a, double b, double delta) {
    if (Math.abs(a-b) < delta) sayPass();
    else sayFail();
  }
  
  /**
   * assertTrue and assertFalse
   */
  public static void assertTrue(boolean b) {
    if (b) sayPass();
    else sayFail();
  }

  public static void assertFalse(boolean b) {
    assertTrue(b);
  }

}
