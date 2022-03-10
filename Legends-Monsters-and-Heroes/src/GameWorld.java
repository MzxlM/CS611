import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * A GameWorld object, class that contains teams that are playing this game and main game process
 */
public class GameWorld {
    private List<Team> teams;
    private GameMap map;

    public GameWorld(List<Team> teams, GameMap map) {
        this.teams = teams;
        this.map = map;
    }

    public GameWorld() throws IOException {
        gameWelcome();
        gameProcess();
    }

    //a method ask user to input the number of teams they want and initialize it.
    private List<Team> teamInitialize() throws IOException {
        System.out.println("How many players you want to play within this game? Input a digit between 1-4(up to 4 gamers right now)");
        Helper helper = new Helper();
        int heroNum = helper.inputNumberChecker(Constant.GAMER_NUMBER);
        List<Team> teams = new ArrayList<>(heroNum);

        //create each team
        for (int i = 0; i < heroNum; i++) {
            Team team = new Team();
            teams.add(team);
        }
        return teams;
    }

    //print instruction and help message and initialize needed variables
    private void gameWelcome() throws IOException {
        System.out.println(Constant.WELCOME);

        //initialize map and teams
        setMap(new GameMap());
        setTeams(teamInitialize());
    }

    //game logic and process
    private void gameProcess() throws IOException {
        //generate the coordinate for team randomly.
        List<Team> teams = getTeams();
        for (Team team : teams) {
            generateCoordinate(team);
        }

        //now let each team move one by one.
        while (true) {
            //for each team make movement once
            for (Team team : getTeams()) {
                teamMove(team);
            }
            //make endless move for next loop
        }
    }

    //generate the coordinate for team randomly.
    private void generateCoordinate(Team team){
        Integer mapWidth = getMap().getMapWidth();
        Integer mapHeight = getMap().getMapHeight();

        //generate random x,y coordinates
        Random random = new Random();
        int coordinateX = random.nextInt(mapWidth);
        int coordinateY = random.nextInt(mapHeight);

        //check if its a market or unreachable cell
        Marker randomCell = getMap().getCellMarker(coordinateX, coordinateY);
        boolean unreachable = randomCell.isUnreachable();
        boolean market = randomCell.isMarket();
        boolean common = randomCell.isCommon();
        if (unreachable || market) {
            //regenerate coordinate
            generateCoordinate(team);
        }

        //let hero be in the common cell
        if (common) {
            randomCell.teamComes(team);
            team.move(coordinateX, coordinateY);
        }

        System.out.println(getMap());
        System.out.println("Team "+team.getPlayerName()+" generated on map with icon:"+team.getTeamIcon());
    }

    private void teamMove(Team team) throws IOException {
        //read input wasd i
        Helper helper = new Helper();
        //if i print information in movement checker and read wasd
        String movement = helper.movementChecker(team);
        movement = movement.toLowerCase();

        //check the team initial position
        int coordinateX = team.getCoordinateX();
        int coordinateY = team.getCoordinateY();

        //make move
        switch (movement) {
            case "w":
                moveTo(team,coordinateX-1,coordinateY, coordinateX, coordinateY);
                break;
            case "a":
                moveTo(team,coordinateX,coordinateY-1, coordinateX, coordinateY);
                break;
            case "s":
                moveTo(team,coordinateX+1,coordinateY, coordinateX, coordinateY);
                break;
            case "d":
                moveTo(team,coordinateX,coordinateY+1, coordinateX, coordinateY);
                break;
        }

    }

    private void moveTo(Team team, int X, int Y, int initialX, int initialY) throws IOException {
        Helper helper = new Helper();
        try {
            //bound check cant go outside of map
            if (X<0||Y<0) {
                throw new Exception(helper.addColor("Destination is out of map, please input another direction", Constant.ANSI_RED));
            }
            if (X>=map.getMapWidth()||Y>=map.getMapHeight()) {
                throw new Exception(helper.addColor("Destination is out of map, please input another direction", Constant.ANSI_RED));
            }
            //unreachable check
            if (map.getCellMarker(X,Y).isUnreachable()) {
                throw new Exception(helper.addColor("Destination is an unreachable cell, please input another direction", Constant.ANSI_RED));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            teamMove(team);
            return;
        }
        //move the hero might be fight or market

        //first write about market
        //hero get into a market
        Cell nextCell = map.getCell(X,Y);
        Marker nextCellMarker = map.getCellMarker(X, Y);
        Marker lastCellMarker = map.getCellMarker(initialX, initialY);
        //change marker
        nextCellMarker.teamComes(team);
        map.setCellMarker(X, Y, nextCellMarker);
        lastCellMarker.teamLeft();
        map.setCellMarker(initialX, initialY, lastCellMarker);
        //change the team coordinate
        team.move(X,Y);
        //going into the cell and things happened. For example you can buy in market and might fight in common cell
        nextCell.eventProcess(team);
        System.out.println(map);
        //the movement for this current team is done for once.
    }

    //getters and setters
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
