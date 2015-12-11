import static org.junit.Assert.*;

import java.awt.Color;
import java.util.*;

import org.junit.Test;

import javalib.worldimages.*;

public class TetrisTest {
    //pieces
    Piece iBlock;
    Piece jBlock;
    Piece lBlock;
    Piece oBlock;
    Piece sBlock;
    Piece zBlock;
    Piece tBlock;
    
    BlockCompare down = new Down();
    
    //blocks 'n' shit
    Block x0y22;
    Block x0y21;
    Block x0y20;
    Block x0y19;
    Block x0y18;
    
    Block x5y22;
    Block x5y21;
    Block x5y20;
    Block x5y19;
    Block x5y18;
    Block x5y17;
    Block x5y16;
    Block x5y15;
    Block x5y14;
    Block x5y13;
    Block x4y13;
    Block x6y13;
    Block x7y13;
    
    //block lists
    ArrayList<Block> empty;
    ArrayList<Block> test1;
    ArrayList<Block> test2;
    ArrayList<Block> fell;
    
    //function objects
    BlockCompare left = new ToTheLeft();
    
    public void initData() {
        //initializing pieces
        iBlock = new IBlock();
        jBlock = new JBlock();
        lBlock = new LBlock();
        oBlock = new OBlock();
        sBlock = new SBlock();
        zBlock = new ZBlock();
        tBlock = new TBlock();
        
        //initializing blocks
        x0y22 = new Block(0, 22, Color.red);
        x0y21 = new Block(0, 21, Color.RED);
        x0y20 = new Block(0, 20, Color.RED);
        x0y19 = new Block(0, 19, Color.RED);
        x0y18 = new Block(0, 18, Color.RED);
        
        x5y22 = new Block(5, 22, Color.red);
        x5y21 = new Block(5, 21, Color.RED);
        x5y20 = new Block(5, 20, Color.RED);
        x5y19 = new Block(5, 19, Color.RED);
        x5y18 = new Block(5, 18, Color.RED);
        x5y17 = new Block(5, 17, Color.red);
        x5y16 = new Block(5, 16, Color.RED);
        x5y15 = new Block(5, 15, Color.RED);
        x5y14 = new Block(5, 14, Color.RED);
        x5y13 = new Block(5, 13, Color.RED);
        x4y13 = new Block(4, 13, Color.RED);
        x6y13 = new Block(6, 13, Color.RED);
        x7y13 = new Block(7, 13, Color.RED);
        
        fell = new ArrayList<Block>();
        fell.add(x5y22);
        fell.add(x5y21);
        fell.add(x5y20);
        fell.add(x5y19);
        fell.add(x5y18);
        fell.add(x5y17);
        fell.add(x5y16);
        fell.add(x5y15);
        fell.add(x5y14);
        fell.add(x5y13);
        fell.add(x4y13);
        fell.add(x6y13);
        fell.add(x7y13);
        
        test1 = new ArrayList<Block>();
        test1.add(this.x0y18);
        test1.add(this.x0y19);
        test1.add(this.x0y20);
        test1.add(this.x0y21);
        test1.add(this.x0y22);
        
        test2 = new ArrayList<Block>();
        test2.add(this.x0y18);
        test2.add(this.x0y19);
        test2.add(this.x0y20);
        test2.add(this.x0y21);
        
        empty = new ArrayList<Block>();
    }
    
    //TEST FOR PIECE
    //tests the method choosePosn
    @Test
    public void testChoosePosn() {
        //to be figured out when i figure out how to test random stuff
    }
    
    @Test
    public void testCanMoveDown() {
        initData();
        iBlock.direction = "up";
        iBlock.posn = new Posn(4, 15);
        assertEquals(this.iBlock.canMoveDown(this.fell), true);
        iBlock.posn = new Posn(6, 15);
        assertEquals(iBlock.canMoveDown(this.fell), true);
    }
    
    @Test
    public void testNextToBlock() {
        initData();
        assertEquals(down.nextToBlock(this.fell, new Posn(4, 17)), true);
    }
    //tests the abstract method canMoveLeft
    /*public void testCanMoveLeft() {
        initData();
        //tests for iBlock
        iBlock.posn = new Posn(1, 16);
        assertEquals(iBlock.canMoveLeft(this.test1), false);
        iBlock.moveDownOne();
        assertEquals(iBlock.canMoveLeft(this.test1), false);
        iBlock.rotateRight();
        iBlock.posn = new Posn(3, 19);
        assertEquals(iBlock.canMoveLeft(this.test1), false);
        iBlock.moveRight();
        assertEquals(iBlock.canMoveLeft(this.test1), true);
        iBlock.direction = "up";
        iBlock.posn = new Posn(0, 16);
        assertEquals(iBlock.canMoveLeft(this.test1), false);
        iBlock.rotateRight();
        iBlock.posn = new Posn(2, 16);
        assertEquals(iBlock.canMoveLeft(empty), false);
        iBlock.moveRight();
        assertEquals(iBlock.canMoveLeft(empty), true);
        iBlock.rotateRight();
        iBlock.posn = new Posn(0, 16);
        assertEquals(iBlock.canMoveLeft(empty), false);
        iBlock.rotateRight();
        iBlock.posn = new Posn(1, 16);
        assertEquals(iBlock.canMoveLeft(empty), false);
        
        //tests for o block
        oBlock.posn = new Posn(1, 17);
        assertEquals(oBlock.canMoveLeft(empty), true);
        assertEquals(oBlock.canMoveLeft(test1), false);
        oBlock.moveDownOne();
        assertEquals(oBlock.canMoveLeft(test1), false);
        oBlock.moveRight();
        assertEquals(oBlock.canMoveLeft(test1), true);
        
        //tests for j block
          //moving it into empty space
        jBlock.posn = new Posn(2, 17);
        assertEquals(jBlock.canMoveLeft(empty), true);
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(empty), true);
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(empty), true);
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(empty), true);
        jBlock.rotateRight();
          //checking that it stops at border
        jBlock.moveLeft();
        assertEquals(jBlock.canMoveLeft(empty), false);
        jBlock.rotateRight();
        jBlock.moveLeft();
        assertEquals(jBlock.canMoveLeft(empty), false);
        jBlock.moveRight();
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(empty), false);
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(empty), false);
        jBlock.rotateRight();
          //checking that it stops at blocks
        jBlock.posn = new Posn(2, 18);
        assertEquals(jBlock.canMoveLeft(test2), false);
        jBlock.rotateRight();
        jBlock.moveLeft();
        assertEquals(jBlock.canMoveLeft(test2), false);
        jBlock.moveRight();
        jBlock.rotateRight();
        assertEquals(jBlock.canMoveLeft(test2), false);
        jBlock.rotateRight();
        jBlock.posn = new Posn(2, 21);
        assertEquals(jBlock.canMoveLeft(test2), true);
        jBlock.moveLeft();
        assertEquals(jBlock.canMoveLeft(test2), false);
    }*/
}
