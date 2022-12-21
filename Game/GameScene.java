package Game;

import java.awt.Graphics;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Entities.Cannon;
import Game.Entities.Obstacle;
import Game.Entities.ObstacleType;
import Game.Entities.Projectil;
import Game.Entities.Snake;
/**
 * GameScene will contain the game settings
 */
public class GameScene extends JPanel {

    public GameScene(JFrame frame) {
        super();

        gameFrame = frame;
        gameIsFinished = false;
        win = false;

        cannon_init();
        snake_init();
        projectil_init();
        obstacle_init();

        // focus
        this.setFocusable(true);// set the focus
        this.requestFocusInWindow();// focus from this scene
        this.addKeyListener(new KeyboardListening(this));

        Thread repanting = new Thread(new RepaintTimer(this, snake, cannon));
        repanting.start();
    }

    private Obstacle[] obstacle_list;
    private Projectil[] projectil_list; // munitions

    private JFrame gameFrame;
    private Cannon cannon;
    private Snake snake;

    private int projectilCounter;

    private boolean gameIsFinished;
    private boolean win;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(ProjectSettings.COLOR_MAIN_WINDOW_BACKGROUND);

        draw_platform(g);
        draw_cannon(g);
        draw_snake(g);
        draw_projectil(g);
        draw_obstacle(g);

        collisionProjectilObstacle();
        collisionProjectilSnake();
        collisionSnakeCannon();
        collisionObstacleSnake();

        checkEndGame();

    }

    /*********** Initialisation ***********/

    private void cannon_init() {
        cannon = new Cannon();
    }

    private void snake_init() {
        snake = new Snake(10, this);
    }

    private void projectil_init() {
        projectilCounter = 0;
        projectil_list = new Projectil[ProjectSettings.PROJECTIL_MAX_NUMBER];

        for (int i = 0; i < projectil_list.length; i++) {
            projectil_list[i] = new Projectil();
        }
    }

    private void obstacle_init() {
        obstacle_list = new Obstacle[ProjectSettings.OBSTACLE_INITAIL_OBSTACLE_NOMBER];

        for (int i = 0; i < obstacle_list.length; i++) {
            obstacle_list[i] = checkObstaclePosition(obstacle_list, new Obstacle(ObstacleType.randomType()));
            // obstacle_list[i] = checkObstaclePosition(obstacle_list, new Obstacle(ObstacleType.MYRTILLE));//test
        }
    }

    /*********** Draw ***********/

    private void draw_platform(Graphics g){
        g.setColor(ProjectSettings.COLOR_PLATFORM);
        g.fillRect(20, 640, 444, 4);
    }

    private void draw_cannon(Graphics g) {
        cannon.draw(g);
    }

    private void draw_snake(Graphics g) {
        snake.drawSnake(g);
    }

    private void draw_projectil(Graphics g) {
        for (int i = 0; i < projectil_list.length; i++) {
            if (projectil_list[i] != null) {
                projectil_list[i].draw(g);
            }
        }
    }

    private void draw_obstacle(Graphics g) {
        for (int i = 0; i < obstacle_list.length; i++) {
            if (obstacle_list[i] != null) {
                obstacle_list[i].draw(g);
            }
        }
    }

    /*********** Methodes ***********/

    private Obstacle checkObstaclePosition(Obstacle[] list, Obstacle obstacle) {
        Obstacle temp;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            else if (list[i].getEntityPosX()== obstacle.getEntityPosX()
                    && list[i].getEntityPosY() == obstacle.getEntityPosY()) {
                temp = new Obstacle(obstacle.getType());
                return checkObstaclePosition(list, temp);
            }
        }
        return obstacle;
    }

    private void collisionProjectilObstacle() {
        for (int i = 0; i < projectil_list.length; i++) {
            for (int j = 0; j < obstacle_list.length; j++) {
                if (obstacle_list[j] != null && projectil_list[i] != null) {
                    if (projectil_list[i].collisionWithObstacle(obstacle_list[j])) {
                        obstacle_list[j] = null;
                        projectil_list[i].setEntityPosX(-10);
                        projectil_list[i].setEntityPosY(-10);
                    }
                }
            }
        }
    }

    private void collisionObstacleSnake() {
        if(snake.getBody().size() <= 0)return;
        for (int j = 0; j < obstacle_list.length; j++) {
            if (obstacle_list[j] != null && snake.getBody().get(snake.getSnakeLength() - 1) != null) {
                if (obstacle_list[j].collisionWithSnake(snake.getBody().get(snake.getSnakeLength() - 1))) {
                    snake.collisionWithObstacle(obstacle_list[j]);
                    obstacle_list[j] = null;
                }

            }
        }

    }

    private void collisionProjectilSnake() {
        for (int i = 0; i < projectil_list.length; i++) {
            if (projectil_list[i] != null) {
                snake.collisionWithProjectil(projectil_list[i]);
            }
        }
    }

    private void collisionSnakeCannon() {
        snake.collisionWithCannon(cannon);
    }

    private void checkEndGame(){
        if (gameIsFinished) {
            JDialog dialog = new JDialog(gameFrame);
            JLabel label = new JLabel();

            if (win) {
                dialog.setTitle("Bien jouer !");
                label.setText("Vous avez gagné !");
            } else if (!win) {
                dialog.setTitle("Oh non !");
                label.setText("Vous avez perdu !");
            }

            dialog.add(label);
            dialog.setSize(200, 200);
            dialog.setLocationRelativeTo(gameFrame);
            dialog.setVisible(true);
        }
    }

    // getter
    public boolean getGameIsFinished() {return gameIsFinished;}
    public JFrame getGameFrame(){return gameFrame;}
    public Cannon getCannon(){return cannon;}
    public int getProjectilCounter(){return projectilCounter;}
    public Obstacle[] getObstacleList(){return obstacle_list;}
    public Projectil[] getProjectilList(){return projectil_list;}

    // setter
    public void setGameIsFinished(boolean finished) {gameIsFinished = finished;}
    public void setWin(boolean win) {this.win = win;}
    public void setProjectilCounter(int i){this.projectilCounter = i;}

}
