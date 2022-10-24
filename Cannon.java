public class Cannon extends Entity{
    
    public Cannon(){
        //super class variable initiation
        super.entity_position_x = ConstantVariable.CANNON_INITIAl_POSITION_X;
        super.entity_position_y = ConstantVariable.CANNON_POSITION_Y;
        super.entity_width = ConstantVariable.CANNON_WIDTH;
        super.entity_height = ConstantVariable.CANNON_HEIGHT;
        super.entity_move_x = 0;//mettre speed
        super.entity_move_y = 0; //a supp
        super.entity_color = ConstantVariable.CANNON_COLOR;

        //define entity shape
    }

    public int move(){

        //left
        if(entity_move_x < 0 && ConstantVariable.CANNON_BORDER_LIMIT_LEFT < entity_position_x){
            entity_position_x += entity_move_x;
        }
        //right
        else if(0 < entity_move_x && entity_position_x + entity_move_x < ConstantVariable.CANNON_BORDER_LIMIT_RIGHT){
            entity_position_x += entity_move_x;
        }
        return entity_position_x;
    }

}
