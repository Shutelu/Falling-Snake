package Game.Entities.Obstacle;

import Game.ProjectSettings;
import Game.Entities.Enemy.Snake;

public class Fraise extends Obstacle{
    
    /**
     * Constructor of the Fraise class
     */
    public Fraise(){
        super(ProjectSettings.COLOR_FRAISE);
    }

    @Override
    public void effect(Snake snake){
        snake.setEatFraise(true);
    }
}
