import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Snake extends JPanel implements Runnable {

public int length;
ArrayList<Square> body = new ArrayList<Square>();
Graphics graphics;
public static boolean isMoving = false;

public String Direction;







//Constructor
public Snake( int length){

this.length = length;

    this.isMoving = true;
    this.Direction = "right";

    createSnake();




}


    //Lancement du JEU





//@Override
//    public void paintComponent(Graphics g) {
//    super.paintComponent(g);
//
//if (isMoving == true){
//
//    drawSnake(g);
//}


//AFFICHE JUSTE LES COORDONNEES
//    for (int i = 0; i < this.body.size(); i++){
//
//        //Récupère l'anneau dans le tableau de carré
//        System.out.println(body.get(i) + "" + i);
//
//
//    }
//
//}



//CRREER LE SERPENT
public void createSnake(){


    for (int i = 0; i < this.length; i++){

        //Ajout du nouvelle anneau



            body.add(new Square( ((i)*20), 0, Color.GREEN ));

        }




}

//FAIT AVANCER LE SNAKE DUNE CASE SUR L'AXE DES X

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


//FONCTION SLEEP() NON UTILISE

public void sleep(int time){

    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }


}

//COLLISION

    public void checkCollision(){

    if (this.body.get(this.length-1).getCoordX() == ConstantVariable.MAIN_WINDOW_WIDTH - 40 || this.body.get(this.length-1).getCoordX() == 0){

        switch(this.Direction){

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


    //DESSINER LE SNAKE
    public void drawSnake(Graphics g) {

    //Faire bouger le snake tout les 100ms
    if (RepaintTimer.compteur % 100 == 0){

        mooveSnake();


    }




    for (int j = 0; j < this.body.size(); j++) {


        g.setColor(this.body.get(j).color);

        g.fillRect(this.body.get(j).getCoordX(), this.body.get(j).getCoordY(), 20, 20);


    }




    }


    @Override
    public void run() {


        while(true){
            try {
                Thread.sleep(100);
                GameFrame.gameScene.repaint();//call to paintComponent of GameScene

            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There seems to be an error in with the sleep ...");
            }


        }
    }



}




