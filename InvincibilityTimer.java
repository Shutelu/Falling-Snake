public class InvincibilityTimer implements Runnable{


    private Snake snake;

    public InvincibilityTimer(Snake snake){
        // this.gameScene = gameScene;
        this.snake = snake;
    }




    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            snake.setCanKillBodyPart(true);
            System.out.println("INVINSIBLE !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
