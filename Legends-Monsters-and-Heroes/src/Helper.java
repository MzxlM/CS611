import java.util.List;
import java.util.Scanner;
/**
 * A Helper object, class that contains some input check and change color method
 */
public class Helper {
    private final Scanner sc=new Scanner(System.in);
    //check if the number that user input is valid
    public Integer inputNumberChecker(Integer upperLimit) {
        String input;
        Integer result = 0;
        try{
            input = sc.next();
            if (input.equals("I")||input.equals("i")) {
                return Constant.INPUT_NUMBER_PRINT_HERO;
            }
            checkQuit(input);
            int i=Integer.parseInt(input);
            if (i<1||i>upperLimit){
                throw new Exception(addColor("Input cant not be less than 1 and bigger than "+upperLimit, Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input cant not be less than 1 and bigger than "+upperLimit+Constant.ANSI_RESET);
            }
            result = i;
        }
        catch (Exception e){
//            System.out.println(Constant.ANSI_RED+ "Please input a number no less than 1 and no bigger than "+upperLimit+"."+Constant.ANSI_RESET);
            System.out.println(e.toString());
            result=inputNumberChecker(upperLimit);
        }
        return result;
    }

    public Integer inputNumberCheckerForI(Team team, Hero hero, int numberForCheck, Integer inputNumber) {
        //when the user enter I/i print team and ask again
        while (inputNumber.equals(Constant.INPUT_NUMBER_PRINT_HERO)){
            if (team == null) {
                System.out.println(hero);
            }else{
                System.out.println(team);
            }
            inputNumber = inputNumberChecker(numberForCheck);
        }
        return inputNumber;
    }

    //check if the number that user input is valid true means Y, false means N
    public String yesOrNoChecker() {
        String input;
        String result;
        try{
            input = sc.next();
            checkQuit(input);
            if (input.equals("Y")||input.equals("y")){
                result = "y";
            }else if (input.equals("N")||input.equals("n")) {
                result = "n";
            }else if (input.equals("I")||input.equals("i")) {
                result = "i";
            }else {
                throw new Exception(addColor("Input should be Y/y or N/n ", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input should be Y/y or N/n "+Constant.ANSI_RESET);
            }
        }
        catch (Exception e){
//            System.out.println(Constant.ANSI_RED+ "Please input a number no less than 1 and no bigger than "+upperLimit+"."+Constant.ANSI_RESET);
            System.out.println(e.toString());
            result = yesOrNoChecker();
        }
        return result;
    }

    //check result whether it's y or n or i
    public String getResultForYN(Hero hero, Team team) {
        String result = yesOrNoChecker();
        //if player enter i, print info
        while (result.equals("i")){
            if (team == null) {
                System.out.println(hero);
            } else {
                System.out.println(team);
            }
            result = yesOrNoChecker();
        }
        return result;
    }

    public Integer getHeroChoice(Team team) {
        team.printHeroes();
        int heroNumbers = team.getHeroes().size();
        //select hero to do sell and buy
        System.out.println("Select your hero by entering the number before hero.(1-"+ heroNumbers +") " +
                "Enter "+ (heroNumbers +1)+" to exit");
        Integer inputNumber = inputNumberChecker(heroNumbers + 1);

        inputNumber = inputNumberCheckerForI(team, null, heroNumbers + 1, inputNumber);
        return inputNumber;
    }

    //check if the number that user input is valid true means Y, false means N
    public String heroIconChecker() {
        String input = "";
        try{
            input = sc.next();
            checkQuit(input);
            if (input.length()>1){
                throw new Exception(addColor("Input should be length 1!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input should be length 1!"+Constant.ANSI_RESET);
            }else if (!checkWasdI(input)){
                throw new Exception(addColor("Input should not be W/w, A/a, S/s, D/d and I/i!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input should not be W/w, A/a, S/s, D/d and I/i!"+Constant.ANSI_RESET);
            }else if (!checkXM(input)){
                throw new Exception(addColor("Input should not be X/x M/m!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Input should not be X/x M/m!"+Constant.ANSI_RESET);
            } else {
                return input;
            }
        }
        catch (Exception e){
//            System.out.println(Constant.ANSI_RED+ "Please input a number no less than 1 and no bigger than "+upperLimit+"."+Constant.ANSI_RESET);
            System.out.println(e.toString());
            input = heroIconChecker();
        }
        return input;
    }

    //check if the number that user input is valid true means Y, false means N
    public String movementChecker(Team team) {
        System.out.println("Player "+team.getPlayerName()+" please enter your movement(WASD)");
        String input = "";
        try{
            input = sc.next();
            checkQuit(input);
            if (checkWasdI(input)){
                throw new Exception(addColor("Your movement should only be WASD/wasd and I/i!", Constant.ANSI_RED));

//                throw new Exception(Constant.ANSI_RED+ "Your movement should only be WASD/wasd and I/i!"+Constant.ANSI_RESET);
            }else {
                if (input.equals("I")||input.equals("i")) {
                    //if it's i print the team information
                    System.out.println(team);
                    input = movementChecker(team);
                }
                return input;
            }

        }
        catch (Exception e){
            System.out.println(e.toString());
            input = movementChecker(team);
        }
        return input;
    }

    //check if the number that user input is valid true means Y, false means N
    public String nameChecker() {
        String input = "";
        try{
            input = sc.next();
            checkQuit(input);
            if (input.length()<=1){
                throw new Exception(addColor("Your name should be at least 2 characters!", Constant.ANSI_RED));
//                throw new Exception(Constant.ANSI_RED+ "Your name should be at least 2 characters!"+Constant.ANSI_RESET);
            }else {
                return input;
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
            input = nameChecker();
        }
        return input;
    }


    //whenever detects Q the program ends
    private void checkQuit(String input) {
        if(input.equals("Q")|| input.equals("q")){
            System.out.println("You have quit the game.");
            System.exit(0);
        }
    }

    //whenever detects WASDI those 5 characters are not permitted false means its not wasdi true means its w a s d i
    private boolean checkWasdI(String input) {
        return !input.equals("W") && !input.equals("w") && !input.equals("A") && !input.equals("a") && !input.equals("S") && !input.equals("s")
                && !input.equals("D") && !input.equals("d") && !input.equals("I") && !input.equals("i");
    }

    private boolean checkXM(String input) {
        return !input.equals("X") && !input.equals("x") && !input.equals("M") && !input.equals("m");
    }

    //print the items with index on a list of items
    public void printItems(List<EntityBaseEntity> items) {
        //print all items
        int i = 0;
        for (EntityBaseEntity entityBaseEntity : items) {
            i++;
            if (Constant.ENABLE_COLOR) {
                System.out.println(Constant.ANSI_PURPLE+i+". " +Constant.ANSI_RESET+ entityBaseEntity);
            }else {
                System.out.println(i+". "+ entityBaseEntity);
            }
        }
    }

    //print the heroes with index on a list
    public void printHeroes(List<Hero> heroes){
        int i = 0;
        for (Hero liveHero : heroes) {
            i++;
            if (Constant.ENABLE_COLOR) {
                System.out.println(Constant.ANSI_PURPLE+i+". " +Constant.ANSI_RESET+ liveHero);
            } else {
                System.out.println(i+". "+ liveHero);
            }
        }
    }

    //add color to expression and print it
    public void printWithColor(String s, String color) {
        if (Constant.ENABLE_COLOR) {
            System.out.println(color + s + Constant.ANSI_RESET);
        } else {
            System.out.println(s);
        }
    }

    //add color to an expression
    public String  addColor(String s, String color) {
        if (Constant.ENABLE_COLOR) {
            s = color + s + Constant.ANSI_RESET;
        }
        return s;
    }

    //print the monsters with index on a list
    public void allowColor(){
        System.out.println("Before the game, You can choose the terminal to be filled with color or not! Enter Y/y for color and N/n for no color!");
        String input;
        try{
            input = sc.next();
            if (input.equals("N")||input.equals("n")) {
                Constant.ENABLE_COLOR = Boolean.FALSE;
                return;
            } else if (input.equals("Y")||input.equals("y")) {
                Constant.ENABLE_COLOR = Boolean.TRUE;
                return;
            } else {
                throw new Exception(addColor("Input cant not other than Y/y N/n ", Constant.ANSI_RED));
            }
        }
        catch (Exception e){
//            System.out.println(Constant.ANSI_RED+ "Please input a number no less than 1 and no bigger than "+upperLimit+"."+Constant.ANSI_RESET);
            System.out.println(e.toString());
            allowColor();
        }
    }

    //print the monsters with index on a list
    public void printMonsters(List<Monster> monsters){
        int i = 0;
        for (Monster monster : monsters) {
            i++;
            if (Constant.ENABLE_COLOR) {
                System.out.println(Constant.ANSI_PURPLE+i+". " +Constant.ANSI_RESET+ monster);
            } else {
                System.out.println(i+". "+ monster);
            }
        }
    }
}
