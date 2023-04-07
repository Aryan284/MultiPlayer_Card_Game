package tests;

import main.GameEntity.Card;
import main.GameEntity.Player;
import main.GameEntity.Suits;
import org.testng.annotations.Test;
import org.junit.Assert;
// tests for checking if cards are added to player or not.
public class PlayerTest {
    @Test
    public void AddPlayerCard(){
        Card c = new Card(1, Suits.DIAMOND);
        Player p = new Player(1);
        p.addCards(c);
        int ans = p.getCard().size();
        Assert.assertEquals(1, ans);
    }
    @Test
    public void removeCard(){
        Card c = new Card(1, Suits.DIAMOND);
        Player p = new Player(1);
        p.addCards(c);
        p.removeCard(c);
        int ans = p.getCard().size();
        Assert.assertEquals(0, ans);
    }
}
