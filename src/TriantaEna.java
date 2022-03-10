import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author: Xinlong Zhang, Xudong Gao
 * @className: TriantaEna
 * @description: This class extends BlackJack class and implements the methods of TriantaEna game.
 **/
public class TriantaEna extends BlackJack {
    //players who dont choose to fold
    private List<BJPlayer> playingPlayers;

    //constructor for game Trianta Ena
    public TriantaEna(List<BJPlayers_base> players) {
        super(players);
        //since this game is played by 2 decks
        shoe = new Shoe(2, 1);
        Dealer temp = getDealer();//for debug
        System.out.println("Welcome to play our Trianta Ena, another version of Black Jack!\n");

    }

    //initialize the game
    @Override
    public void gameInitialize() {
        setWinCondition(31);
        setDealerPoint(27);
        results = new ArrayList<>();
        results_all = new ArrayList<>();
        shoe = new Shoe(2, 1);
        playerListInitialize();
    }

    private void playerListInitialize(){
        List<BJPlayer> players = getPlayers();
        List<BJPlayer> temp = new ArrayList<>();
        for (BJPlayer player : players) {
            BJPlayer tempPlayer = new BJPlayer(player.getName(),player.getCurrency());
            tempPlayer.getHands().get(0).clearBet();
            temp.add(tempPlayer);
        }
        getDealer().getHands().get(0).clearBet();
        getDealer().getHands().get(0).clearHand();


        setBJPlayers(temp);
    }

    //start the game
    @Override
    public void gameProcess() {
        //get the players and banker
        List<BJPlayer> players = getPlayers();
        Dealer dealer = getDealer();
        //shuffle
        shoe.shuffle();
        //the Dealer deals one card to each player
        for (BJPlayer player : players) {
            player.hit(player.getHands().get(0), shoe.draw());
        }
        // The first card the Dealer is dealt is kept face up
        dealer.hit(dealer.getHands().get(0), shoe.drawKnownToAll());
        for (BJPlayer player : players) {
            player.showCards(player.getHands().get(0));
        }
        dealer.showCards();
        //players choose to bet or fold
        setBet(players);

        //all bets have been made, each player with a standing bet receives two more cards face up
        for (BJPlayer player : players) {
            if (!player.getHands().get(0).getCurrentBet().equals(0)) {
                player.hit(player.getHands().get(0), shoe.drawKnownToAll());
                player.hit(player.getHands().get(0), shoe.drawKnownToAll());
            }
        }

        //show cards on terminal
        for (BJPlayer player : players) {
            if (!player.getHands().get(0).getCurrentBet().equals(0)) {

                player.showCards(player.getHands().get(0));
            }
        }
        dealer.showCards();
        System.out.println("**********************************************");
        //each Player in turn may take one of the following actions:
        for (BJPlayer player : players) {
            if (!player.getHands().get(0).getCurrentBet().equals(0)) {
                if (isBoom(player.getHands().get(0))) {
                    System.out.println("The values of the play "+player.getName()+"be equal or greater than "+getWinCondition() +"!");
                    continue;
                }
                if (!isBoom(player.getHands().get(0))) {
                    drawForPlayer(player, player.getHands().get(0));
                }
            }
        }

        System.out.println("**********************************************");
        drawForDealer();
        winCheck();
        printResult();
        bankerRotate();
    }

    //since determining dealer is different from super class override it
    //now choose the dealer which is also banker who has the greatest amount of money
    @Override
    protected void assignRoles(List<BJPlayers_base> players) {
        //Pick the player who has 3 times greater amount of money than others if not
        // need to restart the game
        Dealer dealer = null;
        BJPlayer player;
        List<BJPlayer> BJPlayers = new ArrayList<>();
        //find the maximum currency number
        List<Integer> collect = players.stream().map(BasePlayer::getCurrency).collect(Collectors.toList());
        int maxCurrency = collect.stream().mapToInt(Integer::intValue).max().getAsInt();
        Boolean temp = false;
        //assign dealer and other players
        List<BJPlayers_base> tempPlayers = new ArrayList<>(players);
        for (BJPlayers_base p : tempPlayers) {
            if (p.getCurrency().equals(maxCurrency) && temp.equals(false)) {
                dealer = new Dealer(p.getName(), p.getCurrency());
                players.remove(p);
                temp = true;
            } else {
                player = new BJPlayer(p.getName(), p.getCurrency());
                BJPlayers.add(player);
            }

        }
        setDealer(dealer);
        setBJPlayers(BJPlayers);
    }


