/**
 * A CellBush object, class that represents cell in the map that increase the dexterity of any
 * hero who is inside them by 10%
 */
public class CellBush extends CellBase {

    public CellBush(){
        //change the marker to map the bush cell
        getMarker().markerInitialize(Constant.BUSH);
    }

    @Override
    public void eventProcess(Alive alive) {

    }

}
