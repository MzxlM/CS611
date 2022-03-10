import java.util.ArrayList;
import java.util.List;
/**
 * @author: Xudong Gao
 * @className: Deck
 * @description: This class defines the methods and properties of a deck of playing cards.
 **/
//Deck class for the real object deck which contains numbers of cards
public class Deck {
    //the cards contains
    List<Card> cards=new ArrayList();
    //there should be 4 suits
    static String[] SUITS = {"Heart","Spade","Club","Diamond"};
    //13 ranks
    static String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    //constructor for deck object
    public Deck(int mod){
        //the loop to initialize the deck objects which fills with card
        for(int i = 0;i < SUITS.length;i++){
            for (int j = 0;j < RANKS.length;j++){
                Integer temp = j;
                if (j >= 9) {
                    temp = 9;
                }
                cards.add(new Card(SUITS[i],RANKS[j],temp+1));
            }
        }
        // if mod =0 the deck has 54 cards with jokers
        if(mod == 0){
            cards.add(new Card("Joker","Red",10)); //todo integer values uncertain
            cards.add(new Card("Joker","Black",10));
        }
    }

    //getters and setters
    public List<Card> getCards(){
        return cards;
    }
}