// card class for card object
/**
 * @author: Xudong Gao
 * @className: Card
 * @description: This class defines the methods and properties of a playing card.
 **/
public class Card {
    //rank of each card
    String rank;
    //suit of each card
    String suit;
    //the corresponding Integer value to each rank of card
    Integer integerValue;
    //false: face down,true:face up
    boolean faceUp = false;

    //Card constructors with card suit rank and its intergervalue
    public Card(String suit,String rank, Integer integerValue){
        setSuit(suit);
        setRank(rank);
        setIntegerValue(integerValue);
        isFaceUp();
    }

    //getters and setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        if (integerValue>13 || integerValue<1) {
            throw new IllegalArgumentException("Card value should be an integer between 1 and 13");
        }
        this.integerValue = integerValue;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    //override toString
    public String toString(){
        return getSuit()+" "+getRank()+" ("+getIntegerValue()+")";
    }
}
