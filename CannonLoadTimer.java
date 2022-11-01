public class CannonLoadTimer implements Runnable{
    
    @Override
    public void run(){
        try {
            Thread.sleep(300);
            GameFrame.gameScene.cannon.canFire = true;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
