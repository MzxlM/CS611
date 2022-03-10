import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A File loader class use to load all types of items.
 */
public class FileLoader {
    //read items from files
    public static List<String> loadFiles(Integer itemType) throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/ConfigFiles/";
//        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Armory.txt";
//        List<String> lines = Collections.emptyList();
//        try {
//            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            System.out.println("Please enter the correct filepath");
//            e.printStackTrace();
//        }
        //System.getProperty("user.dir")+filepath
        //filePath = System.getProperty("user.dir"); todo do += on filePath
        switch (itemType) {
            case Constant.ARMORY:
                filePath += Constant.ARMORY_LOCATION;
                break;
            case Constant.FIRE_SPELLS:
                filePath += Constant.FIRE_SPELLS_LOCATION;
                break;
            case Constant.ICE_SPELLS:
                filePath += Constant.ICE_SPELLS_LOCATION;
                break;
            case Constant.LIGHTNING_SPELLS:
                filePath += Constant.LIGHTNING_SPELLS_LOCATION;
                break;
            case Constant.POTIONS:
                filePath += Constant.POTIONS_LOCATION;
                break;
            case Constant.WEAPONRY:
                filePath += Constant.WEAPONRY_LOCATION;
                break;
            case Constant.WARRIOR:
                filePath += Constant.WARRIOR_LOCATION;
                break;
            case Constant.SORCERER:
                filePath += Constant.SORCERER_LOCATION;
                break;
            case Constant.PALADIN:
                filePath += Constant.PALADIN_LOCATION;
                break;
            case Constant.DRAGONS:
                filePath += Constant.DRAGONS_LOCATION;
                break;
            case Constant.EXOSKELETONS:
                filePath += Constant.EXOSKELETONS_LOCATION;
                break;
            case Constant.SPIRITS:
                filePath += Constant.SPIRITS_LOCATION;
                break;
            default:
                filePath = "";
        }
        try {
            if (filePath.equals("")) {
                throw new IOException("filePath wrong");
            }
        }catch (Exception e){
            System.out.println("filePath wrong");
        }


        //Passing filepath into File object
        File file = new File(filePath);
        // Creating BufferReader Object
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring the result variable
        List<String> result = new ArrayList<>();
        String st;
        // read all inputs
        while ((st = br.readLine()) != null) {
            // Print the string for test
//            System.out.println(st);
            if (!st.equals("")) {
                result.add(st);
            }
        }
        result.remove(0);
        return result;
    }
}
