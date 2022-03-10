import java.util.*;
/**
 * @author: Xudong Gao
 * @className: Shoe
 * @description: This class defines the methods and properties of a shoe that contains and distribute the cards.
 **/
//Shoe for card games
public class Shoe{
    //show has up to 5 decks
    private Deck[] decks = new Deck[5];
    // all the cards on the shoe
    List<Card> cards=new ArrayList();
    Iterator<Card> iter;

    //constructor for shoe with num = the numbers of decks, and mod is asking dor jokers.
    public Shoe(int num,int mod){
        for(int i= 0;i < num;i++) {
            decks[i]= new Deck(mod);
        }
        for(int i= 0;i < num;i++){
            this.cards.addAll(decks[i].getCards());
        }
        iter = cards.iterator();
    }

    //for a player to draw card
    public Card draw(){
        return iter.next();
    }

    //draw car that are face up
    public Card drawKnownToAll(){
        Card card = iter.next();
        card.setFaceUp(Boolean.TRUE);
        return card;
    }

    //shuffle all cards on shoe
    public void shuffle(){
        Collections.shuffle(cards);
    }

}
