public class CannonLoadTimer implements Runnable{
    
    @Override
    public void run(){
        try {
            Thread.sleep(300);
            GameFrame.gameScene.cannon.setCanFire(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
