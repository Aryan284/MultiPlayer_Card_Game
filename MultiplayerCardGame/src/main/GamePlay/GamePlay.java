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
        System.out.println("Enter the number of Players max upto 4 players and minimum 2: ");
        int numberOfPlayers = sc.nextInt();

//        Check invalid cases of less than or greater than limit of players

        if(numberOfPlayers < 2 || numberOfPlayers > 4){
            throw new Exception("Invalid number of players. Sorry!!");
        }
        deck = new Deck().getDeckOfCard();
        players = new ArrayList<>();

//        Adding Card of 5 to the given number of players

        for(int i = 1; i <= numberOfPlayers; i++){
            Player p = new Player(i);
            for (int j = 1; j <= 5; j++){
                p.addCards(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
            players.add(p);

        }
//        Game start: the first turn, the draw's top card will
//        serve as the top card or the opening card in the discard pile.

        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);

        //drawPile creation
        drawPile = new ArrayList<>();
        for(Card c: deck){
            drawPile.add(c);
        }
        int CardTake = 1;
        int dirs = 1;
        int playerTurn = 0;
        while (true){
//            Draw Case
            if(drawPile.size() < CardTake){
                System.out.println("Cards are less... Draw Game!");
                break;
            }
            playerTurn %= numberOfPlayers;
            if(playerTurn < 0){
                playerTurn += numberOfPlayers;
            }
            playerTurn %= numberOfPlayers;

            boolean match = false;
            int matchNum = -1;
            Card topDiscardCard = discardPile.get(discardPile.size() - 1);
            System.out.println("Top Card of Discard deck = " + discardPile.get(discardPile.size() - 1));

            for(Card currentCard: players.get(playerTurn).getCard()){
                if (currentCard.getNumbers() == topDiscardCard.getNumbers() || currentCard.getSuit() == topDiscardCard.getSuit()){
                    if(topDiscardCard.getNumbers() == 1 || topDiscardCard.getNumbers() == 11 || topDiscardCard.getNumbers() == 12 || topDiscardCard.getNumbers() == 13){
                        if(currentCard.getNumbers() == topDiscardCard.getNumbers()){
                            continue;
                        }
                        System.out.println("Card matched for Player " + players.get(playerTurn).getId() + "Card and New Top Card of Discard deck = " + currentCard);

                        if(CardTake > 1){
                            while (CardTake > 0){
                                System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                                players.get(playerTurn).addCards(drawPile.get(drawPile.size() - 1));
                                drawPile.remove(drawPile.size() - 1);
                                CardTake -= 1;
                            }
                            CardTake = 1;
                        }
                        players.get(playerTurn).removeCard(currentCard);
                        discardPile.add(currentCard);
                        match = true;
                        matchNum = currentCard.getNumbers();
                        break;
                    }
                }
            }
            if(match = false){
                System.out.println("No Cards match for Player " + players.get(playerTurn).getId() + " Taking " + CardTake + " Card(s)");
                while (CardTake > 0){
                    System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card");
                    players.get(playerTurn).addCards(drawPile.get(drawPile.size() - 1));
                    drawPile.remove(drawPile.size() - 1);
                    CardTake -= 1;

                }
                CardTake = 1;
            }
            if(match == true && players.get(playerTurn).getCard().size() == 0){
                System.out.println("Congrats Player " + players.get(playerTurn).getId() + " Won the match!!");
                System.exit(0);

            }
            if (match == true && matchNum == 1){
                playerTurn += dirs;
            }
            if (match == true && matchNum == 13){
                dirs *= -1;
            }
            if (match == true && matchNum == 11){
                CardTake = 4;
            }
            if (match == true && matchNum == 12){
                CardTake = 2;
            }
            playerTurn += dirs;
            System.out.println("===========");


        }

    }
}
