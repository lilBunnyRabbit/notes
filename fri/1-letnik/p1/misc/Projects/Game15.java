import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;


public class Game15 extends JPanel implements ActionListener {
    private final String IMAGE_TYPE = "jpg";
    private final String IMAGE_NAME = "Photo";
    private final int BOARD_SIZE = 4;

    private int imageSize = 128;

    private int square_x = 0;
    private int square_y = 0;

    private int empty_x = BOARD_SIZE - 1;
    private int empty_y = BOARD_SIZE - 1;

    private boolean pressed = true;

    private Squares[][] objects;
    private Timer timer;
    private Squares empty;

    public Game15() {
        initGame();
    }
    
    private void initGame() {
        addKeyListener(new Inputs());
        setBackground(Color.black);
        setFocusable(true);

        splitImages();

        setPreferredSize(new Dimension(imageSize * BOARD_SIZE, imageSize * BOARD_SIZE));
        loadImages();

        timer = new Timer(0, this);
        timer.start();
    }

    private void loadImages() {
        objects = new Squares[BOARD_SIZE][BOARD_SIZE];   
        int counter = 1;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ImageIcon image = new ImageIcon(String.format("Images/square%d.png", counter));
                objects[i][j] = new Squares(image.getImage(), i, j, counter);
                counter++;
            }
        }

        
        ImageIcon image = new ImageIcon("Images/empty.png");
        empty = new Squares(image.getImage(), BOARD_SIZE - 1, BOARD_SIZE - 1, 16);
        objects[BOARD_SIZE - 1][BOARD_SIZE - 1] = empty;



    }

    private void splitImages(){
        try{
            BufferedImage source = ImageIO.read(new File(String.format("%s.%s", IMAGE_NAME, IMAGE_TYPE)));
            imageSize = source.getHeight() / BOARD_SIZE;
            if(imageSize == 0){ imageSize = 128;}
            int number = 1;
            for (int i = 0; i < source.getHeight(); i += imageSize) {
                for (int j = 0; j < source.getHeight(); j += imageSize) {
                    if(number != BOARD_SIZE * BOARD_SIZE){
                        ImageIO.write(source.getSubimage(j, i, imageSize, imageSize), "png", new File("Images/square" + number++ + ".png"));
                    }
                    
                }

            }
        }catch(Exception e){

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        int previusName = objects[0][0].getName();
        boolean correct = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                g.drawImage(objects[j][i].getImage(), square_x + i*imageSize, square_y + j*imageSize, this);
                if(previusName > objects[i][j].getName()){
                    correct = false;
                }

                if(objects[i][j].getName() == 16){
                    empty_x = i;
                    empty_y = j;
                }

                previusName = objects[i][j].getName();
            }
        }
        pressed = false;

        Toolkit.getDefaultToolkit().sync();

        if(correct){
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 82);
            FontMetrics metr = getFontMetrics(small);
    
            g.setColor(Color.red);
            g.setFont(small);
            g.drawString(msg, ((imageSize * BOARD_SIZE) - metr.stringWidth(msg))/2, (imageSize * BOARD_SIZE) / 2);
        }
      
    }

    public void shuffleParty(){
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
        switch(n) {
            case 1:
                if(empty_y != BOARD_SIZE - 1){
                    objects[empty_x][empty_y] = objects[empty_x][empty_y + 1];
                    objects[empty_x][empty_y + 1] = empty;
                }
                break;
            case 2:
                if(empty_y != 0){
                    objects[empty_x][empty_y] = objects[empty_x][empty_y - 1];
                    objects[empty_x][empty_y - 1] = empty;
                }
                break;
            case 3:
                if(empty_x != BOARD_SIZE - 1){
                    objects[empty_x][empty_y] = objects[empty_x + 1][empty_y];
                    objects[empty_x + 1][empty_y] = empty;
                }
                break;
            case 4:
                if(empty_x != 0){
                    objects[empty_x][empty_y] = objects[empty_x - 1][empty_y];
                    objects[empty_x - 1][empty_y] = empty;
                }
                break;

        }
   
        repaint();
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(pressed){
            repaint();
        }        
    }

    private class Inputs extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                if(empty_y != BOARD_SIZE - 1){
                    objects[empty_x][empty_y] = objects[empty_x][empty_y + 1];
                    objects[empty_x][empty_y + 1] = empty;
                    pressed = true;
                }
            }

            if (key == KeyEvent.VK_RIGHT) {
                if(empty_y != 0){
                    objects[empty_x][empty_y] = objects[empty_x][empty_y - 1];
                    objects[empty_x][empty_y - 1] = empty;
                    pressed = true;
                }
            }

            if (key == KeyEvent.VK_UP) {
                if(empty_x != BOARD_SIZE - 1){
                    objects[empty_x][empty_y] = objects[empty_x + 1][empty_y];
                    objects[empty_x + 1][empty_y] = empty;
                    pressed = true;
                }
            }

            if (key == KeyEvent.VK_DOWN) {
                if(empty_x != 0){
                    objects[empty_x][empty_y] = objects[empty_x - 1][empty_y];
                    objects[empty_x - 1][empty_y] = empty;
                    pressed = true;
                }
            }

            if (key == KeyEvent.VK_S) {
                shuffleParty(); 
                pressed = true;
            }
        }
    }
}