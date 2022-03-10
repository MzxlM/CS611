import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * an abstract hero class which hero can do  toString levelUp usePotion changeEquip change armor learn a spell ，attack
 */
public abstract class HeroBase implements Hero{

    //hero status
    private String name;
    private Integer level;
    private Integer hp;
    private Integer mana;
    private Integer money;
    private Integer experience;

    private Integer strength;
    private Integer dexterity;
    private Integer agility;
    private Integer defense;

    private EntityBaseEntity entityWeapon;
    private EntityBaseEntity entityArmor;
    private List<EntityBaseEntity> spellsLearned = new ArrayList<>();

    private String heroType;
    private List<EntityBaseEntity> bag=new ArrayList<>();

    //constructors for hero class
    public HeroBase(String name, Integer level, Integer hp, Integer mana, Integer money,
                    Integer experience, Integer strength, Integer dexterity,
                    Integer agility, Integer defense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.mana = mana;
        this.money = money;
        this.experience = experience;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.defense = defense;
        this.entityWeapon = new EntityWeapon("NoWeapon", 0, 1, 0, 1);
        this.entityArmor = new EntityArmor("NoArmor", 0, 1, 0);

    }

    public HeroBase(String s, String heroType) {
        super();
        //separate the string into a list of string.
        String[] stats= s.split("\\s+");
        //match the data from the string to corresponding part
        setName(stats[0]);
        setMana(Integer.parseInt(stats[1]));
        setStrength(Integer.parseInt(stats[2]));
        setAgility(Integer.parseInt(stats[3]));
        setDexterity(Integer.parseInt(stats[4]));
        setMoney(Integer.parseInt(stats[5]));
        setExperience(Integer.parseInt(stats[6]));
        setDefense(100);
        setLevel(1);
        setHp(getLevel()*100);
        this.entityWeapon = new EntityWeapon("NoWeapon", 0, 1, 0, 1);
        this.entityArmor = new EntityArmor("NoArmor", 0, 1, 0);
        switch (heroType) {
            case Constant.SORCERERS:
                setHeroType(Constant.SORCERERS);
                break;
            case Constant.WARRIORS:
                setHeroType(Constant.WARRIORS);
                break;
            case Constant.PALADINS:
                setHeroType(Constant.PALADINS);
                break;
        }

    }

    //when status is true, all team dies money needs to be halfed
    @Override
    public void revived(boolean status) {
        setHp(getLevel()*50);
        if (status) {
            setMoney(Math.floorDiv(getMoney(), 2));
        }
    }

    @Override
    public void restore() {
        this.hp = (int) (this.hp * 1.1);
        this.mana = (int) (this.mana * 1.1);
    }

    @Override
    public void gainExp(Integer experience) {
        this.setExperience(getExperience()+experience);
    }

    @Override
    public void learnSpell(EntityBaseEntity spell) {
        this.spellsLearned.add(spell);
        //debug see removed or not
        this.bag.remove(spell);
    }

