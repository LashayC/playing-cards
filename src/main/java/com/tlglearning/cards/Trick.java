package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trick {

  public static void main(String[] args) {
    //DONE instance of deck and shuffle it.
    Random rng = new SecureRandom();
    Deck deck = buildDeck();//NOTE this was extracted out to a method because you want IntelliJ to new what instance of deck it'll be working on in this class... I think

    //DONE Draw cards from the deck until none remain, and split the cards into red and black piles.
    List<Card> blackPile = new ArrayList<>(); //NOTE as a rule, if you're going to sort and shuffle, you wanna use an arrayList for the Instance type. The reference still should still be general
    List<Card> redPile = new ArrayList<>();
    splitDeck(deck, blackPile, redPile); //NOTE extracted this out to splitDeck method. We're doing this so each method is responsible for one task, easy to change. Good code conduct.

    //TODO Swap a random number of cards between red and black piles.


    //TODO Tally count of red cards in red pile, black cards in black pile, and print result. (Order red then black)







  }

  private static void splitDeck(Deck deck, List<Card> blackPile, List<Card> redPile) {
    while (!deck.isEmpty()){ //NOTE if deck is null, the iterator from draw won't compile.
      Card indicator = deck.draw();
//      Card next = deck.draw(); //NOTE you have the option of extracting deck.draw to a variable.
      if(indicator.getSuit().getColor() == Color.BLACK){ //NOTE use suit here first bc they're the ones with the color, not card.
        blackPile.add(deck.draw());
//        blackPile.add(next)
      }else{
        redPile.add(deck.draw());
//        blackPile.add(next)
      }

    }
  }

  private static Deck buildDeck(Random rng) {
    Deck deck = new Deck();
    deck.shuffle(rng);//NOTE you can add the new SecureRandom to get high-quality source of randomness
    return deck;
  }

}
