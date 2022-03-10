import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A Team object, class that represents the team with all the heroes belong to this team.
 */
public class Team{
    private List<Hero> heroes;
    private String teamIcon;
    private String playerName;//name of current player
    private int coordinateX = -1;
    private int coordinateY = -1;


    public Team(List<Hero> heroes, String teamIcon, String playerName) {
        this.heroes = heroes;
        this.teamIcon = teamIcon;
        this.playerName = playerName;
    }

    public Team() throws IOException {
        setHeroes(teamInitialize());
    }

    public void move(Integer X, Integer Y){
        setCoordinateX(X);
        setCoordinateY(Y);
    }

    private List<Hero> teamInitialize() throws IOException {
        return heroes;
    }

    public void printHeroes(){
        Helper helper = new Helper();
        int i=0;
        for (Hero hero : this.getHeroes()) {
            i++;
            System.out.print(helper.addColor(i+". ", Constant.ANSI_PURPLE));
            System.out.println(hero);
//            System.out.println(Constant.ANSI_PURPLE+i+". " +Constant.ANSI_RESET+ hero);
        }
    }

    @Override
    public String toString() {
        return "Team "+ getPlayerName() +", Icon->"+ getTeamIcon() +":\n"+ heroes.toString();
    }

    //getters and setters
    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        Helper helper = new Helper();
        try{
            if (coordinateX < 0) {
                throw new Exception(helper.addColor("Input X should not be smaller than 0!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input X should not be smaller than 0!"+Constant.ANSI_RESET);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        Helper helper = new Helper();
        try{
            if (coordinateY < 0) {
                throw new Exception(helper.addColor("Input Y should not be smaller than 0!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input Y should not be smaller than 0!"+Constant.ANSI_RESET);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        this.coordinateY = coordinateY;
    }
}
