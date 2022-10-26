import javax.swing.JFrame;

//Game Management class

public class GameManager extends JFrame{
    
    public GameManager(){
        super("Failing Snake");
        
        //window settings
        this.setSize(ConstantVariable.MAIN_WINDOW_WIDTH, ConstantVariable.MAIN_WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);//put in center should be after size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        
        //game scene
        gameScene = new GameScene();
        this.setContentPane(gameScene);       
        this.setVisible(true);//must be last
    }

    public static GameScene gameScene;


}
