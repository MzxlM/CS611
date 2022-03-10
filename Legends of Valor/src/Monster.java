/**
 * A Monster interface that represents monster and its basic functions
 */
public interface Monster extends Fightable, Alive{

    void onFire();

    void freezing();

    void flashed();

    String getName();

    Integer getLevel();

    void setCoordinateX(int coordinateX);
    Monster clone();
    void setCoordinateY(int coordinateY);
}
