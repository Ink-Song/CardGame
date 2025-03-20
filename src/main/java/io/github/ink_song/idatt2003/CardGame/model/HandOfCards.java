package io.github.ink_song.idatt2003.CardGame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandOfCards {
  private List<Card> cards;

  public HandOfCards(Card[] cards) {
    this.cards = new ArrayList<>();
    for (Card card : cards) {
      addCardToHand(card);
    }
  }
  public List<Card> getCards() {
    return cards;
  }
  public Card[] getCardsAsArray() {
    return cards.toArray(new Card[0]);
  }
  public void setCards(List<Card> cards) {
    this.cards = cards;
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

  public Card[] findCardsByType(char type){
    return cards.stream().filter(card -> card.getSuite() == type).toArray(Card[]::new);
  }
  public int countCardValue(){
    return cards.stream().mapToInt(Card::getValue).sum();
  }
  public boolean hasQueenOfSpades(){
    Optional<Card> foundCard = cards.stream().filter(card -> card.getSuite() == 'S' && card.getValue() == 12).findFirst();
    return foundCard.isPresent();
  }

  public boolean hasFlush(){
    Optional<Character> suite = cards.stream().findFirst().map(Card::getSuite);
    if(suite.isPresent()){
      Card[] foundCards = findCardsByType(suite.get());
      return foundCards.length == cards.size();
    } else{
      return false;
    }
  }



}
