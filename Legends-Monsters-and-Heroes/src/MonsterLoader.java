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

    public MonsterLoader() throws IOException {
        loadAllItems();
    }
    public void loadAllItems() throws IOException {
        //read all monsters from txt
        List<String> dragon = FileLoader.loadFiles(Constant.DRAGONS);
        List<String> exoskeleton = FileLoader.loadFiles(Constant.EXOSKELETONS);
        List<String> spirit = FileLoader.loadFiles(Constant.SPIRITS);

        //read dragon
        for (String s : dragon) {
            Monster monster = new MonsterDragon(s, Constant.DRAGON);
            this.dragon.add(monster);
            this.allMonsters.add(monster);
        }

        //read exoskeleton
        for (String s : exoskeleton) {
            Monster monster = new MonsterDragon(s, Constant.EXOSKELETON);
            this.exoskeleton.add(monster);
            this.allMonsters.add(monster);
        }

        //read spirit
        for (String s : spirit) {
            Monster monster = new MonsterDragon(s, Constant.SPIRIT);
            this.spirit.add(monster);
            this.allMonsters.add(monster);
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
