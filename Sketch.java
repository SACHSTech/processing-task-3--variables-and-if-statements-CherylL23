import processing.core.PApplet;

public class Sketch extends PApplet {
  
	//house variables
  float houseX = random(0, width);
  float houseY = random(0, height);
  float houseWidth = 200;
  float houseHeight = 150;
	
  public void settings() {
    
	// put your size call here
    size(400, 400);
  }

  public void setup() {
    
    background(0, 210, 252);
  }

  public void draw() {

    //boolean variables
    boolean yCordinates = houseY <= 80;
    boolean xCordinates = houseX <= 50;
   boolean extraSmall = xCordinates && !!yCordinates;
    boolean extraBig = houseX >= 200 || houseY >= 130;
  
  //else statements
    if (extraBig) {
      background(245, 158, 66);
    }
    else if (extraSmall) {
      background(132, 66, 245);
    }
    else {
      background(0, 210, 252);
    }
   
    //biggest rectangle of the house
    fill(240, 235, 182);
    rect(houseX, houseY, houseWidth, houseHeight);

    //roof positions
    fill(207, 76, 33);
    triangle((float) (houseX), (float) (houseY), (float) (houseX + 100), (float) (houseY - 100),
  (float) (houseX + houseWidth) , (float) (houseY));
      
    //window positions
    fill(145, 229, 242);
    rect((float) (houseX + 10), (float) (houseY + 30), (float) (houseWidth - 130), (float) (houseHeight - 90));

    //rectangle door positions
    fill(82, 79, 53);
    rect((float) (houseX + 90), (float) (houseY +30), (float) (houseWidth - 120), (float) (houseHeight - 30));
    
    // doorknob positions
    fill(240, 252, 0);
    ellipse((float) (houseX + 155), (float) (houseY + 100), (float) (houseWidth -185), (float) (houseHeight - 135));
  
   //making a clock to show current time
    float s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
    float m = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI; 
    float h = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI;
    
    


    //variables for the clock
    int width = 100;
    int height = 100;
    int radius = min(width, height) / 2;
    double secondsRadius = radius * 0.72;
    double minutesRadius = radius * 0.60;
    double hoursRadius = radius * 0.50;
    double clockDiameter = radius * 1.8;
    int cx = width / 2;
    int cy = height / 2;
    
    // Draw the clock background
    fill(80);
    noStroke();
    ellipse(cx, cy, (float) clockDiameter, (float) clockDiameter);
   
    //the hands of the clock
    stroke(255);
    strokeWeight(1);
    line((float) cx, (float) cy, (float) (cx + cos(s) * secondsRadius), (float) (cy + sin(s) * secondsRadius));
   strokeWeight(2);
   line((float) cx, (float) cy, (float) (cx + cos(m) * minutesRadius), (float) (cy + sin(m) * minutesRadius));
   strokeWeight(4);
   line((float) cx, (float) cy, (float) (cx + cos(h) * hoursRadius), (float) (cy + sin(h) * hoursRadius));
  
   // the minute ticks
   strokeWeight(2);
    beginShape(POINTS);
  
  for (int a = 0; a < 360; a+=6) {
    float angle = radians(a);
    float x = (float) (cx + cos(angle) * secondsRadius);
    float y = (float) (cy + sin(angle) * secondsRadius);
    vertex(x, y);
  }
 }
}