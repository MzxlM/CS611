/**
 * A Monster interface that represents monster and its basic functions
 */
public interface Monster extends Fightable, Alive{

    void onFire();

    void freezing();

    void flashed();

    String getName();

    Integer getLevel();
}
