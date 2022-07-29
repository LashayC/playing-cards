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


    deck.sort(new Comparator<Card>() {//NOTE you're now passing an instance of Comparator card directly into the .sort method. Now its an anonymous class.

      @Override
      public int compare(Card card1, Card card2) {
        int comparison = card1.getRank().compareTo(card2.getRank());
        if(comparison == 0){
          comparison = card1.getSuit().compareTo(card2.getSuit());
        }
        return comparison;
      }//NOTE this is an example of a strategy.. Rather than creating subclasses of Deck that sort in different way, it used comparators to provide a different strategy of comparator. You can now just use this to keep changing the way the deck is sorted.

    });
    System.out.println("Rank first sorter"+ deck);

  }

}
