

import java.awt.Color;
import java.util.Random;

public enum ObstacleType {
    BOIS(ProjectSettings.COLOR_BOIS),
    FRAISE(ProjectSettings.COLOR_FRAISE),
    MYRTILLE(ProjectSettings.COLOR_MYRTILLE),
    PIECE_DOR(ProjectSettings.COLOR_OR);

    private ObstacleType(Color c){
        this.color = c;
    }

    private final Color color;

    public static ObstacleType randomType(){
        int rand = new Random().nextInt(4);
        switch (rand) {
            case 0:
                return ObstacleType.BOIS;
            case 1:
                return ObstacleType.FRAISE;
            case 2:
                return ObstacleType.MYRTILLE;
            case 3:
                return ObstacleType.PIECE_DOR;
            default:
                return ObstacleType.BOIS;
        }
    }

    //getter
    public Color getObstacleColor(){return color;}
}
