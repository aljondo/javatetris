import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class Tetris {
    static Piece fallingPiece;
    static View view = new View();
    static ArrayList<Block> fell = new ArrayList<Block>();
    static ArrayList<Block> thisPiece = new ArrayList<Block>();
    static Boolean isItReallyDone = false;
    
    
    /*
     * HOW THIS IS GONNA WORK:
     */
    public static void main(String args[]) {
        final Board bored = new Board();
        fallingPiece = bored.generateRandomPiece();
        view.setTheDamnPiece(fallingPiece);
        view.setPiece(fallingPiece.whatGoddamPieceIsThis());
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.createAndShowGui();
            }
        });

        startAnotherTimer();
        Timer timer = new Timer(View.TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent actEvt) {
                fell = view.fell;
                fallingPiece.posn.y = view.thePiece.posn.y;
                System.out.println("Can it move down?" + fallingPiece.canMoveDown(fell));
                    if(fallingPiece.canMoveDown(fell)) {
                        //System.out.println("It can move down");
                        //fallingPiece.posn.y++;
                        //System.out.println(view.thePiece.direction);
                        view.currentPiece.y++;
                        fallingPiece.posn = view.currentPiece;
                        view.repaint();
                        //System.out.println("The backend thinks I am a: " + fallingPiece.whatGoddamPieceIsThis());
                        //System.out.println("The frontend thinks I am a: " + view.thePiece.whatGoddamPieceIsThis());
                        //System.out.println("The frontend thinks I am a " + view.piece);
                        //System.out.println("The backend piece x is at " + fallingPiece.posn.x);
                        //System.out.println("The frontend piece x is at " + view.thePiece.posn.x);
                        //System.out.println("The backend *drawing* x is at " + view.currentPiece.x);
                        //System.out.println("The backend piece y is at " + fallingPiece.posn.y);
                        //System.out.println("The frontend piece y is at " + view.thePiece.posn.y);
                        //System.out.println("The backend *drawing* y is at " + view.currentPiece.y);
                    }
                    else {
                        if(isItReallyDone) {
                        if(bored.gameIsRunning(fell)) {
                            thisPiece = fallingPiece.toBlocks(fell);
                            //System.out.println("thisPiece is empty?" + thisPiece.isEmpty());
                            view.fell.addAll(thisPiece);
                            //System.out.println("view's fell is empty?: " + view.fell.isEmpty());
                            fell = bored.clearRows(fell, thisPiece);
                            fallingPiece = bored.generateRandomPiece();
                            view.thePiece = fallingPiece;
                            view.piece = view.thePiece.whatGoddamPieceIsThis();
                            //System.out.println("Exactly what is this?" + view.thePiece.whatGoddamPieceIsThis());
                            view.currentPiece.y = 0;
                            view.repaint();
                        }
                        else {
                            System.out.println("You lost, bro");
                            ((Timer) actEvt.getSource()).stop();
                        }
                        }
                    }
            }
        });
        timer.start();
    }
    
    private static void startAnotherTimer() {
        final Board bored = new Board();
        new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent actEvt) {
                fallingPiece.posn.x = view.currentPiece.x;
                fallingPiece = view.thePiece;
                view.direction = view.thePiece.direction;
                if(fallingPiece.canMoveDown(fell)) {
                    view.repaint();
                    isItReallyDone = false;
                }
                else {
                    isItReallyDone = true;
                    if(!bored.gameIsRunning(fell)) {
                        System.out.println("You lost, bro");
                        ((Timer) actEvt.getSource()).stop();
                    }
                }
            }
        }).start();
        
    }
    
}

