/**
 * A Spell class extends BaseEntity and implement Useable and Sellable interface.
 */
public class EntitySpell extends EntityBaseEntity implements Useable, Sellable{
    private Integer damage;
    private Integer manaCost;
    private String spellType;

    //constructor for spell
    public EntitySpell(String name, Integer cost, Integer levelRequirement, Integer damage, Integer manaCost, String spellType) {
        super(name, cost, levelRequirement,Constant.SPELL);
        setDamage(damage);
        setManaCost(manaCost);
        setSpellType(spellType);

    }

    public EntitySpell(String spell, String spellType) {
        super();
        //separate the string into a list of string.
        String[] stats= spell.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setCost(Integer.parseInt(stats[1]));
        setLevelRequirement(Integer.parseInt(stats[2]));
        setDamage(Integer.parseInt(stats[3]));
        setManaCost(Integer.parseInt(stats[4]));
        setType(Constant.SPELL);

        switch (spellType) {
            case Constant.FIRE:
                setSpellType(Constant.FIRE);
                break;
            case Constant.ICE:
                setSpellType(Constant.ICE);
                break;
            case Constant.LIGHTNING:
                setSpellType(Constant.LIGHTNING);
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("\nType: %s, Name: %s, Cost: %d, required level: %d,  damage: %d, mana cost: %d",
                getSpellType(), getName(), getCost(), getLevelRequirement(), getDamage(), getManaCost());
    }

    //getters and setters
    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String type) {
        this.spellType = type;
    }


}
