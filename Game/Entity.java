package Game;
import java.awt.Color;
import java.awt.Graphics;
/**
 *  Abstract Entity Class that assemble position, width, move_speed, alive, color
 */
public abstract class Entity {
    
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
}
