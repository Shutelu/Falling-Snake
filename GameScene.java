import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

//GameScene will contain the game settings

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
        
        //instanciation
        projectilCompter = 0;
        cannon = new Cannon();
        // projectil = new Projectil();
        projectilList = new Projectil[ConstantVariable.PROJECTIL_MAX];
        for(int i = 0; i<projectilList.length; i++){
            projectilList[i] = new Projectil();
        }

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
    // public Projectil projectil;
    public Projectil[] projectilList; //munitions

    //Create snake
    public Snake snake;
    public int projectilCompter;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        //background
        setBackground(ConstantVariable.COLOR_MAIN_WINDOW_BACKGROUND);

        //Draw platform
        g2.setColor(ConstantVariable.COLOR_PLATFORM);
        g2.fillRect(20, 640, 444, 4);
        
        // // g2.fillRect(cannon.getEntityPosX(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());
        // g2.fillRect(cannon.move(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());
        cannon.draw(g2);

        //draw projectils
        for(int i = 0; i< projectilList.length; i++){
            projectilList[i].draw(g2);
        }
        // projectil.draw(g2);


        //Draw snake
        snake.drawSnake(g2);
    }
}
