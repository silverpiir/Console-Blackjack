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
            System.out.println("How much would you like to bet? (0 to exit)");
            double playerBet = userInput.nextDouble();

            if(playerBet>playerMoney){
                System.out.println("You don't have that much money!");
                System.out.println("How much would you like to bet?");
                playerBet = userInput.nextDouble();
            }else if(playerBet == 0){
                break;
            }

            boolean endRound = false;

            // Card dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            //Game loop
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
                        System.out.println("Bust! Currently valued at: " + playerDeck.cardsValue() + ". You lost $" + playerBet);
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }

                if(response == 2){
                    break;
                }
            }

            System.out.println("Dealer cards: " + dealerDeck.toString());
            System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());

            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false){
                System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());
                System.out.println("Dealer beats you.");
                playerMoney -= playerBet;
                endRound = true;
            }
            //Dealer hits at 16 and stands at 17
            while(dealerDeck.cardsValue() < 17 && endRound == false){
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }

            //TODO if player hits blackjack, win 1,5x money

            if(dealerDeck.cardsValue() > 21  && endRound == false){
                System.out.println("Dealer busts! You win $" + playerBet*2);
                playerMoney += playerBet;
                endRound = true;
            }

            if(playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound == false){
                System.out.println("Push.");
                endRound = true;
            }

            if(playerDeck.cardsValue() > dealerDeck.cardsValue() && endRound == false){
                System.out.println("You win! Winnings: $" + playerBet*2);
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.\n------------------------------------");
        }

        System.out.println("Game over.");

    }
}
