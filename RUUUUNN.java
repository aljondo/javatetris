import javax.swing.SwingUtilities;


public class RUUUUNN {
    
    public static void main(String[] args) {

        Tetris tetris = new Tetris();
        final View view = new View();

        // Get the swing dispatch thread to make the GUI visible for us
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }
}
