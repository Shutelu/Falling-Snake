import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                GameFrame.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_MOVESPEED_X);
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                GameFrame.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_MOVESPEED_X);
                break;

            case KeyEvent.VK_SPACE:
                if(GameFrame.gameScene.cannon.canFire == true){
                    Projectil[] projectils_list = GameFrame.gameScene.projectil_list;
                    int compter = GameFrame.gameScene.projectilCompter;

                    projectils_list[compter].setEntityPosX(GameFrame.gameScene.cannon.getEntityPosX() + ConstantVariable.CANNON_WIDTH/2 - 1);
                    projectils_list[compter].setEntityPosY(ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT);

                    projectils_list[compter].entityIsAlive = true;
                    GameFrame.gameScene.cannon.canFire = false;

                    new Thread(new CannonLoadTimer()).start();;//reload
                    
                    GameFrame.gameScene.projectilCompter = (compter + 1) % ConstantVariable.PROJECTIL_MAX_NUMBER;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameFrame.gameScene.cannon.setEntityMoveX(0);
        GameFrame.gameScene.cannon.setEntityMoveY(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing
    }

}
