package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom(); //NOTE SecureRandom is a subclass of random to get a random number. The difference between this and the default shuffle is that you get stronger randomness.
    System.out.println(deck);
    deck.shuffle(rng);
    System.out.println(deck);

//    for(Card card : deck){
//      System.out.println(card);
//    }

    deck.sort(); //NOTE shows it put back in natural order.
    System.out.println(deck);

    deck.sort(new RankFirstComparator());//TIP: Implementing a strategy here with RankFirstComparator
    System.out.println("Rank first sorter"+ deck);
  }

   static class RankFirstComparator implements Comparator<Card> {
    //NOTE: For Nested classes if they don't need to be nonstatic, make it static. Since it doesn't need access to anything outside of it, you can leave static. You can also make private as well\
    //NOTE: Things in a static context can only access other things in the same class thats also static.
    //NOTE: without public, methods in classes are package private by default.
    @Override
    public int compare(Card card1, Card card2) {
      int comparison = card1.getRank().compareTo(card2.getRank());//NOTE we're using the comparator here because the enum implements Comparator and should be able to compare itself.
      if(comparison == 0){ //TIP if the comparator returns 0, it means their the same and you can then check suits.
        comparison = card1.getSuit().compareTo(card2.getSuit());
      }
      return comparison;
    }
    //NOTE this is an example of a strategy.. Rather than creating subclasses of Deck that sort in different way, it used comparators to provide a different strategy of comparator. You can now just use this to keep changing the way the deck is sorted.
  }
}
