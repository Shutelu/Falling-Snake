
import java.awt.Graphics;

public class Square extends Entity {

    public Square(int positionX, int positionY) {

        //super class vriable initiation
        super.entity_position_x = positionX;
        super.entity_position_y = positionY;
        super.entity_width = ConstantVariable.SQUARE_WIDTH;
        super.entity_height = ConstantVariable.SQUARE_HEIGHT;
        super.entity_move_x = 0;
        super.entity_move_y = 0;
        super.entityIsAlive = true;
        super.entity_color = ConstantVariable.COLOR_SNAKE;

    }

    @Override
    public int move(){return 0;}

    @Override
    public void draw(Graphics g){}
}
