import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A HeroLoader class use to load all types of heroes from txt.
 */
public class HeroLoader {
    private List<Hero> warriors = new ArrayList<>();
    private List<Hero> sorcerers = new ArrayList<>();
    private List<Hero> paladins = new ArrayList<>();
    private List<Hero> allHero = new ArrayList<>();

    public HeroLoader() throws IOException {
        loadAllItems();
    }
    public void loadAllItems() throws IOException {
        //read all heroes from txt
        List<String> warriors = FileLoader.loadFiles(Constant.WARRIOR);
        List<String> sorcerers = FileLoader.loadFiles(Constant.SORCERER);
        List<String> paladins = FileLoader.loadFiles(Constant.PALADIN);

        //read warriors
        for (String s : warriors) {
            Hero hero = new HeroBaseWarriors(s, Constant.WARRIORS);
            this.warriors.add(hero);
            this.allHero.add(hero);
        }

        //read Sorcerers
        for (String s : sorcerers) {
            Hero hero = new HeroBaseWarriors(s, Constant.SORCERERS);
            this.sorcerers.add(hero);
            this.allHero.add(hero);
        }

        //read paladins
        for (String s : paladins) {
            Hero hero = new HeroBaseWarriors(s, Constant.PALADINS);
            this.paladins.add(hero);
            this.allHero.add(hero);
        }
    }

    //getters
    public List<Hero> getWarriors() {
        return warriors;
    }

    public List<Hero> getSorcerers() {
        return sorcerers;
    }

    public List<Hero> getPaladins() {
        return paladins;
    }

    public List<Hero> getAllHero() {
        return allHero;
    }
}
