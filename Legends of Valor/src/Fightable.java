/**
 * A Fightable interface, class that implement this interface means they can fight with others. like hero and monster
 */
public interface Fightable {
    Integer defense(Integer attackNumber);
    Integer attack();
    boolean dodging();
}
