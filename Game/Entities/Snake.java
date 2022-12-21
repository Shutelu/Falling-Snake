package Game.Entities;
import javax.swing.JPanel;

import Game.GameScene;
import Game.ProjectSettings;
import Game.RepaintTimer;

import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends JPanel {

    private GameScene gameScene;
    private ArrayList<SnakePart> body;
    private int snakeLength;
    private String direction;
    private boolean eatFraise;
    private boolean canKillBodyPart;

    public Snake(int snakeLength, GameScene gameScene) {
        this.gameScene = gameScene;
        this.body = new ArrayList<SnakePart>();
        this.snakeLength = snakeLength;
        this.direction = "right";
        this.eatFraise = false;
        this.canKillBodyPart = true;

        createSnake();
    }

    public void createSnake() {
        for (int i = 0; i < this.snakeLength; i++) {
            body.add(new SnakePart(((i) * 20), 0));
        }
    }

    // FAIT AVANCER LE SNAKE DUNE CASE SUR L'AXE DES X
    public void moveSnake() {

        ArrayList<SnakePart> newbody = new ArrayList<SnakePart>();
        SnakePart first = this.body.get(this.snakeLength - 1);
        SnakePart head = new SnakePart(first.entity_position_x, first.entity_position_y);

        switch (this.direction) {
            case "right" -> head.entity_position_x = head.entity_position_x + 20;
            case "left" -> head.entity_position_x = head.entity_position_x - 20;
            case "up" -> head.entity_position_y = head.entity_position_y - 20;
            case "down" -> head.entity_position_y = head.entity_position_y + 20;
        }

        for (int i = 1; i < this.body.size(); i++) {
            SnakePart previous = this.body.get(i);
            SnakePart newRec = new SnakePart(previous.entity_position_x, previous.entity_position_y);
            newbody.add(newRec);
        }

        newbody.add(head);

        if (eatFraise ==true) {
            this.snakeLength++;
            switch (this.direction) {
                case "right":
                    SnakePart teter = new SnakePart(head.entity_position_x + 20, head.entity_position_y);
                    newbody.add(teter);
                    break;

                case "left":
                    SnakePart tetel = new SnakePart(head.entity_position_x - 20, head.entity_position_y);
                    newbody.add(tetel);
                    break;

            }
            this.eatFraise = false;
        }
        this.body = newbody;
        checkWindowLimitCollision();
    }

    public void checkWindowLimitCollision() {
        if (this.body.get(this.snakeLength - 1).entity_position_x == ProjectSettings.MAIN_WINDOW_WIDTH - 20
                || this.body.get(this.snakeLength - 1).entity_position_x == - 20) {
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
            if (RepaintTimer.getSnakeMoveCounter() % 100 == 0) {
                moveSnake();
            }
            for (int j = 0; j < this.body.size(); j++) {
                g.setColor(this.body.get(j).entity_color);
                g.fillRect(this.body.get(j).entity_position_x, this.body.get(j).entity_position_y, 20, 20);
            }
        } else {
            gameScene.setGameIsFinished(true);
            gameScene.setWin(true);
        }
    }

    public void collisionWithProjectil(Projectil projectil) {
        for (SnakePart snakeBody : body) {
            if (canKillBodyPart) {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.entity_position_x = -10;
                    projectil.entity_position_y = -10;
                    body.remove(0);
                    snakeLength--;
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
            SnakePart head = body.get(body.size() - 1);
            if (cannon.collisionWithSnake(head)) {
                gameScene.setGameIsFinished(true);
            }
        }
    }

    public void collisionWithObstacle(Obstacle obstacle) {
        switch (obstacle.getType()) {
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
                for (int i = 0; i < gameScene.getObstacleList().length - 1; i++) {
                    if (gameScene.getObstacleList()[i] != null) {
                        gameScene.getObstacleList()[i].setType(ObstacleType.randomType());
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
    public int getSnakeLength(){return snakeLength;}
    public ArrayList<SnakePart> getBody(){return body;}

    //setter
    public void setCanKillBodyPart(boolean b) {canKillBodyPart = b;}

}