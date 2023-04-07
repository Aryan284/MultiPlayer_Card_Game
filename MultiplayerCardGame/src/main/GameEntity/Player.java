package main.GameEntity;

import java.util.ArrayList;

public class Player {
    private int id;
    private ArrayList<Card> deckCards = new ArrayList<>();
    public Player(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public ArrayList<Card> getCard(){
        return deckCards;
    }

    public void addCards(Card card){
        deckCards.add(card);

    }
    public void removeCard(Card card){
        deckCards.remove(card);
        return;
    }
    public String toString(){
        return id + " " + deckCards.toString();

    }


}
