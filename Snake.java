import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake extends JPanel {

    public int length;

    public boolean eatFraise = false;
    public ArrayList<Square> body;
    // public ObstacleType[] type = new ObstacleType[] {

    //         ObstacleType.BOIS, ObstacleType.FRAISE, ObstacleType.MYRTILLE, ObstacleType.PIECE_DOR

    // };
    
    public Graphics graphics;
    public String direction;

    public long chrono;
    public long chrono2;
    private boolean canKillBodyPart;
    private GameScene gameScene;

    public Snake(int length, GameScene gameScene) {

        this.gameScene = gameScene;
        this.body = new ArrayList<Square>();
        this.canKillBodyPart = true;
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
        Square head = new Square(first.entity_position_x, first.entity_position_y);

        switch (this.direction) {
            case "right" -> head.entity_position_x = head.entity_position_x + 20;
            case "left" -> head.entity_position_x = head.entity_position_x - 20;
            case "up" -> head.entity_position_y = head.entity_position_y - 20;
            case "down" -> head.entity_position_y = head.entity_position_y + 20;
        }

        for (int i = 1; i < this.body.size(); i++) {
            Square previous = this.body.get(i);
            Square newRec = new Square(previous.entity_position_x, previous.entity_position_y);
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
        if (this.body.get(this.length - 1).entity_position_x == ConstantVariable.MAIN_WINDOW_WIDTH - 20
                || this.body.get(this.length - 1).entity_position_x == - 20) {
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
                gameScene.setGameIsFinished(true);
                gameScene.setLose(true);
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

    //setter
    public void setCanKillBodyPart(boolean b) {canKillBodyPart = b;}

}