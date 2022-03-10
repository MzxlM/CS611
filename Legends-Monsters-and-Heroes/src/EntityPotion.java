/**
 * A Potion class extends BaseEntity and implement Usable and Sellable interface.
 */
public class EntityPotion extends EntityBaseEntity implements Useable, Sellable{
    private Integer attributeIncrease;
    private String attributeAffected;

    public EntityPotion(String name, Integer cost, Integer levelRequirement, Integer attributeIncrease, String attributeAffected) {
        super(name, cost, levelRequirement,Constant.POTION);
        setAttributeAffected(attributeAffected);
        setAttributeIncrease(attributeIncrease);
    }

    public EntityPotion(String potion) {
        super();
        //separate the string into a list of string.
        String[] stats= potion.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setCost(Integer.parseInt(stats[1]));
        setLevelRequirement(Integer.parseInt(stats[2]));
        setAttributeIncrease(Integer.parseInt(stats[3]));
        setAttributeAffected(stats[4]);
        setType(Constant.POTION);
    }

    @Override
    public String toString() {
        return String.format("\nName: %s, Cost: %d, required level: %d, attribute increase: %d, attribute affected: %s",
                getName(), getCost(), getLevelRequirement(), getAttributeIncrease(), getAttributeAffected());
    }

    //getters and setters
    public Integer getAttributeIncrease() {
        return attributeIncrease;
    }

    public void setAttributeIncrease(Integer attributeIncrease) {
        this.attributeIncrease = attributeIncrease;
    }

    public String getAttributeAffected() {
        return attributeAffected;
    }

    public void setAttributeAffected(String attributeAffected) {
        this.attributeAffected = attributeAffected;
    }


}
