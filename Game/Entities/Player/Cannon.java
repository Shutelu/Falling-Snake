package Game.Entities.Player;
import java.awt.Graphics;

import Game.ProjectSettings;
import Game.Entities.Entity;
import Game.Entities.Enemy.SnakePart;
/**
 * Cannon that move from left to right with A and D and the arrow key, shoot projectil with spacebare
 */
public class Cannon extends Entity{
    
    /**
     * Constructor of the class Cannon 
     */
    public Cannon(){
        super(
            ProjectSettings.CANNON_POSITION_X,
            ProjectSettings.CANNON_POSITION_Y,
            ProjectSettings.CANNON_WIDTH,
            ProjectSettings.CANNON_HEIGHT,
            0,
            0,
            true,
            ProjectSettings.COLOR_CANNON
        );
        this.canFire = true;
    }

    private boolean canFire;

    /**
     * Calculate the position and movement of the entity 
     * @return the position of the entity
     */
    public int move(){
        //left and limit | -1
        if(entity_move_x < 0 && ProjectSettings.CANNON_BORDER_LIMIT_LEFT < entity_position_x){
            entity_position_x += entity_move_x;
        }
        //right and limit | 1
        else if(0 < entity_move_x && entity_position_x < ProjectSettings.CANNON_BORDER_LIMIT_RIGHT){
            entity_position_x += entity_move_x;
        }
        return entity_position_x;
    }

    /**
     * Draw the entity on screen
     * @param g the graphic of the game
     */
    public void draw(Graphics g){
        g.setColor(entity_color);
        g.fillRect(move(), entity_position_y, entity_width, entity_height);
    }

    /**
     * Check the collision between the Cannon and the snake
     * @param snakeHead the first part of the snake that will collide with the cannon
     * @return true if collide else false
     */
    public boolean collisionWithSnake(SnakePart snakeHead){
        if(this.entity_position_x <= snakeHead.getEntityPosX() + snakeHead.getEntityWidth()
            && this.entity_position_y <= snakeHead.getEntityPosY() + snakeHead.getEntityHeight()
            && this.entity_position_x + this.entity_width >= snakeHead.getEntityPosX()
            && this.entity_position_y <= snakeHead.getEntityPosY() + snakeHead.getEntityHeight()
        )
        {return true;}
        return false;
    }

    /**
     * Get if the cannon can fire
     * @return true if can fire else false
     */
    public boolean getCanFire(){return canFire;}

    /**
     * Set the cannon to fire
     * @param b true if can fire else false
     */
    public void setCanFire(boolean b){canFire = b;}
}
