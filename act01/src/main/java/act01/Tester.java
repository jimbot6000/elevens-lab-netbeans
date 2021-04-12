/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act01;

import assertions.Assertions;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("Card class test");
    testGetSuit();
    testGetRank();
    testGetPointValue();
    testMatches();
    Assertions.summary();
  }
  
  public static void testGetSuit() {
    Card instance = new Card("5", "Hearts", 5);
    Assertions.assertEquals("getSuit", instance.getSuit(), "Hearts");    
  }
  
  public static void testGetRank() {
    Card instance = new Card("5", "Hearts", 5);
    Assertions.assertEquals("getRank", instance.getRank(), "5");
  }
  
  public static void testGetPointValue() {
    Card instance = new Card("5", "Hearts", 5);
    Assertions.assertEquals("getPointValue", instance.getPointValue(), 5);
  }
  
  public static void testMatches() {
    Card otherCard = new Card("9", "Clubs", 9);
    Card instance = new Card("9", "Clubs", 9);
    Assertions.assertTrue("matches-1", instance.matches(otherCard));
    
    otherCard = new Card("10", "Clubs", 10);
    instance = new Card("9", "Clubs", 9);
    Assertions.assertFalse("matches-2", instance.matches(otherCard));
    
    otherCard = new Card("10", "Hearts", 10);
    instance = new Card("10", "Clubs", 10);
    Assertions.assertFalse("matches-3", instance.matches(otherCard));

    otherCard = new Card("Ace", "Hearts", 1);
    instance = new Card("Ace", "Hearts", 14);
    Assertions.assertFalse("matches-4", instance.matches(otherCard));    
  }
  
}
