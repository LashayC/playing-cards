package com.tlglearning.cards.model;

import java.util.Comparator;
import java.util.Objects;

public class Card implements Comparable<Card>{

    private final Rank rank;

    private final Suit suit;

    private final String representation;

    private final int hash;

    public Card(Rank rank, Suit suit) {
      this.rank = rank;
      this.suit = suit;
      representation = rank.getSymbol() + suit.getSymbol();
      hash = Objects.hash(rank, suit);
    }

    public Rank getRank() {
      return rank;
    }

    public Suit getSuit() {
      return suit;
    }

    @Override
    public int hashCode() {
      return hash;
    }
    @Override
    public boolean equals(Object obj) {
      boolean result;
      if(this == obj){ //NOTE if this current obj is pointing at the same reference of obj, you know they're equal by default
        result = true;
      }else if(obj instanceof Card){ //NOTE if obj is an instance of Card you can cast a Card in order to access the fields and behaviors of a card then compare.
        Card other  = (Card) obj; //NOTE you cast the Card here so you can access those methods and behaviors
        result = (rank == other.rank && suit == other.suit); //NOTE now you can compare between this object and another instance of Card
      }else{
        result = false;
      }

      return result;
    }

    @Override
    public String toString() {
      return representation;
    }

    @Override
    public int compareTo(Card other) {
//      int comparison = suit.compareTo(other.suit);
//
//      if(comparison == 0){
//        comparison = rank.compareTo(other.rank);
//      }
//        return comparison;
      return Comparator
          .comparing(Card::getSuit)
          .thenComparing(Card::getRank)
          .compare(this,other); //NOTE don't know why this was changed at alllllll
    }


}

