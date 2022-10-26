import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
        cannon = new Cannon();
        projectil = new Projectil();

        this.setFocusable(true);//set the focus
        this.requestFocusInWindow();//focus from this scene
        this.addKeyListener(new KeyboardListening());

        //infini repaint
        Thread infiniteRepanting = new Thread(new Chrono());
        infiniteRepanting.start();
    }

    public Cannon cannon;
    public Projectil projectil;

    /**
     * called when we need to paint
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        //background
        setBackground(ConstantVariable.COLOR_MAIN_WINDOW_BACKGROUND);

        //Draw platform
        g2.setColor(ConstantVariable.COLOR_PLATFORM);
        g2.fillRect(20, 640, 444, 4);
        
        //Draw canon
        // g2.setColor(cannon.getColor());
        // // g2.fillRect(cannon.getEntityPosX(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());
        // g2.fillRect(cannon.move(), cannon.getEntityPosY(), cannon.getEntityWidth(), cannon.getEntityHeight());
        cannon.draw(g2);
        projectil.draw(g2);

    }
}
