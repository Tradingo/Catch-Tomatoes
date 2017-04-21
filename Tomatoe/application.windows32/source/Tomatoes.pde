class Tomatoes {
  color farve;
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
    newSpeed = 0.25;
    radius = 25;
    farve = (#E30202);
  }
  void move() {
    yPos = yPos+ySpeed;
    if (yPos > height) {
      yPos = -50;
      xPos = random(5, 490);
      myScore1.lives = myScore1.lives - 1;
    }
  
  }
  void collision() {
    distance1 = dist(xPos, yPos+radius/2, myPlayer1.xPos, myPlayer1.yPos);
    distance2 = dist(xPos, yPos+radius/2, myPlayer1.xPos + myPlayer1.bredde, myPlayer1.yPos);
    if (distance1 < radius/2 || distance2 < radius/2 || xPos > myPlayer1.xPos && xPos < myPlayer1.xPos + myPlayer1.bredde && yPos + radius> myPlayer1.yPos) {
      yPos = -50;
      xPos = random(5, 490);
      myScore1.score = int(myScore1.score + ySpeed);
      ySpeed = ySpeed + newSpeed;
    }
  }
  void display() {
    stroke(0);
    fill(farve);
    ellipse(xPos, yPos, radius, radius);
  }
}