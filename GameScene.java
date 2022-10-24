import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
        cannon = new Cannon();

        this.setFocusable(true);//set the focus
        this.requestFocusInWindow();//focus from this scene
        this.addKeyListener(new KeyboardListening());

        //infini repaint
        Thread infinitePanting = new Thread(new Chrono());
        infinitePanting.start();
    }

    public Cannon cannon;

    /**
     * called when we need to paint
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        //Draw Background //a changer 
        g2.setColor(Color.BLACK); //utiliser un setBackground
        g2.fillRect(0, 0, ConstantVariable.MAIN_WINDOW_WIDTH, ConstantVariable.MAIN_WINDOW_HEIGHT);

        //Draw edge
        g2.setColor(Color.GREEN);
        g2.fillRect(20, 650, 455, 5);
        
        //Draw canon
        g2.setColor(cannon.getColor());
        // g2.fillRect(cannon.getEntityPosX(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());
        g2.fillRect(cannon.move(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());

    }
}
