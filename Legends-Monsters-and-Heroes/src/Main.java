import java.io.IOException;
/**
 * start the whole project
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Helper helper = new Helper();
        helper.allowColor();
        new GameWorld();
    }
}
