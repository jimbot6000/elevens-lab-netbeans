/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act07;

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
    Assertions.begin("State variables");
    testStateVariables();
    Assertions.summary();
  }
  
  public static void testStateVariables() {
    Model instance = new Model(null);
    instance.init();
    Assertions.assertEquals("stateVariables: gameStatus", instance.get("gameStatus").getClass().getSimpleName(), "Integer");
    Assertions.assertEquals("stateVariables: deck", instance.get("deck").getClass().getSimpleName(), "Deck");
    Assertions.assertEquals("stateVariables: board", instance.get("board").getClass().getSimpleName(), "Card[]");
    Assertions.assertEquals("stateVariables: cardSelected", instance.get("cardSelected").getClass().getSimpleName(), "boolean[]");
    Assertions.assertEquals("stateVariables: validSelection", instance.get("validSelection").getClass().getSimpleName(), "Boolean");
    Assertions.assertEquals("stateVariables: gameWon", instance.get("gameWon").getClass().getSimpleName(), "Boolean");
    Assertions.assertEquals("stateVariables: gamesWon", instance.get("gamesWon").getClass().getSimpleName(), "Integer");
    Assertions.assertEquals("stateVariables: gamesPlayed", instance.get("gamesPlayed").getClass().getSimpleName(), "Integer");
    
    Assertions.assertEquals("stateVariables: deck size", ((Deck)instance.get("deck")).size(), 52);
    Assertions.assertEquals("stateVariables: board size", ((Card[])instance.get("board")).length, Constants.BOARD_SIZE);
    Assertions.assertEquals("stateVariables: cardSelected size", ((boolean[])instance.get("cardSelected")).length, Constants.BOARD_SIZE);
  }
}
