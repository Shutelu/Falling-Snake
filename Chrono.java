public class Chrono implements Runnable{
    
    private final int PAUSE = 5;//temps attente entre 2 boucles 5ms
    public static int compteTours = 0;//plus tard

    @Override
    public void run(){
        while(true){
            GameFrame.gameScene.repaint();//call to paintComponent of GameScene
            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There seems to be an error in with the sleep ...");
            }
        }
    }
}
