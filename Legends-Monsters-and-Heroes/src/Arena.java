import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Arena class which represents the fight place between hero and monsters
 */
public class Arena {
    private boolean isFinished;
    private boolean isTeamWin;
    private List<Boolean> isHeroFaint;
    private List<Boolean> isHeroFailed;
    private List<Boolean> isMonsterFailed;
    private Team team;
    private List<Monster> monsters;

    public Arena(Team team, List<Monster> monsters) {
        this.team = team;
        this.monsters = monsters;
        initializeArena();
    }

    public Arena(Team team) throws IOException {
        this.team = team;
        initializeArena();
        this.monsters = generalizeMonsters(team);
        fight(team,team.getHeroes(),monsters);
    }

    //initialize arena variables
    private void initializeArena(){
        this.isFinished = false;
        this.isTeamWin = false;
        int numberOfHeroes = this.team.getHeroes().size();
        this.isHeroFaint = new ArrayList<>(numberOfHeroes);
        this.isHeroFailed = new ArrayList<>(numberOfHeroes);
        this.isMonsterFailed = new ArrayList<>(numberOfHeroes);
        this.monsters = new ArrayList<>(numberOfHeroes);
        //fill the arraylist with false
        for (int i = 0; i < numberOfHeroes; i++) {
            this.isHeroFaint.add(Boolean.FALSE);
            this.isHeroFailed.add(Boolean.FALSE);
            this.isMonsterFailed.add(Boolean.TRUE);
        }
    }

    private List<Monster> generalizeMonsters(Team team) throws IOException {
        MonsterLoader monsterLoader = new MonsterLoader();
        List<Monster> allMonsters = monsterLoader.getAllMonsters();



        //for each hero generate a monster on the monster team
        List<Hero> heroes = team.getHeroes();
        List<Monster> liveMonsters = new ArrayList<>(heroes.size());
        for (Hero hero : heroes) {
            Integer level = hero.getLevel();
            //first make all the monster with same level become a list
            List<Monster> sameLevelMonster = allMonsters.stream().filter(i -> i.getLevel().equals(level)).collect(Collectors.toList());
            //random choose one monster
            int index = (int) (Math.random()* sameLevelMonster.size());
            liveMonsters.add(sameLevelMonster.get(index));
        }
        return liveMonsters;
    }


    //List<Hero> liveHeroes = team.getHeroes();
    private void fight(Team team, List<Hero> liveHeroes, List<Monster> liveMonsters){
        Helper helper = new Helper();
        //choose a hero for attack
        System.out.println("Now choose a hero to fight with monster.");
        helper.printHeroes(liveHeroes);
        //let player choose a hero
        Integer heroChoice = helper.inputNumberChecker(liveHeroes.size());
        heroChoice = helper.inputNumberCheckerForI(team, null, liveHeroes.size(), heroChoice);
        Hero hero = liveHeroes.get(heroChoice - 1);

        //let player choose a monster
        System.out.println("Now choose a monster that hero "+ hero.getName()+" will fight with.");
        helper.printMonsters(liveMonsters);

        //let player choose a hero
        Integer monsterChoice = helper.inputNumberChecker(liveMonsters.size());
        monsterChoice = helper.inputNumberCheckerForI(team, null, liveMonsters.size(), monsterChoice);
        Monster monster = liveMonsters.get(monsterChoice - 1);

        //hero choose an action on monster
        heroAttack(hero, monster);
        if (!hero.isAlive()) {
            liveHeroes.remove(hero);
        }
        if (!monster.isAlive()) {
            liveMonsters.remove(monster);
        }

        //game over heroes die
        if (liveHeroes.size() == 0) {
            List<Hero> heroes = team.getHeroes();
            for (Hero hero1 : heroes) {
                hero1.revived(true);
            }
            team.setHeroes(heroes);
            return;
        }

        //game over monsters die
        if (liveMonsters.size() == 0) {
            List<Hero> heroes = team.getHeroes();
            Integer coinEarn = 0;
            Integer expEarn = heroes.size()*2;
            for (Hero hero1 : heroes) {
                coinEarn += hero1.getLevel()*100;
            }
            for (Hero hero1 : heroes) {
                //for hero that alive, restore health and earn money and exp
                if (hero1.isAlive()) {
                    hero1.restore();
                    hero1.setMoney(hero1.getMoney()+coinEarn);
                    hero1.gainExp(expEarn);
                    hero1.levelUp();
                }
                //for hero dies revive them
                if (!hero1.isAlive()) {
                    hero1.revived(false);
                }
            }
            team.setHeroes(heroes);
            return;
        }
        //game will end until all hero dies or monster dies.
        fight(team, liveHeroes, liveMonsters);
    }

