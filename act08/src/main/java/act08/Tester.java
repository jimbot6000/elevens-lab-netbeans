/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act08;

import assertions.Assertions;
import java.util.Arrays;

/**
 *
 * @author Roger Jaffe
 */
public class Tester {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Assertions.begin("Model testing");
    testNewGame();
    testIsLegalMoveSelected();
    testLegalMovesAvailable();
    testIsGameOver1();
    testIsGameOver2();
    Assertions.summary();
  }
  
  public static void testNewGame() {
    Model model = new Model(null);
    model.init();
    model._newGame();
    Card[] board = (Card[])model.get("board");
    for (Card card : board) {
      Assertions.assertNotNull("New game: First board space has a card", card);
    }
    Assertions.assertEquals("gameStatus is IN_PLAY", (int)model.get("gameStatus"), Constants.IN_PLAY);    
  }
  
  public static void testIsLegalMoveSelected() {
    Model model = new Model(null);
    model.init();
    Card[] board = new Card[Constants.BOARD_SIZE];
    String suit = "clubs";
    String[] ranks = {"0","1","2","3","4","5","6","7","8"};
    int[] pointValues = {0,1,2,3,4,5,6,7,8};
    for (int i=0; i<Constants.BOARD_SIZE; i++) {
      board[i] = new Card(ranks[i], suit, pointValues[i]);
    }
    model.set("board", board);
    boolean[] cardSelected = new boolean[Constants.BOARD_SIZE];
    cardSelected[5] = true;
    cardSelected[6] = true;
    model.set("cardSelected", cardSelected);
    Assertions.assertTrue("Cards 5 and 6 should pass", model._isLegalMoveSelected());
    cardSelected[5] = false;
    cardSelected[4] = true;
    model.set("cardSelected", cardSelected);
    Assertions.assertFalse("Cards 4 and 6 should not pass", model._isLegalMoveSelected());
    board[0] = new Card("jack", "clubs", 0);
    board[2] = new Card("queen", "clubs", 0);
    board[5] = new Card("king", "clubs", 0);
    cardSelected[4] = false;
    cardSelected[6] = false;
    cardSelected[0] = true;
    cardSelected[2] = true;
    cardSelected[5] = true;
    model.set("cardSelected", cardSelected);
    Assertions.assertTrue("A jack, queen, king should pass", model._isLegalMoveSelected());    
  }
  
  public static void testLegalMovesAvailable() {
    Model model = new Model(null);
    model.init();
    Card[] board = new Card[Constants.BOARD_SIZE];
    String suit = "clubs";
    String[] ranks = {"0","1","2","3","4","5","6","7","8"};
    int[] pointValues = {0,1,2,3,4,5,6,7,8};
    for (int i=0; i<Constants.BOARD_SIZE; i++) {
      board[i] = new Card(ranks[i], suit, pointValues[i]);
    }
    model.set("board", board);   
    Assertions.assertTrue("0,1,2,3,4,5,6,7,8 legal moves exist", model._legalMovesAvailable());

    String[] ranks2 = {"0","6","6","7","7","8","8","8","8"};
    int[] pointValues2 = {0,6,6,7,7,8,8,8,8};
    for (int i=0; i<Constants.BOARD_SIZE; i++) {
      board[i] = new Card(ranks2[i], suit, pointValues2[i]);
    }
    model.set("board", board);   
    Assertions.assertFalse("0,6,6,7,7,8,8,8,8 legal moves do not exist", model._legalMovesAvailable());
  }
  
  public static void testIsGameOver1() {
    Model model = new Model(null);
    model.init();
    Card[] board = new Card[Constants.BOARD_SIZE];
    String suit = "clubs";
    String[] ranks = {"0","1","2","3","4","5","6","7","8"};
    int[] pointValues = {0,1,2,3,4,5,6,7,8};
    for (int i=0; i<Constants.BOARD_SIZE; i++) {
      board[i] = new Card(ranks[i], suit, pointValues[i]);
    }
    model.set("board", board);   
    Assertions.assertFalse("moves available and not empty deck", model._isGameOver());    
  }
  
  public static void testIsGameOver2() {
    Model model = new Model(null);
    model.init();
    Card[] board = new Card[Constants.BOARD_SIZE];
    String suit = "clubs";
    String[] ranks = {"0","6","6","6","6","7","7","8","8"};
    int[] pointValues = {0,6,6,6,6,7,7,8,8};
    for (int i=0; i<Constants.BOARD_SIZE; i++) {
      board[i] = new Card(ranks[i], suit, pointValues[i]);
    }
    model.set("board", board);   
    Assertions.assertTrue("moves not available and not empty deck", model._isGameOver());    
  }
  
}
