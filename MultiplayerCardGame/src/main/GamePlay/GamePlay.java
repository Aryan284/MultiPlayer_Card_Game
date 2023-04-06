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
        



    }
}
