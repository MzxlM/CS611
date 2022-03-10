import java.io.IOException;
/**
 * A CellInterface, class that represent cell as interface and some of its basic functions
 */
public interface CellInterface {

    Marker getMarker();

    void eventProcess(Team team) throws IOException;
}
