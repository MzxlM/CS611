import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A GameMap object, class that represents the game map which is initialized and well formed for printing.
 */
public class GameMap {
    private Cell[][] map;
    private final double Plain_Probability = 0.4;
    private final double Bush_Probability = 0.2;
    private final double Cave_Probability = 0.2;
    private final double Koulou_Probability = 0.2;
    private final MapFactory MF = new MapFactory();

    //constructors implementing Factory Pattern to create Map
    public GameMap(Integer width, Integer height) throws IOException {
        this.map = MF.GetMap(width,height);
        //this.map = new Cell[width][height];
        initializeMap(width, height);
//        System.out.println(this);
    }

    public GameMap(Integer side) throws IOException {
        this(side,side);
    }

    //no arg constructor generate map size equals to the decide map size.
    public GameMap() throws IOException {
        this(Constant.MAP_SIZE);
    }

    /**
     * random generate an integer that represents
     * the type of a cell
     * @return int
     */
    private int randomCellType() {
        double randomNumber = Math.random();
        if(randomNumber >= 0 && randomNumber <= Plain_Probability){
            return 3;
        }
        else if(randomNumber > Plain_Probability && randomNumber <= Plain_Probability + Bush_Probability){
            return 4;
        }
        else if(randomNumber > Plain_Probability + Bush_Probability &&
                randomNumber <= Plain_Probability + Bush_Probability + Cave_Probability){
            return 5;
        }
        else if(randomNumber > Plain_Probability + Bush_Probability + Cave_Probability &&
                randomNumber <= Plain_Probability + Bush_Probability + Cave_Probability + Koulou_Probability){
            return 6;
        }
        return -1;
    }

    //check the monster nearby and return one monster
    public Monster monsterNearBy(List<Monster> monsters, Integer X, Integer Y) {
        //list all directions
        int[][] directions = new int[5][2];
        directions[0] = new int[]{X - 1, Y}; //up
        directions[1] = new int[]{X, Y-1}; //left
        directions[2] = new int[]{X, Y+1}; //right
        directions[3] = new int[]{X-1, Y-1}; //up left
        directions[4] = new int[]{X-1, Y+1}; // up right

//        int[] up = {X-1, Y};
//        int[] left = {X, Y-1};
//        int[] right = {X, Y+1};
//        int[] upLeft = {X-1, Y-1};
//        int[] upRight = {X-1, Y+1};

        //see if there is any monster
        for (int[] direction : directions) {
            Monster monster = null;
            if (direction[0]>=0&&direction[1]>=0&&direction[0]<getMapWidth()&&direction[1]<getMapHeight()) {
                monster = findMonster(direction, monsters);
            }
            if (monster != null) {
                return monster;
            }
        }
        return null;

    }

    //check if there is any monster on the coordinates given
    private Monster findMonster(int[] coordinates, List<Monster> monsters) {
        int X = coordinates[0];
        int Y = coordinates[1];
        if ((X>=0 && Y>=0)||(X<=getMapHeight() && Y<=getMapWidth())) {
            if (map[X][Y].getMarker().isContainsMonster()) {
                List<Monster> monsterList = monsters.stream().filter(i -> i.getCoordinateX() == X).filter(i -> i.getCoordinateY() == Y).collect(Collectors.toList());
                return monsterList.get(0);
            }
        }
        return null;
    }

    public boolean isHeroNearBy(Integer X, Integer Y) {
        int[][] directions = new int[5][2];
        directions[0] = new int[]{X+1, Y}; //down
        directions[1] = new int[]{X, Y-1}; //left
        directions[2] = new int[]{X, Y+1}; //right
        directions[3] = new int[]{X+1, Y-1}; //down left
        directions[4] = new int[]{X+1, Y+1}; //down right

        //check if there is any hero
        for (int[] direction : directions) {
            boolean isHero = findHero(direction);
            if (isHero) return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    //read if there's hero from marker
    private boolean findHero(int[] coordinates) {
        int X = coordinates[0];
        int Y = coordinates[1];
        if ((X>=0 && Y>=0)&&(X<getMapHeight() && Y<getMapWidth())) {
            if (map[X][Y].getMarker().isContainsHero()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    //generate the map due to required number of markets and unreachable cells.
    private void initializeMap(Integer width, Integer height) throws IOException {
        //set unreachable cells for map
        for(int i = 0; i < height; i++){
            map[i][2] = new CellUnreachable();
            map[i][5] = new CellUnreachable();
        }
        //set nexus cells for map

        for(int i = 0; i < width; i++){
            if(map[0][i] == null){
                map[0][i] = new CellNexus(Constant.MONSTER_NEXUS);
            }
            if(map[width-1][i] == null){
                map[width-1][i] = new CellNexus(Constant.HERO_NEXUS);
                map[width-1][i].getMarker().setExplored(Boolean.TRUE);
            }
        }
        //randomly set plain/bush/cave/koulou cells for map

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if(map[i][j] == null){
                    int type = randomCellType();
                    if(type == 3){
                        map[i][j] = new CellCommon();
                    }
                    else if(type == 4){
                        map[i][j] = new CellBush();
                    }
                    else if(type == 5){
                        map[i][j] = new CellCave();
                    }
                    else if(type == 6){
                        map[i][j] = new CellKoulou();
                    }
                }
            }
        }
    }

    //override the map toString method for map object
    @Override
    public String toString() {
        Helper helper = new Helper();
        String Nexus = helper.addColor("N - N - N", Constant.ANSI_YELLOW);
        String Unreachable = helper.addColor("I - I - I", Constant.ANSI_RED);
        String Plain = "P - P - P";
        String Bush = "B - B - B";
        String Cave = "C - C - C";
        String Koulou = "K - K - K";
        StringBuilder result = new StringBuilder();
        StringBuilder upperLine = new StringBuilder();
        StringBuilder middleLine = new StringBuilder();
        for (Cell[] cells : map) {
            for (int j = 0; j < map[0].length; j++) {
                middleLine.append(cells[j].toString());
                middleLine.append("  ");
                if (cells[j] instanceof CellNexus) {
                    upperLine.append(Nexus);
                } else if (cells[j] instanceof CellUnreachable) {
                    upperLine.append(Unreachable);
                } else if (cells[j] instanceof CellCommon) {
                    upperLine.append(Plain);
                } else if (cells[j] instanceof CellBush) {
                    upperLine.append(Bush);
                } else if (cells[j] instanceof CellCave) {
                    upperLine.append(Cave);
                } else if (cells[j] instanceof CellKoulou) {
                    upperLine.append(Koulou);
                }
                upperLine.append("  ");
            }
            upperLine.append("\n");
            middleLine.append("\n");
            result.append(upperLine).append(middleLine).append(upperLine).append("\n");
            upperLine = new StringBuilder();
            middleLine = new StringBuilder();
        }
        return result.toString();
    }

    //return Width and height.
    public Integer getMapHeight() {return map.length;}
    public Integer getMapWidth() {return map[0].length;}

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
