package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Suit;
import com.tlglearning.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Trick {

  private static final String TALLY_FORMAT = "%1$s pile contains %2$d %1$s cards: %3$s.%n";

  public static void main(String[] args) {
    //DONE instance of deck and shuffle it.
    Random rng = new SecureRandom();
    Deck deck = buildDeck(rng);//NOTE this was extracted out to a method because you want IntelliJ to new what instance of deck it'll be working on in this class... I think

    //DONE Draw cards from the deck until none remain, and split the cards into red and black piles.
    List<Card> blackPile = new ArrayList<>(); //NOTE as a rule, if you're going to sort and shuffle, you wanna use an arrayList for the Instance type. The reference still should still be general
    List<Card> redPile = new ArrayList<>();
    splitDeck(deck, blackPile, redPile); //NOTE extracted this out to splitDeck method. We're doing this so each method is responsible for one task, easy to change. Good code conduct.

    //DONE Swap a random number of cards between red and black piles.
    swapCards(rng, blackPile, redPile);

    //Done Tally count of red cards in red pile, black cards in black pile, and print result. (Order black then red)
    tallyPiles(blackPile, redPile);


  }


  private static Deck buildDeck(Random random) {
    Deck deck = new Deck();
    deck.shuffle(random);//NOTE you can add the new SecureRandom to get high-quality source of randomness
    return deck;
  }

  private static void swapCards(Random rng, List<Card> blackPile, List<Card> redPile) {
    int swapCount = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size())); //NOTE gets a random number between 0 and the lowest number from either pile. +1 ensures that its 0 through 10
    for(int i = 0; i < swapCount; i++){
      redPile.add(blackPile.remove(0)); //NOTE remove is taking card from beginning of blackpile and adding it to end of red pile
      blackPile.add(redPile.remove(0));
    }
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

  private static void tallyPiles(List<Card> blackPile, List<Card> redPile) {
    int blackCount = (int) blackPile
        .stream()
        .filter((card) -> card.getSuit().getColor() == Color.BLACK)
        .count();
    blackPile.sort(
        Comparator
            .comparing(Card::getSuit, Comparator.comparing(Suit::getColor)) //NOTE first arg (key extractor) says this is what we're comparing, add a comma,  2nd arg says this is what we're using for the order
            .thenComparing(Comparator.naturalOrder())
    );

    int redCount = (int) redPile
        .stream()
        .filter((card) -> card.getSuit().getColor() == Color.RED)
        .count();
    redPile.sort(
        Comparator
            .comparing(Card::getSuit, Comparator.comparing(Suit::getColor).reversed()) //NOTE this reverses it so instead of natural order made in enum Suit of Black then red, it goes backwards.
            .thenComparing(Comparator.naturalOrder())
    );

    System.out.printf(TALLY_FORMAT, Color.BLACK, blackCount, blackPile);
    System.out.printf(TALLY_FORMAT, Color.RED, redCount, redPile);
  }

}
