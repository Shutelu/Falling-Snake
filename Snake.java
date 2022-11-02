import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JPanel {

    public int length;
    ArrayList<Square> body = new ArrayList<Square>();
    Graphics graphics;

    public String Direction;

    public Snake(int length) {

        this.length = length;
        this.Direction = "right";

        createSnake();

    }

    public void createSnake() {
        for (int i = 0; i < this.length; i++) {
            // Ajout du nouvelle anneau
            body.add(new Square(((i) * 20), 0, Color.GREEN));
        }
    }

    // FAIT AVANCER LE SNAKE DUNE CASE SUR L'AXE DES X
    public void mooveSnake() {

        ArrayList<Square> newbody = new ArrayList<Square>();
        Square first = this.body.get(this.length - 1);
        Square head = new Square(first.getCoordX(), first.getCoordY(), first.color);

        switch (this.Direction) {
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
        checkCollision();
    }

    public void checkCollision() {
        if (this.body.get(this.length - 1).getCoordX() == ConstantVariable.MAIN_WINDOW_WIDTH - 40
                || this.body.get(this.length - 1).getCoordX() == 0) {

            switch (this.Direction) {
                case "right":
                    this.Direction = "down";
                    mooveSnake();
                    this.Direction = "left";
                    mooveSnake();
                    break;
                case "left":
                    this.Direction = "down";
                    mooveSnake();
                    this.Direction = "right";
                    mooveSnake();
                    break;
            }
        }
    }

    public void killSnake(){

        for (int i = 0; i < this.body.size(); i++){
            for (int j = 0; j < GameFrame.gameScene.projectil_list.length; j++){


                if (this.body.get(i).getCoordX() < GameFrame.gameScene.projectil_list[j].entity_position_x + GameFrame.gameScene.projectil_list[j].entity_width+ 10
                        && this.body.get(i).getCoordX()+ this.body.get(i).getWidth() +10 > GameFrame.gameScene.projectil_list[j].entity_position_x

                        && this.body.get(i).getCoordY()+ this.body.get(i).getHeight() + 15 > GameFrame.gameScene.projectil_list[j].entity_position_y

                        && this.body.get(i).getCoordY()< GameFrame.gameScene.projectil_list[j].entity_position_y + GameFrame.gameScene.projectil_list[j].entity_height + 5 ){


                    GameFrame.gameScene.projectil_list[j].entity_position_x = -10;

                    this.body.remove(0);
                    this.length--;


                }

            }


        }


    }

    public void drawSnake(Graphics g) {

        killSnake();
        // Faire bouger le snake tout les 100ms
        if (RepaintTimer.compteur % 100 == 0) {
            mooveSnake();
        }

        for (int j = 0; j < this.body.size(); j++) {
            g.setColor(this.body.get(j).color);
            g.fillRect(this.body.get(j).getCoordX(), this.body.get(j).getCoordY(), 20, 20);
        }
    }

}
