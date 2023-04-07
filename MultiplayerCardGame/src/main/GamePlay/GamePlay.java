package main.GamePlay;

import main.GameEntity.Card;
import main.GameEntity.Deck;
import main.GameEntity.Player;

import java.util.ArrayList;
import java.util.Scanner;


public class GamePlay {

    private ArrayList<Card> deck;

    private ArrayList<Player> players;
    private ArrayList<Card> discardPile;

    private ArrayList<Card> drawPile;

    


    public void StartGame() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players max upto 4 and minimum 2");
        int numOfPlayers = sc.nextInt();

        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new Exception("Invalid number of players ... Sorry!");
        }

        deck = new Deck().getDeckOfCard();

        players = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            Player p = new Player(i);

            for (int j = 1; j <= 5; j++) {
                p.addCards(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
            players.add(p);

        }
        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);
        drawPile = new ArrayList<>();
        for (Card c : deck) {
            drawPile.add(c);
        }

        int playerTurn = 0;
        int dirs = 1;

        int CardTake = 1;

        while (true) {
            if (drawPile.size() < CardTake) {
                System.out.println("Game drawn !!");
                break;
            }

            playerTurn %= numOfPlayers;
            if (playerTurn < 0) playerTurn += numOfPlayers;
            playerTurn %= numOfPlayers;
            boolean matched = false;
            int matchNum = -1;
            Card topDiscardCard = discardPile.get(discardPile.size() - 1);
            System.out.println("Discard deck top card = " + discardPile.get(discardPile.size() - 1));
            for (Card currentCard : players.get(playerTurn).getCard()) {

                if (currentCard.getNumbers() == topDiscardCard.getNumbers() || currentCard.getSuit() == topDiscardCard.getSuit()) {

                    if (topDiscardCard.getNumbers() == 1 || topDiscardCard.getNumbers() == 11 || topDiscardCard.getNumbers() == 12 || topDiscardCard.getNumbers() == 13) {
                        if (currentCard.getNumbers() == topDiscardCard.getNumbers())
                            continue;
                    }
                    System.out.println("Cards matched for player " + players.get(playerTurn).getId() + " Card and new Discard Deck top card = " + currentCard);

                    if(CardTake > 1){
                        while (CardTake > 0) {
                            System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");

                            players.get(playerTurn).addCards(drawPile.get(drawPile.size() - 1));
                            drawPile.remove(drawPile.size() - 1);
                            CardTake -= 1;
                        }
                        CardTake = 1;
                    }
                    players.get(playerTurn).removeCard(currentCard);
                    discardPile.add(currentCard);
                    matched = true;
                    matchNum = currentCard.getNumbers();
                    break;
                }
            }

            if (matched == false) {
                System.out.println("No cards match for player " + players.get(playerTurn).getId() + " Taking " + CardTake + " Card(s)");

                while (CardTake > 0) {
                    System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                    players.get(playerTurn).addCards(drawPile.get(drawPile.size() - 1));
                    drawPile.remove(drawPile.size() - 1);
                    CardTake -= 1;
                }
                CardTake = 1;
            }
            if (matched == true && players.get(playerTurn).getCard().size() == 0) {

                System.out.println("Congrats player " + players.get(playerTurn).getId() + " won the match !!");

                System.exit(0);
            }

            if (matched == true && matchNum == 1) {
                playerTurn += dirs;
            }
            if (matched == true && matchNum == 13) {
                dirs *= -1;
            }


            if (matched == true && matchNum == 11) {
                CardTake = 4;
            }
            if (matched == true && matchNum == 12) {
                CardTake = 2;
            }

            playerTurn += dirs;

            System.out.println("==============");
        }


    }




}
