import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

//GameScene will contain the game settings

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
        
        gameIsFinished = false;
        // canKillBodyPart = true;
        cannon_init();
        snake_init();
        projectil_init();
        obstacle_init();
        
        //focus
        this.setFocusable(true);//set the focus
        this.requestFocusInWindow();//focus from this scene
        this.addKeyListener(new KeyboardListening());

        Thread infiniteRepanting = new Thread(new RepaintTimer(this));
        infiniteRepanting.start();
    }

    private boolean gameIsFinished;
    // private boolean canKillBodyPart;
    public Cannon cannon;
    public Snake snake;
    public Projectil[] projectil_list; //munitions
    public int projectilCompter;
    public Obstacle[] obstacle_list;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        this.setBackground(ConstantVariable.COLOR_MAIN_WINDOW_BACKGROUND);

        //Draw platform
        g2.setColor(ConstantVariable.COLOR_PLATFORM);
        g2.fillRect(20, 640, 444, 4);
        
        draw_cannon(g2);
        draw_snake(g2);
        draw_projectil(g2);
        draw_obstacle(g2);

        collisionProjectilObstacle();
        collisionProjectilSnake();

        if(gameIsFinished){
            System.out.println("Vous avez gagné !");
        }

    }

    /***********Initialisation***********/

    private void cannon_init(){
        cannon = new Cannon();
    }

    private void snake_init(){
        snake = new Snake(10);
    }

    private void projectil_init(){
        projectilCompter = 0;
        projectil_list = new Projectil[ConstantVariable.PROJECTIL_MAX];
        for(int i = 0; i<projectil_list.length; i++){
            projectil_list[i] = new Projectil();
        }
    }

    private void obstacle_init(){
        int rand;
        obstacle_list = new Obstacle[ConstantVariable.OBSTACLE_INITAIL_OBS_NOMBER];
        for(int i=0; i< obstacle_list.length; i++){
            rand = new Random().nextInt(4);
            switch(rand){
                case 0:
                    obstacle_list[i] = new Obstacle(ObstacleType.BOIS);
                    break;
                case 1:
                    obstacle_list[i] = new Obstacle(ObstacleType.FRAISE);
                    break;
                case 2:
                    obstacle_list[i] = new Obstacle(ObstacleType.MYRTILLE);
                    break;
                case 3:
                    obstacle_list[i] = new Obstacle(ObstacleType.PIECE_DOR);
                    break;
            }
        }
    }

    /***********Draw***********/

    private void draw_cannon(Graphics g){
        cannon.draw(g);
    }

    private void draw_snake(Graphics g){
        snake.drawSnake(g);
    }

    private void draw_projectil(Graphics g){
        for(int i = 0; i< projectil_list.length; i++){
            if(projectil_list[i] != null){
                projectil_list[i].draw(g);
            }
        }
    }

    private void draw_obstacle(Graphics g){
        for(int i = 0; i< obstacle_list.length; i++){
            if(obstacle_list[i] !=null){
                obstacle_list[i].draw(g);
            }
        }
    }

    /***********Methodes***********/

    private void collisionProjectilObstacle(){
        for(int i = 0; i< projectil_list.length; i++){
            for(int j = 0; j<obstacle_list.length; j++){
                if(obstacle_list[j] != null && projectil_list[i] != null){
                    if(projectil_list[i].collisionWithObstacle(obstacle_list[j])){
                        obstacle_list[j] = null;
                        projectil_list[i].entity_position_x = -10;
                        projectil_list[i].entity_position_y = -10;
                        // projectil_list[i] = null;
                        System.out.println("toucher");
                    }
                }
            }
        }
    }

    public void collisionProjectilSnake(){
        // if(canKillBodyPart){
            for(int i=0; i<projectil_list.length; i++){
                if(projectil_list[i] != null){
                    snake.collisionWithProjectil(projectil_list[i]);
                }
            }
        // }
    }


    //getter
    public boolean getGameIsFinished(){return gameIsFinished;}

    // public boolean getCanKillBodyPart(){return canKillBodyPart;}

    //setter
    public void setGameIsFinished(boolean finished){
        gameIsFinished = finished;
    }

    // public void setCanKillBodyPart(boolean can){
    //     canKillBodyPart = can;
    // }
}