    //the whole 1v1 process for hero and monster. true means hero wins, false means monster wins
    private void heroAttack(Hero hero, Monster monster){
        Helper helper = new Helper();
        System.out.println("\nNow hero "+hero.getName()+" please choose your action by Entering the number before the action.");
        //actions: attack, cast spell, use potion, change armor/weapon display hero info, display monster info.
        String choices = "";
        if (Constant.ENABLE_COLOR == Boolean.TRUE) {
            choices = Constant.Fight_ACTIONS_INSCTRUCTIONS_WITHCOLOR;
        }else {
            choices = Constant.Fight_ACTIONS_INSCTRUCTIONS_WITHOUTCOLOR;
        }
        System.out.println(choices);

        //let player choose an action
        Integer inputNumber = helper.inputNumberChecker(Constant.NUMBER_OF_ACTIONS_FIGHT);
        inputNumber = helper.inputNumberCheckerForI(null, hero, Constant.NUMBER_OF_ACTIONS_FIGHT, inputNumber);

        Integer heroDmgOnMonster = 0;
        Integer monsterDmgOnHero = 0;

        switch (inputNumber) {
            case 1:
                //hero attack, monster defense and attack hero
                if (!monster.dodging()) {
                    heroDmgOnMonster = monster.defense(hero.attack());
                }
                if (!hero.dodging()&&monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;

            case 2:
                //hero cast spell, monster defense and attack hero
                heroDmgOnMonster = hero.castSpell(monster);
                if (!hero.dodging()&&monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;

            case 3:
                //hero use potion, monster defense and attack hero
                hero.usePotion((EntityPotion) searchBag(hero, Constant.POTION));
                if (!hero.dodging()&&monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;

            case 4:
                //hero change armor, monster defense and attack hero
                hero.changeArmor(searchBag(hero, Constant.ARMOR));
                if (!hero.dodging()&&monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;

            case 5:
                //hero change weapon, monster defense and attack hero
                hero.changeWeapon(searchBag(hero, Constant.WEAPON));
                if (!hero.dodging()&&monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;

            case 6:
                //print hero info
                System.out.println(hero);
                heroAttack(hero,monster);
                return;
            case 7:
                //print monster info
                System.out.println(monster);
                heroAttack(hero,monster);
                return;
        }

        if (monsterDmgOnHero<0) {
            monsterDmgOnHero = 0;
        }

        if (heroDmgOnMonster<0) {
            heroDmgOnMonster = 0;
        }

        //print round info
        if (Constant.ENABLE_COLOR) {
            System.out.println("At current round hero " + hero.getName() +" cause "+
                    Constant.ANSI_BLUE+heroDmgOnMonster+Constant.ANSI_RESET+ "on monster "+monster.getName()+"\n");
            System.out.println("At current round monster " + monster.getName() +" cause "+
                    Constant.ANSI_BLUE+monsterDmgOnHero+Constant.ANSI_RESET+ "on hero "+hero.getName()+"\n");
        } else {
            System.out.println("At current round hero " + hero.getName() +" cause "+
                    heroDmgOnMonster+"on monster "+monster.getName()+"\n");
            System.out.println("At current round monster " + monster.getName() +" cause "+
                    monsterDmgOnHero+"on hero "+hero.getName()+"\n");

        }

    }

    //search bag and print the related item
    private EntityBaseEntity searchBag(Hero hero, String itemType){
        List<EntityBaseEntity> bag = hero.getBag();
        Helper helper = new Helper();

        if (bag.isEmpty()) {
            helper.printWithColor("Your bag is empty", Constant.ANSI_RED);
            return null;
        }
        int i = 0;
        List<EntityBaseEntity> result = new ArrayList<>();
        for (EntityBaseEntity item : bag) {
            if (item.getType().equals(itemType)){
                result.add(item);
                i++;
                if (Constant.ENABLE_COLOR) {
                    System.out.println(Constant.ANSI_PURPLE+i+". " +Constant.ANSI_RESET+ item);
                } else {
                    System.out.println(i+". "+ item);

                }
            }
        }

        if (result.isEmpty()) {
            helper.printWithColor("Your bag doesn't have "+itemType, Constant.ANSI_RED);
            return null;
        }

        System.out.println("Choose one from the above:\n");
        //and then choose the index and find the item
        Integer inputNumberChecker = helper.inputNumberChecker(hero.getBag().size());
        inputNumberChecker = helper.inputNumberCheckerForI(null, hero, hero.getBag().size(), inputNumberChecker);
        return hero.getBag().get(inputNumberChecker-1);
    }


}
