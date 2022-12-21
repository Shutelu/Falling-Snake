

import java.awt.Graphics;
import java.util.Random;

public class Obstacle extends Entity{
    
    public Obstacle(ObstacleType type){
        //super class variable initiation
        super.entity_position_x = ( (int) (new Random().nextInt(450 - 30) + 30) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS;
        super.entity_position_y = ( (int) (new Random().nextInt(540 - 100) + 100) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS;
        super.entity_width = ProjectSettings.OBSTACLE_WIDTH;
        super.entity_height = ProjectSettings.OBSTACLE_HEIGHT;
        super.entityIsAlive = true;

        //own
        this.obstacleType = type;
    }

    private ObstacleType obstacleType;

    @Override
    public int move(){return 0;}

    @Override 
    public void draw(Graphics g){
        if(entityIsAlive == true){
            g.setColor(obstacleType.getObstacleColor());
            g.fillRect(entity_position_x, entity_position_y, entity_width, entity_height);
        }
    }

    public boolean collisionWithSnake(SnakePart square){

        if(this.entity_position_y <= square.entity_position_y + square.entity_height
                && this.entity_position_x >= square.entity_position_x
                && this.entity_position_x <= square.entity_position_x + square.entity_width
                || this.entity_position_y <= square.entity_position_y + square.entity_height
                && this.entity_position_x + this.entity_width <= square.entity_position_x + square.entity_width
                && this.entity_position_x + this.entity_width >= square.entity_position_x)
        {return true;}

        return false;
    }
    
    //getter
    public ObstacleType getType(){return obstacleType;}
    
    //setter
    public void setType(ObstacleType type){this.obstacleType = type;}
}
