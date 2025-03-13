package io.github.ink_song.idatt2003.CardGame.controller;

import io.github.ink_song.idatt2003.CardGame.model.*;

import java.util.Arrays;

public class GameController {
  private DeckOfCards deckOfCards;
  private HandOfCards handOfCards;
  private int DEFAULT_HAND_SIZE = 5;

  public String getHandOfCardsAsString(){
    return Arrays.toString(handOfCards.getCardsAsArray());
  }
  public GameController() {
    deckOfCards = new DeckOfCards();
  }

  public void dealCards(){
    handOfCards = new HandOfCards(deckOfCards.dealCards(DEFAULT_HAND_SIZE));
  }

  public String analyzeCards(){
    StringBuilder builder = new StringBuilder();
    char[] chars = new char[]{'H', 'C', 'D', 'S'};
    if(handOfCards!=null){
      builder.append("Total Value of Cards: " + handOfCards.countCardValue());
      builder.append("\n");
      builder.append("Heart Cards: " + Arrays.toString(handOfCards.findCardsByType('H')));
      builder.append("\n");
      builder.append("Queen of Spades: " + handOfCards.hasQueenOfSpades());
      builder.append("\n");
      if(handOfCards.hasFlush()){
        char suite = handOfCards.getCards().getFirst().getSuite();
        builder.append("Flush: " + suite);
      } else{
        builder.append("Flush: None!");
      }

    }
    return builder.toString();
  }

}
