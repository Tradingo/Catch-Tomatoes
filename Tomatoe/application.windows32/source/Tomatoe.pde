Tomatoes myTomatoes = new Tomatoes();
Tomatoes myTomatoes2 = new Tomatoes();
Tomatoes myTomatoes3 = new Tomatoes();
Tomatoes myTomatoes4 = new Tomatoes();
Tomatoes myTomatoes5 = new Tomatoes();
Player myPlayer1 = new Player();
Score myScore1 = new Score();
dScreen mydScreen1 = new dScreen();

void setup() {
  size(500, 650);
  frameRate(60);
}



void draw() {
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