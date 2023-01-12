package Game.Entities.Obstacle;

import java.awt.Graphics;
import java.util.Random;
import Game.ProjectSettings;
import Game.Entities.Entity;
import Game.Entities.Enemy.Snake;
import Game.Entities.Enemy.SnakePart;
import java.awt.Color;

/**
 * The obstacle/fruit that will be placed on the scene, extends from it to create a new fruit and override the effect
 */
public abstract class Obstacle extends Entity implements StateObstacle {

    /**
     * Constructor of the Obstacle class
     * @param color color of the obstacle
     */
    public Obstacle(Color color){
        super(
            ( (int) (new Random().nextInt(450 - 30) + 30) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS,
            ( (int) (new Random().nextInt(540 - 100) + 100) / ProjectSettings.OBSTACLE_BLOCS) * ProjectSettings.OBSTACLE_BLOCS,
            ProjectSettings.OBSTACLE_WIDTH,
            ProjectSettings.OBSTACLE_HEIGHT,
            0,
            0,
            true,
            color
        );
    }

    StateObstacle state;

    @Override
    public int move(){return 0;}

    @Override 
    public void draw(Graphics g){
        if(entityIsAlive == true){
            g.setColor(entity_color);
            g.fillRect(entity_position_x, entity_position_y, entity_width, entity_height);
        }
    }

    @Override
    public void doAction(Snake snake){
        this.state.doAction(snake);
    }

    /**
     * Check the collision between obstacle with snake
     * return true if collide else false
     * @param head head of the snake to collide
     * @return true if collide else false
     */
    public boolean collisionWithSnake(SnakePart head){
        if(
            this.entity_position_y <= head.getEntityPosY() + head.getEntityHeight()
            && this.entity_position_x >= head.getEntityPosX()
            && this.entity_position_y >= head.getEntityPosY()
            && this.entity_position_x <= head.getEntityPosX() + head.getEntityWidth()
            || this.entity_position_y <= head.getEntityPosY() + head.getEntityHeight()
            && this.entity_position_x + this.entity_width <= head.getEntityPosX() + head.getEntityWidth()
            && this.entity_position_y >= head.getEntityPosY()
            && this.entity_position_x + this.entity_width >= head.getEntityPosX())
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
    /*public abstract void effect(Snake snake);*/

    /**
     * Give one of the 5 initial random Obstacle between Bois, Fraise, Myrtille, PiereOr 
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

}
