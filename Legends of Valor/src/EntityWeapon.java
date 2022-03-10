/**
 * A Weapon class extends BaseEntity and implement Equipable and Sellable interface.
 */
public class EntityWeapon extends EntityBaseEntity implements Sellable{
    private Integer damage;
    private Integer hands;

    //Constructors for weapon
    public EntityWeapon(String name, Integer cost, Integer levelRequirement, Integer damage, Integer hands) {
        super(name, cost, levelRequirement, Constant.WEAPON);
        setDamage(damage);
        setHands(hands);
    }

    public EntityWeapon(String weapon) {
        super();
        //separate the string into a list of string.
        String[] stats= weapon.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setCost(Integer.parseInt(stats[1]));
        setLevelRequirement(Integer.parseInt(stats[2]));
        setDamage(Integer.parseInt(stats[3]));
        setHands(Integer.parseInt(stats[4]));
        setType(Constant.WEAPON);
    }


    @Override
    public String toString() {
        return String.format("\nName: %s, Cost: %d, required level: %d,  damage: %d, hands: %d",
                getName(), getCost(), getLevelRequirement(), getDamage(), getHands());
    }

    //getters and setters
    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHands() {
        return hands;
    }

    public void setHands(Integer hands) {
        this.hands = hands;
    }
}
