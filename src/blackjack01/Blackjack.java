package blackjack01;

public class Blackjack {

    public static void main(String[] args){

        System.out.println("Welcome to Blackjack");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        System.out.println(playingDeck);

    }
}
