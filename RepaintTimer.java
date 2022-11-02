public class RepaintTimer implements Runnable {

    private final int PAUSE = 5;// temps attente entre 2 boucles 5ms
    public static int compteur = 0;
    // private boolean gameIsFinished;
    private GameScene gameScene;

    public RepaintTimer(GameScene gameScene){
        this.gameScene = gameScene;
    }

    @Override
    public void run() {
        while (gameScene.getGameIsFinished() == false) {
            compteur += 5;
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
