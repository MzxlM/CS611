
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * A GameWorld object, class that contains teams that are playing this game and main game process
 */
public class GameWorld {
    private List<Hero> heroes;
    private List<Monster> monsters = new ArrayList<>();
    private GameMap map;
    private boolean isGameOver = false;
    private String winner = "";
    private static final Helper helper = new Helper();

    public GameWorld() throws IOException {
        playMusic();
        gameWelcome();
        gameProcess();
    }

    public static void playMusic(){
        File clap = new File(System.getProperty("user.dir") + "/src/ConfigFiles/bgm.wav");
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(clap));
            clip.start();

            //Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //a method ask user to input the number of lanes they want and initialize it with heroes.
    private List<Hero> heroesInitialize() throws IOException {
        List<Hero> heroes = new ArrayList<>(Constant.HERO_NUMBER_IN_TEAM);

        int heroNum = Constant.HERO_NUMBER_IN_TEAM;
        //get hero list from txt
        HeroLoader loader = new HeroLoader();
        List<Hero> allHero = loader.getAllHero();

        System.out.println("Those are the heroes you can choose to begin with:");

        //print all heroes that help user to choose
        int i = 0;
        for (Hero hero : allHero) {
            i+=1;
            System.out.println(helper.addColor(i+". ", Constant.ANSI_PURPLE)+hero);
        }

        System.out.println("Now choose one from the hero as your hero. The first choice will be on top, second on mid and so on...");
        //user make the choice
        for (int j = 0; j < heroNum; j++) {
            System.out.println("Now choose one by enter the number before hero list.");
            int heroChoice = helper.inputNumberChecker(allHero.size())-1;
//            Hero hero = allHero.get(heroChoice).
            Hero hero = allHero.get(heroChoice).clone();
            hero.setHeroIcon("H"+(j+1));
            heroes.add(hero);
        }
        //set the coordinates for heroes
        generateCoordinate(heroes);
        return heroes;
    }

    //print instruction and help message and initialize needed variables
    private void gameWelcome() throws IOException {
        helper.allowColor();
        System.out.println(Constant.WELCOME);

        //initialize map and teams
        setMap(new GameMap());
        setHeroes(heroesInitialize());
    }

    //game logic and process
    private void gameProcess() throws IOException {
        //generate the coordinate for each hero by the order of choice.

        //generate the first monsters to against heroes
        List<Monster> monsters = generalizeMonsters(getHeroes());
        this.monsters.addAll(monsters);

        //now let each hero move turn by turn.
        int turns = 0;
        int monsterGenerate = 8;
        while (!this.isGameOver) {
            turns++;

            //generate monsters every 8 turn
            if (monsterGenerate == 0) {
                List<Monster> additionalMonsters = generalizeMonsters(getHeroes());
                this.monsters.addAll(additionalMonsters);
                monsterGenerate = 8;
            }
            monsterGenerate--;
            //for each hero in the game make movement once
            int i = 0;
            for (Hero hero : heroes) {
                i++;
                System.out.println(map);
                if (!hero.isAlive()) {
                    //hero reborn on nexus after one turn
                    String s = "Hero "+hero.getName()+" died, reviving now";
                    System.out.println(helper.addColor(s,Constant.ANSI_BLUE));
                    map.getCellMarker(hero.getCoordinateX(),hero.getCoordinateY()).heroLeft();
                    int[] nexus = hero.getNexus();
                    hero.revived(Boolean.FALSE);
                    map.getCellMarker(nexus[0], nexus[1]).heroComes(hero);
                } else {
                    //hero can take action
                    System.out.println(helper.addColor("Hero "+i+" "+hero.getName()+" please choose your action this turn", Constant.ANSI_BLUE));
                    heroAction(hero);
                    hero.levelUp();
                }
            }

            for (Monster monster : this.monsters) {
                monsterAction(monster);
            }
            //make endless move for next loop
        }

        System.out.println(" ");
        System.out.println("Game ends at turn "+(turns+1));
        System.out.println("\n\nGame Over!!!!!    "+ winner+" wins!");

    }

