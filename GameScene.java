import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

//GameScene will contain the game settings

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
        
        cannon_init();
        projectil_init();
        obstacle_init();

        snake = new Snake(4);

        //focus
        this.setFocusable(true);//set the focus
        this.requestFocusInWindow();//focus from this scene
        this.addKeyListener(new KeyboardListening());

        //infinite repaint
        Thread infiniteRepanting = new Thread(new RepaintTimer());
        infiniteRepanting.start();
    }

    public Cannon cannon;
    public Snake snake;
    public Projectil[] projectil_list; //munitions
    public int projectilCompter;
    public Obstacle[] obstacle_list;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        //background
        setBackground(ConstantVariable.COLOR_MAIN_WINDOW_BACKGROUND);

        //Draw platform
        g2.setColor(ConstantVariable.COLOR_PLATFORM);
        g2.fillRect(20, 640, 444, 4);
        
        
        draw_cannon(g2);
        draw_projectil(g2);
        draw_obstacle(g2);

        //Draw snake
        snake.drawSnake(g2);
    }

    private void cannon_init(){
        cannon = new Cannon();
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
                    //bois
                    obstacle_list[i] = new Obstacle(ObstacleType.BOIS);
                    break;
                case 1:
                    //fraise
                    obstacle_list[i] = new Obstacle(ObstacleType.FRAISE);
                    break;
                case 2:
                    //myrtille
                    obstacle_list[i] = new Obstacle(ObstacleType.MYRTILLE);
                    break;
                case 3:
                    //or
                    obstacle_list[i] = new Obstacle(ObstacleType.PIECE_DOR);
                    break;
            }
        }
    }

    private void draw_cannon(Graphics g){
        cannon.draw(g);
    }

    private void draw_projectil(Graphics g){
        for(int i = 0; i< projectil_list.length; i++){
            projectil_list[i].draw(g);
        }
    }

    private void draw_obstacle(Graphics g){
        for(int i = 0; i< obstacle_list.length; i++){
            obstacle_list[i].draw(g);
        }
    }


}
