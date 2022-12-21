package Game.Entities.Obstacle;

import Game.Entities.Snake;

public class Fraise extends Obstacle{
    
    public Fraise(){
        super(ObstacleType.FRAISE);
    }

    @Override
    public void effect(Snake snake){
        snake.setEatFraise(true);
    }
}
