package Game.Entities.Player;

import java.awt.Graphics;
import Game.ProjectSettings;
import Game.Entities.Entity;
import Game.Entities.SnakePart;
import Game.Entities.Obstacle.Obstacle;

public class Projectil extends Entity{
    
    public Projectil(){
        super(
            -10,
            -10,
            ProjectSettings.PROJECTIL_WIDTH,
            ProjectSettings.PROJECTIL_HEIGHT,
            0,
            ProjectSettings.PROJECTIL_MOVESPEED_Y,
            false,
            ProjectSettings.COLOR_PROJECTIL
        );
    }

    public int move(){
        if(entityIsAlive == true){
            if(this.entity_position_y > 0){
                this.entity_position_y -= ProjectSettings.PROJECTIL_MOVESPEED_Y;
            }
            else{
                this.entityIsAlive = false;
            }
        }
        return this.entity_position_y;
    }

    public void draw(Graphics g){
        if(entityIsAlive == true){
            g.setColor(entity_color);
            g.fillRect(entity_position_x, move(), entity_width, entity_height);
        }
    }

    public boolean collisionWithObstacle(Obstacle obstacle){
        if(this.entity_position_y <= obstacle.getEntityPosY() + obstacle.getEntityHeight() 
            && this.entity_position_x >= obstacle.getEntityPosX()
            && this.entity_position_x <= obstacle.getEntityPosX() + obstacle.getEntityWidth()
            || this.entity_position_y <= obstacle.getEntityPosY() + obstacle.getEntityHeight()
            && this.entity_position_x + this.entity_width <= obstacle.getEntityPosX() + obstacle.getEntityWidth()
            && this.entity_position_x + this.entity_width >= obstacle.getEntityPosX()
        )
        {return true;}
        
        return false;
    }

    public boolean collisionWithSnake(SnakePart snakeBody){
        if(this.entity_position_y <= snakeBody.getEntityPosY() + snakeBody.getEntityHeight()
            && this.entity_position_x >= snakeBody.getEntityPosX()
            && this.entity_position_y >= snakeBody.getEntityPosY()
            && this.entity_position_x <= snakeBody.getEntityPosX() + snakeBody.getEntityWidth()
            || this.entity_position_y <= snakeBody.getEntityPosY() + snakeBody.getEntityHeight()
            && this.entity_position_x + this.entity_width >= snakeBody.getEntityPosX()
            && this.entity_position_y >= snakeBody.getEntityPosY()
            && this.entity_position_x + this.entity_width <= snakeBody.getEntityPosX() + snakeBody.getEntityWidth()
        )
        {return true;}
        return false;
    }

}
