# HeroAndLegendsII
Hero And Legends part II code for BU CS 611



#group members：
Name : Xinlong Zhang
Email : xinlongz@bu.edu

Name : Zhaoyu Yin
Email: zyyin@bu.edu

Name : Yuesi Liu
Email : yzl268@bu.edu


#Control keys:
W,A,S,D,Q,I.
Whenever you enter Q, the program ends.
WASD is for movement when the hero is moving.
I is whenever you created a hero, Press I for information of that hero.

The other instructions are printed on terminal. Just follow the terminal you will know how to play this game.
You will be ask to make choice during this game by entering numbers.


#bonus part:
1. There is a colorful terminal experience.(get it by input Y/y for the first question of this game. It ask for enable color or not)
2. Input is getting parsed from the input files and is not harcoded
3. background music Sound
4. factory design.

#run it by
javac Main.java
java Main

#Factory Pattern:
Factory Pattern is implemented when creating Monsters,Heroes and Items. It encapsulate the creation of the objects in factory classes and therefore the code will not expose the creation logic to the client.

#Description of each class:
Alive.java:A Alive class which represents alive object like hero and monsters.

Cell.java:A Cell, class that represent cell as interface and some of its basic functions

CellBase.java:A abstract CellBase object, class that represent base cell that is part of the map

CellBush.java:  A CellBush object, class that represents cell in the map that increase the dexterity of any hero who is inside them by 10%

CellCave.java: A CellCave object, class that represents cell in the map that increase the agility of any hero who is inside them by 10%

CellCommon.java:A common CellBase object extends cell, class that represent the empty cell in map which may contains monsters

CellKoulou.java: A CellCave object, class that represents cell in the map that increase the strength of any hero who is inside them by 10%

CellNexus.java:A CellNexus object, class that represents market extends cell object. A market cell contains a market

CellUnreachable.java:A CellUnreachable object, class that represents cell in the map that cant be reach by hero

Constant.java:A Constant Class, has all the constants used for program

Entity.java:A Entity interface, class that implement this interface means it's an item. like weapon, armor, etc.

EntityArmor.java:A armor class extends BaseEntity and implement Equipable and Sellable interface.

EntityBaseEntity.java:A abstract EntityBaseEntity object, class that represent base property of all items

EntityPotion.java:A Potion class extends BaseEntity and implement Usable and Sellable interface.

EntitySpell.java:A Spell class extends BaseEntity and implement Useable and Sellable interface.

EntityWeapon.java:A Weapon class extends BaseEntity and implement Equipable and Sellable interface.

Fightable.java: A Fightable interface, class that implement this interface means they can fight with others. like hero and monster

FileLoader.java: A File loader class use to load all types of items.

GameMap.java: A GameMap object, class that represents the game map which is initialized and well formed for printing.

GameWorld.java:A GameWorld object, class that contains teams that are playing this game and main game process

Helper.java:A Helper object, class that contains some input check and change color method

Hero.java:A Hero interface, class that implement this interface means it's a hero.

HeroBase.java: an abstract hero class which hero can do  toString levelUp usePotion changeEquip change armor learn a spell ，attack

HeroBasePaladins.java:A HeroBasePaladins hero class which represents paladins

HeroBaseSorcerers.java:A HeroBaseSorcerers hero class which represents Sorcerers

HeroBaseWarriors.java:A HeroBaseWarriors hero class which represents Warriors

HeroLoader.java:A HeroLoader class use to load all types of heroes from txt.

Main.java:start the whole project

Marker.java:a marker Object saves some memorable info

Market.java:A market object in CellNexus object that allow hero can buy and sell

MarketLoader.java:A MarketLoader class use to load all types of items from txt.

Monster.java:A Monster interface that represents monster and its basic functions

MonsterBase.java:A MonsterBase class that represents the basic prototype of monsters

MonsterDragon.java:A MonsterDragon class which represents dragon

MonsterExoskeleton.java:A MonsterExoskeleton class which represents Exoskeleton

MonsterLoader.java:A MonsterLoader class use to load all types of monsters from txt.

