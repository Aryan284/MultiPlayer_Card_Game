package GameEntity;

public class Card {
    private int numbers;
    private Suits suit;

    public Card(int number, Suits CardSuit){
        numbers = number;
        suit = CardSuit;

    }
    Card(){

    }


    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }
    public String toString(){
        return numbers + " " + suit;
    }

}
