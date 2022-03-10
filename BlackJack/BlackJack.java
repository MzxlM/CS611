import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Xudong Gao,Xinlong Zhang
 * @className: BlackJack
 * @description: This class extends CardGame class and implements the methods of BlackJack.
 **/
//black Jack card game
public class BlackJack extends CardGame {
    //player dealer
    private Dealer dealer;
    //player against dealer
    private List<BJPlayer> players;
    private Integer winCondition = 21;
    private Integer dealerPoint = 17;
    // scanners
    Scanner in = new Scanner(System.in);
    //variable that is the game finished
    private boolean finished = false;
    //store the game results of who win the game(1 if dealers wins, 0 if players wins, 2 if equal)
    List<Integer> results;
    List<List<Integer>> results_all;
    private final Integer playerWin = 0;
    private final Integer dealerWin = 1;
    private final Integer draw = 2;


    //BlackJack constructors with players in the game
    public BlackJack(List<BJPlayers_base> players) {
        //todo players number check
        super(players);


        shoe = new Shoe(1, 1);
        //instructions
        System.out.println("Welcome to play our Black Jack!\n");
        assignRoles(players);

    }


    //random assign roles to each player who will play this game todo scalable
    protected void assignRoles(List<BJPlayers_base> players) {
        //generate a random player to become dealer
        Integer round = Math.toIntExact(Math.round((players.size()-1)*Math.random()));
        Dealer dealer;
        BJPlayer player;
        List<BJPlayer> BJPlayers = new ArrayList<>();
        dealer = new Dealer(players.get(round).getName(), players.get(0).getCurrency());
        System.out.println("The player "+players.get(round).getName()+" is the dealer!");
        players.remove(players.get(round));
        for (BJPlayers_base p : players) {
            player = new BJPlayer(p.getName(), p.getCurrency());
            BJPlayers.add(player);
        }
        setDealer(dealer);
        setBJPlayers(BJPlayers);
    }


    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Integer getWinCondition() {
        return winCondition;
    }

    public void setWinCondition(Integer winCondition) {
        this.winCondition = winCondition;
    }

    public Integer getDealerPoint() {
        return dealerPoint;
    }

    public void setDealerPoint(Integer dealerPoint) {
        this.dealerPoint = dealerPoint;
    }

    @Override
    public void gameInitialize() {
        setBet(players);
        results = new ArrayList<>();
        results_all = new ArrayList<>();
    }


    @Override
    public void gameProcess() {
        shoe.shuffle();
        for (BJPlayer player : players) {
            player.hit(player.getHands().get(0), shoe.drawKnownToAll());
            player.hit(player.getHands().get(0), shoe.drawKnownToAll());
        }
        dealer.hit(dealer.getHands().get(0), shoe.drawKnownToAll());
        dealer.hit(dealer.getHands().get(0), shoe.draw());
        for (BJPlayer player : players) {
            player.showCards(player.getHands().get(0));
        }
        dealer.showCards();
        System.out.println("**********************************************");
        for (BJPlayer player : players) {
            if (isBoom(player.getHands().get(0))) {
                System.out.println("The values of the play "+player.getName()+"be equal or greater than 21!");
                continue;
            }
            spilt(player, player.getHands().get(0));
            for (Hand hand : player.getHands()) {
                if (!isBoom(hand)) {
                    drawForPlayer(player, hand);
                }
            }
        }
        System.out.println("**********************************************");
        drawForDealer();
        winCheck();
        printResult();
    }

    protected void setBet(List<BJPlayer> players){
        for (BJPlayer player: players){
            System.out.println("Please the player " + player.getName() + " place the bets: ");
            while (true) {
                String next = in.next();
                try {
                    Integer bet = Integer.parseInt(next);
                    if (bet > 0 && bet <= player.getCurrency()) {
                        player.getHands().get(0).setCurrentBet(bet);
                        break;
                    }
                } catch (NumberFormatException e) {
                }
                System.out.println("Please Enter a Number Between 1 and "+player.getCurrency());
            }
        }
    }

    private void spilt(BJPlayer player,Hand hand) {
        List<Card> cards = hand.getCards();
        if(cards.get(0).getRank().equals(cards.get(1).getRank())){
            System.out.println("Please the player "+ player.getName() +" choose if splits for hand "+player.getHands().indexOf(hand)+":(y/n) ");
            String next;
            while (true) {
                next = in.next();
                if (next.equals("y")) {
                    Hand aHand = player.spilt(hand, hand.getCards().get(1));
                    player.hit(hand, shoe.drawKnownToAll());
                    System.out.println("The values of the player "+ player.getName() +" are update to "+hand.getValues());
                    spilt(player,hand);
                    player.hit(aHand,shoe.drawKnownToAll());
                    spilt(player,aHand);
                    break;
                }
                if (next.equals("n")) {
                    break;
                }

                System.out.println("Please Enter y or n !");
            }

        }
    }

    protected void drawForPlayer(BJPlayer player,Hand hand){
        while (true){
            System.out.println("Please the player "+ player.getName() +" choose if stands for hand "+player.getHands().indexOf(hand)+":(y/n) ");
            System.out.println("Current values:"+hand.getValues());
            while (true) {
                String next = in.next();
                if (next.equals("y")) {
                    player.setStand(true);
                    break;
                }
                if (next.equals("n")) {
                    break;
                }
                System.out.println("Please Enter y or n !");
            }

            if(player.getIsStand()){
                break;
            }
            else{
                player.hit(hand,shoe.drawKnownToAll());
                System.out.println("The values of the player "+ player.getName() +" are update to "+hand.getValues());
            }
            if(isBoom(hand)){
                break;
            }
        }
    }