    //override the toString methods
    @Override
    public String toString() {
        return "\nhero "+heroType+"{" +
                "name:" + name +
                ", level:" + level +
                ", hp:" + hp +
                ", mana:" + mana +
                ", strength:" + strength +
                ", agility:" + agility +
                ", dexterity:" + dexterity +
                ", money:" + money +
                ", experience:" + experience +
                "\nEquipment: Weapon["+ entityWeapon.getName() +"] and Armor ["+ entityArmor.getName() +
                "]}";
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    //when hero level up
    public void levelUp(){
        if (getExperience() - getLevel() * 10 < 0) {
            return;
        }
        //increase all the corresponding properties
        setExperience(getExperience() - getLevel() * 10);
        setLevel(getLevel() + 1);
        setHp(getLevel() * 100);
        setMana((int) (getMana() * 1.1));
        setDefense((int) (getDefense() * 1.1));
    }

    //hero can use a potion
    @Override
    public void usePotion(EntityPotion entityPotion){
        if (entityPotion == null) {
            return;
        }
        Integer attributeIncrease = entityPotion.getAttributeIncrease();
        String attributesAffected = entityPotion.getAttributeAffected();

        //if the potion is all attributed, change it to specified attributes
        if (attributesAffected.equals("All")) {
            attributesAffected = Constant.ATTRIBUTED_ALL;
        }
        //split attributes to an arraylist.
        String[] strings = attributesAffected.split("/");
        List<String> attributeAffected = new ArrayList<String>(Arrays.asList(strings));

        //use the potion
        usePotion(attributeAffected, attributeIncrease);

        //remove potion from bag
        this.bag.remove(entityPotion);
    }

    private void usePotion(List<String> attributeAffected, Integer attributeIncrease) {
        for (String s : attributeAffected) {
            switch (s){
                //increase corresponding attributes.
                case Constant.ATTRIBUTED_HEALTH:
                    this.setHp(this.getHp()+attributeIncrease);
                    break;
                case Constant.ATTRIBUTED_STRENGTH:
                    this.setStrength(this.getStrength()+attributeIncrease);
                    break;
                case Constant.ATTRIBUTED_MANA:
                    this.setMana(this.getMana()+attributeIncrease);
                    break;
                case Constant.ATTRIBUTED_AGILITY:
                    this.setAgility(this.getAgility()+attributeIncrease);
                    break;
                case Constant.ATTRIBUTED_DEFENSE:
                    this.setDefense(this.getDefense()+attributeIncrease);
                    break;
                case Constant.ATTRIBUTED_DEXTERITY:
                    this.setDexterity(this.getDexterity()+attributeIncrease);
                    break;
            }
        }

    }

        //hero can buy an item from the market
    @Override
    public void buy(EntityBaseEntity item) {
        //level check
        if (requirementCheck(item.getLevelRequirement(), this.getLevel(), " You dont meet the level requirement to buy " + item.getName() + "\n")) return;

        //money check
        if (requirementCheck(item.getCost(), this.getMoney(), " You dont meet have enough money to buy " + item.getName()+ "\n")) return;

        //hero pay for it
        Integer restMoney = getMoney() - item.getCost();
        setMoney(restMoney);
        System.out.println("Thank you for your purchase, your current balance is : " + restMoney);

        //add item to bag
        this.bag.add(item);
    }

    //hero can sell a item for half the price they bought
    @Override
    public void sell(){
        Helper helper = new Helper();
        printBag();

        //select hero to do sell and buy
        int size = bag.size();
        System.out.println("Select the item you are selling by entering the number before hero.(1-"+ size +") " +
                "Enter "+ (size+1)+" to exit market");
        Integer inputNumber = helper.inputNumberChecker(size + 1);

        //if the player want to exit the market
        if (inputNumber.equals(size+1)) {
            return;
        }else{
            sell(bag.get(inputNumber-1));
        }

        System.out.println("Do you want to sell another item on the market? Enter Y/y for another buy. N/n to exit");
        String result = helper.getResultForYN(this, null);

        if (result.equals("y")){
            sell();
        }
        return;
    }

    @Override
    public void printBag() {
        Helper helper = new Helper();
        System.out.println("You have the following things in your bag: ");
        helper.printItems(bag);
    }



    private void sell(EntityBaseEntity item) {
        //hero pay for it
        double moneyBack = item.getCost() * 0.5;
        Integer restMoney = getMoney() + (int) moneyBack;
        setMoney(restMoney);
        System.out.println("Thank you for your selling, your current balance is : " + restMoney);

        //remove item to bag
        this.bag.remove(item);
    }

    @Override
    //for hero to change another weapon
    public void changeWeapon(EntityBaseEntity newWeapon){
        if (newWeapon == null) {
            return;
        }
        this.bag.remove(newWeapon);
        EntityBaseEntity weapon = getWeapon();
        this.bag.add(weapon);
        if (weapon.getName().equals("NoWeapon")) {
            this.bag.remove(weapon);
        }
        setWeapon(newWeapon);
    }

    @Override
    //for hero to remove current weapon
    public void removeWeapon(){
        EntityBaseEntity weapon = getWeapon();
        this.bag.add(weapon);
        setWeapon(new EntityWeapon("NoWeapon", 0, 1, 0, 1));
    }

    @Override
    //for hero to change another armor
    public void changeArmor(EntityBaseEntity newArmor){
        if (newArmor == null) {
            return;
        }
        this.bag.remove(newArmor);
        EntityBaseEntity armor = getArmor();
        this.bag.add(armor);
        if (armor.getName().equals("NoArmor")) {
            this.bag.remove(armor);
        }
        setArmor(newArmor);
    }

    @Override
    //for hero to remove current armor
    public void removeArmor(){
        EntityBaseEntity armor = getArmor();
        this.bag.add(armor);
        setArmor(new EntityArmor("NoArmor", 0, 1, 0));
    }


    //hero's ability to defense
    @Override
    public Integer defense(Integer attackNumber) {
        //decrease attack by 0.05* defense and the dmg reduction by armor
        double v = attackNumber - this.getDefense() * 0.05- getArmor().getDamageReduction()*Constant.DMG_REDUCTION_RATE;
        //change hp
        this.setHp(this.getHp() - (int) v);
        return(int) v;
    }

    @Override
    public boolean dodging() {
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        double dodging = Math.ceil(getAgility()*0.002);
        //hero dodging
        if (randomInt <= (int)dodging) {
            System.out.println("Miss, Hero "+this.getName()+" doges");
            return true;
        }
        return false;
    }

    //check whether a hero can use or buy a stuff with special conditions
    private boolean requirementCheck(Integer requirement, Integer heroStatus, String s) {
        //level check
        if (requirement > heroStatus) {
            System.out.println(s);
            return true;
        }
        return false;
    }

    //hero do the normal attack and return the dmg number
    @Override
    public Integer attack() {
        return (int)(getStrength()+getWeapon().getDamage()*0.05);
    }

    //hero castSpell on monster and return the ture dmg on monster
    @Override
    public Integer castSpell(Monster monster) {
        Helper helper = new Helper();
        //mana check
        if (manaCheck()) {
            helper.printWithColor("Your dont have any spell you can use! reason might be not enough mana, or you didnt learn anything", Constant.ANSI_RED);
//            System.out.println("Your dont have any spell you can use! reason might be not enough mana, or you didnt learn anything");
            return 0;
        }
        System.out.println("Choose one of the following spell:\n");
        printSpellsLearned();
        //choose a spell
        EntitySpell spellChosen = getSpell(helper);

        //check mana
        while (this.getMana()<spellChosen.getManaCost()) {
            helper.printWithColor("You dont have enough mana for this spell. Please choose another one!", Constant.ANSI_RED);
//            System.out.println("You dont have enough mana for this spell. Please choose another one!");
            spellChosen = getSpell(helper);
        }

        setMana(getMana() - spellChosen.getManaCost());
        //if the spell is dodging
        if (monster.dodging()) {
            return 0;
        }

        Integer spellDmg = spellChosen.getDamage()+ Math.floorDiv(getDexterity(), 10000)*spellChosen.getDamage();
        //cast dmg on monster
        Integer realDmg = monster.defense(spellDmg);
        //set monster's fired or sth
        switch (spellChosen.getSpellType()){
            case Constant.FIRE:
                monster.onFire();
                break;
            case Constant.ICE:
                monster.freezing();
                break;
            case Constant.LIGHTNING:
                monster.flashed();
                break;
        }
        return realDmg;
    }

    private EntitySpell getSpell(Helper helper) {
        //let the player choose a spell
        Integer inputNumberChecker = helper.inputNumberChecker(this.getSpellsLearned().size());
        inputNumberChecker = helper.inputNumberCheckerForI(null, this, this.getSpellsLearned().size(), inputNumberChecker);
        return (EntitySpell) this.getSpellsLearned().get(inputNumberChecker-1);
    }

    //true means there's no mana for any spell
    private boolean manaCheck(){
        if (getSpellsLearned().isEmpty()) {
            return true;
        }
        for (EntityBaseEntity spell : getSpellsLearned()) {
            EntitySpell spell1 = (EntitySpell) spell;
            if (this.getMana() >= spell1.getManaCost()) return false;
        }
        return true;
    }

    @Override
    public void printSpellsLearned() {
        Helper helper = new Helper();
        System.out.println("You have the following spells that you learned:\n");
        helper.printItems(this.getSpellsLearned());
    }

    //getters abd setters
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    @Override
    public Integer getMoney() {
        return money;
    }

    @Override
    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public EntityWeapon getWeapon() {
        return (EntityWeapon) entityWeapon;
    }

    public void setWeapon(EntityBaseEntity entityWeapon) {
        this.entityWeapon = entityWeapon;
    }

    public EntityArmor getArmor() {

        return (EntityArmor) entityArmor;
    }

    public void setArmor(EntityBaseEntity entityArmor) {
        this.entityArmor = entityArmor;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    @Override
    public List<EntityBaseEntity> getBag() {
        return bag;
    }

    public void setBag(List<EntityBaseEntity> bag) {
        this.bag = bag;
    }

    public List<EntityBaseEntity> getSpellsLearned() {
        return spellsLearned;
    }

    public void setSpellsLearned(List<EntityBaseEntity> spellsLearned) {
        this.spellsLearned = spellsLearned;
    }
}
