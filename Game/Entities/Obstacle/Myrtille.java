package Game.Entities.Obstacle;

import Game.ProjectSettings;
import Game.Entities.Enemy.Snake;

public class Myrtille extends Obstacle {
    
    /**
     * Constructor of the Myrtille class
     */
    public Myrtille(){
        super(ProjectSettings.COLOR_MYRTILLE);
    }

    @Override
    public void effect(Snake snake){
        if(snake.getCanKillBodyPart()){
            snake.setCanKillBodyPart(false);
            System.out.println("invincible time !");
        }
    }
}
