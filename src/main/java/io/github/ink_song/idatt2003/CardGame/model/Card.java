package io.github.ink_song.idatt2003.CardGame.model;

public class Card {
  private final char suite;
  private final int value;
  public Card(char suite , int value) {
    this.suite = suite;
    this.value = value;
  }
  public int getValue() {
    return value;
  }
  public char getSuite() {
    return suite;
  }

  public String getCardInfo(){
    return "" + suite + value;
  }
  @Override
  public String toString() {
    return "" + suite + value;
  }
}
