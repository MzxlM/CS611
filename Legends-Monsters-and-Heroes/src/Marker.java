/**
 * a marker Object saves some memorable info
 */
public class Marker {
    //denote whether or not the cell is hero market, unreachable or common
    private boolean containsTeam;
    private boolean isMarket;
    private boolean isUnreachable;
    private boolean isCommon;
    private String teamIcon = "H";

    //constructors
    public Marker() {
        setContainsTeam(Boolean.FALSE);
        setMarket(Boolean.FALSE);
        setCommon(Boolean.FALSE);
        setUnreachable(Boolean.FALSE);
        setCommon(Boolean.FALSE);
    }

    //if the markerType is market, set the marker as default market. same for rest.
    public void markerInitialize(Integer markerType) {
        if (markerType.equals(Constant.MARKET)) {
            setMarket(Boolean.TRUE);
        } else if (markerType.equals(Constant.UNREACHABLE)) {
            setUnreachable(Boolean.TRUE);
        } else if (markerType.equals(Constant.COMMON)) {
            setCommon(Boolean.TRUE);
        }
    }

    //the methods for hero comes and left.
    public void teamComes(Team team){
        setContainsTeam(Boolean.TRUE);
        setTeamIcon(team.getTeamIcon());
    }

    public void teamLeft(){
        setContainsTeam(Boolean.FALSE);
    }

    //getters and setters
    public boolean isContainsTeam() {
        return containsTeam;
    }

    public void setContainsTeam(boolean containsTeam) {
        this.containsTeam = containsTeam;
    }

    public boolean isMarket() {
        return isMarket;
    }

    public void setMarket(boolean market) {
        isMarket = market;
    }

    public boolean isUnreachable() {
        return isUnreachable;
    }

    public void setUnreachable(boolean unreachable) {
        isUnreachable = unreachable;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }
}
