package io.github.ink_song.idatt2003.CardGame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
  DeckOfCards deck = new DeckOfCards();

  @Test
  void dealCards() {
    Card[] cards = deck.dealCards(10);
    for (Card card : cards) {
      System.out.println(card.getCardInfo());
    }
  }
}