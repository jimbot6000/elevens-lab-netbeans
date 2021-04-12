/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act03;

import assertions.Assertions;
import java.util.Arrays;

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
    Assertions.begin("Shuffler test (Activity 03)");
    testPerfectShuffle();
    testSelectionShuffle();
    Assertions.summary();
  }
  
  public static void testPerfectShuffle() {
    int[] valuesEven =   {0,1,2,3,4,5,6,7,8,9};
    int[] shouldBeEven = {0,5,1,6,2,7,3,8,4,9};
    int[] shuffled = Shuffler.perfectShuffle(valuesEven);
    Assertions.assertArrayEquals("perfectShuffle-even", shuffled, shouldBeEven);

    int[] valuesOdd =   {0,1,2,3,4,5,6,7,8,9,10};
    int[] shouldBeOdd = {0,6,1,7,2,8,3,9,4,10,5};
    shuffled = Shuffler.perfectShuffle(valuesOdd);
    Assertions.assertArrayEquals("perfectShuffle-odd", shuffled, shouldBeOdd);
    
    int[] startValues = new int[52];
    for (int i=0; i<startValues.length; i++) 
      startValues[i] = i;
    int[] clonedValues = startValues.clone();
    // 8 shuffles will put it back as it started
    for (int i=0; i<8; i++) {
      clonedValues = Shuffler.perfectShuffle(clonedValues);
    }
    Assertions.assertArrayEquals("perfectShuffle-52Cards", clonedValues, startValues);
  }
  
  public static void testSelectionShuffle() {
    int[] values =   {0,1,2,3,4,5,6,7,8,9};
    int[] shuffled = Shuffler.selectionShuffle(values);

    // If we sort the array, we should get what we started with -- no 
    // duplicate numbers or anything weird.
    int[] shouldBe =  {0,1,2,3,4,5,6,7,8,9};
    Arrays.sort(shuffled);
    Assertions.assertArrayEquals("selectionShuffle2", shuffled, shouldBe);
  }
}
