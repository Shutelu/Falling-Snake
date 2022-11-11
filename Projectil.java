import java.awt.Graphics;

public class Projectil extends Entity{
    
    public Projectil(){
        //super class variable initiation
        super.entity_position_x = -10;
        super.entity_position_y = -10;
        super.entity_width = ConstantVariable.PROJECTIL_WIDTH;
        super.entity_height = ConstantVariable.PROJECTIL_HEIGHT;
        super.entity_move_y = ConstantVariable.PROJECTIL_MOVESPEED_Y;
        super.entity_color = ConstantVariable.COLOR_PROJECTIL;
        super.entityIsAlive = false;
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
        if(
            this.entity_position_y <= snakeBody.entity_position_y + snakeBody.entity_height
            && this.entity_position_x >= snakeBody.entity_position_x
            && this.entity_position_y >= snakeBody.entity_position_y
            && this.entity_position_x <= snakeBody.entity_position_x + snakeBody.entity_width
            || this.entity_position_y <= snakeBody.entity_position_y + snakeBody.entity_height
            && this.entity_position_x + this.entity_width >= snakeBody.entity_position_x
            && this.entity_position_y >= snakeBody.entity_position_y
            && this.entity_position_x + this.entity_width <= snakeBody.entity_position_x + snakeBody.entity_width
        )
        {return true;}
        return false;
    }

}
