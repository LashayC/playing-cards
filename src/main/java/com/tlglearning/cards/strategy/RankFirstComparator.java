package com.tlglearning.cards.strategy;

import com.tlglearning.cards.model.Card;
import java.util.Comparator;

public class RankFirstComparator implements Comparator<Card>{

  @Override
  public int compare(Card card1, Card card2) {
    int comparison = card1.getRank().compareTo(card2.getRank());//NOTE we're using the comparator here because the enum implements Comparator and should be able to compare itself.
    if(comparison == 0){ //TIP if the comparator returns 0, it means their the same and you can then check suits.
      comparison = card1.getSuit().compareTo(card2.getSuit());
    }
    return comparison;
  }
}
