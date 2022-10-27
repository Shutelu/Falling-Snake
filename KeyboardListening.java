import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        //debug
        System.out.println(
            "posX : " + GameFrame.gameScene.cannon.getEntityPosX() +
            " posY : " + GameFrame.gameScene.cannon.getEntityPosY() + 
            " keyChar : " + e.getKeyChar() + 
            " keyCode : " + e.getKeyCode()
        );
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                // if(LEFT_BORDER_LIMIT < canon.getX())
                // canon.setLocation(canon.getX()-SPEED, canon.getY());
                // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
                // - ConstantVariable.CANNON_SPEED);
                //GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() + 10);
                // GameManager.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
                GameFrame.gameScene.cannon.setEntityPosX(GameFrame.gameScene.cannon.getEntityPosX() - 1);
                break;
            case 'd':
                // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
                // + ConstantVariable.CANNON_SPEED);
                //GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() - 10);
                GameFrame.gameScene.cannon.setEntityPosX(GameFrame.gameScene.cannon.getEntityPosX() + 1);
                // GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
            case 'w':
            GameFrame.gameScene.cannon.setEntityPosY(GameFrame.gameScene.cannon.getEntityPosY() - 1);
                // GameManager.gameScene.cannon.setEntityMoveY(-ConstantVariable.CANNON_SPEED_Y);
                break;
            case 's':
                // GameManager.gameScene.cannon.setEntityMoveY(ConstantVariable.CANNON_SPEED_Y);
                GameFrame.gameScene.cannon.setEntityPosY(GameFrame.gameScene.cannon.getEntityPosY() + 1);
        }
        switch (e.getKeyCode()) {
            case 37:
                GameFrame.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
                break;
            case 39:
                GameFrame.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
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

    }

}
