/**
 * a marker Object saves some memorable info
 */
public class Marker {
    //denote whether or not the cell is hero market, unreachable or common
    private boolean containsHero;
    private boolean containsMonster;
    private boolean isNexus;
    private boolean isUnreachable;
    private boolean isCommon;
    private boolean isBush;
    private boolean isCave;
    private boolean isKoulou;
    private boolean isExplored;
    private String heroIcon = "H";
    private String monsterIcon = "M";

    //constructors
    public Marker() {
        setContainsHero(Boolean.FALSE);
        setContainsMonster(Boolean.FALSE);
        setNexus(Boolean.FALSE);
        setCommon(Boolean.FALSE);
        setUnreachable(Boolean.FALSE);
        setBush(Boolean.FALSE);
        setCave(Boolean.FALSE);
        setKoulou(Boolean.FALSE);
        setExplored(Boolean.FALSE);
    }

    //if the markerType is market, set the marker as default market. same for rest.
    public void markerInitialize(Integer markerType) {
        if (markerType.equals(Constant.NEXUS)) {
            setNexus(Boolean.TRUE);
        } else if (markerType.equals(Constant.UNREACHABLE)) {
            setUnreachable(Boolean.TRUE);
        } else if (markerType.equals(Constant.COMMON)) {
            setCommon(Boolean.TRUE);
        } else if (markerType.equals(Constant.BUSH)) {
            setBush(Boolean.TRUE);
        } else if (markerType.equals(Constant.CAVE)) {
            setCave(Boolean.TRUE);
        } else if (markerType.equals(Constant.KOULOU)) {
            setKoulou(Boolean.TRUE);
        }
    }

    public void heroComes(Hero hero){
        setContainsHero(Boolean.TRUE);
        setExplored(Boolean.TRUE);
        setHeroIcon(hero.getHeroIcon());
    }

    public void heroLeft(){
        setContainsHero(Boolean.FALSE);
    }

    public void monsterComes(Monster monster){
        setContainsMonster(Boolean.TRUE);
        setExplored(Boolean.FALSE);
    }

    public void monsterLeft() { setContainsMonster(Boolean.FALSE); }

    //getters and setters
    public boolean isContainsHero() {
        return containsHero;
    }

    public void setContainsHero(boolean containsHero) {
        this.containsHero = containsHero;
    }

    public boolean isContainsMonster() { return containsMonster; }

    public void setContainsMonster(boolean containsMonster) {this.containsMonster = containsMonster; }

    public boolean isNexus() {
        return isNexus;
    }

    public void setNexus(boolean market) {
        isNexus = market;
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

    public boolean isBush() {
        return isBush;
    }

    public void setBush(boolean bush) {
        this.isBush = bush;
    }

    public boolean isCave() {
        return isCave;
    }

    public void setCave(boolean cave) {
        this.isCave = cave;
    }

    public boolean isKoulou() {
        return isKoulou;
    }

    public void setKoulou(boolean koulou) {
        this.isKoulou = koulou;
    }

    public boolean isExplored() {
        return isExplored;
    }

    public void setExplored(boolean explored) {
        isExplored = explored;
    }

    public String getHeroIcon() { return heroIcon; }

    public void setHeroIcon(String heroIcon) { this.heroIcon = heroIcon; }

    public String getMonsterIcon() { return monsterIcon; }

    public void setMonsterIcon(String monsterIcon) { this.monsterIcon = monsterIcon; }
}
