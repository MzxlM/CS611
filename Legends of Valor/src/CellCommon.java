/**
 * A common Cell object extends cell, class that represent the empty cell in map which may contains monsters
 */
public class CellCommon extends CellBase {

    public CellCommon() {
        //change the marker to map the common cell
        getMarker().markerInitialize(Constant.COMMON);
    }

    //the event happens on common cell
    @Override
    public void eventProcess(Alive alive) {

    }

    //check inventories
    private void checkInventories(Hero hero){
        //check hero sell;
        Helper helper = new Helper();
        System.out.println("Do you want to check inventory? Enter Y/y for selling, N/n for not");
        String result = helper.getResultForYN(hero, null);

        //let hero sell
        if (result.equals("y")){
            hero.printBag();
        }
    }


}
