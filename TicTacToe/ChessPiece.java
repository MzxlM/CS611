
/**
 * @description: this is ChessPiece object
 * @author: Xinlong Zhang
 * @date: 2021/9/29 5:05 PM
 */
public class ChessPiece {
    private String type; // denote whether it's O or X

    public ChessPiece (String type) {
        this.type = type;
    }

    public ChessPiece () {
        this.type = "*";
    }

    public boolean isEmpty(){
        // if the Piece is *,  it means its empty at this point.
        if (type.equals("*")){
            return true;
        }
        return false;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getType () {
        return this.type;
    }
}