    public List<BJPlayer> getPlayers() {
        return players;
    }

    protected void drawForDealer() {
        int dealers = dealer.getHands().get(0).getValues();
        System.out.println("The values of dealer are "+dealers);

        while (dealers < dealerPoint) {
            System.out.println("The values of the dealer are too small, and keep drawing.");
            dealer.getHands().get(0).drawCard(shoe.draw());
            dealers = dealer.getHands().get(0).getValues();
            System.out.println("The values of dealer are updated to "+dealers);
        }
        if (dealers >= winCondition) {
            //winCheck(player);
            return;
        }
        drawMore();
    }

    private void drawMore() {
        while (true){
            System.out.println("Dealer please choose if draw one more (y/n) ");
            System.out.println("Current Values:"+dealer.getHands().get(0).getValues());

            while (true) {
                String next = in.next();
                if (next.equals("y")) {
                    for(BJPlayer player:players) {
                        player.setStand(true);
                    }
                    dealer.getHands().get(0).drawCard(shoe.draw());
                    System.out.println("The values of the dealer are update to "+dealer.getHands().get(0).getValues());
                    break;
                }
                if (next.equals("n")) {
                    return;
                }
                System.out.println("Please Enter y or n !");
            }
            if (dealer.getHands().get(0).getValues() >= winCondition) {
                break;
            }

        }
    }
    protected   boolean isBoom(Hand hand){
        if(hand.getValues() >= winCondition){
            return true;
        }
        return false;
    }

    protected Integer compareValue(Hand hand){
        //return 1 if dealers is greater, 0 if players is greater, 2 if equal
        Integer dealers = dealer.getHands().get(0).getValues();
        Integer players = hand.getValues();
        List<Card> cardsDealer = dealer.getHands().get(0).getCards();
        List<Card> cardsPlayer = hand.getCards();
        for (Card card : cardsDealer) {
            if (card.getRank().equals("A")) {
                if (dealers+10 <= winCondition) {
                    dealers+=10;
                }
            }
        }
        for (Card card : cardsPlayer) {
            if (card.getRank().equals("A")) {
                if (players+10 <= winCondition) {
                    players+=10;
                }
            }
        }
        if (dealers > winCondition && players <= winCondition) {
            return playerWin;
        }
        if (dealers <= winCondition && players > winCondition){
            return dealerWin;
        }
        if (dealers > winCondition && players > winCondition) {
            return draw;
        }
        if (players > dealers) {
            return playerWin;
        } else if (players < dealers) {
            return dealerWin;
        } else {
            return draw;
        }
    }

    protected void winCheck(){
        for (BJPlayer player:players) {
            for (Hand hand : player.getHands()) {
                Integer result = compareValue(hand);
                if (result == dealerWin) {
                    player.setCurrency(player.getCurrency() - hand.getCurrentBet());
                    dealer.setCurrency(dealer.getCurrency() + hand.getCurrentBet());
                } else if (result == playerWin) {
                    player.setCurrency(player.getCurrency() + hand.getCurrentBet());
                    dealer.setCurrency(dealer.getCurrency() - hand.getCurrentBet());
                }
                results.add(result);

            }
            results_all.add(results);
            results = new ArrayList();

        }
    }

    protected void printResult() {
        System.out.println("**********************************************");
        int player_index = 0;
        for(List<Integer> results:results_all) {
            int hand_index = 0;
            for (Integer result : results) {

                if (result == playerWin) {
                    System.out.println("The hand " + hand_index + " of the player "+players.get(player_index++).getName()+" wins!");
                } else  if(result == dealerWin) {
                    System.out.println("The hand " + hand_index + " of the player "+players.get(player_index++).getName()+" loses!");
                }
                else {
                    System.out.println("The hand " + hand_index + " of the player "+players.get(player_index++).getName()+" DRAW!");
                }
                hand_index++;
            }
        }
        for (BJPlayer player:players) {
            System.out.println("Current balance of the player "+player.getName()+": " + player.getCurrency());
        }
        System.out.println("Current balance of the dealer("+dealer.getName()+"): "+dealer.getCurrency());
    }


    protected static boolean tryAgain(int count) {
        System.out.println("Do you want to play again? (yes/no)");
        Scanner in = new Scanner(System.in);
        while (true) {
            String answer = in.next();
            if (answer.equals("yes")) {
                return true;
            } else if (answer.equals(("no"))) {
                return false;
            } else System.out.println("Please re-enter your choice, which must be \"yes\" or \"no\".");
        }
    }

    public List<? extends BJPlayers_base> getALLPlayers() {
        List<BJPlayers_base> players_base = new ArrayList<>();

        players_base.add(dealer);
        for(BJPlayer player:players){
            players_base.add(player);
        }
        return players_base;
    }

    public void setBJPlayers(List<BJPlayer> players) {
        this.players = players;
    }

    public static boolean initializeCheck(List<BJPlayers_base> players) {
        if(players.size()!=2){
            System.out.println("Only two players are allowed to join Black Jack!");
            return false;
        }
        else return true;
    }
}