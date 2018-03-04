package blackjack01;

import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args){

        System.out.println("Welcome to Blackjack");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);
        //System.out.println(playingDeck);

    }
}
