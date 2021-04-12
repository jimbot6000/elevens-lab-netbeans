/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act10;

import assertions.Assertions;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("View test");
    testInit();
    testSetBorders();
    testSetAllBorders();
    Assertions.summary();
  }
  
  public static void testInit() {
    View view = new View(null);
    view.init();
    JLabel[] cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      JLabel card = cards[i];
      Assertions.assertNotNull("card is not null", card);
      Assertions.assertEquals("card label name should be "+i, card.getName(), Integer.toString(i));
    }
  }

  /**
   * Test of setBorders method, of class View.
   */
  public static void testSetBorders() {
    boolean[] cardSelectedStatus = {false, false, true, true, false, false, false, true, false};
    View view = new View(null);
    view.init();
    int result = view._setBorders(cardSelectedStatus, Color.PINK, 3);
    Assertions.assertEquals("Number of selected cells should be 3", 3, result);
    JLabel[] cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      JLabel card = cards[i];
      if (i == 2 || i == 3 || i == 7) {
        LineBorder lb = (LineBorder)card.getBorder();
        Assertions.assertEquals("Color should be pink", lb.getLineColor(), Color.PINK);
        Assertions.assertEquals("Thickness should be 3", lb.getThickness(), 3);
      } else {
        Assertions.assertNull("No border", card.getBorder());
      }
    }
  }

  /**
   * Test of setAllBorders method, of class View.
   */
  public static void testSetAllBorders() {
    View view = new View(null);
    view.init();
    view._setAllBorders(Color.PINK, 3);
    JLabel[] cards = (JLabel[])view.get("cards");
    for (JLabel card : cards) {
      LineBorder lb = (LineBorder)card.getBorder();
      Assertions.assertEquals("Color should be pink", lb.getLineColor(), Color.PINK);
      Assertions.assertEquals("Thickness should be 3", lb.getThickness(), 3);
    }
  }
  
}
