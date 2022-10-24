import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                // if(LEFT_BORDER_LIMIT < canon.getX())
                // canon.setLocation(canon.getX()-SPEED, canon.getY());
                // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
                // - ConstantVariable.CANNON_SPEED);
                GameManager.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
                break;
            case 'd':
                // GameManager.gameScene.cannon.setEntityPosX(GameManager.gameScene.cannon.getEntityPosX()
                // + ConstantVariable.CANNON_SPEED);
                GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
        }
        switch (e.getKeyCode()) {
            case 37:
                GameManager.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_SPEED);
                break;
            case 39:
                GameManager.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_SPEED);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameManager.gameScene.cannon.setEntityMoveX(0);

    }

}
