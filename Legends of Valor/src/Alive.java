/**
 * A Alive class which represents alive object like hero and monsters
 */
public interface Alive extends Cloneable{
    void move(Integer X, Integer Y);

    boolean isAlive();
    Integer getHp();
    int getCoordinateX();
    int getCoordinateY();
}
