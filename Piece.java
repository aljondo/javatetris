import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javalib.worldimages.*;
//to represent pieces controllable in Tetris
abstract class Piece {
    Posn posn;
    String direction;
    Random rando = new Random();
    BlockCompare left = new ToTheLeft();
    BlockCompare right = new ToTheRight();
    BlockCompare down = new Down();
    
    
    Piece() {
        this.direction = "up";
        this.posn = this.choosePosn();
    }
    
    //chooses a random starting point along the top of the board
    Posn choosePosn() {
        int ex = rando.nextInt(9);
        return new Posn(ex, 0);
    }
    
    Boolean willItRotate(ArrayList<Block> fell, Piece samplePiece) {
        ArrayList<Block> sampleBlocks = samplePiece.toBlocks(fell);
        Boolean canRotate = true;
        for(int i = 0; i < sampleBlocks.size(); i++) {
            if(sampleBlocks.get(i).posn.x <= 0 || sampleBlocks.get(i).posn.x >= 10) {
                canRotate = false;
            }
        }
        if(canRotate) {
        for(int i = 0; i < fell.size(); i++) {
            for(int j = 0; j < sampleBlocks.size(); j++) {
                if(sampleBlocks.get(j).posn.y == fell.get(i).posn.y && 
                        sampleBlocks.get(j).posn.x == fell.get(i).posn.x ||
                        sampleBlocks.get(j).posn.x == 0 || sampleBlocks.get(j).posn.x == 10) {
                    canRotate = false;
                    j = sampleBlocks.size();
                    i = fell.size();
                }
            }
        }
        }
        return canRotate;
    }
    
    //rotates this piece to the right
    public void rotateRight(ArrayList<Block> fell) {
        Piece samplePiece = this;
        ArrayList<Block> sampleBlocks;
        Boolean canRotate = true;
        
        if(this.direction == "up") {
            samplePiece.direction = "right";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 2;
                                        samplePiece.direction = "up";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "right";
        }
        else if(this.direction == "right") {
            samplePiece.direction = "down";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "right";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "down";
        } 
        else if(this.direction == "down") {
            samplePiece.direction = "left";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "down";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "left";
        }
        else {
            samplePiece.direction = "up";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "left";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "right";
        }
    }
    
