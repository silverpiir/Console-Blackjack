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
        int i = 0;
        for(Card aCard : this.cards){
            cardListOutput += "\n" + i + " - " + aCard.toString();
            i++;
        }
        return cardListOutput;
    }



}
