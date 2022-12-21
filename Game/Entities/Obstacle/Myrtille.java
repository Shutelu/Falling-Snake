package Game.Entities.Obstacle;

import Game.Entities.Snake;

public class Myrtille extends Obstacle {
    
    public Myrtille(){
        super(ObstacleType.MYRTILLE);
    }

    @Override
    public void effect(Snake snake){
        if(snake.getCanKillBodyPart()){
            snake.setCanKillBodyPart(false);
            System.out.println("invincible time !");
        }
    }
}
