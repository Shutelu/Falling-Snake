import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        // switch (e.getKeyChar()) {
        //     // case 'a':
        //         // if(LEFT_BORDER_LIMIT < canon.getX())
        //         // canon.setLocation(canon.getX()-SPEED, canon.getY());
        //         // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
        //         // - ConstantVariable.CANNON_SPEED);
        //         //GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() + 10);
        //         // GameManager.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
        //         // break;
        //     // case 'd':
        //         // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
        //         // + ConstantVariable.CANNON_SPEED);
        //         //GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() - 10);
        //         // GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
        //         // break;
        //     // case 'w':
        //     //     // GameManager.gameScene.cannon.setEntityMoveY(-ConstantVariable.CANNON_SPEED_Y);
        //     //     break;
        //     // case 's':
        //     //     // GameManager.gameScene.cannon.setEntityMoveY(ConstantVariable.CANNON_SPEED_Y);
        //     //     break;
        // }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                GameFrame.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED_X);
                break;
            case KeyEvent.VK_D:
                GameFrame.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED_X);
                break;
            case KeyEvent.VK_LEFT:
                GameFrame.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED_X);
                break;
            case KeyEvent.VK_RIGHT:
                GameFrame.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED_X);
                break;
            case KeyEvent.VK_SPACE:
                if(GameFrame.gameScene.projectil.getCanonFire() == false){
                    GameFrame.gameScene.projectil.setEntityPosY(ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT);
                    GameFrame.gameScene.projectil.setEntityPosX(GameFrame.gameScene.cannon.getEntityPosX() + ConstantVariable.PROJECTIL_WIDTH/2 - 1);
                    GameFrame.gameScene.projectil.setCanonFire(true);
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameFrame.gameScene.cannon.setEntityMoveX(0);
        GameFrame.gameScene.cannon.setEntityMoveY(0);
        //debug
        System.out.println(
            "posX : " + GameFrame.gameScene.cannon.getEntityPosX() +
            " posY : " + GameFrame.gameScene.cannon.getEntityPosY() + 
            " keyChar : " + e.getKeyChar() + 
            " keyCode : " + e.getKeyCode()
        );
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing
    }

}
