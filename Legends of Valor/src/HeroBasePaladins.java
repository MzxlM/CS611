/**
 * A HeroBasePaladins hero class which represents paladins
 */
public class HeroBasePaladins extends HeroBase {
    public HeroBasePaladins(String s, String heroType) {
        super(s, heroType);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setStrength((int) (getStrength() * 1.1));
        setDexterity((int) (getDexterity() * 1.1));
        setAgility((int) (getAgility() * 1.05));
        setDefense((int) (getDefense() * 1.05));

    }
}
