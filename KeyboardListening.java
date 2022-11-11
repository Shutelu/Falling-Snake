import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListening implements KeyListener {

    public KeyboardListening(GameScene gameScene){
        this.gameScene = gameScene;
    }

    private GameScene gameScene;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                gameScene.getCannon().entity_move_x = -ConstantVariable.CANNON_MOVESPEED_X;
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                gameScene.getCannon().entity_move_x = ConstantVariable.CANNON_MOVESPEED_X;
                break;

            case KeyEvent.VK_SPACE:
                if(gameScene.getCannon().getCanFire() == true){
                    Projectil[] projectils_list = gameScene.getProjectilList();
                    int compter = gameScene.getProjectilCounter();

                    gameScene.getCannon().setCanFire(false);
                    projectils_list[compter].entity_position_x = gameScene.getCannon().entity_position_x + ConstantVariable.CANNON_WIDTH/2 - 1;
                    projectils_list[compter].entity_position_y = ConstantVariable.CANNON_POSITION_Y - ConstantVariable.PROJECTIL_HEIGHT;
                    projectils_list[compter].entityIsAlive = true;
                    gameScene.setProjectilCounter((compter + 1) % ConstantVariable.PROJECTIL_MAX_NUMBER);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameScene.getCannon().entity_move_x = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing
    }

}
