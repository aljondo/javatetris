import java.util.ArrayList;

import javalib.worldimages.Posn;


public interface BlockCompare {
    //returns true if the given posn can move next to a block in a direction in the 
    public Boolean
    nextToBlock(ArrayList<Block> fell, Posn current);
}
    
//all these methods do the opposite of what the name implies
class ToTheLeft implements BlockCompare {
    public Boolean nextToBlock(ArrayList<Block> fell, Posn current) {
        Boolean canMove = true;
        if(current.x < 1) {
            canMove = false;
        }
        else {
            for (int i = 0; i < fell.size(); i++) {
                if (fell.get(i).posn.x == current.x - 1 && fell.get(i).posn.y == current.y) {
                    canMove = false;
                    i = fell.size();
                }
            }
        }
        return canMove;
    }
}
 
class Down implements BlockCompare {
    public Boolean nextToBlock(ArrayList<Block> fell, Posn current) {
        Boolean canMove = true;
        for(int i = 0; i < fell.size(); i++) {
            if(fell.get(i).posn.x == current.x && fell.get(i).posn.y == current.y + 1) {
                canMove = false;
                i = fell.size();
            }
        }
        return canMove && current.y < 21;
    }
}

class ToTheRight implements BlockCompare {
    public Boolean nextToBlock(ArrayList<Block> fell, Posn current) {
        Boolean canMove = true;
        if(current.x > 8) {
            canMove = false;
        }
        else {
            for(int i = 0; i < fell.size(); i++) {
                if(fell.get(i).posn.x == current.x + 1 && fell.get(i).posn.y == current.y) {
                    canMove = false;
                    i = fell.size();
                }
            }
        }
        return canMove;
    }
}
