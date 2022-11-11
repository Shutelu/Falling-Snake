import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity {
    
    protected int entity_position_x, entity_position_y;
    protected int entity_width, entity_height;
    protected int entity_move_x, entity_move_y;
    protected boolean entityIsAlive;
    protected Color entity_color;


    //getters
    // public int getEntityPosX(){return entity_position_x;}
    // public int getEntityPosY(){return entity_position_y;}
    // public int getEntityWidth(){return entity_width;}
    // public int getEntityHeight(){return entity_height;}
    // public Color getEntityColor(){return entity_color;}

    //setters
    public void setEntityPosX(int x){entity_position_x = x;}
    public void setEntityPosY(int y){entity_position_y = y;}
    public void setEntityMoveX(int x){entity_move_x = x;}
    public void setEntityMoveY(int y){entity_move_y = y;}
    public void setEntityColor(Color c){entity_color = c;}

    public abstract int move();
    public abstract void draw(Graphics g);
}
