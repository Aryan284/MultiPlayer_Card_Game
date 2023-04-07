package tests;

import main.GameEntity.Card;
import main.GameEntity.Deck;
import main.GameEntity.Suits;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {
    @Test
    public void checkShuffle(){
        ArrayList<Card> unShuffle = new ArrayList<>();
        for(Suits suits: Suits.values()){
            for(int i = 1; i <= 13; i++){
                unShuffle.add(new Card(i, suits));
            }
        }
//        System.out.println(unShuffle.toString());
        Deck deck = new Deck();
        ArrayList<Card> shuffle = deck.getDeckOfCard();
//        System.out.println(shuffle.toString());
        Assert.assertEquals(false, unShuffle.toString() == shuffle.toString());

    }
}
