/**
 * A abstract EntityBaseEntity object, class that represent base property of all items
 */
public abstract class EntityBaseEntity implements Entity{
    private String name;
    private Integer levelRequirement;
    private Integer cost;
    private String type;

    public EntityBaseEntity(String name, Integer cost, Integer levelRequirement, String type) {
        setName(name);
        setCost(cost);
        setLevelRequirement(levelRequirement);
        setType(type);
    }
    public EntityBaseEntity(){

    }

    @Override
    public String toString() {
        return "EntityBaseEntity{" +
                "name='" + name + '\'' +
                ", levelRequirement=" + levelRequirement +
                ", cost=" + cost +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(Integer levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
