import javax.swing.JFrame;

public class RunGame extends JFrame {

    public RunGame() {
        initUI();
    }
    
    private void initUI() {
        Game15 b = new Game15();
        add(b);
        
        setResizable(false);
        pack();
        
        setTitle("Game15");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        JFrame ex = new RunGame();
        ex.setVisible(true);
    }
    
}