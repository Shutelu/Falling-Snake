import java.awt.Color;

public enum ObstacleType {
    BOIS(ConstantVariable.COLOR_BOIS),
    FRAISE(ConstantVariable.COLOR_FRAISE),
    MYRTILLE(ConstantVariable.COLOR_MYRTILLE),
    PIECE_DOR(ConstantVariable.COLOR_OR);

    private ObstacleType(Color c){this.color = c;}

    private final Color color;

    public Color getObstacleColor(){return color;}
}
