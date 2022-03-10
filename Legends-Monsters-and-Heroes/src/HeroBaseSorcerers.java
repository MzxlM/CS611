/**
 * A HeroBaseSorcerers hero class which represents Sorcerers
 */
public class HeroBaseSorcerers extends HeroBase {


    public HeroBaseSorcerers(String s, String heroType) {
        super(s, heroType);
    }

    @Override
    public void levelUp() {
        super.levelUp();

        setStrength((int) (getStrength() * 1.05));
        setDexterity((int) (getDexterity() * 1.1));
        setAgility((int) (getAgility() * 1.1));
        setDefense((int) (getDefense() * 1.05));
    }
}
