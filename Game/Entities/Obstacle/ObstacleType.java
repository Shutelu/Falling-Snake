package Game.Entities.Obstacle;

import java.awt.Color;
import Game.ProjectSettings;

public enum ObstacleType {
    BOIS(ProjectSettings.COLOR_BOIS),
    FRAISE(ProjectSettings.COLOR_FRAISE),
    MYRTILLE(ProjectSettings.COLOR_MYRTILLE),
    PIECE_DOR(ProjectSettings.COLOR_OR);

    private ObstacleType(Color c){
        this.color = c;
    }

    private final Color color;

    //getter
    public Color getObstacleColor(){return color;}
}
