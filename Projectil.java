import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Projectil extends Entity{
    
    public Projectil(){
        super.entity_position_x = 0;
        super.entity_position_y = ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT;
        super.entity_width = ConstantVariable.PROJECTIL_WIDTH;
        super.entity_height = ConstantVariable.PROJECTIL_HEIGHT;
        super.entity_move_x = 0;
        super.entity_move_y = ConstantVariable.PROJECTIL_SPEED_Y;
    }

    private boolean canonFire = false;

    //getter
    public boolean getCanonFire(){return canonFire;}

    //setter
    public void setCanonFire(boolean bool){canonFire = bool;}

    public int move(){
        if(canonFire == true){
            //in screen
            if(this.entity_position_y > 0){
                this.entity_position_y -= ConstantVariable.PROJECTIL_SPEED_Y;
            }
            else{
                setCanonFire(false);
            }
        }
        return this.entity_position_y;
    }

    public void draw(Graphics g){
        if(this.canonFire == true){
            g.setColor(Color.WHITE);
            g.fillRect(entity_position_x, move(), entity_width, entity_height);
        }
    }
}