    //do the players input check. Banker must have 3 times of players' currency
    public static boolean initializeCheck(List<BJPlayers_base> players) {

        List<Integer> collect = players.stream().map(BasePlayer::getCurrency).collect(Collectors.toList());
        int maxCurrency = collect.stream().mapToInt(Integer::intValue).max().getAsInt();            //300
        //delete the maxCurrency from the list collect
        for (int i = 0; i < collect.size(); i++) {
            if (collect.get(i).equals(maxCurrency)) {
                Integer remove = collect.remove(i);
                break;
            }

        }
        // if the amount is not 1/3 of dealers, re-input the game or play the other one
        for (Integer integer : collect) {
            if (!integer.equals(maxCurrency/3)){
                System.out.println("Each player begins with the same amount of money; the player who is the Banker, " +
                        "must begin with three times the amount of the Players. For example, " +
                        "if the players begins with $100.00 each, the Banker must have $300.00.");
                return false;
            }
        }
        return true;
    }

    //Override setBet methods from super class.
    @Override
    protected void setBet(List<BJPlayer> players) {
        // just a loop which let each player put their bet or fold.
        for (BJPlayer player: players){
            System.out.println("Please the player " + player.getName() + " place the bets: ");
            System.out.println("Please bet 0 if you choose to fold ");
            while (true) {
                String next = in.next();
                try {
                    Integer bet = Integer.parseInt(next);
                    if (bet > 0 && bet <= player.getCurrency()) {
                        player.getHands().get(0).setCurrentBet(bet);
                        break;
                    }
                    if (bet.equals(0)) {
                        break;
                    }
                } catch (NumberFormatException e) {
                }
                System.out.println("Please Enter a Number Between 0 and "+player.getCurrency());
            }
        }
        //kick players who dont want to play
        setPlayingPlayers(players);
    }

    // rotate banker if one of the player's amount is greater than banker
    private void bankerRotate(){
        List<BJPlayer> players = new ArrayList<>(getPlayers());
        boolean swap = false;
        //sort the player by their currency
        players.sort(new PlayerCurrencyComparator());
        // ask if the player want to become banker
        for (BJPlayer player : getPlayers()) {
            if (player.getCurrency() > getDealer().getCurrency()) {
                System.out.println("Player: " + player.getName()+ " do you want to become the new banker(y/n)?");
                boolean b = bankerRot(player);
                if (b){
                    swap = true;
                    break;
                }
            }
        }

        if (!swap) {
            System.out.println("Since no one want to be the banker, the current banker stays as banker");
        }
    }

    //ask the player if he or she wants to be the banker and made the switch
    private boolean bankerRot(BJPlayer player){
        String answer = in.next();
        if (answer.equals("y")) {
            //make the banker switch
            Dealer dealer = getDealer();
            setDealer(new Dealer(player.getName(), player.getCurrency()));
            List<BJPlayer> players = getPlayers();
            players.remove(player);
            players.add(new BJPlayer(dealer.getName(), dealer.getCurrency()));
            setBJPlayers(players);

            System.out.println(player.getName() + " now becomes the new banker");
            return true;
        }
        if (answer.equals("n")) {
            return false;
        }
        System.out.println("Please enter y for yes or n for no");
        bankerRot(player);

        return false;
    }

    @Override
    protected void winCheck() {
        for (BJPlayer player:getPlayers()) {
            for (Hand hand : player.getHands()) {
                Integer result = compareValue(hand);
                Dealer dealer = getDealer();
                //if the player doesnt bet it's a draw
                if (hand.getCurrentBet().equals(0)) {
                    result = 2;
                }
                if (result == 1) {
                    player.setCurrency(player.getCurrency() - hand.getCurrentBet());
                    dealer.setCurrency(dealer.getCurrency() + hand.getCurrentBet());
                } else if (result == 0) {
                    player.setCurrency(player.getCurrency() + hand.getCurrentBet());
                    dealer.setCurrency(dealer.getCurrency() - hand.getCurrentBet());
                }
                results.add(result);

            }
            results_all.add(results);
            results = new ArrayList();

        }

    }
    //getters and setters
    public List<BJPlayer> getPlayingPlayers() {
        return playingPlayers;
    }

    public void setPlayingPlayers(List<BJPlayer> playingPlayers) {
        this.playingPlayers = playingPlayers;
    }


}