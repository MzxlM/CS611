/**
 * A abstract Cell object, class that represent base cell that is part of the map
 */
public abstract class CellBase implements Cell {

    private Marker marker;

    public CellBase(Marker marker) {
        this.marker = marker;
    }

    public CellBase(){
        this.marker = new Marker();
    }

    @Override
    public String toString() {
        Helper helper = new Helper();
        // if there's hero print hero, otherwise print commonCell
        boolean containsHero = this.getMarker().isContainsHero();
        boolean containsMonster = this.getMarker().isContainsMonster();
        //only contains hero
        if (containsHero == true && containsMonster == false){
            String heroIcon = helper.addColor(getMarker().getHeroIcon(), Constant.ANSI_GREEN);
            return "| " + heroIcon + "    |";
        }
        //only contains monster
        else if(containsHero == false && containsMonster == true){
            String monsterIcon = helper.addColor(getMarker().getMonsterIcon(), Constant.ANSI_CYAN);
            return "|    " + monsterIcon + "  |";
        }
        //contains a monster and a hero
        else if(containsHero == true && containsMonster == true){
            String heroIcon = helper.addColor(getMarker().getHeroIcon(), Constant.ANSI_GREEN);
            String monsterIcon = helper.addColor(getMarker().getMonsterIcon(), Constant.ANSI_CYAN);
            return "| " + heroIcon + " " + monsterIcon + "  |";
        }
        else{
            return "|       |";
        }
    }

    @Override
    public Marker getMarker() {
        return marker;
    }

    @Override
    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
