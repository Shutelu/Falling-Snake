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
}
