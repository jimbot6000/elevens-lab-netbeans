/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act04;

import assertions.Assertions;
import java.util.Arrays;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {

  static String suits[] = {"Hearts"};
  static String ranks[] = {"2","3","4","5"};
  static int pointValues[] = {2, 3, 4, 5};
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("Shuffler test (Activity 04)");
    testShuffle();
    Assertions.summary();
  }
  
  public static void testShuffle() {
    Deck instance = new Deck(ranks, suits, pointValues);
    int c1 = instance.deal().getPointValue();
    int c2 = instance.deal().getPointValue();
    int c3 = instance.deal().getPointValue();
    int c4 = instance.deal().getPointValue();
    int[] found = {0, 0, 0, 0};
    found[c1-2]++;
    found[c2-2]++;
    found[c3-2]++;
    found[c4-2]++;
    Assertions.assertEquals("testShuffle1", found[0], 1);
    Assertions.assertEquals("testShuffle2", found[1], 1);
    Assertions.assertEquals("testShuffle3", found[2], 1);
    Assertions.assertEquals("testShuffle4", found[3], 1);
    Assertions.assertEquals("testShuffle5", instance.size(), 0);
    instance.shuffle();
    Assertions.assertEquals("testShuffle6", instance.size(), 4);
  }
  
}
