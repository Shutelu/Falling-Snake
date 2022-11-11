public class RepaintTimer implements Runnable {

    private GameScene gameScene;
    private Snake snake;
    private Cannon cannon;

    private final int PAUSE = 5;// temps attente entre 2 boucles 5ms
    private static int snakeMoveCounter = 0;
    private int snakeCounter;
    private int cannonCounter;

    public RepaintTimer(GameScene gameScene, Snake snake, Cannon cannon){
        this.gameScene = gameScene;
        this.snake = snake;
        this.cannon = cannon;
        this.snakeCounter = 0;
        this.cannonCounter = 0;
    }

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

    private void snakeMove(){
        if (snakeMoveCounter % 100 == 0) {
            snake.moveSnake();
        }
    }
    
    private void cannonLoadTimer(){
        if(cannon.getCanFire() == false){
            cannonCounter += 5;
            if(cannonCounter % 280 == 0){
                cannon.setCanFire(true);
                cannonCounter = 0;
            }
        }
    }
    
    private void snakeInvincibilityTimer(){
        if(snake.getCanKillBodyPart() == false){
            for(Square s : snake.getBody()){
                s.entity_color = ConstantVariable.COLOR_SNAKE_INVINCIBLE;
            }
            snakeCounter += 4;
            if(snakeCounter % 2000 == 0){
                snake.setCanKillBodyPart(true);
                snakeCounter = 0;
                System.out.println("fin invincibilité");
            }
        }
    }

    //getter
    public static int getSnakeMoveCounter(){return snakeMoveCounter;}





}
