import java.io.IOException;
/**
 * A CellInterface, class that represent cell as interface and some of its basic functions
 */
public interface Cell {

    Marker getMarker();

    void eventProcess(Alive alive) throws IOException;

    void setMarker(Marker marker);
}
