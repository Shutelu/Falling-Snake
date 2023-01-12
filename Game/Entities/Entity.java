package Game.Entities;
import java.awt.Color;
import java.awt.Graphics;

/**
 *  Abstract Entity Class that assemble position, width, move_speed, alive, color
 */
public abstract class Entity {
    
    /**
     * Entity constructor class
     * @param posx entity position x
     * @param posy entity position y
     * @param width entity width
     * @param height entity height
     * @param movex entity move x
     * @param movey entity move y
     * @param alive entity if alive
     * @param color entity color
     */
    public Entity(int posx, int posy, int width, int height, int movex, int movey, boolean alive, Color color){
        entity_position_x = posx;
        entity_position_y = posy;
        entity_width = width;
        entity_height = height;
        entity_move_x = movex;
        entity_move_y = movey;
        entityIsAlive = alive;
        entity_color = color;
    }

    protected int entity_position_x, entity_position_y;
    protected int entity_width, entity_height;
    protected int entity_move_x, entity_move_y;
    protected boolean entityIsAlive;
    protected Color entity_color;

    /**
     * Calculate the position and movement of the entity 
     * @return the position of the entity
     */
    public abstract int move();

    /**
     * Draw the entity on screen
     * @param g the graphic of the game
     */
    public abstract void draw(Graphics g);

    //getter
    public int getEntityPosX(){return entity_position_x;}
    public int getEntityPosY(){return entity_position_y;}
    public int getEntityWidth(){return entity_width;}
    public int getEntityHeight(){return entity_height;}
    public int getEntityMoveX(){return entity_move_x;}
    public int getEntityMoveY(){return entity_move_y;}
    public boolean getEntityIsAlive(){return entityIsAlive;}
    public Color getEntityColor(){return entity_color;}

    //setter
    public void setEntityPosX(int x){entity_position_x = x;}
    public void setEntityPosY(int y){entity_position_y = y;}
    public void setEntityMoveX(int x){entity_move_x = x;}
    public void setEntityMoveY(int y){entity_move_y = y;}
    public void setEntityAlive(boolean b){entityIsAlive = b;}
    public void setEntityColor(Color c){entity_color = c;}
}
