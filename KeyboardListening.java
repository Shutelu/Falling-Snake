import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(
            "posX : " + GameManager.gameScene.cannon.getEntityPosX() +
            " posY : " + GameManager.gameScene.cannon.getEntityPosY() + 
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
                GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() - 1);
                break;
            case 'd':
                // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
                // + ConstantVariable.CANNON_SPEED);
                //GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() - 10);
                GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() + 1);
                // GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
            case 'w':
            GameManager.gameScene.cannon.setEntityPosY(GameManager.gameScene.cannon.getEntityPosY() - 1);
                // GameManager.gameScene.cannon.setEntityMoveY(-ConstantVariable.CANNON_SPEED_Y);
                break;
            case 's':
                // GameManager.gameScene.cannon.setEntityMoveY(ConstantVariable.CANNON_SPEED_Y);
                GameManager.gameScene.cannon.setEntityPosY(GameManager.gameScene.cannon.getEntityPosY() + 1);
        }
        switch (e.getKeyCode()) {
            case 37:
                GameManager.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
                break;
            case 39:
                GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(GameManager.gameScene.projectil.getCanonFire() == false){
                GameManager.gameScene.projectil.setEntityPosY(ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT);
                GameManager.gameScene.projectil.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX() + ConstantVariable.PROJECTIL_WIDTH/2 - 1);
                GameManager.gameScene.projectil.setCanonFire(true);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameManager.gameScene.cannon.setEntityMoveX(0);
        GameManager.gameScene.cannon.setEntityMoveY(0);

    }

}
