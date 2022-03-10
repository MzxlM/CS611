import java.util.List;
/**
 * @author: Xinlong Zhang
 * @className: BJPlayer
 * @description: This class defines the methods and properties of a player for BlackJack game.
 **/
//player class for
public class BJPlayer extends BJPlayers_base {
    //variable denotes whether player stands or not
    private boolean isStand;

    //no-arg constructor from superclass
    public BJPlayer(){
        super();
    }

    //constructor with input name and player's currency
    public BJPlayer(String name, Integer currency) {
        super(name, currency);
    }

    //make changes to new hand
    public Hand spilt(Hand hand, Card card){
        //remove the last card that drawn
        hand.removeLastCard(card);
        //create a new hand
        Hand newHand = new Hand();
        //assign the last card to new hand
        newHand.drawCard(card);
        //bet the same bet which is on current hand
        newHand.setCurrentBet(hand.getCurrentBet());
        //make changes to hand's list of player
        List<Hand> hands = super.getHands();
        hands.add(newHand);
        super.setHands(hands);
        return newHand;
    }

    //change status to stand
    public void stand(Hand hand){
        setStand(Boolean.TRUE);
    }

    //double up
    public void DoubleUp(Hand hand, Card card){
        hand.setCurrentBet(hand.getCurrentBet()*2);
        hit(hand, card);
        stand(hand);
    }
    //getters and setters
    public boolean getIsStand() {
        return isStand;
    }

    public void setStand(boolean stand) {
        isStand = stand;
    }

    //show cards of player's hand
    public void showCards(Hand hand){
        System.out.println("These are the cards of the player "+ getName() +"'s hand " + getHands().indexOf(hand)+":");
        System.out.println(hand);
    }
}
