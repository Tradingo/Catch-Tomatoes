class dScreen {
  float Gameover;
  
  
  void display() {
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