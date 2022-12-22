package Game.Entities.Obstacle;

import Game.ProjectSettings;
import Game.Entities.Snake;

public class PieceOr extends Obstacle{
    
    /**
     * Constructor of the PieceOr class
     */
    public PieceOr(){
        super(ProjectSettings.COLOR_OR);
    }

    @Override
    public void effect(Snake snake){
        for (int i = 0; i < snake.getSnakGameScene().getObstacleList().length - 1; i++) {
            if (snake.getSnakGameScene().getObstacleList()[i] != null) {
                // snake.getSnakGameScene().getObstacleList()[i].setType(ObstacleType.randomType());
                snake.getSnakGameScene().getObstacleList()[i] = snake.getSnakGameScene().getObstacleList()[i].changeObstacle();
            }
        }
    }
}
