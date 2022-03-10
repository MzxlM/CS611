/**
 * A CellCave object, class that represents cell in the map that increase the strength of any
 * hero who is inside them by 10%
 */
public class CellKoulou extends CellBase {

    public CellKoulou(){
        //change the marker to map the koulou cell
        getMarker().markerInitialize(Constant.KOULOU);
    }



    @Override
    public void eventProcess(Alive alive) {

    }

}
