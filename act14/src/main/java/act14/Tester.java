/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act14;

import assertions.Assertions;
import com.mrjaffesclass.apcs.messenger.*;
import java.awt.Color;
import javax.swing.JButton;
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
    Assertions.begin("Model test");
    testCardsLeftInDeck();
    testGameStatus();
    testGamesPlayed();
    testGamesWon();
    testIsLegalMove();
    testModelBoardChanged();
    testModelSelectedCardsChanged();
    Assertions.summary();
  }
  
  /**
   * @param args the command line arguments
   */
  public static void testModelBoardChanged() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    JLabel[] cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      Assertions.assertNull("modelBoardChanged-1", cards[i].getIcon());
    }
    Card[] board = {
      new Card("ace", "hearts", 1),
      new Card("2", "hearts", 2),
      new Card("3", "hearts", 3),
      new Card("4", "hearts", 4),
      new Card("6", "hearts", 6),
      new Card("7", "hearts", 7),
      new Card("8", "hearts", 8),
      new Card("9", "hearts", 9),
      new Card("10", "hearts", 10),
    };
    messenger.notify("model:boardChanged", board);
    cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      Assertions.assertNotNull("modelBoardChanged-2-"+i, cards[i].getIcon());    
    }
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testModelSelectedCardsChanged() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    JLabel[] cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      Assertions.assertNull("modelSelectedCardsChanged-1-"+i, cards[i].getBorder());
    }
    boolean[] newSelectedCards = {true, true, false, true, false, false, false, false, false};
    messenger.notify("model:selectedCardsChanged", newSelectedCards);
    cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      if (i==0 || i==1 || i==3) {
        Assertions.assertNotNull("modelSelectedCardsChanged-2-"+i, cards[i].getBorder());
      } else {
        Assertions.assertNull("modelSelectedCardsChanged-3-"+i, cards[i].getBorder());
      }
    }
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testIsLegalMove() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    JButton playBtn = (JButton)view.get("playBtn");
    Assertions.assertTrue("initial state", playBtn.isEnabled());
    messenger.notify("model:isLegalMove", false);
    playBtn = (JButton)view.get("playBtn");
    Assertions.assertFalse("after model:isLegalMove", playBtn.isEnabled());
    messenger.notify("model:isLegalMove", true);
    playBtn = (JButton)view.get("playBtn");
    Assertions.assertTrue("after next model:isLegalMove", playBtn.isEnabled());
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testCardsLeftInDeck() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    messenger.notify("model:cardsLeftInDeck", 10);
    JLabel cardsLeft = (JLabel)view.get("cardsLeft");
    Assertions.assertEquals("model:cardsLeftInDeck", cardsLeft.getText(), "10");
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testGamesWon() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    messenger.notify("model:gamesWon", 10);
    JLabel gamesWon = (JLabel)view.get("gamesWon");
    Assertions.assertEquals("model:gamesWon", gamesWon.getText(), "10");
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testGamesPlayed() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    messenger.notify("model:gamesPlayed", 10);
    JLabel gamesPlayed = (JLabel)view.get("gamesPlayed");
    Assertions.assertEquals("model:gamesPlayed", gamesPlayed.getText(), "10");
  }

  /**
   * Test of model:boardChanged event handling, of class View.
   */
  public static void testGameStatus() {
    Messenger messenger = new Messenger();
    View view = new View(messenger);
    view.init();
    JLabel[] cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      Assertions.assertNull("model:gameStatus-1-"+i, cards[i].getBorder());
    }
    messenger.notify("model:gameStatus", Constants.YOU_LOSE);
    cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      LineBorder lb = (LineBorder)cards[i].getBorder();
      Assertions.assertEquals("model:gameStatus-2-"+i, lb.getLineColor(), Color.RED);
    }
    messenger.notify("model:gameStatus", Constants.YOU_WIN);
    cards = (JLabel[])view.get("cards");
    for (int i=0; i<cards.length; i++) {
      LineBorder lb = (LineBorder)cards[i].getBorder();
      Assertions.assertEquals("model:gameStatus-3-"+i, lb.getLineColor(), Color.GREEN);
    }
  }

}
