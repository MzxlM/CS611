import java.util.ArrayList;
import java.util.List;
/**
 * @author: Xinlong Zhang
 * @className: BasePlayer
 * @description: This is an abstract class of the general player.
 **/
public abstract class BasePlayer {
    //player's name
    private String name;
    //player's total currency
    private Integer currency;
    //player's hands object
    private List<Hand> hands;

    //player no-arg constructor
    public BasePlayer(){
        List<Hand> temp = new ArrayList<>();
        temp.add(new Hand());
        setName("default");
        setCurrency(0);
        setHands(temp);
    }

    //constructor with input name and player's currency
    public BasePlayer(String name, Integer currency) {
        setName(name);
        setCurrency(currency);
        List<Hand> temp = new ArrayList<>();
        temp.add(new Hand());
        setHands(temp);
    }

    //get and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("name can't be empty");
        }
        this.name = name;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        if (currency<0) {
            throw new IllegalArgumentException("currency cant be smaller than 0");
        }

        this.currency = currency;
    }

    public List<Hand> getHands() {
        return hands;
    }

    public void setHands(List<Hand> hands) {
        if (hands.isEmpty()) {
            throw new IllegalArgumentException("at least a hand for each player");
        }
        this.hands = hands;
    }


}
