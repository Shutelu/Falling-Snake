import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//Game Management class

public class GameManager extends JFrame implements KeyListener{
    
    public GameManager(){
        super("Failing Snake");
        //window settings
        this.setSize(ConstantVariable.MAIN_WINDOW_WIDTH, ConstantVariable.MAIN_WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//put in center should be after size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.addKeyListener(this);
        
        //game scene
        gameScene = new GameScene();
        this.setContentPane(gameScene);

        //canon init and settings
        canon = new JLabel();
        canon.setBounds(((ConstantVariable.MAIN_WINDOW_WIDTH/2)-20), (ConstantVariable.MAIN_WINDOW_HEIGHT-60), 20, 20);;
        canon.setBackground(Color.RED);
        canon.setOpaque(true);
        
        //adding
        this.add(canon);
        this.setVisible(true);//must be last
    }

    private final int LEFT_BORDER_LIMIT = 0;
    private final int RIGHT_BORDER_LIMIT = 464;
    private final int SPEED = 5;
    private JLabel canon;
    public static GameScene gameScene;
    

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
