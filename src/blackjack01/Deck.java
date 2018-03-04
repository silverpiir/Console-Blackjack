package blackjack01;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    // Constructor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck(){
        // Generate deck of 52 cards
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public String toString(){
        String cardListOutput = "";
        for(Card aCard : this.cards){
            cardListOutput += "\n" + aCard.toString();
        }
        return cardListOutput;
    }

    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

}
