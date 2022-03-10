import java.io.IOException;
/**
 * A CellMarket object, class that represents market extends cell object. A market cell contains a market
 */
public class CellMarket extends Cell{
    private Market market;

    //constructors
    public CellMarket() throws IOException {
        this.market = new Market();
        //change the marker to map the market cell
        getMarker().markerInitialize(Constant.MARKET);
    }

    //what's happening on market
    @Override
    public void eventProcess(Team team) {
        Helper helper = new Helper();
        int heroNumbers = team.getHeroes().size();
//        int i = 0;

        //print instructions and hero list
        System.out.println("Now you are in Market, you can choose a hero to start selling and buying.");

        //let play choice a hero
        Integer inputNumber = helper.getHeroChoice(team);

        //if the player want to exit the market
        if (inputNumber.equals(heroNumbers+1)) {
            return;
        }

        //let hero do the buy at market
        Hero hero = team.getHeroes().get(inputNumber-1);
        this.market.startShopping(hero);

        //check hero sell;
        System.out.println("Do you want to sell anything? Enter Y/y for selling, N/n for not");
        String result = helper.getResultForYN(hero, null);

        //let hero sell
        if (result.equals("y")){
            hero.sell();
        }

        //do it for another hero until exit
        eventProcess(team);
    }

    @Override
    public String toString() {
        Helper helper = new Helper();
        // if there's hero print hero, otherwise print Market
        boolean containsHero = this.getMarker().isContainsTeam();
        if (containsHero == Boolean.TRUE) return helper.addColor(getMarker().getTeamIcon(), Constant.ANSI_GREEN);

        return helper.addColor(" M ", Constant.ANSI_YELLOW);
//        return Constant.ANSI_YELLOW+" M "+Constant.ANSI_RESET;

    }

    public Market getMarket() {
        return market;
    }
}
