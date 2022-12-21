package Game.Entities;

import java.awt.Graphics;
import java.util.Random;
import Game.ProjectSettings;

public class Obstacle extends Entity{
    
    public Obstacle(ObstacleType type){
        super(
            ( (int) (new Random().nextInt(450 - 30) + 30) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS,
            ( (int) (new Random().nextInt(540 - 100) + 100) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS,
            ProjectSettings.OBSTACLE_WIDTH,
            ProjectSettings.OBSTACLE_HEIGHT,
            0,
            0,
            true,
            null
        );

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
