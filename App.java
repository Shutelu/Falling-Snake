import javax.swing.JFrame;

public class App{

    public static void main(String[] args){
        
        //Variables creation 
        JFrame mainWindow = new JFrame();
        int mainWindowSizeX = 400;
        int mainWindowSizeY = 400;
        int mainWindowLocationX = 600;
        int mainWindowLocationY = 200;

        //mainWindow configuration
        mainWindow.setTitle("Failling Snake");
        mainWindow.setSize(mainWindowSizeX, mainWindowSizeY);
        mainWindow.setLocation(mainWindowLocationX, mainWindowLocationY);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);

        //Main codes
    }

}