    //rotates this piece to the left
    public void rotateLeft(ArrayList<Block> fell) {
        Piece samplePiece = this;
        //ArrayList<Block> sampleBlocks;
        Boolean canRotate = true;
        
        if(this.direction == "up") {
            samplePiece.direction = "left";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 2;
                                        samplePiece.direction = "up";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "right";
        }
        else if(this.direction == "left") {
            samplePiece.direction = "down";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "left";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "down";
        } 
        else if(this.direction == "down") {
            samplePiece.direction = "right";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "down";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "left";
        }
        else {
            samplePiece.direction = "up";
            canRotate = this.willItRotate(fell, samplePiece);
            if(!canRotate) {
                samplePiece.posn.x -= 1;
                canRotate = this.willItRotate(fell, samplePiece);
                if(!canRotate) {
                    samplePiece.posn.x += 2;
                    canRotate = this.willItRotate(fell, samplePiece);
                    if(!canRotate) {
                        samplePiece.posn.x -= 1;
                        samplePiece.posn.y += 1;
                        canRotate = this.willItRotate(fell, samplePiece);
                        if(!canRotate) {
                            samplePiece.posn.y += 1;
                            canRotate = this.willItRotate(fell, samplePiece);
                            if(!canRotate) {
                                samplePiece.posn.y -= 2;
                                samplePiece.posn.x += 2;
                                canRotate = this.willItRotate(fell, samplePiece);
                                if(!canRotate) {
                                    samplePiece.posn.x -= 4;
                                    canRotate = this.willItRotate(fell, samplePiece);
                                    if(!canRotate) {
                                        samplePiece.posn.x += 4;
                                        samplePiece.direction = "right";
                                        canRotate = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if(canRotate) {
                    this.posn = samplePiece.posn;
                    this.direction = samplePiece.direction;
                }
            }
            //this.posn = samplePiece.posn;
            //this.direction = "right";
        }
    }
    
    //moves this piece down one
    public void moveDownOne() {
        this.posn.y += 1;
    }
    
    //moves this piece left one
    public void moveLeft() {
        this.posn.x -= 1;
    }
    
    //moves this piece right one
    public void moveRight() {
        this.posn.x += 1;
    }
    
    //moves this piece down to the bottom
    public void allTheWayDown(ArrayList<Block> fell) {
        while(this.canMoveDown(fell)) {
            this.posn.y += 1;
        }
    }
    
    //returns true if this piece can move down
    public abstract Boolean canMoveDown(ArrayList<Block> fell);
    
    //returns true if this piece can shift left
    public abstract Boolean canMoveLeft(ArrayList<Block> fell);
    
    //returns true if this piece can shift right
    public abstract Boolean canMoveRight(ArrayList<Block> fell);
    
    //returns true if this piece can rotate left
    public abstract Boolean canRotateLeft(ArrayList<Block> fell);
    
    //returns true if this piece can rotate right
    public abstract Boolean canRotateRight(ArrayList<Block> fell);
    
    //converts this piece to an ArrayList of Blocks
    public abstract ArrayList<Block> toBlocks(ArrayList<Block> fell);
    
    //what f***ing piece is this
    public abstract String whatGoddamPieceIsThis();
}

class IBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "IBlock";
    }
    
    //returns true if this piece can shift left. wow holy hell fml
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for (n = 0; n < 4; n++) {
                canMove = left.nextToBlock(fell, current);
                if (!canMove) {
                    n = 4;
                }
                current.y++;
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y + 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 4; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(!canMove) {
                        n = 4;
                    }
                    current.y--;
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
            }
        }
        else {
            current = new Posn(this.posn.x - 2, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
            }
        }
        return canMove;
    }
    
    //returns true if this piece can move down
    public  Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y + 2);
            canMove = this.down.nextToBlock(fell, current);
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y + 1);
            canMove = this.down.nextToBlock(fell, current);            
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            for(n = 0; n < 4; n++) {
                canMove = this.down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                }
                else {
                    n = 4;
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x - 2, this.posn.y);
            for(n = 0; n < 4; n++) {
                canMove = this.down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                }
                else {
                    n = 4;
                }
            }
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for(n = 0; n < 4; n++) {
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                }
                else {
                    n = 4;
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y - 2);
            for(n = 0; n < 4; n++) {
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                }
                else {
                    n = 4;
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x + 2, this.posn.y);
            canMove = right.nextToBlock(fell, current);
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = right.nextToBlock(fell, current);
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        //Piece sampleBlock = this;
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        int n;
        Posn current;
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for(n = 0; n < 4; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.CYAN));
                current.y++;
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y - 2);
            for(n = 0; n < 4; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.CYAN));
                current.y++;
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            for(n = 0; n < 4; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.CYAN));
                current.x++;
            }
        }
        else {
            current = new Posn(this.posn.x - 2, this.posn.y);
            for(n = 0; n < 4; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.CYAN));
                current.x++;
            }
        }
        return thisPiece;
    }
}

class JBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "JBlock";
    }
    
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 2; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(!canMove) {
                        n = 2;
                    }
                    current.y--;
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 3; n ++) {
                    canMove = left.nextToBlock(fell, current);
                    if(!canMove) {
                        n = 3;
                    }
                    current.y++;
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.x += 2;
                    current.y++;
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    current.x--;
                    if(current.x == 0) {
                        canMove = false;
                    }
                    else {
                        canMove = left.nextToBlock(fell, current);
                    }
                }
            }
        }
        return canMove;
    }
    
    //returns true if this piece can move down
    public  Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            for(n = 0; n < 3; n++) {
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    current.y++;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y + 1);
            for(n = 0; n < 2; n++) {
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                }
                else {
                    n = 2;
                }
            }
        }
        else {
            current = new Posn(this.posn.x + 1, this.posn.y -1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y += 2;
                canMove = down.nextToBlock(fell, current);
            }
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x += 2;
                current.y++;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for(n = 0; n < 3; n++) {
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        int n;
        Posn current;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.BLUE));
            current.y++;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.BLUE));
                current.x++;
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y + 1);
            thisPiece.add(new Block(current.x, current.y, Color.BLUE));
            current.y--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.BLUE));
                current.x--;
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y + 1);
            thisPiece.add(new Block(current.x, current.y, Color.BLUE));
            current.x++;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.BLUE));
                current.y--;
            }
        }
        else {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.BLUE));
            current.x--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.BLUE));
                current.y++;
            }
        }
        return thisPiece;
    } 
}

class LBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "LBlock";
    }
    
    //returns true if blah some shit.
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 2; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y--;
                        current.x -= 2;
                    }
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y -1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 3; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y++;
                    }
                    else {
                        n = 3;
                    }
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 2; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y++;
                    }
                    else {
                        n = 2;
                    }
                }
            }
        }
        else {
            current = new Posn(this.posn.x, this.posn.y + 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.y--;
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y--;
                    current.x--;
                    if(current.x == 0) {
                        canMove = false;
                    }
                    else {
                        canMove = left.nextToBlock(fell, current);
                    }
                }
            }
        }
        return canMove;
    }
    
    //returns true if this piece can move down
    public Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            for(n = 0; n < 3; n++) {
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x--;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y + 1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y--;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y += 2;
                canMove = down.nextToBlock(fell, current);
            }

        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y+ 1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y--;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y + 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x += 2;
                current.y--;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for(n = 0; n < 3; n++) {
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    current.y++;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        int n;
        Posn current;
        if(direction == "up") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
            current.y++;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
                current.x--;
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y + 1);
            thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
            current.y--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
                current.x++;
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
            current.x++;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
                current.y++;
            }
        }
        else {
            current = new Posn(this.posn.x + 1, this.posn.y + 1);
            thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
            current.x--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.ORANGE));
                current.y--;
            }
        }
        return thisPiece;
    }
}

class OBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "HmBlock";
    }
    
    //what do you think?
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        current = new Posn(this.posn.x, this.posn.y);
        for(n = 0; n < 2; n++) {
            //System.out.println("n = " + n);
            canMove = left.nextToBlock(fell, current);
            if(!canMove) {
                n = 2;
                //System.out.println("This can't move. we done");
            }
            else {
                current.y++;
                //System.out.println("That block could move. we're going on");
                //System.out.println("The current block is (1, " + current.y +")");
                //System.out.println("Can it move? " + left.nextToBlock(fell, current));
            }
        }
        return canMove;
    }

    public Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        current = new Posn(this.posn.x, this.posn.y + 1);
        canMove = down.nextToBlock(fell, current);
        if(canMove) {
            current.x++;
            canMove = down.nextToBlock(fell, current);
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current = new Posn(this.posn.x + 1, this.posn.y);
        Boolean canMove = right.nextToBlock(fell, current);
        if(canMove) {
            current.y++;
            canMove = right.nextToBlock(fell, current);
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        Posn current;
        current = new Posn(this.posn.x, this.posn.y);
        thisPiece.add(new Block(current.x, current.y, Color.YELLOW));
        current.x++;
        thisPiece.add(new Block(current.x, current.y, Color.YELLOW));
        current.y++;
        thisPiece.add(new Block(current.x, current.y, Color.YELLOW));
        current.x--;
        thisPiece.add(new Block(current.x, current.y, Color.YELLOW));
        return thisPiece;
    }
}

class SBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "SBlock";
    }
    
    //returns yer mum
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "left") {
            current = new Posn(this.posn.x, this.posn.y);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                if(current.x == 0) {
                    canMove = false;
                }
                else {
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    current.y--;
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y++;
                        current.x++;
                        canMove = left.nextToBlock(fell, current);
                    }
                }
            }
        }
        else {
            current = new Posn(this.posn.x, this.posn.y - 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y++;
                        current.x++;
                        canMove = left.nextToBlock(fell, current);
                    }
                }
            }
        }
        return canMove;
    }

    public Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x--;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x--;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                current.x--;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                current.x--;
                canMove = right.nextToBlock(fell, current);
            }
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        Posn current;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
        }
        else {
            current = new Posn(this.posn.x - 2, this.posn.y);
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.GREEN));
        }
        return thisPiece;
    }
}

class ZBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "ZBlock";
    }
    
    public Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        return canMove;
    }

    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = left.nextToBlock(fell, current);
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = left.nextToBlock(fell, current);
            }
        }
        return canMove;
    }

    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    current.x--;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                    current.x--;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x, this.posn.y);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
            }
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        // TODO Auto-generated method stub
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        Posn current;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x + 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x--;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
        }
        else {
            current = new Posn(this.posn.x - 1, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.y--;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
            current.x++;
            thisPiece.add(new Block(current.x, current.y, Color.RED));
        }
        return thisPiece;
    }
}

class TBlock extends Piece {
    //what fucking piece is this
    public String whatGoddamPieceIsThis() {
        return "TBlock";
    }
    
    //fuck.
    public Boolean canMoveLeft(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                canMove = left.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    current.y--;
                    canMove = left.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                for(n = 0; n < 3; n++) {
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.y++; 
                    }
                    else {
                        n = 3;
                    }
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            if(current.x == 0) {
                canMove = false;
            }
            else {
                current.x++;
                current.y++;
            }
        }
        else {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = left.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                if(current.x == 0) {
                    canMove = false;
                }
                else {
                    canMove = left.nextToBlock(fell, current);
                    if(canMove) {
                        current.x++;
                        current.y++;
                        canMove = left.nextToBlock(fell, current);
                    }
                }
            }
        }
        return canMove;
    }

    public Boolean canMoveDown(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            for(n = 0; n < 3; n ++) {
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
                if(canMove) {
                    current.x++;
                    current.y--;
                    canMove = down.nextToBlock(fell, current);
                }
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x + 1, this.posn.y);
            canMove = down.nextToBlock(fell, current);
            if(canMove) {
                current.x--;
                current.y++;
                canMove = down.nextToBlock(fell, current);
            }
        }
        return canMove;
    }
    
    public Boolean canMoveRight(ArrayList<Block> fell) {
        Posn current;
        int n;
        Boolean canMove = true;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y + 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y--;
                canMove = right.nextToBlock(fell, current);
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            for(n = 0; n < 3; n++) {
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.y++;
                }
                else {
                    n = 3;
                }
            }
        }
        else if(direction == "right") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            canMove = right.nextToBlock(fell, current);
            if(canMove) {
                current.x++;
                current.y++;
                canMove = right.nextToBlock(fell, current);
                if(canMove) {
                    current.x--;
                    current.y++;
                    canMove = right.nextToBlock(fell, current);
                }
            }
        }
        return canMove;
    }

    @Override
    public Boolean canRotateLeft(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    @Override
    public Boolean canRotateRight(ArrayList<Block> fell) {
        if(direction == "up") {
            
        }
        else if(direction == "down") {
            
        }
        else if(direction == "left") {
            
        }
        else if(direction == "right") {
            
        }
        return true;
    }

    public ArrayList<Block> toBlocks(ArrayList<Block> fell) {
        ArrayList<Block> thisPiece = new ArrayList<Block>();
        int n;
        Posn current;
        if(direction == "up") {
            current = new Posn(this.posn.x, this.posn.y - 1);
            thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
            current.x--;
            current.y++;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
                current.x++;
            }
        }
        else if(direction == "down") {
            current = new Posn(this.posn.x, this.posn.y + 1);
            thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
            current.x--;
            current.y--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
                current.x++;
            }
        }
        else if(direction == "left") {
            current = new Posn(this.posn.x - 1, this.posn.y);
            thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
            current.x++;
            current.y--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
                current.y++;
            }
        }
        else {
            current = new Posn(this.posn.x + 1, this.posn.y);
            thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
            current.x--;
            current.y--;
            for(n = 0; n < 3; n++) {
                thisPiece.add(new Block(current.x, current.y, Color.MAGENTA));
                current.y++;
            }
        }
        return thisPiece;
    }
}
