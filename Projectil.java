import java.awt.Graphics;

public class Projectil extends Entity{
    
    public Projectil(){
        //super class variable initiation
        super.entity_position_x = 0;
        super.entity_position_y = ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT;
        super.entity_width = ConstantVariable.PROJECTIL_WIDTH;
        super.entity_height = ConstantVariable.PROJECTIL_HEIGHT;
        super.entity_move_x = 0;
        super.entity_move_y = ConstantVariable.PROJECTIL_MOVESPEED_Y;
        super.entityIsAlive = false;
        super.entity_color = ConstantVariable.COLOR_PROJECTIL;
    }

    public int move(){
        if(entityIsAlive == true){
            if(this.entity_position_y > 0){
                this.entity_position_y -= ConstantVariable.PROJECTIL_MOVESPEED_Y;
            }
            else{
                this.entityIsAlive = false;
            }
        }
        return this.entity_position_y;
    }

    public void draw(Graphics g){
        if(entityIsAlive == true){
            g.setColor(entity_color);
            g.fillRect(entity_position_x, move(), entity_width, entity_height);
        }
    }

    public boolean collisionWithObstacle(Obstacle obstacle){
        if(this.entity_position_y <= obstacle.entity_position_y + obstacle.entity_height 
        && this.entity_position_x >= obstacle.entity_position_x
        && this.entity_position_x <= obstacle.entity_position_x + obstacle.entity_width
        || this.entity_position_y <= obstacle.entity_position_y + obstacle.entity_height
        && this.entity_position_x + this.entity_width <= obstacle.entity_position_x + obstacle.entity_width
        && this.entity_position_x + this.entity_width >= obstacle.entity_position_x)
        {return true;}
        
        return false;
    }

    public boolean collisionWithSnake(Square snakeBody){
        if(this.entity_position_y <= snakeBody.getCoordY() + snakeBody.getSquareHeight() 
        && this.entity_position_x >= snakeBody.getCoordX()
        && this.entity_position_x <= snakeBody.getCoordX() + snakeBody.getSquareWidth()
        || this.entity_position_y <= snakeBody.getCoordY() + snakeBody.getSquareHeight()
        && this.entity_position_x + this.entity_width <= snakeBody.getCoordX() + snakeBody.getSquareWidth()
        && this.entity_position_x + this.entity_width >= snakeBody.getCoordX())
        {return true;}
        return false;
    }

}
