import java.io.IOException;

/**
 * A CellMarket object, class that represents market extends cell object. A market cell contains a market
 */
public class CellNexus extends CellBase {
    private Market market;
    private String type;

    //constructors
//    public CellNexus() throws IOException {
//        this.market = new Market();
//        //change the marker to map the market cell
//        getMarker().markerInitialize(Constant.Nexus);
//    }

    public CellNexus(String type) throws IOException {
        this.market = new Market();
        //change the marker to map the market cell
        getMarker().markerInitialize(Constant.NEXUS);
        setType(type);
    }

    //what's happening on market
    @Override
    public void eventProcess(Alive alive) {
        Hero hero = (Hero) alive;
        Helper helper = new Helper();



        //let hero do the buy at market
        this.market.startShopping(hero);

        //check hero sell;
        System.out.println("Do you want to sell anything? Enter Y/y for selling, N/n for not");
        String result = helper.getResultForYN(hero, null);

        //let hero sell
        if (result.equals("y")){
            //hero.sell();
            market.heroSelling(hero);
        }

//        System.out.println("Do you want to leave? if not leaving you will start to buy again. Enter Y/y for leaving, N/n for not");
//        result = helper.getResultForYN(hero, null);
//        //if the player want to exit the market
//        if (result.equals("y")) {
//            return;
//        }else {
//            //do it for another hero until exit
//            eventProcess(hero);
//        }
//
//
//        return;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
