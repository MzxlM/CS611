public class ItemFactory {
    //Factory Pattern
    public EntityArmor GetArmor(String data){
        return new EntityArmor(data);
    }
    public EntityPotion GetPotion(String data){
        return new EntityPotion(data);
    }
    public EntitySpell GetSpell(String data,String Spelltype){
        return new EntitySpell(data,Spelltype);
    }
    public EntityWeapon GetWeapon(String data){
        return new EntityWeapon(data);
    }
}
