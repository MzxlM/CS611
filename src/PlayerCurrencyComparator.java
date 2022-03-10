import java.util.Comparator;
/**
 * @author: Xinlong Zhang
 * @className: PlayerCurrencyComparator
 * @description: the comparator for comparing player with their currency. Bigger values go first
 **/
public class PlayerCurrencyComparator implements Comparator<BJPlayer> {
    @Override
    public int compare(BJPlayer o1, BJPlayer o2) {
        if (o1.getCurrency() > o2.getCurrency()) {
            return -1;
        }
        if (o1.getCurrency() < o2.getCurrency()) {
            return 1;
        }
        if (o1.getCurrency().equals(o2.getCurrency()) ) {
            return 0;
        }
        return 0;
    }

}
