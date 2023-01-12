package Game;

import Game.Entities.Enemy.Snake;
import Game.Entities.Enemy.SnakePart;
import Game.Entities.Player.Cannon;

/**
 * Global timer that all object on the scene can use
 */
public class RepaintTimer implements Runnable {

    /**
     * Constructor of the RepainTimer
     * @param gameScene the game scene
     * @param snake the snake
     * @param cannon the cannon
     */
    public RepaintTimer(GameScene gameScene, Snake snake, Cannon cannon){
        this.gameScene = gameScene;
        this.snake = snake;
        this.cannon = cannon;
        this.snakeCounter = 0;
        this.cannonCounter = 0;
    }

    private final int PAUSE = 5;// timer between two loop
    private static int snakeMoveCounter = 0;
    private GameScene gameScene;
    private Snake snake;
    private Cannon cannon;
    private int snakeCounter;
    private int cannonCounter;

    @Override
    public void run() {
        while (gameScene.getGameIsFinished() == false) {
            snakeMoveCounter += 5;

            // snakeMove();//no flash
            cannonLoadTimer();
            snakeInvincibilityTimer();

            gameScene.repaint();// call to paintComponent of GameScene

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There seems to be an error in with the sleep ...");
            }
        }
    }
    
    /**
     * Timer between every shoot so the player can't do rafal
     */
    private void cannonLoadTimer(){
        if(cannon.getCanFire() == false){
            cannonCounter += 5;
            if(cannonCounter % ProjectSettings.CANNON_CANFIRE_DURATION == 0){
                cannon.setCanFire(true);
                cannonCounter = 0;
            }
        }
    }
    
    /**
     * Timer for the invincibility duration of the snake
     */
    private void snakeInvincibilityTimer(){
        if(snake.getCanKillBodyPart() == false){
            for(SnakePart s : snake.getBody()){
                s.setEntityColor(ProjectSettings.COLOR_SNAKE_INVINCIBLE);
            }
            snakeCounter += 4;
            if(snakeCounter % ProjectSettings.SNAKE_INVINCIBLE_DURATION == 0){
                snake.setCanKillBodyPart(true);
                snakeCounter = 0;
                System.out.println("fin invincibilité");
            }
        }
    }

    /**
     * Get the move counter of the snake
     * @return the snake move counter
     */
    public static int getSnakeMoveCounter(){return snakeMoveCounter;}





}
