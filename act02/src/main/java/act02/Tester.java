/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act02;

import assertions.Assertions;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {

  final static String ranks[] = {"Ace","4",};
  final static String suits[] = {"Hearts","Clubs"};
  final static int pointValues[] = {1, 4};
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("Deck class test");
    testConstructor();
    testDeal();
    testIsEmpty();
    testSize();
    Assertions.summary();
  }
  
  public static void testConstructor() {
    Deck instance = new Deck(ranks, suits, pointValues);
    Assertions.assertEquals("constructor1", instance.getCard(0).getSuit(), "Hearts");
    Assertions.assertEquals("constructor2", instance.getCard(0).getRank(), "Ace");
    Assertions.assertEquals("constructor3", instance.getCard(0).getPointValue(), 1);
    Assertions.assertEquals("constructor4", instance.getCard(1).getSuit(), "Clubs");
    Assertions.assertEquals("constructor5", instance.getCard(1).getRank(), "Ace");
    Assertions.assertEquals("constructor6", instance.getCard(1).getPointValue(), 1);
    Assertions.assertEquals("constructor7", instance.getCard(2).getSuit(), "Hearts");
    Assertions.assertEquals("constructor8", instance.getCard(2).getRank(), "4");
    Assertions.assertEquals("constructor9", instance.getCard(2).getPointValue(), 4);
    Assertions.assertEquals("constructor10", instance.getCard(3).getSuit(), "Clubs");
    Assertions.assertEquals("constructor11", instance.getCard(3).getRank(), "4");
    Assertions.assertEquals("constructor12", instance.getCard(3).getPointValue(), 4);    
    Assertions.assertTrue("constructor13", instance.shuffled);
  }
  
  /**
   * Test of isEmpty method, of class Deck.
   */
  public static void testIsEmpty() {
    String[] emptyStrings = {};
    int[] emptyInts = {};
    Deck instance = new Deck(emptyStrings, emptyStrings, emptyInts);
    Assertions.assertTrue("isEmpty", instance.isEmpty());
  }

  /**
   * Test of size method, of class Deck.
   */
  public static void testSize() {
    Deck instance = new Deck(ranks, suits, pointValues);
    Assertions.assertEquals("size", instance.size(), 4);
  }

  /**
   * Test of deal method, of class Deck.
   */
  public static void testDeal() {
    Deck instance = new Deck(ranks, suits, pointValues);
    Card c = instance.deal();
    Assertions.assertEquals("deal1", c.getRank(), "4");
    Assertions.assertEquals("deal2", c.getSuit(), "Clubs");
    Assertions.assertEquals("deal3", instance.size(), 3);
    c = instance.deal();
    Assertions.assertEquals("deal4", c.getRank(), "4");
    Assertions.assertEquals("deal5", c.getSuit(), "Hearts");
    Assertions.assertEquals("deal6", instance.size(), 2);
  }

}
