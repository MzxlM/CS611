import java.io.IOException;

/**
 * A abstract Cell object, class that represent base cell that is part of the map
 */
public abstract class Cell implements CellInterface{

    private Marker marker;

    public Cell(Marker marker) {
        this.marker = marker;
    }

    public Cell(){
        this.marker = new Marker();
    }

    @Override
    public void eventProcess(Team team) throws IOException {

    }

    @Override
    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
