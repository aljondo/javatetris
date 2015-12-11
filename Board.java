import javax.swing.*;

import java.util.Random;
import java.util.ArrayList;

//a bored
public class Board  {
    Random rando = new Random();
    JComponent component;
    Piece piece;
    
   
    
    //returns true if the game isnt lost
    public boolean gameIsRunning(ArrayList<Block> fell) {
        Boolean dat = true;
        for(int i = 0; i < fell.size(); i++) {
            dat = (!(fell.get(i).posn.y == 0));
        }
        return dat;
    }
    
    //creates a new random piece
    public Piece generateRandomPiece() {
        int p = rando.nextInt(7);
        Piece piece;
        if(p == 0) {
            piece = new IBlock();
        }
        else if(p == 1) {
            piece = new JBlock();
        }
        else if(p == 2) {
            piece = new LBlock();
            
        }
        else if(p == 3) {
            piece = new OBlock();
        }
        else if(p == 4) {
            piece = new SBlock();
        }
        else if(p == 5) {
            piece = new ZBlock();
        }
        else {
            piece = new TBlock();
        }
        return piece;
    }
    
    //figures out row shit
    public ArrayList<Block> clearRows(ArrayList<Block> fell, ArrayList<Block> thisPiece) {
        ArrayList<Block> row1 = new ArrayList<Block>();
        ArrayList<Block> row2 = new ArrayList<Block>();
        ArrayList<Block> row3 = new ArrayList<Block>();
        ArrayList<Block> row4 = new ArrayList<Block>();
        ArrayList<Block> row5 = new ArrayList<Block>();
        ArrayList<Block> row6 = new ArrayList<Block>();
        ArrayList<Block> row7 = new ArrayList<Block>();
        ArrayList<Block> row8 = new ArrayList<Block>();
        ArrayList<Block> row9 = new ArrayList<Block>();
        ArrayList<Block> row10 = new ArrayList<Block>();
        ArrayList<Block> row11 = new ArrayList<Block>();
        ArrayList<Block> row12 = new ArrayList<Block>();
        ArrayList<Block> row13 = new ArrayList<Block>();
        ArrayList<Block> row14 = new ArrayList<Block>();
        ArrayList<Block> row15 = new ArrayList<Block>();
        ArrayList<Block> row16 = new ArrayList<Block>();
        ArrayList<Block> row17 = new ArrayList<Block>();
        ArrayList<Block> row18 = new ArrayList<Block>();
        ArrayList<Block> row19 = new ArrayList<Block>();
        ArrayList<Block> row20 = new ArrayList<Block>();
        ArrayList<Block> row21 = new ArrayList<Block>();
        ArrayList<Block> row22 = new ArrayList<Block>();
        ArrayList<Block> row23 = new ArrayList<Block>();
        
        ArrayList<Block> trulyFell = fell;
        
        for(int i = 22; i > 0; i--) {
            for(int j = 0; j < fell.size(); j++) {
                if(i == 22) {
                    if(fell.get(j).posn.y == i){
                        row1.add(fell.get(j));
                        System.out.println("Pls work");
                    }
                }
                else if(i == 21) {
                    if(fell.get(j).posn.y == i) {
                        row2.add(fell.get(j));
                    }
                }
                else if(i == 20) {
                    if(fell.get(j).posn.y == i) {
                        row3.add(fell.get(j));
                    }
                }
                else if(i == 19) {
                    if(fell.get(j).posn.y == i) {
                        row4.add(fell.get(j));
                    }
                }
                else if(i == 18) {
                    if(fell.get(j).posn.y == i) {
                        row5.add(fell.get(j));
                    }
                }
                else if(i == 17) {
                    if(fell.get(j).posn.y == i) {
                        row6.add(fell.get(j));
                    }
                }
                else if(i == 16) {
                    if(fell.get(j).posn.y == i) {
                        row7.add(fell.get(j));
                    }
                }
                else if(i == 15) {
                    if(fell.get(j).posn.y == i) {
                        row8.add(fell.get(j));
                    }
                }
                else if(i == 14) {
                    if(fell.get(j).posn.y == i) {
                        row9.add(fell.get(j));
                    }
                }
                else if(i == 13) {
                    if(fell.get(j).posn.y == i) {
                        row10.add(fell.get(j));
                    }
                }
                else if(i == 12) {
                    if(fell.get(j).posn.y == i) {
                        row11.add(fell.get(j));
                    }
                }
                else if(i == 11) {
                    if(fell.get(j).posn.y == i) {
                        row12.add(fell.get(j));
                    }
                }
                else if(i == 10) {
                    if(fell.get(j).posn.y == i) {
                        row13.add(fell.get(j));
                    }
                }
                else if(i == 9) {
                    if(fell.get(j).posn.y == i) {
                        row14.add(fell.get(j));
                    }
                }
                else if(i == 8) {
                    if(fell.get(j).posn.y == i) {
                        row15.add(fell.get(j));
                    }
                }
                else if(i == 7) {
                    if(fell.get(j).posn.y == i) {
                        row16.add(fell.get(j));
                    }
                }
                else if(i == 6) {
                    if(fell.get(j).posn.y == i) {
                        row17.add(fell.get(j));
                    }
                }
                else if(i == 5) {
                    if(fell.get(j).posn.y == i) {
                        row18.add(fell.get(j));
                    }
                }
                else if(i == 4) {
                    if(fell.get(j).posn.y == i) {
                        row19.add(fell.get(j));
                    }
                }
                else if(i == 3) {
                    if(fell.get(j).posn.y == i) {
                        row20.add(fell.get(j));
                    }
                }
                else if(i == 3) {
                    if(fell.get(j).posn.y == i) {
                        row21.add(fell.get(j));
                    }
                }
                else if(i == 2) {
                    if(fell.get(j).posn.y == i) {
                        row22.add(fell.get(j));
                    }
                }
                else if(i == 1) {
                    if(fell.get(j).posn.y == i) {
                        row23.add(fell.get(j));
                    }
                }
            }
        }
        
        if(row1.size() == 10) {
           trulyFell = this.blockClearer(trulyFell, row1); 
           System.out.println("IT WORKED!");
        }
        if(row2.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row2); 
        }
        if(row3.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row3); 
        }
        if(row4.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row4); 
        }
        if(row5.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row5); 
        }
        if(row6.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row6); 
        }
        if(row7.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row7); 
        }
        if(row8.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row8); 
        }
        if(row9.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row9); 
        }
        if(row10.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row10);  
        }
        if(row11.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row11); 
        }
        if(row12.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row12); 
        }
        if(row13.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row13); 
        }
        if(row14.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row14); 
        }
        if(row15.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row15); 
        }
        if(row16.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row16); 
        }
        if(row17.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row17); 
        }
        if(row18.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row18); 
        }
        if(row19.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row19); 
        }
        if(row20.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row20); 
        }
        if(row21.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row21); 
        }
        if(row22.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row22); 
        } 
        if(row23.size() == 10) {
            trulyFell = this.blockClearer(trulyFell, row23); 
        }
        
        return trulyFell;
    }
    
    public ArrayList<Block> blockClearer(ArrayList<Block> fell, ArrayList<Block> toBeCleared) {
        int i;
        
        for(i = 0; i < toBeCleared.size(); i++) {
            fell.remove(toBeCleared.get(i));
        }
        for(i = 0; i < fell.size(); i++) {
            if(fell.get(i).posn.y < toBeCleared.get(0).posn.y) {
                fell.get(i).posn.y += 1;
            }
        }
        return fell;
    }

}