//player Dealer for blackjack game
/**
 * @author: Xinlong Zhang
 * @className: Dealer
 * @description: player Dealer for blackjack game
 **/
public class Dealer extends BJPlayers_base{

    //dealer constructor requires name and currency for player
    public Dealer(String name, Integer currency) {
        super(name, currency);
    }

    //dealer's method for print hands.
    public void showCards(){
        System.out.println("These are the cards of the dealer's hand:");
        System.out.println(getHands());
    }

}