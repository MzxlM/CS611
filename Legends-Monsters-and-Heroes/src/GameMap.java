import java.io.IOException;
import java.util.Random;
/**
 * A GameMap object, class that represents the game map which is initialized and well formed for printing.
 */
public class GameMap {
    private Cell[][] map;

    //constructors
    public GameMap(Integer width, Integer height) throws IOException {
        this.map = new Cell[width][height];
        initializeMap(width, height);
        System.out.println(this);
    }

    public GameMap(Integer side) throws IOException {
        this(side,side);
    }

    //no arg constructor generate map size equals to the decide map size.
    public GameMap() throws IOException {
        this(Constant.MAP_SIZE);
    }
    //generate the map due to required number of markets and unreachable cells.
    private void initializeMap(Integer width, Integer height) throws IOException {
        Random random = new Random();
        int numberOfMarket = 0;
        int numberOfUnreachable = 0;
        //number of at most how many unreachable and market
        double unreachableLimit = Math.ceil(width * height * (double) Constant.UNREACHABLE_CELLS/(double) Constant.TOTAL_CELLS);
        double marketLimit = Math.ceil(width * height * (double) Constant.MARKER_CELLS/(double) Constant.TOTAL_CELLS);
//        System.out.println("important data: " + unreachableLimit + "   " + marketLimit);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //Calculate what percent of the cells to use
                int randomInt = random.nextInt(Constant.TOTAL_CELLS);
                if (randomInt < Constant.UNREACHABLE_CELLS&& numberOfUnreachable<=unreachableLimit) {
                    //generate unreachable
                    map[i][j] = new CellUnreachable();
                    numberOfUnreachable++;
                } else if (randomInt < (Constant.UNREACHABLE_CELLS+Constant.MARKER_CELLS)&& numberOfMarket<=marketLimit) {
                    //generate market
                    map[i][j] = new CellMarket();
                    numberOfMarket++;
                } else {
                    //generate common cell
                    map[i][j] = new CellCommon();
                }
            }
        }
    }

    //return Width and height.
    public Integer getMapWidth() {return map.length;}
    public Integer getMapHeight() {return map[0].length;}


    //override the map toString method for map object
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int numberOfMarket = 0;
        int numberOfUnreachable = 0;
        printSeparationLine(result);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                result.append("*").append(map[i][j]);
                if (map[i][j].getMarker().isMarket() == Boolean.TRUE) {
                    numberOfMarket++;
                }
                if (map[i][j].getMarker().isUnreachable() == Boolean.TRUE) {
                    numberOfUnreachable++;
                }
            }
            result.append("*\n");
            printSeparationLine(result);
        }
        //marketChecker print the percent of market and unreachable cell
        if (Constant.DEBUG_MAP_PERCENT == Boolean.TRUE) {
            double i = (double)numberOfMarket* 1/64;
            double j = (double)numberOfUnreachable* 1/64;
            System.out.println("percent of Market: "+ i);
            System.out.println("percent of Unreachable: "+ j);
        }
        return result.toString();
    }

    //print a line ******** respect to the map size
    private void printSeparationLine(StringBuilder result) {
        for (int i = 0; i < map.length; i++) {
            result.append("****");
        }
        result.append("*\n");
    }

    public Marker getCellMarker(Integer X, Integer Y){
        return this.map[X][Y].getMarker();
    }

    public void setCellMarker(Integer X, Integer Y, Marker marker){
        this.map[X][Y].setMarker(marker);
    }

    public Cell getCell(Integer X, Integer Y){
        return this.map[X][Y];
    }
}
