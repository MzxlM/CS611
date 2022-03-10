import java.util.List;

/**
 * A Hero interface, class that implement this interface means it's a hero.
 */
public interface Hero extends Fightable, Alive{
    void usePotion(EntityPotion entityPotion);
    void buy(EntityBaseEntity item);
    void sell();
    void levelUp();
    void changeWeapon(EntityBaseEntity weapon);
    void removeWeapon();
    void changeArmor(EntityBaseEntity newArmor);
    void removeArmor();
    List<EntityBaseEntity> getBag();
    void printBag();
    void learnSpell(EntityBaseEntity Spell);
    String getName();
    void printSpellsLearned();
    Integer castSpell(Monster monster);
    Integer getLevel();
    Integer getMoney();
    void setMoney(Integer money);
    void revived(boolean status);
    void restore();
    void gainExp(Integer experience);

}
