import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JFrame implements KeyListener, ActionListener {

    public static int mainWindowSizeWidth = 500;
    public static int mainWindowSizeHeight = 500;


    Snake snake;

    public Screen(){

        Timer timer = new Timer(300, this);
        timer.start();

        //mainWindow configuration
        this.setTitle("Falling Snake");
        this.setSize(mainWindowSizeWidth, mainWindowSizeHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        snake = new Snake( 4);
        this.add(snake);


    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

    }
}
