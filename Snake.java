import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake extends JPanel {

    public int length;
    public ArrayList<Square> body;
    public ObstacleType [] type = new ObstacleType[]{

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

        if (isKilled() == false) {
            // Faire bouger le snake tout les 100ms
            if (RepaintTimer.compteur % 50 == 0) {
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
                    canKillBodyPart = false;
                    projectil.entity_position_x = -10;
                    projectil.entity_position_y = -10;
                    // projectil = null;
                    body.remove(0);
                    length--;
                    new Thread(new SnakeBodyTimer(this)).start();
                    break;
                }
            } else {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.entity_position_x = -10;
                    projectil.entity_position_y = -10;
                }
            }
        }
    }

    public void collisionWithCannon(Cannon cannon){
        if(body.size() > 1){
            Square head = body.get(body.size() - 1);
            if(cannon.collisionWithSnake(head)){
                GameFrame.gameScene.setGameIsFinished(true);
                GameFrame.gameScene.setLose(true);
            }
        }
    }

    public void collisionWithObstacle(Obstacle obstacle){


            switch (obstacle.obstacleType) {
                case BOIS:

                    if(this.direction == "right") {
                        this.direction = "down";
                        moveSnake();
                        this.direction = "left";
                        moveSnake();
                    }else if (this.direction == "left"){

                        this.direction = "down";
                        moveSnake();
                        this.direction = "right";
                        moveSnake();

                    }
                    break;
                case FRAISE:

                    switch (this.direction) {
                        case "right" -> this.body.add(new Square(this.body.get(0).entity_position_x-20, this.body.get(0).entity_position_y));
                        case "left" -> this.body.add(new Square(this.body.get(0).entity_position_x+20, this.body.get(0).entity_position_y));
                    /*ERREUR*/    case "up" -> this.body.add(new Square(this.body.get(0).entity_position_x, this.body.get(0).entity_position_y + 20));
                        case "down" ->  this.body.add(new Square(this.body.get(0).entity_position_x, this.body.get(0).entity_position_y - 20));
                    }

                    this.length ++;
                    break;


                case MYRTILLE:


                    this.canKillBodyPart = false;
                    new Thread(new InvincibilityTimer(this)).start();


                    break;
                case PIECE_DOR:

                    Random random = new Random();
                    for (int i = 0; i < GameFrame.gameScene.obstacle_list.length-1; i++){

                        if (GameFrame.gameScene.obstacle_list[i] != null) {

                            GameFrame.gameScene.obstacle_list[i].obstacleType = type[random.nextInt(type.length)];


                        }

                    }
                break;

            }



    }

    private boolean isKilled(){
        if(body.size() < 1){
            return true;
        }
        return false;
    }

    public void setCanKillBodyPart(boolean b) {
        canKillBodyPart = b;
    }

}
