import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JPanel {

    public int length;

    public boolean eatFraise = false;
    public ArrayList<Square> body;
    public ObstacleType[] type = new ObstacleType[] {

            ObstacleType.BOIS, ObstacleType.FRAISE, ObstacleType.MYRTILLE, ObstacleType.PIECE_DOR

    };
    public Graphics graphics;
    public String direction;

    public long chrono;
    public long chrono2;
    private boolean canKillBodyPart;

    public Snake(int length) {

        canKillBodyPart = true;
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

        if (eatFraise ==true) {

            this.length++;
            switch (this.direction) {
                case "right":
                    Square teter = new Square(head.entity_position_x + 20, head.entity_position_y);
                    newbody.add(teter);
                    break;

                case "left":
                    Square tetel = new Square(head.entity_position_x - 20, head.entity_position_y);
                    newbody.add(tetel);
                    break;

            }
            this.eatFraise = false;
        }
        this.body = newbody;
        checkWindowLimitCollision();
    }

    public void checkWindowLimitCollision() {
        if (this.body.get(this.length - 1).getEntityPosX() == ConstantVariable.MAIN_WINDOW_WIDTH - 20
                || this.body.get(this.length - 1).getEntityPosX() == - 20) {
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

        if (isKilled() == false) {
            // Faire bouger le snake tout les 100ms
            if (RepaintTimer.compteur % 100 == 0) {
                moveSnake();
            }
            for (int j = 0; j < this.body.size(); j++) {
                g.setColor(this.body.get(j).getEntityColor());
                g.fillRect(this.body.get(j).getEntityPosX(), this.body.get(j).getEntityPosY(), 20, 20);
            }
        } else {
            GameFrame.gameScene.setGameIsFinished(true);
            GameFrame.gameScene.setWin(true);
        }
    }

    public void collisionWithProjectil(Projectil projectil) {
        for (Square snakeBody : body) {
            if (canKillBodyPart) {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.entity_position_x = -10;
                    projectil.entity_position_y = -10;
                    body.remove(0);
                    length--;
                    break;
                }
            } 
            else {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.entity_position_x = -10;
                    projectil.entity_position_y = -10;
                }
            }
        }
    }

    public void collisionWithCannon(Cannon cannon) {
        if (body.size() > 0) {
            Square head = body.get(body.size() - 1);
            if (cannon.collisionWithSnake(head)) {
                GameFrame.gameScene.setGameIsFinished(true);
                GameFrame.gameScene.setLose(true);
            }
        }
    }

    public void collisionWithObstacle(Obstacle obstacle) {
        switch (obstacle.obstacleType) {
            case BOIS:
                if (this.direction == "right") {
                    this.direction = "down";
                    moveSnake();
                    this.direction = "left";
                    moveSnake();
                } else if (this.direction == "left") {
                    this.direction = "down";
                    moveSnake();
                    this.direction = "right";
                    moveSnake();
                }
                break;

            case FRAISE:
                this.eatFraise = true;
                break;

            case MYRTILLE:
                if(canKillBodyPart){
                    this.canKillBodyPart = false;
                    System.out.println("invincible time !");
                }

                break;
            case PIECE_DOR:

                Random random = new Random();
                for (int i = 0; i < GameFrame.gameScene.obstacle_list.length - 1; i++) {

                    if (GameFrame.gameScene.obstacle_list[i] != null) {
                        GameFrame.gameScene.obstacle_list[i].obstacleType = type[random.nextInt(type.length)];
                    }

                }
                break;

        }

    }

    private boolean isKilled() {
        if (body.size() < 1) {
            return true;
        }
        return false;
    }

    //getter
    public boolean getCanKillBodyPart(){return canKillBodyPart;}

    public void setCanKillBodyPart(boolean b) {
        canKillBodyPart = b;
    }

}