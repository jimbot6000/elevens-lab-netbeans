/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act12;

import assertions.Assertions;
import com.mrjaffesclass.apcs.messenger.*;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("Model test");
    testClearAll();
    testCardClicked();
    testPlay();
    Assertions.summary();
  }
  
  public static void testClearAll() {
    Messenger messenger = new Messenger();
    Model model = new Model(messenger);
    boolean[] cardSelectedTrue = {true, true, true, true, true, true, true, true, true};
    boolean[] cardSelectedFalse = {false, false, false, false, false, false, false, false, false};
    model.init();
    boolean[] cardSelected = (boolean[])model.get("cardSelected");
    Assertions.assertArrayEquals("cardSelectedBeforeClearAll", cardSelectedFalse, cardSelected);
    model.set("cardSelected", cardSelectedTrue);
    messenger.notify("view:clearAll");
    cardSelected = (boolean[])model.get("cardSelected");
    Assertions.assertArrayEquals("cardSelectedAfterClearAll", cardSelectedFalse, cardSelected);
  }

  /**
   * Test of view:clearAll message, of class Model.
   */
  public static void testCardClicked() {
    Messenger messenger = new Messenger();
    Model model = new Model(messenger);
    boolean[] cardSelected1 = {false, false, false, false, false, false, false, false, false};
    boolean[] cardSelected2 = {false, false, true, false, false, false, false, false, false};
    model.init();
    boolean[] cardSelected = (boolean[])model.get("cardSelected");
    Assertions.assertArrayEquals("cardSelectedBeforeCardClicked", cardSelected1, cardSelected);
    messenger.notify("view:cardClicked", 2);
    cardSelected = (boolean[])model.get("cardSelected");
    Assertions.assertArrayEquals("cardSelectedAfterCardClicked", cardSelected2, cardSelected);
  }

  /**
   * Test of view:play message, of class Model.
   */
  public static void testPlay() {
    Messenger messenger = new Messenger();
    Model model = new Model(messenger);
    model.init();
    messenger.notify("view:cardClicked", 2);
    messenger.notify("view:cardClicked", 5);
    Card[] board = (Card[])model.get("board");
    String card2 = board[2].toString();
    String card5 = board[5].toString();
    messenger.notify("view:play");
    board = (Card[])model.get("board");
    Assertions.assertNotEquals("boardValue1", card2, board[2].toString());
    Assertions.assertNotEquals("boardValue2", card5, board[5].toString());
    boolean[] cardSelected = (boolean[])model.get("cardSelected");
    for (int i=0; i<cardSelected.length; i++) {
      Assertions.assertFalse("cardSelected", cardSelected[i]);
    }
  }

  public void messageHandler(String messageName, Object messagePayload) {
    
  }
  
}
