public class RepaintTimer implements Runnable {

    private final int PAUSE = 5;// temps attente entre 2 boucles 5ms
    public static int compteur = 0;

    @Override
    public void run() {
        while (true) {
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
