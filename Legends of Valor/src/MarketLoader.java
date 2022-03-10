import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A MarketLoader class use to load all types of items from txt.
 */
public class MarketLoader {
    private List<EntityArmor> entityArmors = new ArrayList<>();
    private List<EntityPotion> entityPotions = new ArrayList<>();
    private List<EntityWeapon> entityWeapons = new ArrayList<>();
    private List<EntitySpell> entitySpells = new ArrayList<>();
    private List<EntityBaseEntity> items = new ArrayList<>();
    private ItemFactory IF = new ItemFactory();
    public MarketLoader() throws IOException {
        loadAllItems();
    }

    // read all the items from files and put it into list
    public void loadAllItems() throws IOException {
        //read all items from txt
        List<String> armory = FileLoader.loadFiles(Constant.ARMORY);
        List<String> potions = FileLoader.loadFiles(Constant.POTIONS);
        List<String> fireSpells = FileLoader.loadFiles(Constant.FIRE_SPELLS);
        List<String> iceSpells = FileLoader.loadFiles(Constant.ICE_SPELLS);
        List<String> lightningSpells = FileLoader.loadFiles(Constant.LIGHTNING_SPELLS);
        List<String> weaponry = FileLoader.loadFiles(Constant.WEAPONRY);

        //read armors using Factory Pattern
        for (String s : armory) {
            //EntityArmor entityArmor = new EntityArmor(s);
            //EntityArmor entityArmor = IF.GetArmor(s);
            this.entityArmors.add(IF.GetArmor(s));
            this.items.add(IF.GetArmor(s));
        }

        //read potions using Factory Pattern
        for (String potion : potions) {
            //EntityPotion entityPotion = new EntityPotion(potion);
            //EntityPotion entityPotion =IF.GetPotion(potion);
            this.entityPotions.add(IF.GetPotion(potion));
            this.items.add(IF.GetPotion(potion));
        }

        //read fire spells using Factory Pattern
        for (String fire_spell : fireSpells) {
            //EntitySpell spells = new EntitySpell(fire_spell, Constant.FIRE);
            //EntitySpell spells = IF.GetSpell(fire_spell,Constant.FIRE);
            this.entitySpells.add(IF.GetSpell(fire_spell,Constant.FIRE));
            this.items.add(IF.GetSpell(fire_spell,Constant.FIRE));
        }

        //read ice spells using Factory Pattern
        for (String ice_spell : iceSpells) {
            //EntitySpell spells = new EntitySpell(ice_spell, Constant.ICE);
           // EntitySpell spells = IF.GetSpell(ice_spell,Constant.ICE);
            this.entitySpells.add(IF.GetSpell(ice_spell,Constant.ICE));
            this.items.add(IF.GetSpell(ice_spell,Constant.ICE));
        }

        //read lightning spells using Factory Pattern
        for (String lightning_spell : lightningSpells) {
            //EntitySpell spells = new EntitySpell(lightning_spell, Constant.LIGHTNING);
            //EntitySpell spells = IF.GetSpell(lightning_spell,Constant.LIGHTNING);
            this.entitySpells.add(IF.GetSpell(lightning_spell,Constant.LIGHTNING));
            this.items.add(IF.GetSpell(lightning_spell,Constant.LIGHTNING));
        }

        //read weaponry spells using Factory Pattern
        for (String weapons : weaponry) {
            //EntityWeapon entityWeapon = new EntityWeapon(weapons);
           // EntityWeapon entityWeapon = IF.GetWeapon(weapons);
            this.entityWeapons.add(IF.GetWeapon(weapons));
            this.items.add(IF.GetWeapon(weapons));
        }
    }

    //getters
    public List<EntityArmor> getEntityArmors() {
        return entityArmors;
    }

    public List<EntityPotion> getEntityPotions() {
        return entityPotions;
    }

    public List<EntityWeapon> getEntityWeapons() {
        return entityWeapons;
    }

    public List<EntitySpell> getEntitySpells() {
        return entitySpells;
    }

    public List<EntityBaseEntity> getItems() {
        return items;
    }
}