    //the hero can choose which action they want to take
    private void heroAction(Hero hero) throws IOException {
        int allowedOperations = 6;
        boolean isMonster = false;
        String[] heroActions = Constant.HERO_ACTIONS_INSCTRUCTIONS;

        //check if nexus, buy and sell first.
        if (hero.getCoordinateX() == Constant.HERO_NEXUS_COORDINATE){
            System.out.println(helper.addColor("Hero "+hero.getName()+" now you are in Nexus. Do you want to buy anything in the market?" +
                                "Enter Y/y for entering market, N/n for hero action.", Constant.ANSI_BLUE));

            String result = helper.getResultForYN(hero, null);
            if (result.equals("y")) {
                getMap().getCell(hero.getCoordinateX(),hero.getCoordinateY()).eventProcess(hero);
            }
        }
        Monster monster = getMap().monsterNearBy(this.monsters, hero.getCoordinateX(), hero.getCoordinateY());
        if (monster == null) {
            System.out.println(helper.addColor("There is no monster near you. You cant attack or cast a spell", Constant.ANSI_BLUE));
            //we dont let user do the attack and cast spells since there's no monster
            allowedOperations = allowedOperations-2;
        } else {
            System.out.println(helper.addColor("There is monster near you. You can choose to attack or cast a spell", Constant.ANSI_BLUE));
            isMonster = true;
        }

        //print the allowed actions
        for (int i = 0; i < allowedOperations; i++) {
            String index = helper.addColor(String.valueOf(i+1), Constant.ANSI_PURPLE);
            System.out.println(index+ heroActions[i]);
        }

        //read the action user choose { "Move", "Teleport", "Back", "Inventories check", "Attack","Cast spell"};
        Integer inputNumberChecker = helper.inputNumberChecker(allowedOperations);
        inputNumberChecker = helper.inputNumberCheckerForI(null, hero, allowedOperations, inputNumberChecker);

        Integer heroDmgOnMonster = 0;
        Integer monsterDmgOnHero = 0;
        Boolean isFight = Boolean.FALSE;
        switch (inputNumberChecker) {
            case 1:
                //regular move
                if (isMonster) {
                    System.out.println(helper.addColor("You cant move right now, there is an monster nearby you", Constant.ANSI_RED));
                    if (!hero.dodging()&&monster.isAlive()) {
                        monsterDmgOnHero = hero.defense(monster.attack());
                        isFight = Boolean.TRUE;
                    }
                } else {
                    makeMove(hero, Boolean.FALSE, Boolean.FALSE);
                }
                break;
            case 2:
                //tp move
                makeMove(hero, Boolean.TRUE, Boolean.FALSE);
                break;
            case 3:
                //back
                int[] nexus = hero.getNexus();
                moveTo(hero, nexus[0], nexus[1], hero.getCoordinateX(), hero.getCoordinateY(), Boolean.TRUE, Boolean.TRUE);
                break;
            case 4:
                //Inventories check change weapon or armors or consume potion or learn a spell
                if (isMonster) {
                    if (!hero.dodging()&&monster.isAlive()) {
                        monsterDmgOnHero = hero.defense(monster.attack());
                    }
                    isFight = Boolean.TRUE;
                }
                checkBag(hero);
                break;
            case 5:
                isFight = Boolean.TRUE;
                //hero attack, monster defense and attack hero
                if (monster != null && !monster.dodging()) {
                    heroDmgOnMonster = monster.defense(hero.attack());
                }
                if (monster != null && !hero.dodging() && monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;
            case 6:
                //cast spell
                isFight = Boolean.TRUE;
                heroDmgOnMonster = hero.castSpell(monster);
                if (monster != null && !hero.dodging() && monster.isAlive()) {
                    monsterDmgOnHero = hero.defense(monster.attack());
                }
                break;
        }
        if (isFight&&monster != null) {
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


        //if monster dies or hero dies. reset
        if (!hero.isAlive()) {
            String s = "Hero "+hero.getName()+" died, waiting for revive!";
            System.out.println(helper.addColor(s,Constant.ANSI_RED));
            map.getCellMarker(hero.getCoordinateX(),hero.getCoordinateY()).heroLeft();
        }

        //if monster dies, reward hero and remove monster
        if (monster != null && !monster.isAlive()) {
            String s = "Monster " + monster.getName() + " died.";
            System.out.println(helper.addColor(s, Constant.ANSI_RED));
            this.monsters.remove(monster);
            map.getCellMarker(monster.getCoordinateX(), monster.getCoordinateY()).monsterLeft();
            hero.setMoney(hero.getMoney()+hero.getLevel()*100);
            hero.gainExp(monster.getLevel()*2);
        }

    }

    private void monsterAction(Monster monster) throws IOException {
        //if there is hero nearby, monster standby and prepare to attack.
        boolean heroNearBy = map.isHeroNearBy(monster.getCoordinateX(), monster.getCoordinateY());
        if (heroNearBy == Boolean.FALSE) {
            makeMove(monster, Boolean.FALSE, Boolean.FALSE);
        }
    }
    private List<Monster> generalizeMonsters(List<Hero> heroes) throws IOException {
        MonsterLoader monsterLoader = new MonsterLoader();
        List<Monster> allMonsters = monsterLoader.getAllMonsters();

        //for each hero generate a monster on the monster team
        List<Monster> liveMonsters = new ArrayList<>(heroes.size());
        int j = 0;
        for (Hero hero : heroes) {
            Integer level = hero.getLevel();
            //first make all the monster with same level become a list
            List<Monster> sameLevelMonster = allMonsters.stream().filter(i -> i.getLevel().equals(level)).collect(Collectors.toList());
            //random choose one monster
            int index = (int) (Math.random()* sameLevelMonster.size());
            Monster monster = sameLevelMonster.get(index).clone();
            monster.setCoordinateX(Constant.MONSTER_NEXUS_COORDINATE);
            //born on left or right side of nexus
            int y = getY(j);
            monster.setCoordinateY(y);
            map.getCellMarker(Constant.MONSTER_NEXUS_COORDINATE, y).monsterComes(monster);
            liveMonsters.add(monster);
            j++;
        }
        return liveMonsters;
    }

    //generate the coordinate for hero randomly.
    private void generateCoordinate(List<Hero> heroes){

        for (int i = 0; i < heroes.size(); i++) {
            Hero hero = heroes.get(i);
            hero.setCoordinateX(map.getMapHeight()-1);
            int y = getY(i);
            hero.setCoordinateY(y);
            hero.setNexus(map.getMapHeight()-1, y);
            map.getCellMarker(map.getMapHeight()-1, y).heroComes(hero);
        }
    }

    //decide the y axis which means born on the left or right nexus
    private int getY(int i) {
        Random random = new Random();
        //since each line has size 2 and an inaccessible cell
        int y = i * (Constant.LANE_SIZE+1);
        int offset = (Constant.LANE_SIZE-1);

        //use a random number to decide if the hero born on the left nexus or right nexus
        if (random.nextInt(Constant.LANE_SIZE) == offset) {
            y+=offset;
        }
        return y;
    }

    //move method for hero
    private void makeMove(Alive alive, boolean isTP, boolean isBack) throws IOException {
        String movement = "";
        int coordinateX;
        int coordinateY;

        //check the team initial position
        coordinateX = alive.getCoordinateX();
        coordinateY = alive.getCoordinateY();

        if (isTP && alive instanceof Hero) {
            //read x,y
            System.out.println("Please input the TP row coordinate");
            Integer inputNumberCheckerX = helper.inputNumberChecker(Constant.MAP_SIZE);
            inputNumberCheckerX = helper.inputNumberCheckerForI(null, (Hero) alive, Constant.MAP_SIZE, inputNumberCheckerX);
            System.out.println("Please input the TP column coordinate");

            Integer inputNumberCheckerY = helper.inputNumberChecker(Constant.MAP_SIZE);
            inputNumberCheckerY = helper.inputNumberCheckerForI(null, (Hero) alive, Constant.MAP_SIZE, inputNumberCheckerY);
            moveTo(alive, inputNumberCheckerX-1, inputNumberCheckerY-1, coordinateX, coordinateY, true, isBack);
            return;
        }
        //read input wasd i
        //if i print information in movement checker and read wasd
        if (alive instanceof Hero) movement = helper.movementChecker((Hero) alive);
        if (alive instanceof Monster) movement = "s";

        movement = movement.toLowerCase();


        //make move
        switch (movement) {
            case "w":
                moveTo(alive, coordinateX-1, coordinateY, coordinateX, coordinateY, isTP, isBack);
                break;
            case "a":
                moveTo(alive, coordinateX, coordinateY-1, coordinateX, coordinateY, isTP, isBack);
                break;
            case "s":
                moveTo(alive, coordinateX+1, coordinateY, coordinateX, coordinateY, isTP, isBack);
                break;
            case "d":
                moveTo(alive, coordinateX, coordinateY+1, coordinateX, coordinateY, isTP, isBack);
                break;
        }

    }

    //a moveTo method with the initial position and destination
    private void moveTo(Alive alive, int X, int Y, int initialX, int initialY, boolean isTP, boolean isBack) throws IOException {
        try {
            //bound check cant go outside of map
            if (X<0||Y<0) {
                throw new Exception(helper.addColor("Destination is out of map, please input another directionv", Constant.ANSI_RED));
            }
            if (X>=map.getMapHeight()||Y>=map.getMapWidth()) {
                throw new Exception(helper.addColor("Destination is out of map, please input another direction!", Constant.ANSI_RED));
            }
            //unreachable check
            if (map.getCellMarker(X,Y).isUnreachable()) {
                throw new Exception(helper.addColor("Destination is an unreachable cell, please input another direction!", Constant.ANSI_RED));
            }
            //alive check
            if (map.getCellMarker(X,Y).isContainsMonster()) {
                throw new Exception(helper.addColor("Destination already has a monster in it!", Constant.ANSI_RED));
            }
            if (map.getCellMarker(X,Y).isContainsHero()) {
                throw new Exception(helper.addColor("Destination already has a hero in it!", Constant.ANSI_RED));
            }
            if (isTP && !map.getCellMarker(X,Y).isExplored()) {
                throw new Exception(helper.addColor("Destination is not explored yet!", Constant.ANSI_RED));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            if (isBack) {
                System.out.println(helper.addColor("Since you cant go back, you will stay at current location. Your action is skipped!", Constant.ANSI_RED));
                return;
            }
            makeMove(alive, isTP, false);
            return;
        }
        //read the marker of initial position and destination
        Cell nextCell = map.getCell(X,Y);
        Marker nextCellMarker = map.getCellMarker(X, Y);
        Marker lastCellMarker = map.getCellMarker(initialX, initialY);
        //change marker
        if (alive instanceof Hero) {
            Hero hero = (Hero) alive;
            nextCellMarker.heroComes(hero);
            map.setCellMarker(X, Y, nextCellMarker);
            lastCellMarker.heroLeft();
            map.setCellMarker(initialX, initialY, lastCellMarker);
        } else if (alive instanceof  Monster){
            Monster monster = (Monster) alive;
            nextCellMarker.monsterComes(monster);
            map.setCellMarker(X, Y, nextCellMarker);
            lastCellMarker.monsterLeft();
            map.setCellMarker(initialX, initialY, lastCellMarker);
        }
        //change the alive coordinate
        alive.move(X,Y);
        //going into the cell and things happened. For example you can buy in market and might fight in common cell
//        nextCell.eventProcess(alive);
        //System.out.println(map);
        winCheck(alive, X, Y);
    }

    private void checkBag(Hero hero) {
        if (hero.getBag().isEmpty()) {
            helper.printWithColor("This hero's bag is empty!", Constant.ANSI_RED);
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

        System.out.println("Do you want to use another item on inventory? Enter Y/y for yes, N/n for not");
        String result = helper.getResultForYN(hero, null);

        if (result.equals("y")) {
            checkBag(hero);
        }
    }

    //check if there's an winner
    private void winCheck(Alive heroOrLegend, int X, int Y){
        //if the cell is nexus do the check
        Cell destination = map.getCell(X, Y);
        String type;
        if (destination instanceof CellNexus) {
            type = ((CellNexus) destination).getType();
        } else {
            return;
        }
        //set the win check for each move. note the enemy nexus
        if (heroOrLegend instanceof Hero && type.equals(Constant.MONSTER_NEXUS)) {
            //if hero making the move and he is on monster nexus, game over
            this.isGameOver = Boolean.TRUE;
            this.winner = Constant.HERO_NEXUS;
        } else if (heroOrLegend instanceof Monster && type.equals(Constant.HERO_NEXUS)) {
            //game over when monster on hero nexus
            this.isGameOver = Boolean.TRUE;
            this.winner = Constant.MONSTER_NEXUS;
        }

    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }
}
