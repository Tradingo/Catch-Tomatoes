import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Tomatoe extends PApplet {

Tomatoes myTomatoes = new Tomatoes();
Tomatoes myTomatoes2 = new Tomatoes();
Tomatoes myTomatoes3 = new Tomatoes();
Tomatoes myTomatoes4 = new Tomatoes();
Tomatoes myTomatoes5 = new Tomatoes();
Player myPlayer1 = new Player();
Score myScore1 = new Score();
dScreen mydScreen1 = new dScreen();

public void setup() {
  
  frameRate(60);
}



public void draw() {
  background(255);
  myScore1.display();
  myPlayer1.display();
  myTomatoes.display();
  myTomatoes.move();
  myTomatoes.collision();
  myTomatoes2.display();
  myTomatoes2.move();
  myTomatoes2.collision();
  myTomatoes3.display();
  myTomatoes3.move();
  myTomatoes3.collision();
  myTomatoes4.display();
  myTomatoes4.move();
  myTomatoes4.collision();
  myTomatoes5.display();
  myTomatoes5.move();
  myTomatoes5.collision();
  mydScreen1.display();
  
}
class dScreen {
  float Gameover;
  
  
  public void display() {
    if (myScore1.lives <= 0) {
      background(0);
      textSize(40);
      textAlign(CENTER);
      text("Game Over", 250, 300);
      fill(255);
      textSize(20);
      textAlign(CENTER);
      text("Press R to restart", 250, 350);
      if (keyPressed) {
        if (key == 'r' || key == 'R') {
          background(255);
          myTomatoes.yPos = -100;
        }
      }
    }
  }
}
class Player {
  int c;  
  float xPos;
  float yPos;
  float bredde = 50;
  float hoejde = 20;
  float lives;

  Player() {
    xPos = mouseX;
    yPos = 600;
    c = color(158, 10, 10);
  }


  public void display() {
    xPos = mouseX;
    yPos = 600;
    c = color(158, 10, 10);
    rect(xPos, yPos, bredde, hoejde);
  }
}
class Score{
  int score = 0;
  int lives = 3;
  public void display() {
    textSize(20);
    text("Score:" + score, 15, 30);
    text("Lives:" + lives, 15, 50);
    
  }
}
class Tomatoes {
  int farve;
  float xPos;
  float yPos;
  float ySpeed;
  float newSpeed;
  float radius;
  float distance1;
  float distance2;


  Tomatoes() {
    xPos = random(5, 490);
    yPos = -100;
    ySpeed = random(1, 4);
    newSpeed = 0.25f;
    radius = 25;
    farve = (0xffE30202);
  }
  public void move() {
    yPos = yPos+ySpeed;
    if (yPos > height) {
      yPos = -50;
      xPos = random(5, 490);
      myScore1.lives = myScore1.lives - 1;
    }
  
  }
  public void collision() {
    distance1 = dist(xPos, yPos+radius/2, myPlayer1.xPos, myPlayer1.yPos);
    distance2 = dist(xPos, yPos+radius/2, myPlayer1.xPos + myPlayer1.bredde, myPlayer1.yPos);
    if (distance1 < radius/2 || distance2 < radius/2 || xPos > myPlayer1.xPos && xPos < myPlayer1.xPos + myPlayer1.bredde && yPos + radius> myPlayer1.yPos) {
      yPos = -50;
      xPos = random(5, 490);
      myScore1.score = PApplet.parseInt(myScore1.score + ySpeed);
      ySpeed = ySpeed + newSpeed;
    }
  }
  public void display() {
    stroke(0);
    fill(farve);
    ellipse(xPos, yPos, radius, radius);
  }
}
  public void settings() {  size(500, 650); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Tomatoe" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
