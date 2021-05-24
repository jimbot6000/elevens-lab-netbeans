/*
 * Copyright 2018 Roger Jaffe
 * All rights reserved
 */

package act03;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.  See the code in 
   * Tester.java for an example of how the interleaving works.
	 * @param values is an array of integers simulating cards to be shuffled.
   * @return the shuffled array
	 */
	public static int[] perfectShuffle(int[] values) {
		int n = values.length;
		int[] shuffled = new int[n];
		int k = 0;
		int m = n - (n/2) - 1; //this is dum but also cool
		for(int j = 0; j <= m; j++) {
			shuffled[k] = values[j];
			k+=2;
		}
		k = 1;
		for(int j = m+1; j < n; j++) {
			shuffled[k] = values[j];
			k+=2;
		}
		return shuffled;
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
   * @return the shuffled array
	 */
	public static int[] selectionShuffle(int[] values) {
		int n = values.length;
		int j;
		for(int k = n-1; k > 0; k--) {
			j = (int)(Math.random() * (k+1));
			int temp = values[k];
			values[k] = values[j];
			values[j] = temp;
		}
		
		return values;
	}
}
