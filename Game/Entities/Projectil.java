package Game.Entities;

import java.awt.Graphics;
import Game.ProjectSettings;
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
        if(this.entity_position_y <= obstacle.entity_position_y + obstacle.entity_height 
        && this.entity_position_x >= obstacle.entity_position_x
        && this.entity_position_x <= obstacle.entity_position_x + obstacle.entity_width
        || this.entity_position_y <= obstacle.entity_position_y + obstacle.entity_height
        && this.entity_position_x + this.entity_width <= obstacle.entity_position_x + obstacle.entity_width
        && this.entity_position_x + this.entity_width >= obstacle.entity_position_x)
        {return true;}
        
        return false;
    }

    public boolean collisionWithSnake(SnakePart snakeBody){
        if(
            this.entity_position_y <= snakeBody.entity_position_y + snakeBody.entity_height
            && this.entity_position_x >= snakeBody.entity_position_x
            && this.entity_position_y >= snakeBody.entity_position_y
            && this.entity_position_x <= snakeBody.entity_position_x + snakeBody.entity_width
            || this.entity_position_y <= snakeBody.entity_position_y + snakeBody.entity_height
            && this.entity_position_x + this.entity_width >= snakeBody.entity_position_x
            && this.entity_position_y >= snakeBody.entity_position_y
            && this.entity_position_x + this.entity_width <= snakeBody.entity_position_x + snakeBody.entity_width
        )
        {return true;}
        return false;
    }

}
