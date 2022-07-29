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

    //NOTE still this is an example of a strategy.. Rather than creating subclasses of Deck that sort in different way, it used comparators to provide a different strategy of comparator. You can now just use this to keep changing the way the deck is sorted.
    //NOTE replaced lambda with Camparator chain.

    deck.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
    System.out.println("Rank first sorter"+ deck); //NOTE a method reference is any method that takes none or 1 param. That's what the :: do here. (A method reference is still a lambda, jus dif syntax)
    //NOTE: Because the param on the left side is also being used to invoke a method on the left side, you know the param has all the info needed for the method. You can condense it
    //NOTE: and tell it to just use the left side to invoke the method on the left. You also exclude the curly braces on the right bc you're just telling the compiler that when its time to invoke the method left side will invoke the method.
    //NOTE: You can do this w/ mult params as well as long as the order is right and its implementing a Functional object(An object that implements Function(T t) class)

//    deck.sort(Comparator
//        .comparing((Card card) -> card.getRank()) //NOTE you can expand the method reference out to 2 lambdas by right clicking on Card and expanding it.
//        .thenComparing(card1 -> card1.getSuit()));
//    System.out.println("Rank first sorter"+ deck);

  }

}
