package com.tlglearning.cards.model;

public enum Suit {
//  public static final Suit CLUBS - new Suit(symbol); NOTE this code shows that each enum is actually an instance of Suit using a constructor

  CLUBS('\u2663'), //NOTE No fields can come before the enum list, only after. Enums also can't start with numbers.
  DIAMONDS('\u2662'),
  HEARTS('\u2661'),
  SPADES('\u2660');

  private final char symbol; //NOTE final fields are assigned a single value during initialization, dassit.

  Suit(char symbol) { //NOTE all enum constructors are private.
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }
}
