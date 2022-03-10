/**
 * A armor class extends BaseEntity and implement Equipable and Sellable interface.
 */
public class EntityArmor extends EntityBaseEntity implements Sellable{
    private Integer damageReduction;

    //constructors for armor
    public EntityArmor(String name, Integer cost, Integer levelRequirement, Integer damageReduction) {
        super(name, cost, levelRequirement, Constant.ARMOR);
        setDamageReduction(damageReduction);
    }

    public EntityArmor(String armor) {
        super();
        //separate the string into a list of string.
        String[] stats= armor.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setCost(Integer.parseInt(stats[1]));
        setLevelRequirement(Integer.parseInt(stats[2]));
        setDamageReduction(Integer.parseInt(stats[3]));
        setType(Constant.ARMOR);
    }

    //print out the detail of this armor including name cost, level requirement and damage reduction.
    @Override
    public String toString() {
        return String.format("\nName: %s, Cost: %d, required level: %d, damageReduction: %d",
                getName(), getCost(), getLevelRequirement(), getDamageReduction());
    }




    //getters and setters
    public void setDamageReduction(Integer damageReduction) {
        this.damageReduction = damageReduction;
    }

    public Integer getDamageReduction() {
        return damageReduction;
    }
}
