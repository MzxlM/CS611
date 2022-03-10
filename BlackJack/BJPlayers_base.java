//player class for all black jack games
/**
 * @author: Xinlong Zhang
 * @className: BJPlayers_base
 * @description: This class defines the methods and properties of a general player for BlackJack game.
 **/
public class BJPlayers_base extends BasePlayer{
    //no-arg constructor which is same to super class
    public BJPlayers_base(){
        super();
    }

    //constructor with input name and player's currency
    public BJPlayers_base(String name, Integer currency) {
        super(name, currency);
    }

    //get a card and put it on the hand chosen
    public void hit(Hand hand, Card card){
        hand.drawCard(card);

    }

    //show cards of player's hand
    public void showCards(Hand hand){
        System.out.println(hand);
    }

}