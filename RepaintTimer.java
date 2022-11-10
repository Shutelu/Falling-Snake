public class RepaintTimer implements Runnable {

    private GameScene gameScene;
    private Snake snake;

    private final int PAUSE = 5;// temps attente entre 2 boucles 5ms
    public static int compteur = 0;
    private int snakeCounter;

    public RepaintTimer(GameScene gameScene, Snake snake){
        this.gameScene = gameScene;
        this.snake = snake;
        this.snakeCounter = 0;
    }

    @Override
    public void run() {
        while (gameScene.getGameIsFinished() == false) {

            compteur += 5;

            //snake invincibility
            if(snake.getCanKillBodyPart() == false){
                for(Square s : snake.body){
                    s.setEntityColor(ConstantVariable.COLOR_SNAKE_INVINCIBLE);
                }
                snakeCounter += 4;
                if(snakeCounter % 1000 == 0){
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
