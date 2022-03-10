/**
 * A HeroBaseWarriors hero class which represents Warriors
 */
public class HeroBaseWarriors extends HeroBase {
    public HeroBaseWarriors(String s, String heroType) {
        super(s, heroType);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setStrength((int) (getStrength() * 1.1));
        setDexterity((int) (getDexterity() * 1.05));
        setAgility((int) (getAgility() * 1.05));
        setDefense((int) (getDefense() * 1.05));
    }
}
