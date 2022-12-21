package Game.Entities.Obstacle;
import Game.Entities.Snake;

public class Bois extends Obstacle{
    
    public Bois(){
        super(ObstacleType.BOIS);
    }

    @Override
    public void effect(Snake snake){
        if (snake.getDirection() == "right") {
            snake.setDirection("down");
            snake.moveSnake();
            snake.setDirection("left");
            snake.moveSnake();
        } else if (snake.getDirection() == "left") {
            snake.setDirection("down");
            snake.moveSnake();
            snake.setDirection("right");
            snake.moveSnake();
        }
    }
}
