import java.awt.Image;

class Squares {
    private int x, y, name;
    private Image image;
    
    public Squares(Image image, int x, int y, int name){
        this.image = image;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Image getImage(){
        return this.image;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getName(){
        return this.name;
    }

}