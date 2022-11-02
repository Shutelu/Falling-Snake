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
            case KeyEvent.VK_LEFT:
                GameFrame.gameScene.cannon.setEntityMoveX(-ConstantVariable.CANNON_MOVESPEED_X);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                GameFrame.gameScene.cannon.setEntityMoveX(ConstantVariable.CANNON_MOVESPEED_X);
                break;
            
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(GameFrame.gameScene.cannon.canFire == true){
                int compter = GameFrame.gameScene.projectilCompter;
                GameFrame.gameScene.projectil_list[compter] = new Projectil();
                GameFrame.gameScene.projectil_list[compter].setEntityPosX(GameFrame.gameScene.cannon.getEntityPosX() + ConstantVariable.CANNON_WIDTH/2 - 1);
                GameFrame.gameScene.projectil_list[compter].setEntityPosY(ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT);
                GameFrame.gameScene.projectil_list[compter].entityIsAlive = true;
                GameFrame.gameScene.cannon.canFire = false;
                new Thread(new CannonLoadTimer()).start();;//reload
                GameFrame.gameScene.projectilCompter = (GameFrame.gameScene.projectilCompter + 1) % ConstantVariable.PROJECTIL_MAX;
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
