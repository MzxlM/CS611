import java.util.List;

/**
 * A Hero interface, class that implement this interface means it's a hero.
 */
public interface Hero extends Fightable, Alive{
    void usePotion(EntityPotion entityPotion);
    void levelUp();
    void sellRemove(EntityBaseEntity item);
    void changeWeapon(EntityBaseEntity weapon);
    void removeWeapon();
    void changeArmor(EntityBaseEntity newArmor);
    void removeArmor();
    List<EntityBaseEntity> getBag();
    void move(Integer X, Integer Y);
    void printBag();
    void learnSpell(EntityBaseEntity Spell);

    void cloneInitialize();

    String getName();
    void printSpellsLearned();
    Integer castSpell(Monster monster);
    Integer getLevel();
    Integer getMoney();
    void setMoney(Integer money);
    void revived(boolean status);
    void restore();
    void gainExp(Integer experience);
    void setCoordinateX(int coordinateX);
    void setCoordinateY(int coordinateY);
    void setHeroIcon(String s);
    String getHeroIcon();

    int[] getNexus();
    Hero clone();
    void setNexus(Integer X, Integer Y);
}
