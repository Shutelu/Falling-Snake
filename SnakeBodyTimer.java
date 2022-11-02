public class SnakeBodyTimer implements Runnable{
    
    // private GameScene gameScene;
    private Snake snake;

    public SnakeBodyTimer(Snake snake){
        // this.gameScene = gameScene;
        this.snake = snake;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(500);
            snake.setCanKillBodyPart(true);
            System.out.println("fin can kill");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
