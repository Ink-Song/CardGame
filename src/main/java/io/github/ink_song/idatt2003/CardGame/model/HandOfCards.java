package io.github.ink_song.idatt2003.CardGame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandOfCards {
  List<Card> cards;

  public HandOfCards(Card[] cards) {
    for (Card card : cards) {
      addCardToHand(card);
    }
  }
  public List<Card> getCards() {
    return cards;
  }

  public void addCardToHand(Card card) {
    cards.add(card);
  }
  public void removeCardFromHand(Card card) {
    cards.remove(card);
  }
  public void emptyHand(){
    cards.clear();
  }

  //Supposed to use streams for this. Don't do whatever all of this is. Look into streams tomorrow after math is finished.
//  public Card[] findCardsByType(char type){
//    ArrayList<Card> foundCards = new ArrayList<Card>();
//    for (Card card : cards) {
//      if(card.getSuite() == type){
//        foundCards.add(card);
//      }
//    }
//    Card[] returnedCards = new Card[foundCards.size()];
//    returnedCards = foundCards.toArray(returnedCards);
//    return returnedCards;
//  }

  public List<Card> findCardsByType(char type){
    return cards.stream().filter(card -> card.getSuite() == type).collect(Collectors.toList());
  }
  public int countCardValue(){
    return cards.stream().mapToInt(Card::getValue).sum();
  }

//  public boolean hasCardOf(char type, int value){
//
//  }

  // function for checking for a flush (or any specific combination perhaps?)


}
