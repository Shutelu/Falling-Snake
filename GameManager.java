import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameManager extends JFrame implements KeyListener{
    
    public GameManager(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);//put in center should be after size
        this.setResizable(false);
        this.setLayout(null);
        this.addKeyListener(this);

        canon = new JLabel();
        canon.setBounds(((WIDTH/2)-20), (HEIGHT-60), 20, 20);;
        canon.setBackground(Color.RED);
        canon.setOpaque(true);

        this.add(canon);
        this.setVisible(true);
    }

    private final int WIDTH = 500;
    private final int HEIGHT = 700;
    private final int LEFT_BORDER_LIMIT = 0;
    private final int RIGHT_BORDER_LIMIT = 464;
    private final int SPEED = 5;
    private JLabel canon;
    

    @Override
    public void keyTyped(KeyEvent e){
        switch(e.getKeyChar()){
            case 'a':
                if(LEFT_BORDER_LIMIT < canon.getX())
                    canon.setLocation(canon.getX()-SPEED, canon.getY());
                break;
            case 'd':
                if(canon.getX() < RIGHT_BORDER_LIMIT )
                    canon.setLocation(canon.getX()+SPEED, canon.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 37:
                if(LEFT_BORDER_LIMIT < canon.getX())
                    canon.setLocation(canon.getX()-SPEED, canon.getY());
                break;
            case 39:
                if(canon.getX() < RIGHT_BORDER_LIMIT )
                    canon.setLocation(canon.getX()+SPEED, canon.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        //debug
       System.out.println(e.getKeyCode());
       System.out.println(canon.getX() + " " +canon.getY());
    }


}
