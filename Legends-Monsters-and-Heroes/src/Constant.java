/**
 * A Constant Class, has all the constants used for program
 */
public class Constant {
    //debug mode Constant
    public static boolean DEBUG_MAP_PERCENT = Boolean.TRUE;
    public static boolean ENABLE_COLOR = Boolean.FALSE;
    public static double DMG_REDUCTION_RATE = 1.0;


    public static final String WELCOME = "Welcome to Heroes and legends designed by Xinlong. " +
            "In this game you can fight monster, gain experience and level up indefinitely. " +
            "Here are some basic instructions W/w: move up A/a: move left S/s: move down D/d: " +
            "move right Q/q: quit game\n I/i: show information. If we are not in a fight this " +
            "should show information about the heroes (level, hp, mana, current exp, money " +
            "and skill levels).\n Here is the map of this game:";

    //constant for spell type
    public static final String ICE = "Ice";
    public static final String FIRE = "Fire";
    public static final String LIGHTNING = "Lightning";

    //constant for item type, hero type and monster type
    public static final int ARMORY = 1;
    public static final int FIRE_SPELLS = 2;
    public static final int ICE_SPELLS = 3;
    public static final int LIGHTNING_SPELLS = 4;
    public static final int POTIONS = 5;
    public static final int WEAPONRY = 6;
    public static final int WARRIOR = 7;
    public static final int SORCERER = 8;
    public static final int PALADIN = 9;
    public static final int DRAGONS = 10;
    public static final int EXOSKELETONS = 11;
    public static final int SPIRITS = 12;

    //constant for item type market
    public static final int MARKET_ARMORY = 1;
    public static final int MARKET_SPELLS = 2;
    public static final int MARKET_POTIONS = 3;
    public static final int MARKET_WEAPONRY = 4;
    public static final int MARKET_ITEM_TYPES = 4;

    //constants for txt file location
    public static final String ARMORY_LOCATION = "Armory.txt";
    public static final String FIRE_SPELLS_LOCATION = "FireSpells.txt";
    public static final String ICE_SPELLS_LOCATION = "IceSpells.txt";
    public static final String LIGHTNING_SPELLS_LOCATION = "LightningSpells.txt";
    public static final String POTIONS_LOCATION = "Potions.txt";
    public static final String WEAPONRY_LOCATION = "Weaponry.txt";

    public static final String WARRIOR_LOCATION = "Warriors.txt";
    public static final String SORCERER_LOCATION = "Sorcerers.txt";
    public static final String PALADIN_LOCATION = "Paladins.txt";
    public static final String DRAGONS_LOCATION = "Dragons.txt";
    public static final String EXOSKELETONS_LOCATION = "Exoskeletons.txt";
    public static final String SPIRITS_LOCATION = "Spirits.txt";
    //cygwin

    //constants for hero type
    public static final String SORCERERS = "Sorcerers";
    public static final String WARRIORS = "Warriors";
    public static final String PALADINS = "Paladins";

    //constants for monster type
    public static final String DRAGON = "Dragon";
    public static final String EXOSKELETON = "Exoskeleton";
    public static final String SPIRIT = "Spirit";

    //constants for marker initialize
    public static final int MARKET = 1;
    public static final int UNREACHABLE = 2;
    public static final int COMMON = 3;

    //constants for potion attributed type
    public static final String ATTRIBUTED_HEALTH = "Health";
    public static final String ATTRIBUTED_MANA = "Mana";
    public static final String ATTRIBUTED_STRENGTH = "Strength";
    public static final String ATTRIBUTED_DEXTERITY = "Dexterity";
    public static final String ATTRIBUTED_DEFENSE = "Defense";
    public static final String ATTRIBUTED_AGILITY = "Agility";
    public static final String ATTRIBUTED_ALL = "Health/Mana/Strength/Dexterity/Defense/Agility";

    //terminal colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //Hero number limit
    public static final int HERO_NUMBER_IN_TEAM = 3;
    public static final int GAMER_NUMBER = 4;


    //Constant for map use
    public static final int UNREACHABLE_CELLS = 20;
    public static final int MARKER_CELLS = 30;
    public static final int TOTAL_CELLS = 100;
    public static final int COMMON_CELLS = TOTAL_CELLS-UNREACHABLE_CELLS-MARKER_CELLS;

    public static final int MAP_SIZE = 8;

    public static final int INPUT_NUMBER_PRINT_HERO = -101;


    public static final String HERO_ACTIONS = Constant.ANSI_PURPLE+"1."+Constant.ANSI_PURPLE+"Check Inventory\n"
            +Constant.ANSI_PURPLE+"2."+Constant.ANSI_PURPLE+"Change Weapon\n"
            +Constant.ANSI_PURPLE+"3."+Constant.ANSI_PURPLE+"Change Armors\n"
            +Constant.ANSI_PURPLE+"4."+Constant.ANSI_PURPLE+"Consume Potion\n"
            +Constant.ANSI_PURPLE+"5."+Constant.ANSI_PURPLE+"Exit hero action\n";


    //item type
    public static final String WEAPON = "Weapon";
    public static final String ARMOR = "Armor";
    public static final String POTION = "Potion";
    public static final String SPELL = "Spell";

    //hero actions during fight
    public static final int NUMBER_OF_ACTIONS_FIGHT = 7;
    public static final String Fight_ACTIONS_INSCTRUCTIONS_WITHCOLOR = Constant.ANSI_PURPLE+"1. "+Constant.ANSI_RESET+"Attack"+
            Constant.ANSI_PURPLE+"2. "+Constant.ANSI_RESET+"Cast spell"+
            Constant.ANSI_PURPLE+"3. "+Constant.ANSI_RESET+"Use potion"+
            Constant.ANSI_PURPLE+"4. "+Constant.ANSI_RESET+"Change armor"+
            Constant.ANSI_PURPLE+"5. "+Constant.ANSI_RESET+"Change weapon"+
            Constant.ANSI_PURPLE+"6. "+Constant.ANSI_RESET+"Display Hero Info"+
            Constant.ANSI_PURPLE+"7. "+Constant.ANSI_RESET+"Display Monster Info";

    public static final String Fight_ACTIONS_INSCTRUCTIONS_WITHOUTCOLOR = "1. Attack"+
            "2. Cast spell"+
            "3. Use potion"+
            "4. Change armor"+
            "5. Change weapon"+
            "6. Display Hero Info"+
            "7. Display Monster Info";




}