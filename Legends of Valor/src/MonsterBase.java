import java.util.Random;

/**
 * A MonsterBase class that represents the basic prototype of monsters
 */
public abstract class MonsterBase implements Monster{

    //monster property
    private String name;
    private Integer level;
    private Integer hp;
    private Integer damage;
    private Integer defense;
    private Integer dodgeChance;
    private String monsterType;
    private int coordinateX = -1;
    private int coordinateY = -1;

    public MonsterBase(String name, Integer level, Integer damage, Integer defense, Integer dodgeChance, String monsterType) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.monsterType = monsterType;
        this.hp = level*100;
    }

    public MonsterBase(String s, String monsterType) {
        super();
        //separate the string into a list of string.
        String[] stats= s.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setLevel(Integer.parseInt(stats[1]));
        setDamage(Integer.parseInt(stats[2]));
        setDefense(Integer.parseInt(stats[3]));
        setDodgeChance(Integer.parseInt(stats[4]));
        setMonsterTypes(monsterType);
        setHp(getLevel()*100);
    }

    private void setMonsterTypes(String monsterType) {
        switch (monsterType) {
            case Constant.DRAGON:
                setMonsterType(Constant.DRAGON);
                break;
            case Constant.EXOSKELETON:
                setMonsterType(Constant.EXOSKELETON);
                break;
            case Constant.SPIRIT:
                setMonsterType(Constant.SPIRIT);
                break;
        }
    }

    @Override
    public String toString() {
        return "\nmonster " + monsterType+ ": {" +
                "name='" + name +
                ", level=" + level +
                ", hp=" + hp +
                ", damage=" + damage +
                ", defense=" + defense +
                ", dodgeChance=" + dodgeChance +
                "}";
    }

    @Override
    public Integer defense(Integer attackNumber) {
        //decrease attack by 0.05* defense
        double v = attackNumber - this.getDefense() * 0.05;
        //change hp
        this.setHp(this.getHp() - (int) v);
        return (int) v;
    }

    @Override
    public boolean dodging() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        double dodging = Math.ceil(getDodgeChance());
        //hero dodging
        if (randomInt <= (int)dodging) {
            System.out.println("Miss, Monster "+this.getName()+" doges");
            return true;
        }
        return false;
    }

    @Override
    public void move(Integer X, Integer Y){
        setCoordinateX(X);
        setCoordinateY(Y);
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    //hero cast a fire spell to monster
    @Override
    public void onFire() {
        setDefense((int) (this.defense * 0.9));
    }

    //hero cast a ice spell to monster
    @Override
    public void freezing() {
        setDamage((int) (this.damage * 0.9));
    }

    //hero cast a lighting spell to monster
    @Override
    public void flashed() {
        setDodgeChance((int) (this.dodgeChance * 0.9));
    }

    //monster do the normal attack and return the dmg number
    @Override
    public Integer attack() {
        return (int)(getDamage()*0.05);
    }

    @Override
    public Monster clone() {
        Monster o = null;
        try {
            o = (Monster)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return  o;
    }

    //getters and setters
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(Integer dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    @Override
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public int getCoordinateX() {
        return coordinateX;
    }

    @Override
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    @Override
    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
