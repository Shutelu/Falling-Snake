import java.awt.Color;
/**
 *  Class that contains all the game configurations/settings as constant variable 
 */
public abstract class ProjectSettings{

    /*================================================================================*/
    /*==================================== WINDOW ====================================*/
    /*=== Screen size for 500-700 : TL(0,0) | TR(464,0) | BL(0,640) | BR(464,640) ====*/
    /*================================================================================*/
    public static final int MAIN_WINDOW_WIDTH = 500;
    public static final int MAIN_WINDOW_HEIGHT = 700;
    public static final String MAIN_WINDOW_TITLE = "Falling Snakes";

    /*================================================================================*/
    /*==================================== COLOR =====================================*/
    /*================================================================================*/
    public static final Color COLOR_MAIN_WINDOW_BACKGROUND = Color.BLACK;
    public static final Color COLOR_PLATFORM = Color.GREEN;
    public static final Color COLOR_CANNON = Color.RED;
    public static final Color COLOR_PROJECTIL = Color.WHITE;
    public static final Color COLOR_SNAKE = Color.GREEN;
    public static final Color COLOR_SNAKE_INVINCIBLE = new Color(245, 233, 66);
    public static final Color COLOR_BOIS = new Color(112,83,4);
    public static final Color COLOR_FRAISE = new Color(191,19,51);
    public static final Color COLOR_MYRTILLE = new Color(97, 19, 191);
    public static final Color COLOR_OR = new Color(219, 222, 29);

    /*================================================================================*/
    /*==================================== CANNON ====================================*/
    /*================================================================================*/
    public static final int CANNON_WIDTH = 20;
    public static final int CANNON_HEIGHT = 20;
    public static final int CANNON_POSITION_X = (MAIN_WINDOW_WIDTH - CANNON_WIDTH) / 2;
    public static final int CANNON_POSITION_Y = 610;
    public static final int CANNON_MOVESPEED_X = 1;//move unit
    public static final int CANNON_MOVESPEED_Y = 1;
    public static final int CANNON_BORDER_LIMIT_LEFT = 5;
    public static final int CANNON_BORDER_LIMIT_RIGHT = 455;

    /*================================================================================*/
    /*=================================== SNAKEPART ==================================*/
    /*================================================================================*/
    public static final int SNAKEPART_WIDTH = 20;
    public static final int SNAKEPART_HEIGHT = 20;

    /*================================================================================*/
    /*=================================== PROJECTIL ==================================*/
    /*================================================================================*/
    public static final int PROJECTIL_WIDTH = 7;
    public static final int PROJECTIL_HEIGHT = 3;
    public static final int PROJECTIL_MOVESPEED_Y = 1;
    public static final int PROJECTIL_MAX_NUMBER = 10;//the maximum number of projectil you may store

    /*================================================================================*/
    /*=================================== OBSTACLE ===================================*/
    /*================================================================================*/
    public static final int OBSTACLE_WIDTH = 15;
    public static final int OBSTACLE_HEIGHT = 15;
    public static final int OBSTACLE_INITAIL_OBSTACLE_NOMBER = 15;
    public static final int OBSTACLE_BLOCS = 20;

    /*================================================================================*/
    /*================================== TIMER(ms) ===================================*/
    /*================================================================================*/
    public static final int TIMER_CANKILL = 500;
    public static final int TIMER_INVINCIBLE = 2000;

}