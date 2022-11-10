public class RepaintTimer implements Runnable {

    private GameScene gameScene;
    private Snake snake;
    private Cannon cannon;

    private final int PAUSE = 5;// temps attente entre 2 boucles 5ms
    public static int compteur = 0;
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

            compteur += 5;

            //cannon load timer
            if(cannon.getCanFire() == false){
                cannonCounter += 5;
                if(cannonCounter % 300 == 0){
                    cannon.setCanFire(true);
                    cannonCounter = 0;
                    System.out.println("peut tirer");
                }
            }

            //snake invincibility timer
            if(snake.getCanKillBodyPart() == false){
                for(Square s : snake.body){
                    s.setEntityColor(ConstantVariable.COLOR_SNAKE_INVINCIBLE);
                }
                snakeCounter += 4;
                if(snakeCounter % 2000 == 0){
                    snake.setCanKillBodyPart(true);
                    snakeCounter = 0;
                    System.out.println("fin invincibilité");
                }
            }


            GameFrame.gameScene.repaint();// call to paintComponent of GameScene

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There seems to be an error in with the sleep ...");
            }
        }
    }
}
