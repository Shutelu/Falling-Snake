public class Cannon extends Entity{
    
    public Cannon(){
        //super class variable initiation
        super.entity_position_x = ConstantVariable.CANNON_INITIAl_POSITION_X;
        super.entity_position_y = ConstantVariable.CANNON_POSITION_Y;
        super.entity_width = ConstantVariable.CANNON_WIDTH;
        super.entity_height = ConstantVariable.CANNON_HEIGHT;
        super.entity_move_x = ConstantVariable.CANNON_SPEED;//a changer
        super.entity_move_y = 0; //a supp
        super.entity_color = ConstantVariable.CANNON_COLOR;

        //define entity shape
    }

}
