package Game.Entities;

import java.awt.Graphics;
import Game.ProjectSettings;

public class SnakePart extends Entity {

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
