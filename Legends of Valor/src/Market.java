import java.io.IOException;
import java.util.List;
/**
 * A market object in CellMarket object that allow hero can buy and sell
 */
public class Market {
    private MarketLoader marketLoader;
//    private List<EntityArmor> entityArmors = new ArrayList<>();
//    private List<EntityPotion> entityPotions = new ArrayList<>();
//    private List<EntityWeapon> entityWeapons = new ArrayList<>();
//    private List<EntitySpell> entitySpells = new ArrayList<>();
//    private List<EntityBaseEntity> items = new ArrayList<>();
    private Helper helper = new Helper();

    public Market() throws IOException {
        this.marketLoader = new MarketLoader();
    }

    //print some helpful information and welcome messages
    public void welcome(){
        //welcome
        System.out.println("Welcome to the market of Heroes and Legends. This is the list of all the item you can buy from our market.\n"+this.toString());

    }

    //the hero start shopping
    public void startShopping(Hero hero) {
        //hero make a selection about the item type they want to buy for example armor. input (MARKET_ARMORY) 1 to buy armor
        System.out.println("Which type you want to buy in the market? There are currently 4 types. Enter(1-4) to select\n" +
                "1.Armor\n2.Spells\n3.Potions\n4.Weapon");
        Integer heroSelection = helper.inputNumberChecker(Constant.MARKET_ITEM_TYPES);
        heroSelection = helper.inputNumberCheckerForI(null, hero,Constant.MARKET_ITEM_TYPES, heroSelection);

        switch (heroSelection) {
            case Constant.MARKET_ARMORY:
                marketSell(hero, marketLoader.getEntityArmors());
                break;
            case Constant.MARKET_SPELLS:
                marketSell(hero, marketLoader.getEntitySpells());
                break;
            case Constant.MARKET_POTIONS:
                marketSell(hero, marketLoader.getEntityPotions());
                break;
            case Constant.MARKET_WEAPONRY:
                marketSell(hero, marketLoader.getEntityWeapons());
                break;
        }

        System.out.println("Do you want to buy another buy on the market? Enter Y/y for another buy. N/n to exit");
        String result = helper.getResultForYN(hero, null);

        if (result.equals("y")){
            startShopping(hero);
        }
    }

    //after selecting a type, print the items for that list and let hero choose which item hero want to buy
    private void marketSell(Hero hero, List<? extends EntityBaseEntity> items) {
        helper.printItems((List<EntityBaseEntity>) items);
        System.out.println("Now please enter the number before the item for the item you want to buy!\n");
        //the index of hero's choice
        int heroChoice = helper.inputNumberChecker(items.size());
        heroChoice = helper.inputNumberCheckerForI(null, hero, items.size(), heroChoice);
        heroChoice--;
        //hero.buy(items.get(heroChoice));
        heroBuying(hero, items.get(heroChoice));
    }

    public void heroBuying(Hero hero, EntityBaseEntity item) {

        //level check
        if (helper.requirementCheck(item.getLevelRequirement(), hero.getLevel(), " You dont meet the level requirement to buy " + item.getName() + "\n")) return;

        //money check
        if (helper.requirementCheck(item.getCost(), hero.getMoney(), " You dont meet have enough money to buy " + item.getName()+ "\n")) return;

        //hero pay for it
        Integer restMoney = hero.getMoney() - item.getCost();
        hero.setMoney(restMoney);
        System.out.println("Thank you for your purchase, your current balance is : " + restMoney);

        //add item to bag
        hero.getBag().add(item);
    }

    //todo debug see if the item removed and if the hero received money
    //sell an item
    public void heroSelling(Hero hero){
        hero.printBag();
        List<EntityBaseEntity> bag = hero.getBag();

        //select hero to do sell and buy
        int size = bag.size();
        System.out.println("Select the item you are selling by entering the number before hero.(1-"+ size +") " +
                "Enter "+ (size+1)+" to exit market");
        Integer inputNumber = helper.inputNumberChecker(size + 1);

        //if the player want to exit the market
        if (inputNumber.equals(size+1)) {
            return;
        }else{
            //sell the item
            hero.sellRemove(bag.get(inputNumber-1));
        }

        System.out.println("Do you want to sell another item on the market? Enter Y/y for another buy. N/n to exit");
        String result = helper.getResultForYN(hero, null);

        if (result.equals("y")){
            heroSelling(hero);
        }
        return;
    }

    //print all the items in market
    @Override
    public String toString() {
        return "Market: {" +
                "\nweapons: " + marketLoader.getEntityWeapons() +
                "\narmors: " + marketLoader.getEntityArmors() +
                "\npotions: " + marketLoader.getEntityPotions() +
                "\nspells: " + marketLoader.getEntitySpells() +
                '}';
    }

    //getters and setters
    public void setMarketLoader(MarketLoader marketLoader) {
        this.marketLoader = marketLoader;
    }
}
