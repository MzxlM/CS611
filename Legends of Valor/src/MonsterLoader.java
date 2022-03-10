import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A MonsterLoader class use to load all types of monsters from txt.
 */
public class MonsterLoader {

    private List<Monster> dragon = new ArrayList<>();
    private List<Monster> exoskeleton = new ArrayList<>();
    private List<Monster> spirit = new ArrayList<>();
    private List<Monster> allMonsters = new ArrayList<>();
    private MonsterFactory MF = new MonsterFactory();

    public MonsterLoader() throws IOException {
        loadAllItems();
    }
    public void loadAllItems() throws IOException {
        //read all monsters from txt
        List<String> dragon = FileLoader.loadFiles(Constant.DRAGONS);
        List<String> exoskeleton = FileLoader.loadFiles(Constant.EXOSKELETONS);
        List<String> spirit = FileLoader.loadFiles(Constant.SPIRITS);

        //read dragon using Factory Pattern
        for (String s : dragon) {
            //Monster monster = new MonsterDragon(s, Constant.DRAGON);
            //Monster monster = MF.GetDragon(s,Constant.DRAGON);
            this.dragon.add(MF.GetDragon(s,Constant.DRAGON));
            this.allMonsters.add(MF.GetDragon(s,Constant.DRAGON));
        }

        //read exoskeleton using Factory Pattern
        for (String s : exoskeleton) {
            //Monster monster = new MonsterDragon(s, Constant.EXOSKELETON);
            //Monster monster = MF.GetExoskeleton(s,Constant.EXOSKELETON);
            this.exoskeleton.add(MF.GetExoskeleton(s,Constant.EXOSKELETON));
            this.allMonsters.add(MF.GetExoskeleton(s,Constant.EXOSKELETON));
        }

        //read spirit using Factory Pattern
        for (String s : spirit) {
            //Monster monster = new MonsterDragon(s, Constant.SPIRIT);
            //Monster monster = MF.GetSpirit(s,Constant.SPIRIT);
            this.spirit.add(MF.GetSpirit(s,Constant.SPIRIT));
            this.allMonsters.add(MF.GetSpirit(s,Constant.SPIRIT));
        }
    }

    public List<Monster> getDragon() {
        return dragon;
    }

    public List<Monster> getExoskeleton() {
        return exoskeleton;
    }

    public List<Monster> getSpirit() {
        return spirit;
    }

    public List<Monster> getAllMonsters() {
        return allMonsters;
    }
}
