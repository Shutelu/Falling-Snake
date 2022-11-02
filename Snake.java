import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JPanel {

    public int length;
    public ArrayList<Square> body;
    public Graphics graphics;
    public String direction;

    public Snake(int length) {

        body = new ArrayList<Square>();
        this.length = length;
        this.direction = "right";

        createSnake();

    }

    public void createSnake() {
        for (int i = 0; i < this.length; i++) {
            body.add(new Square(((i) * 20), 0));
        }
    }

    // FAIT AVANCER LE SNAKE DUNE CASE SUR L'AXE DES X
    public void moveSnake() {

        ArrayList<Square> newbody = new ArrayList<Square>();
        Square first = this.body.get(this.length - 1);
        Square head = new Square(first.getEntityPosX(), first.getEntityPosY());

        switch (this.direction) {
            case "right" -> head.setEntityPosX(head.getEntityPosX() + 20);
            case "left" -> head.setEntityPosX(head.getEntityPosX() - 20);
            case "up" -> head.setEntityPosY(head.getEntityPosY() - 20);
            case "down" -> head.setEntityPosY(head.getEntityPosY() + 20);
        }

        for (int i = 1; i < this.body.size(); i++) {
            Square previous = this.body.get(i);
            Square newRec = new Square(previous.getEntityPosX(), previous.getEntityPosY());
            newbody.add(newRec);
        }

        newbody.add(head);
        this.body = newbody;
        checkWindowLimitCollision();
    }

    public void checkWindowLimitCollision() {
        if (this.body.get(this.length - 1).getEntityPosX() == ConstantVariable.MAIN_WINDOW_WIDTH - 40
                || this.body.get(this.length - 1).getEntityPosX() == 0) {

            switch (this.direction) {
                case "right":
                    this.direction = "down";
                    moveSnake();
                    this.direction = "left";
                    moveSnake();
                    break;
                case "left":
                    this.direction = "down";
                    moveSnake();
                    this.direction = "right";
                    moveSnake();
                    break;
            }
        }
    }

    public void drawSnake(Graphics g) {

        if(isKilled() == false){
            // Faire bouger le snake tout les 100ms
            if (RepaintTimer.compteur % 100 == 0) {
                moveSnake();
            }
    
            for (int j = 0; j < this.body.size(); j++) {
                g.setColor(this.body.get(j).getEntityColor());
                g.fillRect(this.body.get(j).getEntityPosX(), this.body.get(j).getEntityPosY(), 20, 20);
            }
        }
        else{
            GameFrame.gameScene.setGameIsFinished(true);
        }
    }

    public void collisionWithProjectil(Projectil projectil){
        for(Square snakeBody : body){
            if(projectil.collisionWithSnake(snakeBody)){
                projectil.entity_position_x = -10;
                body.remove(0);
                length--;
                break;
            }
        }
    }

    private boolean isKilled(){
        if(body.size() < 1){
            return true;
        }
        return false;
    }

}
