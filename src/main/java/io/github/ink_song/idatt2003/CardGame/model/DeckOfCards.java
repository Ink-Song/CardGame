package io.github.ink_song.idatt2003.CardGame.model;

public class DeckOfCards {
  private final Card[] deck;
  private final char[] suite = {'S','H','D','C'};
  public DeckOfCards() {
    deck = new Card[52];
    int index = 0;
    for (int i = 0; i < suite.length; i++) {
      for (int j = 1; j < 13; j++) {
        deck[index] = new Card(suite[i], j);
        index++;
      }
    }
  }
}