MonsterSpirit.java:A MonsterSpirit class which represents Spirit

Sellable.java:A Sellable interface, class that implement this represents items that could be sell

Team.java:A Team object, class that represents the team with all the heroes belong to this team.


#sample run(without color) (each user input is denoted). (note: in order to make this game easier, hero has high dmg as default)

/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/bin/java -agentlib:jdwp=transport=dt_socket,address=127.0.0.1:52039,suspend=y,server=n -javaagent:/Users/xinlong/Library/Caches/JetBrains/IntelliJIdea2020.3/captureAgent/debugger-agent.jar -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/legacy8ujsse.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/openjsse.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home/lib/tools.jar:/Users/xinlong/folder/BostonUniversity/cs611/HW5/out/production/HW5:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar Main
Connected to the target VM, address: '127.0.0.1:52039', transport: 'socket'
Before the game, You can choose the terminal to be filled with color or not! Enter Y/y for color and N/n for no color!
n-------------------------------------------------------------------------------------------------USER INPUT
Welcome to Heroes and legends designed by Xinlong. In this game you can fight monster, gain experience and level up indefinitely. Here are some basic instructions W/w: move up A/a: move left S/s: move down D/d: move right Q/q: quit game
 I/i: show information. If we are not in a fight this should show information about the heroes (level, hp, mana, current exp, money and skill levels).
 Here is the map of this game:
