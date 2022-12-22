package Game.Entities.Enemy;

import java.awt.Graphics;
import Game.ProjectSettings;
import Game.Entities.Entity;

public class SnakePart extends Entity {

    /**
     * Constructor of the SnakePart class
     * @param positionX initial position x 
     * @param positionY initial position y
     */
    public SnakePart(int positionX, int positionY) {
        super(
            positionX,
            positionY,
            ProjectSettings.SNAKEPART_WIDTH,
            ProjectSettings.SNAKEPART_HEIGHT,
            0,
            0,
            true,
            ProjectSettings.COLOR_SNAKE
        );
    }

    @Override
    public int move(){return 0;}

    @Override
    public void draw(Graphics g){}
}
