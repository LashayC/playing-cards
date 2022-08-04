package com.tlglearning.cards.model;

import java.awt.Color;

public enum Suit {
//  public static final Suit CLUBS - new Suit(symbol); NOTE this code shows that each enum is actually an instance of Suit using a constructor

  CLUBS('\u2663', Color.BLACK), //NOTE No fields can come before the enum list, only after. Enums also can't start with numbers.
  DIAMONDS('\u2662', Color.RED),
  HEARTS('\u2661', Color.RED),
  SPADES('\u2660', Color.BLACK);

  private final char symbol; //NOTE final fields are assigned a single value during initialization, dassit.
  private final Color color;

  Suit(char symbol, Color color) { //NOTE all enum constructors are private.
    this.symbol = symbol;
    this.color = color;
  }
  public char getSymbol() {
    return symbol;
  }

  public Color getColor() {
    return color;
  }

  public enum Color {
    BLACK, RED
  }



}
