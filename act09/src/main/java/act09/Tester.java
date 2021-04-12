/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */
package act09;

import assertions.Assertions;
import java.util.Arrays;
import javax.swing.JLabel;

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
    testUIVariables();
    Assertions.summary();
  }
  
  public static void testUIVariables() {
    View instance = new View(null);
    instance.init();
    String[] vars = {"card1","card2","card3","card4","card5","card6","card7","card8","card9",
      "cardsLeft","directionsLabel","gamesPlayed","gamesWon","numberOfCardsLabel",
      "numberOfGamesPlayedLabel","numberOfGamesWonLabel"};
    for (String var : vars) {
      Assertions.assertEquals(var+" is a JLabel", instance.get(var).getClass().getSimpleName(), "JLabel");
    }
    for (int i=1; i<=9; i++) {
      Assertions.assertEquals("card"+i+" has a name of "+(i-1), ((JLabel)instance.get("card"+i)).getName(), Integer.toString(i-1));
    }
    Assertions.assertEquals("cards is a JLabel array", instance.get("cards").getClass().getSimpleName(), "JLabel[]");
    Assertions.assertEquals("clearAllBtn is a JButton", instance.get("clearAllBtn").getClass().getSimpleName(), "JButton");
    Assertions.assertEquals("newGameBtn is a JButton", instance.get("newGameBtn").getClass().getSimpleName(), "JButton");
    Assertions.assertEquals("playBtn is a JButton", instance.get("playBtn").getClass().getSimpleName(), "JButton");
  }

}
