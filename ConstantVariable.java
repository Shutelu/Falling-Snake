import java.awt.Color;
// Class that will store all the constant variable
//settings or configurations later

public abstract class ConstantVariable{

    /***********Window***********/
    public static final int MAIN_WINDOW_WIDTH = 500;
    public static final int MAIN_WINDOW_HEIGHT = 700;
    public static final String MAIN_WINDOW_TITLE = "Falling Snakes";
    // public static final int MAIN_BORDER_LIMIT = 50;//a changer

    //real screen size for 500 - 700
    //topleft = 0,0
    //topright = 464,0
    //bottomleft = 0,640
    //bottomright = 464,640

    /***********Color***********/
    public static final Color COLOR_MAIN_WINDOW_BACKGROUND = Color.BLACK;
    public static final Color COLOR_PLATFORM = Color.GREEN;
    public static final Color COLOR_CANNON = Color.RED;
    public static final Color COLOR_SNAKE = Color.GREEN;
    public static final Color COLOR_PROJECTIL = Color.WHITE;
    public static final Color COLOR_BOIS = new Color(112,83,4);
    public static final Color COLOR_FRAISE = new Color(191,19,51);
    public static final Color COLOR_MYRTILLE = new Color(97, 19, 191);
    public static final Color COLOR_OR = new Color(219, 222, 29);

    /***********Cannon***********/
    public static final int CANNON_WIDTH = 20;
    public static final int CANNON_HEIGHT = 20;

    public static final int CANNON_POSITION_X = (MAIN_WINDOW_WIDTH - CANNON_WIDTH) / 2;
    public static final int CANNON_POSITION_Y = 610;

    public static final int CANNON_MOVESPEED_X = 1;//uniter de deplacement pour le moment
    public static final int CANNON_MOVESPEED_Y = 1;

    public static final int CANNON_BORDER_LIMIT_LEFT = 5;
    public static final int CANNON_BORDER_LIMIT_RIGHT = 455;

    /***********Projectil***********/
    public static final int PROJECTIL_WIDTH = 7;
    public static final int PROJECTIL_HEIGHT = 3;
    
    public static final int PROJECTIL_MOVESPEED_Y = 1;
    
    public static final int PROJECTIL_MAX = 10;//the maximum number of projectil you may store

    /***********Obstacle***********/
    public static final int OBSTACLE_WIDTH = 10;
    public static final int OBSTACLE_HEIGHT = 10;

    public static final int OBSTACLE_INITAIL_OBS_NOMBER = 15;

}