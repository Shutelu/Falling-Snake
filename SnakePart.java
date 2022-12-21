


import java.awt.Graphics;

public class SnakePart extends Entity {

    public SnakePart(int positionX, int positionY) {

        //super class vriable initiation
        super.entity_position_x = positionX;
        super.entity_position_y = positionY;
        super.entity_width = ProjectSettings.SQUARE_WIDTH;
        super.entity_height = ProjectSettings.SQUARE_HEIGHT;
        super.entityIsAlive = true;
        super.entity_color = ProjectSettings.COLOR_SNAKE;

    }

    @Override
    public int move(){return 0;}

    @Override
    public void draw(Graphics g){}
}
