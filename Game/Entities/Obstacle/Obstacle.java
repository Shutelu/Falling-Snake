package Game.Entities.Obstacle;

import java.awt.Graphics;
import java.util.Random;

import Game.GameScene;
import Game.ProjectSettings;
import Game.Entities.Entity;
import Game.Entities.Snake;
import Game.Entities.SnakePart;

/**
 * The obstacle/fruit that will be placed on the scene, extends from it to create a new fruit and override the effect
 */
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

        if(this.entity_position_y <= square.getEntityPosY() + square.getEntityHeight()
                && this.entity_position_x >= square.getEntityPosX()
                && this.entity_position_x <= square.getEntityPosX() + square.getEntityWidth()
                || this.entity_position_y <= square.getEntityPosY() + square.getEntityHeight()
                && this.entity_position_x + this.entity_width <= square.getEntityPosX() + square.getEntityWidth()
                && this.entity_position_x + this.entity_width >= square.getEntityPosX())
        {return true;}

        return false;
    }

    /**
     * Change the old obstacle to a new random one
     * @return new random obstacle
     */
    public Obstacle changeObstacle(){
        Obstacle o = Obstacle.randomObstacle();
        o.entity_position_x = this.entity_position_x;
        o.entity_position_y = this.entity_position_y;
        return o;
    }

    /**
     * The effect of the obstacle/fruit
     */
    public void effect(Snake snake){System.out.println("tetst");}

    /**
     * Give one of the 4 initial random Obstacle between Bois, Fraise, Myrtille, PiereOr 
     * @return Obstacle to place
     */
    public static Obstacle randomObstacle(){
        int randObs = new Random().nextInt(4);
        switch (randObs) {
            case 0:
                return new Bois();
            case 1:
                return new Fraise();
            case 2:
                return new Myrtille();
            case 3:
                return new PieceOr();
            default:
                return new Bois();
        }
    }
    
    //getter
    public ObstacleType getType(){return obstacleType;}
    
    //setter
    public void setType(ObstacleType type){this.obstacleType = type;}
}
