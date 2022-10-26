import java.awt.Color;
// Class that will store all the constant variable
//setting or configuration later

public abstract class ConstantVariable{

    /***********Window***********/

    public static final int MAIN_WINDOW_WIDTH = 500;
    public static final int MAIN_WINDOW_HEIGHT = 700;
    public static final int MAIN_WINDOW_REAL_WIDTH = 464;
    public static final int MAIN_WINDOW_REAL_HEIGHT = 640;
    public static final int MAIN_BORDER_LIMIT = 50;//a changer

    //real screen size for 500 - 700
    //topleft = 0,0
    //topright = 464,0
    //bottomleft = 0,640
    //bottomright = 464,640

    /***********Cannon***********/
    public static final int CANNON_WIDTH = 20;
    public static final int CANNON_HEIGHT = 20;

    public static final int CANNON_INITIAl_POSITION_X = (MAIN_WINDOW_WIDTH - CANNON_WIDTH) / 2;
    public static final int CANNON_POSITION_Y = 610;

    public static final int CANNON_SPEED = 1;//uniter de deplacement pour le moment
    public static final int CANNON_SPEED_Y = 1;
    public static final Color CANNON_COLOR = Color.RED;//?

    public static final int CANNON_BORDER_LIMIT_LEFT = 10;
    public static final int CANNON_BORDER_LIMIT_RIGHT = 450;

    /***********Projectil***********/
    public static final int PROJECTIL_WIDTH = 5;
    public static final int PROJECTIL_HEIGHT = 15;

    public static final int PROJECTIL_SPEED_Y = 2;

}