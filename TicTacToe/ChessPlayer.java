
/**
 * @description: Chess Player object that contains some basic features.
 * @author: Xinlong Zhang
 * @date: 2021/9/29 4:42 PM
 */
public class ChessPlayer {
    //name of player and the chess type they have
    private String name;
    private String chessType;
    private Integer wins;
    private Integer team;

    //player object
    public ChessPlayer (String name) {
        this.name = name;
        this.chessType = "*";
        this.wins = 0;
    }
    public ChessPlayer () {
        this.name = "default";
        this.chessType = "*";
        this.wins = 0;
    }

    //get name of player
    public String getName() {
        return this.name;
    }

    //get chessType player choose
    public String getChessType() {
        return this.chessType;
    }

    //set chessType to player
    public void setChessType(String chessType) {
        this.chessType = chessType;
    }

    //set name to player
    public void setName(String name) {
        this.name = name;
    }

    //get the number of wins
    public Integer getWins() {
        return wins;
    }

    //set the number of wins
    public void setWins(Integer wins) {
        if (wins <0) {
            throw new IllegalArgumentException("User profile number of wins is wrong.");
        }
        this.wins = wins;
    }

    //get team name
    public Integer getTeam() {
        return team;
    }

    //set team name
    public void setTeam(Integer team) {
        this.team = team;
    }

    public boolean isValid() {
        //if name is empty or chessType is empty or wins <0 its not a valid player
        return !name.isEmpty() && !chessType.isEmpty();
    }


    public boolean equals(ChessPlayer player) {
        return this.name.equals(player.name);
    }

    //set the players
    public void setPlayer(ChessPlayer player) {
        setName(player.getName());
        setChessType("*");
        setWins(0);
    }

}
