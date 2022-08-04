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
  private Iterator<Card> drawIterator;


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
    drawIterator = null; //NOTE: Once you shuffle your cards, you have to start over and draw from the top.
  }

  public void sort(){
    sort(null);//NOTE when you pass in null it uses the natural order to sort. This first one invokes the second and may pass in a null value.
    drawIterator  = null; //NOTE if you resort the deck, stop where ever you are and start drawing from the top again.
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

  public int size(){
    return cards.size();
  }

  public boolean isEmpty(){
    return drawIterator != null && !drawIterator.hasNext(); //NOTE if there's no next card to draw from and or null, you know cards are used up its true the cards are used up.
  }

  public Card draw(){
    if(drawIterator == null){
      drawIterator = cards.iterator(); //NOTE this creates a new iterator when you invoke the draw method to start the game. Only starts if the value is null.
    }
    return drawIterator.next();
  }

}
