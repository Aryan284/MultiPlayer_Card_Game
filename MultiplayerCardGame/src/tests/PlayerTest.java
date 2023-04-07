package tests;

import main.GameEntity.Card;
import main.GameEntity.Player;
import main.GameEntity.Suits;
import org.junit.Assert;
import org.junit.Test;

// tests for checking if cards are added to player or not.
public class PlayerTest {
    @Test
    public void AddPlayerCard(){
        Card c1 = new Card(1, Suits.DIAMOND);
        Player p1 = new Player(1);
        p1.addCards(c1);
        int result = p1.getCard().size();
        Assert.assertEquals(1, result);
    }
    @Test
    public void removePlayerCard(){
        Card c1 = new Card(1, Suits.DIAMOND);
        Player p1 = new Player(1);
        p1.addCards(c1);
        p1.removeCard(c1);
        int result = p1.getCard().size();
        Assert.assertEquals(0, result);
    }
}
