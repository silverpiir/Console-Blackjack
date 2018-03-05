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

        while(playerMoney>0){
            System.out.println("You have $" + playerMoney);
            System.out.println("How much would you like to bet?");
            double playerBet = userInput.nextDouble();

            if(playerBet>playerMoney){
                System.out.println("You don't have that much money!");
                System.out.println("How much would you like to bet?");
                playerBet = userInput.nextDouble();
            }

            boolean endRound = false;

            // Card dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while(true){
                System.out.print("Your hand: ");
                System.out.print(playerDeck.toString());
                System.out.println("\nYour hand is valued at: " + playerDeck.cardsValue() + "\n");

                System.out.println("Dealer's hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");

                System.out.println("Would you like to (1)Hit or (2)Stand?");
                int response = userInput.nextInt();

                if(response == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You drew a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("Bust. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }

                if(response == 2){
                    break;
                }
            }
        }

        System.out.println("You are out of money!");

    }
}
