/**
 * A CellCave object, class that represents cell in the map that increase the agility of any
 * hero who is inside them by 10%
 */
public class CellCave extends CellBase {

    public CellCave(){
        //change the marker to map the cave cell
        getMarker().markerInitialize(Constant.CAVE);
    }

    @Override
    public void eventProcess(Alive alive) {

    }

}
