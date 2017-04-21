class Score{
  int score = 0;
  int lives = 3;
  void display() {
    textSize(20);
    text("Score:" + score, 15, 30);
    text("Lives:" + lives, 15, 50);
    
  }
}