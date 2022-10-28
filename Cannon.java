import java.awt.Graphics;

public class Cannon extends Entity{
    
    public Cannon(){
        //super class variable initiation
        super.entity_position_x = ConstantVariable.CANNON_INITIAl_POSITION_X;
        super.entity_position_y = ConstantVariable.CANNON_POSITION_Y;
        super.entity_width = ConstantVariable.CANNON_WIDTH;
        super.entity_height = ConstantVariable.CANNON_HEIGHT;
        super.entity_move_x = 0;//mettre speed
        super.entity_move_y = 0; //a supp
        super.entity_color = ConstantVariable.COLOR_CANNON;

        //define entity shape
    }

    public int move(){

        //left and not limit | -1
        if(entity_move_x < 0 && ConstantVariable.CANNON_BORDER_LIMIT_LEFT < entity_position_x){
            entity_position_x += entity_move_x;
        }
        //right and not limit | 1
        else if(0 < entity_move_x && entity_position_x + entity_move_x < ConstantVariable.CANNON_BORDER_LIMIT_RIGHT){
            entity_position_x += entity_move_x;
        }

        // if(entity_move_x < 0 ){
        //     entity_position_x += entity_move_x;
        // }
        // //right and not limit | 1
        // else if(0 < entity_move_x ){
        //     entity_position_x += entity_move_x;
        // }

        // //up
        // if(entity_move_y < 0){
        //     entity_position_y += entity_move_y;
        // }
        // //down
        // else if(0 < entity_move_y){
        //     entity_position_y += entity_move_y;
        // }
        
        return entity_position_x;
    }

    public void draw(Graphics g){
        g.setColor(entity_color);
        //g.fillRect(entity_position_x, entity_position_y, entity_width, entity_height);
        g.fillRect(move(), entity_position_y, entity_width, entity_height);
        // g.fillRect(entity_position_x, entity_position_y, entity_width, entity_height);
    }

}
