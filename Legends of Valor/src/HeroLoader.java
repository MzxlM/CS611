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
    private HeroFactory HF = new HeroFactory();

    public HeroLoader() throws IOException {
        loadAllItems();
    }
    public void loadAllItems() throws IOException {
        //read all heroes from txt
        List<String> warriors = FileLoader.loadFiles(Constant.WARRIOR);
        List<String> sorcerers = FileLoader.loadFiles(Constant.SORCERER);
        List<String> paladins = FileLoader.loadFiles(Constant.PALADIN);

        //read warriors and create Warriors using Factory Pattern
        for (String s : warriors) {
            //Hero hero = new HeroBaseWarriors(s, Constant.WARRIORS);
            //Hero hero = HF.GetWarriors(s,Constant.WARRIORS);
            this.warriors.add(HF.GetWarriors(s,Constant.WARRIORS));
            this.allHero.add(HF.GetWarriors(s,Constant.WARRIORS));
        }

        //read Sorcerers and create Sorcerers using Factory Pattern
        for (String s : sorcerers) {
            //Hero hero = new HeroBaseWarriors(s, Constant.SORCERERS);
            //Hero hero = HF.GetSorcerers(s,Constant.SORCERERS);
            this.sorcerers.add(HF.GetSorcerers(s,Constant.SORCERERS));
            this.allHero.add(HF.GetSorcerers(s,Constant.SORCERERS));
        }

        //read paladins and create Paladins using Factory Pattern
        for (String s : paladins) {
           // Hero hero = new HeroBaseWarriors(s, Constant.PALADINS);
            //Hero hero = new HeroBasePaladins(s,Constant.PALADINS);
            this.paladins.add(HF.GetPaladins(s,Constant.PALADINS));
            this.allHero.add(HF.GetPaladins(s,Constant.PALADINS));
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
