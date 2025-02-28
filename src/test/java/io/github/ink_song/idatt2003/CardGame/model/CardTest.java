package io.github.ink_song.idatt2003.CardGame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CardTest {
  Card testCard = new Card('H',12);

  @Test
  void getCardInfo() {
    assertEquals("H12", testCard.getCardInfo());
  }
}