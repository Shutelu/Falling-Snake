package Game.Entities.Enemy;
import javax.swing.JPanel;
import Game.GameScene;
import Game.ProjectSettings;
import Game.RepaintTimer;
import Game.Entities.Player.Cannon;
import Game.Entities.Player.Projectil;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * The Snake will move from top to bottom
 * if the snake touch an Obstacle an effect will occur
 * if the snake touch the Cannon the game will end and the player will lose
 * if the snake is killed before colliding with the Cannon the game will end and the player will win 
 */
public class Snake extends JPanel {

    /**
     * Constructor of the Snake class
     * @param snakeLength length of the snake
     * @param gameScene game scene
     */
    public Snake(int snakeLength, GameScene gameScene) {
        this.body = new ArrayList<SnakePart>();
        this.gameScene = gameScene;
        this.snakeLength = snakeLength;
        this.direction = "right";
        this.eatFraise = false;
        this.canKillBodyPart = true;
        createSnake();
    }

    private GameScene gameScene;
    private ArrayList<SnakePart> body;
    private int snakeLength;
    private String direction;
    private boolean eatFraise;
    private boolean canKillBodyPart;

    private void createSnake() {
        for (int i = 0; i < this.snakeLength; i++) {
            body.add(new SnakePart(((i) * ProjectSettings.SNAKEPART_WIDTH), 0));
        }
    }

    private void checkWindowLimitCollision() {
        if (this.body.get(this.snakeLength - 1).getEntityPosX() == ProjectSettings.MAIN_WINDOW_WIDTH - ProjectSettings.SNAKEPART_WIDTH
                || this.body.get(this.snakeLength - 1).getEntityPosX() == - ProjectSettings.SNAKEPART_WIDTH) {
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

    /**
     * move the snake
     */
    public void moveSnake() {
        ArrayList<SnakePart> newbody = new ArrayList<SnakePart>();
        SnakePart first = this.body.get(this.snakeLength - 1);
        SnakePart head = new SnakePart(first.getEntityPosX(), first.getEntityPosY());

        switch (this.direction) {
            case"right" -> head.setEntityPosX(head.getEntityPosX() + ProjectSettings.SNAKEPART_WIDTH);
            case"left" -> head.setEntityPosX(head.getEntityPosX() - ProjectSettings.SNAKEPART_WIDTH);
            case "up" -> head.setEntityPosY(head.getEntityPosY() - ProjectSettings.SNAKEPART_WIDTH);
            case "down" -> head.setEntityPosY(head.getEntityPosY() + ProjectSettings.SNAKEPART_WIDTH);
        }

        for (int i = 1; i < this.body.size(); i++) {
            SnakePart previous = this.body.get(i);
            SnakePart newRec = new SnakePart(previous.getEntityPosX(), previous.getEntityPosY());
            newbody.add(newRec);
        }

        newbody.add(head);

        if (eatFraise ==true) {
            this.snakeLength++;
            switch (this.direction) {
                case "right":
                    SnakePart teter = new SnakePart(head.getEntityPosX() + ProjectSettings.SNAKEPART_WIDTH, head.getEntityPosY());
                    newbody.add(teter);
                    break;
                case "left":
                    SnakePart tetel = new SnakePart(head.getEntityPosX() - ProjectSettings.SNAKEPART_WIDTH, head.getEntityPosY());
                    newbody.add(tetel);
                    break;
            }
            this.eatFraise = false;
        }
        this.body = newbody;
        checkWindowLimitCollision();
    }

    /**
     * Draw the Snake on the scene
     * @param g graphics g
     */
    public void drawSnake(Graphics g) {
        if (isKilled() == false) {
            if (RepaintTimer.getSnakeMoveCounter() % ProjectSettings.SNAKE_REPAINT_DURATION == 0) {
                moveSnake();
            }
            for (int j = 0; j < this.body.size(); j++) {
                g.setColor(this.body.get(j).getEntityColor());
                g.fillRect(this.body.get(j).getEntityPosX(), this.body.get(j).getEntityPosY(), ProjectSettings.SNAKEPART_WIDTH, ProjectSettings.SNAKEPART_HEIGHT);
            }
        } else {
            gameScene.setGameIsFinished(true);
            gameScene.setWin(true);
        }
    }

    /**
     * Check the collision between Snake and Projectil 
     * the snake will lose one of its part if collision is true and the projectil will be placed out of the scene
     * if the snake if invicible then only the projectil will be placed out of the scene
     * @param projectil the projectil to collide
     */
    public void collisionWithProjectil(Projectil projectil) {
        for (SnakePart snakeBody : body) {
            if (canKillBodyPart) {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.setEntityPosX(ProjectSettings.PROJECTIL_OUT);
                    projectil.setEntityPosY(ProjectSettings.PROJECTIL_OUT);
                    body.remove(0);
                    snakeLength--;
                    break;
                }
            } 
            else {
                if (projectil.collisionWithSnake(snakeBody)) {
                    projectil.setEntityPosX(ProjectSettings.PROJECTIL_OUT);
                    projectil.setEntityPosY(ProjectSettings.PROJECTIL_OUT);
                }
            }
        }
    }

    /**
     * Check collision between Snake and Cannon, if collide then the game is finished
     * @param cannon Cannon to collide
     */
    public void collisionWithCannon(Cannon cannon) {
        if (body.size() > 0) {
            SnakePart head = body.get(body.size() - 1);
            if (cannon.collisionWithSnake(head)) {
                gameScene.setGameIsFinished(true);
            }
        }
    }

    /**
     * Check if the Snake is killed
     * return true if is killed else false
     */
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
    public String getDirection(){return direction;}
    public GameScene getSnakGameScene(){return gameScene;}

    //setter
    public void setCanKillBodyPart(boolean b) {canKillBodyPart = b;}
    public void setDirection(String s){direction = s;}
    public void setEatFraise(boolean b){eatFraise = b;}

}