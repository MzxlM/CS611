Name : Xinlong Zhang
Email : xinlongz@bu.edu

Bonus:
1. color text
2. This game can be player up to 4 teams(4 players)
3. read from txt

My system: macos

Description of each class:
Alive.java:A Alive class which represents alive object like hero and monsters.
Arena.java: A Arena class which represents the fight place between hero and monsters
Cell.java:A abstract Cell object, class that represent base cell that is part of the map
CellCommon.java:A common Cell object extends cell, class that represent the empty cell in map which may contains monsters
CellInterface.java:A CellInterface, class that represent cell as interface and some of its basic functions
CellMarket.java:A CellMarket object, class that represents market extends cell object. A market cell contains a market
CellUnreachable.java:A CellUnreachable object, class that represents cell in the map that cant be reach by hero
Constant.java:A Constant Class, has all the constants used for program
Entity.java:A Entity interface, class that implement this interface means it's an item. like weapon, armor, etc.
EntityArmor.java:A armor class extends BaseEntity and implement Equipable and Sellable interface.
EntityBaseEntity.java:A abstract EntityBaseEntity object, class that represent base property of all items
EntityPotion.java:A Potion class extends BaseEntity and implement Usable and Sellable interface.
EntitySpell.java:A Spell class extends BaseEntity and implement Useable and Sellable interface.
EntityWeapon.java:A Weapon class extends BaseEntity and implement Equipable and Sellable interface.
Equipable.java: A equipable interface, means that item is equipable. like weapon, armor, etc.
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
Market.java:A market object in CellMarket object that allow hero can buy and sell
MarketLoader.java:A MarketLoader class use to load all types of items from txt.
Monster.java:A Monster interface that represents monster and its basic functions
MonsterBase.java:A MonsterBase class that represents the basic prototype of monsters
MonsterDragon.java:A MonsterDragon class which represents dragon
MonsterExoskeleton.java:A MonsterExoskeleton class which represents Exoskeleton
MonsterLoader.java:A MonsterLoader class use to load all types of monsters from txt.
MonsterSpirit.java:A MonsterSpirit class which represents Spirit
Sellable.java:A Sellable interface, class that implement this represents items that could be sell
Team.java:A Team object, class that represents the team with all the heroes belong to this team.
Useable.java:A Useable interface, class that implement this interface means it coule be use for some purpose like potion.



















