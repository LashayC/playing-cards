package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.strategy.RankFirstComparator;
import java.security.SecureRandom;
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

    deck.sort(new RankFirstComparator());
    System.out.println("Rank first sorter"+ deck);
  }

}
