package io.github.ink_song.idatt2003.CardGame.model;

import java.util.Random;

public class DeckOfCards {
  private final Card[] deck;
  private final char[] suite = {'S','H','D','C'};
  private final Random rand = new Random();
  public DeckOfCards() {
    deck = new Card[52];
    int index = 0;
    for (int i = 0; i < suite.length; i++) {
      for (int j = 1; j < 14; j++) {
        deck[index] = new Card(suite[i], j);
        index++;
      }
    }
  }

  public Card[] getDeck() {
    return deck;
  }

  public Card[] dealCards(int handSize){
    Card[] cards = new Card[handSize];
    int[] generatedCards = generateRandomNumbers(handSize);
    for (int i = 0; i < handSize; i++) {
      cards[i] = deck[generatedCards[i]];
    }
    return cards;
  }

  private int[] generateRandomNumbers(int amount){
    rand.setSeed(System.currentTimeMillis());
    int[] numbers = new int[amount];
    int currentIteration = 0;
    do{
      numbers[currentIteration] = rand.nextInt(51);
      boolean isUnique = true;
      for (int i = 0; i < amount; i++) {
        if(currentIteration == i){

        }
        else if(numbers[currentIteration] == numbers[i]){
          isUnique = false;
        }
      }
      if(isUnique){
        currentIteration++;
      }
    }while (currentIteration < amount);
    return numbers;
  }
}
