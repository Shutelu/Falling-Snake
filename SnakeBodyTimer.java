public class SnakeBodyTimer implements Runnable{
    
    // private GameScene gameScene;
    private Snake snake;
    private int duration;
    private boolean invincible;

    public SnakeBodyTimer(Snake snake,int duration, boolean invincible){
        // this.gameScene = gameScene;
        this.snake = snake;
        this.duration = duration;
        this.invincible = invincible;

    }


    @Override
    public void run() {
        synchronized(snake){
            if(!invincible){
                try {
                    Thread.sleep(duration);
                    snake.setCanKillBodyPart(true);
                    System.out.println("fin can kill");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if(invincible){
                try {
                    // for(Square s : this.snake.body){
                    //     s.setEntityColor(ConstantVariable.COLOR_SNAKE_INVINCIBLE);
                    // }
                    Thread.sleep(duration);
                    snake.setCanKillBodyPart(true);
                    // for(Square s : this.snake.body){
                    //     s.setEntityColor(ConstantVariable.COLOR_SNAKE);
                    // }
                    System.out.println("fin invincibility");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
