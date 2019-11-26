package Tutorial_3;
import java.util.*;


public class assignment3 {

}

class Solution {
  /**
   * Shuffles a deck of cards. This is done by splitting the existing deck into two halves, L1 and L2.
   * The two halves will be merged back together by taking alternating elements from L1 and L2.
   * Where the order is as follows:
   * first element of L1, first element of L2, second element of L1, second element of L2, and so forth.
   *
   * @param deck
   * @return
   */
  public static List<Card> cardShuffle(List<Card> deck) {
    List<Card> result = new ArrayList<Card>();
    
    int fronPointer = 0;
    int backPointer = (deck.size() / 2);
    
    for (int i = 0 ; i < deck.size(); i++){
      if(i % 2 == 0) {
    	 result.add(i, deck.get(fronPointer));
    	 fronPointer++;
      } else {
    	  result.add(i, deck.get(backPointer));
    	  backPointer++;
      }
    }
    return result;
    
  }
}

class Card {

	  public Num number;

	  public Suit suit;

	  public Card(Num number, Suit suit) {
	    this.number = number;
	    this.suit = suit;
	  }

	  public Card(int number, int suit) {
	    this.number = Num.get(number);
	    this.suit = Suit.get(suit);
	  }

	  public String toString() {
	    return this.number.toString().toLowerCase() + " of " + this.suit.toString().toLowerCase();
	  }
	  
	  public boolean equals(Object other) {
	    if (other instanceof Card) {
	      Card that = (Card) other;
	      return this.number.equals(that.number) && this.suit.equals(that.suit);
	    }
	    return false;
	  }
	}

	enum Suit {

	  DIAMONDS(0), CLUBS(1), HEARTS(2), SPADES(3);

	  private static final Map<Integer, Suit> lookup = new HashMap<>();

	  static {
	    for (Suit s : EnumSet.allOf(Suit.class)) {
	      lookup.put(s.getCode(), s);
	    }
	  }

	  private int code;

	  Suit(int code) {
	    this.code = code;
	  }

	  public int getCode() {
	    return this.code;
	  }

	  public static Suit get(int code) {
	    return lookup.get(code);
	  }
	}

	enum Num {

	  ACE(1),
	  TWO(2),
	  THREE(3),
	  FOUR(4),
	  FIVE(5),
	  SIX(6),
	  SEVEN(7),
	  EIGHT(8),
	  NINE(9),
	  TEN(10),
	  JACK(11),
	  QUEEN(12),
	  KING(13);

	  private static final Map<Integer, Num> lookup = new HashMap<>();

	  static {
	    for (Num n : EnumSet.allOf(Num.class)) {
	      lookup.put(n.getCode(), n);
	    }
	  }

	  private int code;

	  Num(int code) {
	    this.code = code;
	  }

	  public int getCode() {
	    return this.code;
	  }

	  public static Num get(int code) {
	    return lookup.get(code);
	  }
	}


