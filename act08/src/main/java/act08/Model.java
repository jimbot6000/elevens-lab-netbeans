package act08;

import com.mrjaffesclass.apcs.messenger.*;

/**
 * The model represents the data used by the Elevens game.
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;

  // Game state variables
  private int gameStatus;
  private Deck deck;
  private Card[] board;
  private boolean[] cardSelected;
  private boolean validSelection;
  private boolean gameWon;
  private int gamesWon;
  private int gamesPlayed;

  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    // This is for the messaging
    mvcMessaging = messages;    
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    // Create a new deck, new board array, and new cardSelected array to keep
    // track of the selected cards
    deck = new Deck(Constants.RANKS, Constants.SUITS, Constants.POINT_VALUES);
    board = new Card[Constants.BOARD_SIZE];
    cardSelected = new boolean[Constants.BOARD_SIZE];

    // Initialize the game counters
    gamesWon = 0;
    gamesPlayed = 0;    
  }
  
  /**
   * Initialize the model to start a new game
   */
  private void newGame() {
    // To be implemented in Activity 08
  }

  /**
   * Check to see if the selected cards represent a legal move
   * @return True if move is legal
   */
  private boolean isLegalMoveSelected() {
    // To be implemented in Activity 08
  }
  
  /**
   * Checks the board to see if there are legal plays available (but not
   * necessarily selected)
   * @return True if there are legal plays available
   */
  private boolean legalMovesAvailable() {
    // To be implemented in Activity 08
  }
  
  /**
   * Check to see if the game is over
   * @return True if the game is over
   */
  private boolean isGameOver() {
    // To be implemented in Activity 08
  }
  
  /**
   * The model must implement messageHandler so it can process
   * messages sent from the View.  messagePayload can be any object, but
   * it must be cast into the expected class.
   * @param messageName
   * @param messagePayload 
   */
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    switch (messageName) {
            
      default: {
        
      }
    }
  }
  
  /**
   * *********** FOR TESTING ONLY -- DO NOT CHANGE OR REMOVE ***********
   */
  public Object get(String prop) {
    switch (prop) {
      case "gameStatus": return gameStatus;
      case "deck":  return deck;
      case "board":  return board;
      case "cardSelected":  return cardSelected;
      case "validSelection": return validSelection;
      case "gameWon": return gameWon;
      case "gamesWon": return gamesWon;
      case "gamesPlayed": return gamesPlayed; 
      default: return null;
    }
  }
  
  public void set(String prop, Object val) {
    switch (prop) {
      case "gameStatus": gameStatus = (int)val; break;
      case "deck":  deck = (Deck)val; break;
      case "board": board = (Card[])val; break;
      case "cardSelected": cardSelected = (boolean[])val; break;
      case "validSelection":  validSelection = (boolean)val; break;
      case "gameWon":  gameWon = (boolean)val; break;
      case "gamesWon":  gamesWon = (int)val; break;
      case "gamesPlayed":  gamesPlayed = (int)val;  break;
      default:  ;
    }
  }
  
  public void _newGame() {
    newGame();
  }
  
  public boolean _isLegalMoveSelected() {
    return isLegalMoveSelected();
  }
  
  public boolean _legalMovesAvailable() {
    return legalMovesAvailable();
  }
  
  public boolean _isGameOver() {
    return isGameOver();
  }
  
}
