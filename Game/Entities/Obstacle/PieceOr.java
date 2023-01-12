package Game.Entities.Obstacle;

import Game.ProjectSettings;
import Game.Entities.Enemy.Snake;

/**
 * Obstacle PieceOr
 */
public class PieceOr extends Obstacle{

    /**
     * Constructor of the PieceOr class
     */
    public PieceOr() {
        super(ProjectSettings.COLOR_OR);
    }
    
    @Override
    public void doAction(Snake snake) {
        for (int i = 0; i < snake.getSnakGameScene().getObstacleList().length - 1; i++) {
            if (snake.getSnakGameScene().getObstacleList()[i] != null) {
                snake.getSnakGameScene().getObstacleList()[i] = snake.getSnakGameScene().getObstacleList()[i].changeObstacle();
            }
        }

    }

}
