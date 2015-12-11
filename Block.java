//to represent individual Blocks

import java.awt.Color;

import javalib.worldimages.*;

public class Block {
    Posn posn;
    Color color;
    
    Block(int x, int y, Color color) {
        this.posn = new Posn(x, y);
        this.color = color;
    }
}
