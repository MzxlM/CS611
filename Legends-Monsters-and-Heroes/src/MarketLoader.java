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

        //read armors
        for (String s : armory) {
            EntityArmor entityArmor = new EntityArmor(s);
            this.entityArmors.add(entityArmor);
            this.items.add(entityArmor);
        }

        //read potions
        for (String potion : potions) {
            EntityPotion entityPotion = new EntityPotion(potion);
            this.entityPotions.add(entityPotion);
            this.items.add(entityPotion);
        }

        //read fire spells
        for (String fire_spell : fireSpells) {
            EntitySpell spells = new EntitySpell(fire_spell, Constant.FIRE);
            this.entitySpells.add(spells);
            this.items.add(spells);
        }

        //read ice spells
        for (String ice_spell : iceSpells) {
            EntitySpell spells = new EntitySpell(ice_spell, Constant.ICE);
            this.entitySpells.add(spells);
            this.items.add(spells);
        }

        //read lightning spells
        for (String lightning_spell : lightningSpells) {
            EntitySpell spells = new EntitySpell(lightning_spell, Constant.LIGHTNING);
            this.entitySpells.add(spells);
            this.items.add(spells);
        }

        //read weaponry spells
        for (String weapons : weaponry) {
            EntityWeapon entityWeapon = new EntityWeapon(weapons);
            this.entityWeapons.add(entityWeapon);
            this.items.add(entityWeapon);
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
