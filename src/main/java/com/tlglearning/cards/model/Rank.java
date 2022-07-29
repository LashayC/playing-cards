package com.tlglearning.cards.model;

public enum Rank {

  //NOTE the order of enums matter. They are the default natural order that other methods will see them as.
  //NOTE For Rank its in descending order and Suits is in alphabetical order.
  ACE("A"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  ONE("1"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");

private final String symbol;


  Rank(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