Those are the heroes you can choose to begin with:
1.
hero Warriors{name:Gaerdal_Ironhand, level:1, hp:100, mana:100, strength:700, agility:500, dexterity:600, money:1354, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
2.
hero Warriors{name:Sehanine_Monnbow, level:1, hp:100, mana:600, strength:700, agility:800, dexterity:500, money:2500, experience:8
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
3.
hero Warriors{name:Muamman_Duathall, level:1, hp:100, mana:300, strength:900, agility:500, dexterity:750, money:2546, experience:6
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
4.
hero Warriors{name:Flandal_Steelskin, level:1, hp:100, mana:200, strength:750, agility:650, dexterity:700, money:2500, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
5.
hero Warriors{name:Undefeated_Yoj, level:1, hp:100, mana:400, strength:800, agility:400, dexterity:700, money:2500, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
6.
hero Warriors{name:Eunoia_Cyn, level:1, hp:100, mana:400, strength:700, agility:800, dexterity:600, money:2500, experience:6
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
7.
hero Sorcerers{name:Rillifane_Rallathil, level:1, hp:100, mana:1300, strength:750, agility:450, dexterity:500, money:2500, experience:9
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
8.
hero Sorcerers{name:Segojan_Earthcaller, level:1, hp:100, mana:900, strength:800, agility:500, dexterity:650, money:2500, experience:5
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
9.
hero Sorcerers{name:Reign_Havoc, level:1, hp:100, mana:800, strength:800, agility:800, dexterity:800, money:2500, experience:8
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
10.
hero Sorcerers{name:Reverie_Ashels, level:1, hp:100, mana:900, strength:800, agility:700, dexterity:400, money:2500, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
11.
hero Sorcerers{name:Kalabar, level:1, hp:100, mana:800, strength:850, agility:400, dexterity:600, money:2500, experience:6
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
12.
hero Sorcerers{name:Skye_Soar, level:1, hp:100, mana:1000, strength:700, agility:400, dexterity:500, money:2500, experience:5
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
13.
hero Paladins{name:Parzival, level:1, hp:100, mana:300, strength:750, agility:650, dexterity:700, money:2500, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
14.
hero Paladins{name:Sehanine_Moonbow, level:1, hp:100, mana:300, strength:750, agility:700, dexterity:700, money:2500, experience:7
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
15.
hero Paladins{name:Skoraeus_Stonebones, level:1, hp:100, mana:250, strength:650, agility:600, dexterity:350, money:2500, experience:4
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
16.
hero Paladins{name:Garl_Glittergold, level:1, hp:100, mana:100, strength:600, agility:500, dexterity:400, money:2500, experience:5
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
17.
hero Paladins{name:Amaryllis_Astra, level:1, hp:100, mana:500, strength:500, agility:500, dexterity:500, money:2500, experience:5
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
18.
hero Paladins{name:Caliber_Heist, level:1, hp:100, mana:400, strength:400, agility:400, dexterity:400, money:2500, experience:8
Equipment: Weapon[NoWeapon] and Armor [NoArmor]}
Now choose one from the hero as your hero. The first choice will be on top, second on mid and so on...
Now choose one by enter the number before hero list.
1-------------------------------------------------------------------------------------------------USER INPUT
Now choose one by enter the number before hero list.
1-------------------------------------------------------------------------------------------------USER INPUT
Now choose one by enter the number before hero list.
1-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H1    |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
y-------------------------------------------------------------------------------------------------USER INPUT
Which type you want to buy in the market? There are currently 4 types. Enter(1-4) to select
1.Armor
2.Spells
3.Potions
4.Weapon
1-------------------------------------------------------------------------------------------------USER INPUT
1.
Name: Platinum_Shield, Cost: 150, required level: 1, damageReduction: 200
2.
Name: Breastplate, Cost: 350, required level: 3, damageReduction: 600
3.
Name: Full_Body_Armor, Cost: 1000, required level: 8, damageReduction: 1100
4.
Name: Wizard_Shield, Cost: 1200, required level: 10, damageReduction: 1500
5.
Name: Guardian_Angel, Cost: 1000, required level: 10, damageReduction: 1000
Now please enter the number before the item for the item you want to buy!

1-------------------------------------------------------------------------------------------------USER INPUT
Thank you for your purchase, your current balance is : 1204
Do you want to buy another buy on the market? Enter Y/y for another buy. N/n to exit
n-------------------------------------------------------------------------------------------------USER INPUT
Do you want to sell anything? Enter Y/y for selling, N/n for not
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
2-------------------------------------------------------------------------------------------------USER INPUT
Please input the TP row coordinate
8-------------------------------------------------------------------------------------------------USER INPUT
Please input the TP column coordinate
1-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
4-------------------------------------------------------------------------------------------------USER INPUT
This hero's bag is empty!
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
| H2    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
y-------------------------------------------------------------------------------------------------USER INPUT
Which type you want to buy in the market? There are currently 4 types. Enter(1-4) to select
1.Armor
2.Spells
3.Potions
4.Weapon
1-------------------------------------------------------------------------------------------------USER INPUT
1.
Name: Platinum_Shield, Cost: 150, required level: 1, damageReduction: 200
2.
Name: Breastplate, Cost: 350, required level: 3, damageReduction: 600
3.
Name: Full_Body_Armor, Cost: 1000, required level: 8, damageReduction: 1100
4.
Name: Wizard_Shield, Cost: 1200, required level: 10, damageReduction: 1500
5.
Name: Guardian_Angel, Cost: 1000, required level: 10, damageReduction: 1000
Now please enter the number before the item for the item you want to buy!

1-------------------------------------------------------------------------------------------------USER INPUT
Thank you for your purchase, your current balance is : 1204
Do you want to buy another buy on the market? Enter Y/y for another buy. N/n to exit
n-------------------------------------------------------------------------------------------------USER INPUT
Do you want to sell anything? Enter Y/y for selling, N/n for not
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
3-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
Miss, Monster BigBad-Wolf doges
At current round hero Gaerdal_Ironhand cause 0on monster BigBad-Wolf

At current round monster BigBad-Wolf cause 2on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
4-------------------------------------------------------------------------------------------------USER INPUT
Now choose one of the items to use:

You have the following things in your bag:
1.
Name: Platinum_Shield, Cost: 150, required level: 1, damageReduction: 200
1-------------------------------------------------------------------------------------------------USER INPUT
Do you want to use another item on inventory? Enter Y/y for yes, N/n for not
y-------------------------------------------------------------------------------------------------USER INPUT
This hero's bag is empty!
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|    M  |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
1-------------------------------------------------------------------------------------------------USER INPUT
You cant move right now, there is an monster nearby you
At current round hero Gaerdal_Ironhand cause 0on monster Natsunomeryu

At current round monster Natsunomeryu cause 0on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|    M  |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
At current round hero Gaerdal_Ironhand cause 687on monster BigBad-Wolf

At current round monster BigBad-Wolf cause 0on hero Gaerdal_Ironhand

Monster BigBad-Wolf died.
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
Hero Gaerdal_Ironhand now you are in Nexus. Do you want to buy anything in the market?Enter Y/y for entering market, N/n for hero action.
1-------------------------------------------------------------------------------------------------USER INPUT
java.lang.Exception: Input should be Y/y or N/n
n-------------------------------------------------------------------------------------------------USER INPUT
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |    M  |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
At current round hero Gaerdal_Ironhand cause 690on monster Natsunomeryu

At current round monster Natsunomeryu cause 0on hero Gaerdal_Ironhand

Monster Natsunomeryu died.
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
1-------------------------------------------------------------------------------------------------USER INPUT
You cant move right now, there is an monster nearby you
At current round hero Gaerdal_Ironhand cause 0on monster Natsunomeryu

At current round monster Natsunomeryu cause -200on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
6-------------------------------------------------------------------------------------------------USER INPUT
Your dont have any spell you can use! reason might be not enough mana, or you didnt learn anything
At current round hero Gaerdal_Ironhand cause 0on monster Natsunomeryu

At current round monster Natsunomeryu cause -200on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
1-------------------------------------------------------------------------------------------------USER INPUT
You cant move right now, there is an monster nearby you
At current round hero Gaerdal_Ironhand cause 0on monster Natsunomeryu

At current round monster Natsunomeryu cause -200on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |    M  |  | X X X |  |    M  |  |       |  | X X X |  |    M  |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
1-------------------------------------------------------------------------------------------------USER INPUT
You cant move right now, there is an monster nearby you
At current round hero Gaerdal_Ironhand cause 0on monster BigBad-Wolf

At current round monster BigBad-Wolf cause 2on hero Gaerdal_Ironhand

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |    M  |  | X X X |  |    M  |  |       |  | X X X |  |    M  |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |    M  |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
At current round hero Gaerdal_Ironhand cause 690on monster Natsunomeryu

At current round monster Natsunomeryu cause 0on hero Gaerdal_Ironhand

Monster Natsunomeryu died.
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |    M  |  | X X X |  |    M  |  |       |  | X X X |  |    M  |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
At current round hero Gaerdal_Ironhand cause 682on monster Blinky

At current round monster Blinky cause 0on hero Gaerdal_Ironhand

Monster Blinky died.
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |    M  |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |    M  |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 1 Gaerdal_Ironhand please choose your action this turn
There is monster near you. You can choose to attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
5Attack
6Cast spell
5-------------------------------------------------------------------------------------------------USER INPUT
At current round hero Gaerdal_Ironhand cause 687on monster BigBad-Wolf

At current round monster BigBad-Wolf cause 0on hero Gaerdal_Ironhand

Monster BigBad-Wolf died.
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |    M  |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 2 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K
| H1    |  |       |  | X X X |  |    M  |  |       |  | X X X |  |       |  | H3    |
P - P - P  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  P - P - P  K - K - K

C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  P - P - P  I - I - I  P - P - P  P - P - P

B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  P - P - P  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
P - P - P  C - C - C  I - I - I  P - P - P  C - C - C  I - I - I  B - B - B  C - C - C

K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  B - B - B  I - I - I  C - C - C  P - P - P  I - I - I  P - P - P  P - P - P

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N


Hero 3 Gaerdal_Ironhand please choose your action this turn
There is no monster near you. You cant attack or cast a spell
1Move
2Teleport
3Back
4Inventories check
1-------------------------------------------------------------------------------------------------USER INPUT
Hero Gaerdal_Ironhand please enter your movement(WASD)
w-------------------------------------------------------------------------------------------------USER INPUT

Game ends at turn 11


Game Over!!!!!    hero wins!
Disconnected from the target VM, address: '127.0.0.1:52039', transport: 'socket'

Process finished with exit code 0



