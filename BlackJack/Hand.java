import java.util.ArrayList;
import java.util.List;
/**
 * @author: Xudong Gao
 * @className: Hand
 * @description: This class defines the methods and properties of a player's hand.
 **/
//the hand for each player which holds cards
public class Hand {
    //the total values that hand holds
    private Integer values;
    //all cards that hand holds
    List<Card> cards;
    //current bet on this hand
    private Integer currentBet;

    //no-arg constructor
    public Hand(){
        cards = new ArrayList();
        this.currentBet = 0;
    }

    //draw a card and add to hand
    public void drawCard(Card card){
        cards.add(card);
        setValues(calcValue());
    }

    //remove the last drawn card for spilt
    public void removeLastCard(Card card){
        cards.remove(card);
        setValues(calcValue());
    }

    //getters and setters
    public int getValues(){
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public Integer getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Integer currentBet) {
        if (currentBet<0) {
            throw new IllegalArgumentException("currentBet cant be smaller than 0");
        }
        if (currentBet <= this.currentBet) {
            throw new IllegalArgumentException("you should bet more than current bet");
        }
        this.currentBet = currentBet;
    }
    public void clearBet() {

        this.currentBet = 0;
    }
    public void clearHand() {
        cards = new ArrayList();
        this.currentBet = 0;
    }
    public List<Card> getCards() {
        return cards;
    }

    //method that calc the value of cards currently on hand
    private Integer calcValue(){
        Integer value = 0;
        for (Card card : cards) {
            value+=card.getIntegerValue();
        }
        return value;
    }

    //Override toString methods that prints card suit and value.
    public String toString(){
        String cards = new String();
        for(Card card: getCards()){
            if(card.isFaceUp()) {
                cards += card.toString() + ",\n";
            }
            else cards += "***Invisible Card***";
        }
        return cards;
    }
}