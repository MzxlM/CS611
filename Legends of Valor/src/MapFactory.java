import java.io.IOException;
import java.util.List;

public class MapFactory {
    //Factory Pattern Implementation
    public Cell[][] GetMap(Integer width, Integer height){
        return new Cell[width][height];
    }

}
