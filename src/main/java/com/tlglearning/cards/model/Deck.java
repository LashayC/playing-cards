package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable <Card> {

  private final List<Card> cards;
  private Random defaultRng;

  public Deck() {
    Suit[] suits = Suit.values();
    Rank[] ranks = Rank.values();
    cards = new ArrayList<>(suits.length * ranks.length);

    for(Suit suit : suits){
      for (Rank rank : ranks){
        Card card = new Card(rank, suit);//NOTE this will pair cards by rank and suit
        cards.add(card); //NOTE this will add it to the array
      }
    }

  }

  public void shuffle(){
    if(defaultRng == null){
      defaultRng = new Random();
    }
    shuffle(defaultRng);
  }

  public void shuffle(Random rng){
    Collections.shuffle(cards, rng);
  }

  public void sort(){
    sort(null);//NOTE when you pass in null it uses the natural order to sort. This first one invokes the second and may pass in a null value.
  }

  public void sort(Comparator<Card> comparator){
    cards.sort(comparator); //NOTE this may be called above with a null value. .sort is a method of List.
  }

  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

}