

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javalib.worldimages.Posn;

import javax.swing.*;

public class View extends JComponent implements KeyListener {

    private static final long serialVersionUID = 1L;
    private static final int windowW = 300;
    private static final int windowH = 660;
    public static final int TIMER_DELAY = 1000;
    public int w = 30;
    public int h = 30;
    public String direction = "up";
    public String piece = "IBlock";
    public Posn currentPiece = new Posn(5, 0);
    static JTextField typingArea;
    public Piece thePiece = new IBlock();
    public ArrayList<Block> fell = new ArrayList<Block>();
    //Boolean gamesStillGoin = true;

    View() {
        
        /*new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actEvt) {
                    if (currentPiece.y < 21) {
                        currentPiece.y++;
                        repaint();
                    }
                    else {
                        //((Timer) actEvt.getSource()).stop();
                        if(gamesStillGoin) {
                            piece = thePiece.whatGoddamPieceIsThis();
                            currentPiece.y = 0;
                        }
                    }
            }
        }).start();*/
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(windowW, windowH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
         * g.setColor(Color.BLACK); g.drawRect(currentPiece.x * 30,
         * currentPiece.y * 30, w, h); g.setColor(Color.CYAN);
         * g.fillRect(currentPiece.x * 30, currentPiece.y * 30, w, h);
         */
        // the below line does the above chunk. NOICE.
        // this.paintHelper(g, Color.CYAN, currentPiece.x, currentPiece.y);
        // this.paintHelper(g, Color.RED, currentPiece.x + 1, currentPiece.y);
        Posn current;
        int n;
        //this.piece = "ZBlock";
        //this.direction = "left";
        if (this.piece.equals("IBlock")) {
            g.setColor(Color.CYAN);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x, currentPiece.y - 1);
                for (n = 0; n < 4; n++) {
                    this.paintHelper(g, Color.CYAN, current.x, current.y);
                    current.y++;
                }
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x - 2, currentPiece.y);
                for (n = 0; n < 4; n++) {
                    this.paintHelper(g, Color.CYAN, current.x, current.y);
                    current.x++;
                }
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y);
                for (n = 0; n < 4; n++) {
                    this.paintHelper(g, Color.CYAN, current.x, current.y);
                    current.x++;
                }
            }
            else {
                current = new Posn(currentPiece.x, currentPiece.y - 2);
                for (n = 0; n < 4; n++) {
                    this.paintHelper(g, Color.CYAN, current.x, current.y);
                    current.y++;
                }
            }
        }
        else if (this.piece.equals("JBlock")) {
            g.setColor(Color.BLUE);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y - 1);
                this.paintHelper(g, Color.BLUE, current.x, current.y);
                current.y++;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.BLUE, current.x, current.y);
                    current.x++;
                }
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x + 1, currentPiece.y - 1);
                this.paintHelper(g, Color.BLUE, current.x, current.y);
                current.x--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.BLUE, current.x, current.y);
                    current.y++;
                }
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y + 1);
                this.paintHelper(g, Color.BLUE, current.x, current.y);
                current.x++;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.BLUE, current.x, current.y);
                    current.y--;
                }
            }
            else {
                current = new Posn(currentPiece.x + 1, currentPiece.y + 1);
                this.paintHelper(g, Color.BLUE, current.x, current.y);
                current.y--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.BLUE, current.x, current.y);
                    current.x--;
                }
            }
        }
        else if (this.piece.equals("LBlock")) {
            g.setColor(Color.ORANGE);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x + 1, currentPiece.y - 1);
                this.paintHelper(g, Color.ORANGE, current.x, current.y);
                current.y++;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.ORANGE, current.x, current.y);
                    current.x--;
                }
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x + 1, currentPiece.y + 1);
                this.paintHelper(g, Color.ORANGE, current.x, current.y);
                current.x--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.ORANGE, current.x, current.y);
                    current.y--;
                }
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y - 1);
                this.paintHelper(g, Color.ORANGE, current.x, current.y);
                current.x++;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.ORANGE, current.x, current.y);
                    current.y++;
                }
            }
            else {
                current = new Posn(currentPiece.x - 1, currentPiece.y + 1);
                this.paintHelper(g, Color.ORANGE, current.x, current.y);
                current.y--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.ORANGE, current.x, current.y);
                    current.x++;
                }
            }
        }
        else if (this.piece.equals("SBlock")) {
            g.setColor(Color.GREEN);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y - 1);
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y);
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y--;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x + 1, currentPiece.y);
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x--;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x--;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
            }
            else {
                current = new Posn(currentPiece.x, currentPiece.y - 1);
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.GREEN, current.x, current.y);
            }
        }
        else if (this.piece.equals("ZBlock")) {
            g.setColor(Color.RED);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x, currentPiece.y - 1);
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x--;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y - 1);
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.RED, current.x, current.y);
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y);
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x++;
                this.paintHelper(g, Color.RED, current.x, current.y);
            }
            else {
                current = new Posn(currentPiece.x + 1, currentPiece.y - 1);
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.x--;
                this.paintHelper(g, Color.RED, current.x, current.y);
                current.y++;
                this.paintHelper(g, Color.RED, current.x, current.y);
            }
        }
        else if (this.piece.equals("HmBlock")) {
            g.setColor(Color.YELLOW);
            current = new Posn(currentPiece.x, currentPiece.y);
            this.paintHelper(g, Color.YELLOW, current.x, current.y);
            current.x++;
            this.paintHelper(g, Color.YELLOW, current.x, current.y);
            current.y--;
            this.paintHelper(g, Color.YELLOW, current.x, current.y);
            current.x--;
            this.paintHelper(g, Color.YELLOW, current.x, current.y);
        }
        else if(this.piece.equals("TBlock")) {// TBlock
            g.setColor(Color.MAGENTA);
            if (this.direction.equals("up")) {
                current = new Posn(currentPiece.x, currentPiece.y - 1);
                this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                current.y++;
                current.x--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                    current.x++;
                }
            }
            else if (this.direction.equals("right")) {
                current = new Posn(currentPiece.x + 1, currentPiece.y);
                this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                current.y--;
                current.x--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                    current.y++;
                }
            }
            else if (this.direction.equals("left")) {
                current = new Posn(currentPiece.x - 1, currentPiece.y);
                this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                current.y--;
                current.x++;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                    current.y++;
                }
            }
            else {
                current = new Posn(currentPiece.x, currentPiece.y + 1);
                this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                current.y--;
                current.x--;
                for (n = 0; n < 3; n++) {
                    this.paintHelper(g, Color.MAGENTA, current.x, current.y);
                    current.x++;
                }
            }
        }
        for(int x = 0; x < this.fell.size(); x++) {
            this.paintHelper(g, this.fell.get(x).color, this.fell.get(x).posn.x, this.fell.get(x).posn.y);
        }
    }

    // IMPORTANT: paints a block with its fill color and outline color
    public void paintHelper(Graphics g, Color c, int x, int y) {
        g.setColor(c);
        g.fillRect(x * 30, y * 30, w, h);
        g.setColor(Color.BLACK);
        g.drawRect(x * 30, y * 30, w, h);
    }

    public int getRectX() {
        return currentPiece.x;
    }

    public int getRectY() {
        return currentPiece.y;
    }
    
    // IMPORTANT: gives the piece an x-coordinate when it spawns
    public void whereTheHellIsItStarting(int x) {
        this.currentPiece.x = x;
    }
    // IMPORTANT: mutator for the current piece's x coordinate
    public void movePieceLeft() {
        this.currentPiece.x--;
    }
    
    // IMPORTANT: mutator for the current piece's x coordinate
    public void movePieceRight() {
        this.currentPiece.x++;
    }

    // IMPORTANT: mutator for the current piece's y coordinate
    public void movePieceDown() {
        this.currentPiece.y++;
    }

    // IMPORTANT: mutator for the current piece's direction
    public void rotatePieceRight() {
        if(this.direction == "up") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
        else if(this.direction == "right") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
        else if(this.direction == "down") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
        else {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
    }

    //totes important
    public void rotatePieceLeft() {
        if(this.direction == "up") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
        else if(this.direction == "left") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        } 
        else if(this.direction == "down") {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
        else {
            this.currentPiece = this.thePiece.posn;
            this.direction = this.thePiece.direction;
        }
    }

    // IMPORTANT: mutator for the current piece
    public void setPiece(String p) {
        this.piece = p;
    }
    
    //IMPORTANT: sets the damn piece
    public void setTheDamnPiece(Piece p) {
        this.thePiece = p;
    }

    // returns the current type of piece
    public String getPiece() {
        return this.piece;
    }

    // returns the current piece's direction
    public String getDirection() {
        return this.direction;
    }

    public void createAndShowGui() {
        JFrame frame = new JFrame("Tetris");
        //JComponent component;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.addKeyListener(this);
        frame.setVisible(true);


        //this.addComponentsToFrame(frame);
        
    }


    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }*/

    // LOTSA KEYBOARD STUFF
    public void keyPressed(KeyEvent e) {
        keyBoardStuff(e, "KeyPressed");
    }

    public void keyReleased(KeyEvent e) {
        keyBoardStuff(e, "KeyReleased");
    }

    public void keyTyped(KeyEvent e) {
        keyBoardStuff(e, "KeyTyped");
    }

    public void keyBoardStuff(KeyEvent e, String keyStatus) {
        int id = e.getID();
        if (id == KeyEvent.KEY_PRESSED) {
            char c = e.getKeyChar();
            moreKeyBoardStuff(c);
        }
    }

    public void moreKeyBoardStuff(char c) {
        if (c == 's') {
            if(this.thePiece.canMoveDown(fell)) {
                this.movePieceDown();
                this.thePiece.posn.y = this.currentPiece.y;
            }
        }
        else if (c == 'a') {
            if(this.thePiece.canMoveLeft(fell)) {
                this.movePieceLeft();
                this.thePiece.posn.x = this.currentPiece.x;
            }
        }
        else if (c == 'd') {
            if(this.thePiece.canMoveRight(fell)) {
                this.movePieceRight();
                this.thePiece.posn.x = this.currentPiece.x;
            }
        }
        else if (c == 'x') {
                this.thePiece.rotateLeft(fell);
                this.rotatePieceLeft();
        }
        else if (c == 'c') {
                this.thePiece.rotateRight(fell);
                this.rotatePieceRight();
        }
    }
}
