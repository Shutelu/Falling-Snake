import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameScene extends JPanel{
    
    public GameScene(){
        super();
    }

    /**
     * called when we need to paint
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);//heritage
        Graphics g2 = (Graphics2D) g;//g2 plus performant

        //Draw Background
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, ConstantVariable.MAIN_WINDOW_WIDTH, ConstantVariable.MAIN_WINDOW_HEIGHT);

        //Draw edge
        g2.setColor(Color.GREEN);
        g2.fillRect(20, 650, 455, 5);
        System.out.println("drawline");
    }
}
