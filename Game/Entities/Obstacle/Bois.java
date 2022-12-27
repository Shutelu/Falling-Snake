package Game.Entities.Obstacle;
import Game.ProjectSettings;
import Game.Entities.Enemy.Snake;

public class Bois extends Obstacle implements StateObstacle {
    
    /**
     * Constructor of the Bois class
     */
    public Bois(){
        super(ProjectSettings.COLOR_BOIS);
    }

    @Override
    public void doAction(Snake snake) {
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
