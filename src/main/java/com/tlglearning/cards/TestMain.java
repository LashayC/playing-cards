package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Rank;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom(); //NOTE SecureRandom is a subclass of random to get a random number. The difference between this and the default shuffle is that you get stronger randomness. Cryptographic
    Set<Rank> excludedCards = EnumSet.range(Rank.TWO, Rank.EIGHT);

    Spliterator<Card> splitter = Spliterators.spliterator(deck.iterator(), deck.size(), 0);
    List<Card> pinochleCards =  StreamSupport
        .stream(splitter, false)
        .filter((card) -> !excludedCards.contains(card.getRank()))
        .collect(Collectors.toList());

    System.out.println(pinochleCards);
  }

}
