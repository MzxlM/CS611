/**
 * A CellUnreachable object, class that represents cell in the map that cant be reach by hero
 */
public class CellUnreachable extends CellBase {

    public CellUnreachable() {
        //change the marker to map the unreachable cell
        getMarker().markerInitialize(Constant.UNREACHABLE);
    }


    @Override
    public String toString() {
        Helper helper = new Helper();
        String unreachableIcon =  helper.addColor(" X X X ", Constant.ANSI_RED);
        return "|" + unreachableIcon + "|";
    }

    @Override
    public void eventProcess(Alive alive) {

    }
}
