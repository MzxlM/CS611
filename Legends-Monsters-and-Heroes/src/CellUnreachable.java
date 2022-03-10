/**
 * A CellUnreachable object, class that represents cell in the map that cant be reach by hero
 */
public class CellUnreachable extends Cell{

    public CellUnreachable() {
        //change the marker to map the unreachable cell
        getMarker().markerInitialize(Constant.UNREACHABLE);
    }


    @Override
    public String toString() {
        Helper helper = new Helper();
        return helper.addColor(" X ", Constant.ANSI_RED);
//        return Constant.ANSI_RED+" X "+Constant.ANSI_RESET;
    }

    @Override
    public void eventProcess(Team team) {

    }
}
