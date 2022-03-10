import java.io.IOException;
import java.util.Random;
/**
 * A common Cell object extends cell, class that represent the empty cell in map which may contains monsters
 */
public class CellCommon extends Cell{

    public CellCommon() {
        //change the marker to map the common cell
        getMarker().markerInitialize(Constant.COMMON);
    }

    public boolean FightMonster(){
        Helper helper = new Helper();
        Random random=new Random();
        int dice=random.nextInt(10);
        if(dice<=2){
            helper.printWithColor("No monster on this tile!", Constant.ANSI_BLUE);
            return false;
        }
        else {
            helper.printWithColor("You are in a battle!", Constant.ANSI_BLUE);
            return true;
        }

    }

    //the event happens on common cell
    @Override
    public void eventProcess(Team team) throws IOException {
        //roll a dice
        boolean isMonster = FightMonster();

        if (isMonster == Boolean.FALSE) {
            //check inventories change weapons or armors, consume potion
            heroAction(team);
            return;
        }else {
            //on a fight
            new Arena(team);
        }

        //check inventories change weapons or armors, consume potion
        heroAction(team);
    }

    //let the hero do inventories check, change weapon or armors and consume potion
    private void heroAction(Team team){
        //check hero sell;
        Helper helper = new Helper();

        System.out.println("Now you are in peace, you can choose a hero to start inventories check, change weapon or armors and consume potion. " +
                "\nDo you want to choose the hero? Enter Y/y for yes N/n for No and make next move");
        String result = helper.getResultForYN(null, team);
        if (result.equals("n")) {
            return;
        }
        //pick the hero to take action until left.
        takeAction(team);
    }

    private void takeAction(Team team) {
        Helper helper = new Helper();
        int heroNumbers = team.getHeroes().size();
        //let player pick hero and do the action.
        System.out.println("Now choose a hero to start inventories check, change weapon or armors and consume potion.");
        //let player choose a hero
        Integer inputNumber = helper.getHeroChoice(team);

        //if the player want to exit the hero action
        if (inputNumber.equals(heroNumbers +1)) {
            return;
        }
        Hero hero = team.getHeroes().get(inputNumber - 1);
        if (hero.getBag().isEmpty()) {
            helper.printWithColor("This hero's bag is empty!", Constant.ANSI_RED);
            takeAction(team);
            return;
        }
        System.out.println("Now choose one of the items to use: \n");
        hero.printBag();
        Integer inputNumberChecker = helper.inputNumberChecker(hero.getBag().size());
        inputNumberChecker = helper.inputNumberCheckerForI(null, hero, hero.getBag().size(), inputNumberChecker);
        EntityBaseEntity entityBaseEntity = hero.getBag().get(inputNumberChecker-1);
        if (entityBaseEntity.getType().equals(Constant.ARMOR)) {
            hero.changeArmor(entityBaseEntity);
        }
        if (entityBaseEntity.getType().equals(Constant.POTION)) {
            hero.usePotion((EntityPotion) entityBaseEntity);
        }
        if (entityBaseEntity.getType().equals(Constant.WEAPON)) {
            hero.changeWeapon(entityBaseEntity);
        }
        if (entityBaseEntity.getType().equals(Constant.SPELL)) {
            hero.learnSpell(entityBaseEntity);
        }

        takeAction(team);
    }

    //check inventories
    private void checkInventories(Hero hero){
        //check hero sell;
        Helper helper = new Helper();
        System.out.println("Do you want to check inventory? Enter Y/y for selling, N/n for not");
        String result = helper.getResultForYN(hero, null);

        //let hero sell
        if (result.equals("y")){
            hero.printBag();
        }
    }

    @Override
    public String toString() {
        Helper helper = new Helper();
        // if there's hero print hero, otherwise print commonCell
        boolean containsHero = this.getMarker().isContainsTeam();
        if (containsHero == Boolean.TRUE) return helper.addColor(getMarker().getTeamIcon(), Constant.ANSI_GREEN);
        return "   ";
    }
}
