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
            body.add(new Square(((i) * 20), 0, Color.GREEN));
        }
    }

    // FAIT AVANCER LE SNAKE DUNE CASE SUR L'AXE DES X
    public void moveSnake() {

        ArrayList<Square> newbody = new ArrayList<Square>();
        Square first = this.body.get(this.length - 1);
        Square head = new Square(first.getCoordX(), first.getCoordY(), first.color);

        switch (this.direction) {
            case "right" -> head.CoordX += 20;
            case "left" -> head.CoordX -= 20;
            case "up" -> head.CoordY -= 20;
            case "down" -> head.CoordY += 20;
        }

        for (int i = 1; i < this.body.size(); i++) {
            Square previous = this.body.get(i);
            Square newRec = new Square(previous.getCoordX(), previous.getCoordY(), previous.color);
            newbody.add(newRec);
        }

        newbody.add(head);
        this.body = newbody;
        checkWindowLimitCollision();
    }

    public void checkWindowLimitCollision() {
        if (this.body.get(this.length - 1).getCoordX() == ConstantVariable.MAIN_WINDOW_WIDTH - 40
                || this.body.get(this.length - 1).getCoordX() == 0) {

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

    public void killSnake() {
        for (int i = 0; i < this.body.size(); i++) {
            for (int j = 0; j < GameFrame.gameScene.projectil_list.length; j++) {

                Projectil projectil = GameFrame.gameScene.projectil_list[j];
                if (this.body.get(i).getCoordX() < projectil.entity_position_x + projectil.entity_width + 10
                        && this.body.get(i).getCoordX() + this.body.get(i).getWidth() + 10 > projectil.entity_position_x

                        && this.body.get(i).getCoordY() + this.body.get(i).getHeight()
                                + 15 > GameFrame.gameScene.projectil_list[j].entity_position_y

                        && this.body.get(i).getCoordY() < GameFrame.gameScene.projectil_list[j].entity_position_y
                                + GameFrame.gameScene.projectil_list[j].entity_height + 5) {

                    projectil.entity_position_x = -10;

                    this.body.remove(0);
                    this.length--;

                }
                // if (this.body.get(i).getCoordX() < GameFrame.gameScene.projectil_list[j].entity_position_x
                //         + GameFrame.gameScene.projectil_list[j].entity_width + 10
                //         && this.body.get(i).getCoordX() + this.body.get(i).getWidth()
                //                 + 10 > GameFrame.gameScene.projectil_list[j].entity_position_x

                //         && this.body.get(i).getCoordY() + this.body.get(i).getHeight()
                //                 + 15 > GameFrame.gameScene.projectil_list[j].entity_position_y

                //         && this.body.get(i).getCoordY() < GameFrame.gameScene.projectil_list[j].entity_position_y
                //                 + GameFrame.gameScene.projectil_list[j].entity_height + 5) {

                //     GameFrame.gameScene.projectil_list[j].entity_position_x = -10;

                //     this.body.remove(0);
                //     this.length--;

                // }
            }
        }
    }

    public void drawSnake(Graphics g) {

        // killSnake();
        // Faire bouger le snake tout les 100ms
        if (RepaintTimer.compteur % 100 == 0) {
            moveSnake();
        }

        for (int j = 0; j < this.body.size(); j++) {
            g.setColor(this.body.get(j).color);
            g.fillRect(this.body.get(j).getCoordX(), this.body.get(j).getCoordY(), 20, 20);
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

    public boolean isKilled(){
        if(body.size() < 0){
            return true;
        }
        return false;
    }

}
