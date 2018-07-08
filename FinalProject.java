package finalproject;
import processing.core.PApplet;
import processing.core.PFont;

public class FinalProject extends PApplet 
{
	PFont font;
	PFont playerFont;
	int textYLocation;
	
	public int startTime;
	public int timer;
	public int count;
	public int colorState;
	
	
    public static void main(String[] args) {
 
        PApplet.main("finalproject.FinalProject");
    }
 
    //2D array with (x, y) locations of the points of the cat.
    public int[][] catPoints = {{13,12},{12,12},{12,14},{13,14},{14,14},{14,13},{14,12},{14,11},{13,11},{12,11},{11,11},{11,12},{11,13},{11,14},{11,15},{12,15},{13,15},{14,15},{15,15},{15,14},{15,13},{15,12},{15,11},{15,10},{14, 10},{12,10},{11,10},{10,10},{10,10},{10,12},{10,13},{10,14},{10,15},{10,16},{16,16},{16,9},{9,9},{9,17},{17,17},{17,8},{8,8},{8,18},{18,18},{18,7},{7,7},{7,19},{19,19},{19,6},{6,6},{6,20},{20,20},{20,5},{5,5},{5,21},{20,21},{20,19}};
 
    public void settings() {
        size(800, 600);
    }
 
    public void setup() {
    	
		startTime = millis(); 
		background(255, 255, 255);
        playerFont = createFont("Lucida Bright", 12, true);
        
    	count = catPoints.length - 1;
    	     
        for(int i = 0; i < catPoints.length; i++) {
        	catPoints[i][0] *= 15;
        	catPoints[i][1] *= 15;
        }
    }
 
    public void draw() {
    	textYLocation = 1;
    	timer = millis() - startTime;
    	
    	if(colorState == 0) {
    		stroke(48, 0, 93);
    		textYLocation = 15;
    		drawPlayerText("As of 2014 77% of Americans regularly experience physical symptoms caused by stress.");
    	}
    	if(colorState == 1) {
    		stroke(64, 0, 125);
    		textYLocation = 16;
    		drawPlayerText("48% of Americans reported lying awake at night due to stress.");
    	}
    	if(colorState == 2) {
    		stroke(96, 0, 187);
    		textYLocation = 17;
    		drawPlayerText("26% of Americans reported being alienated from a friend or family member because of stress");
    	}
    	if(colorState == 3) {
    		stroke(129, 0, 250);
    		textYLocation = 18;
    		drawPlayerText("54% of Americans said stress has caused them to fight with people close to them");
    	}
    	if(colorState == 4) {
    		stroke(192, 128, 253);
    		textYLocation = 19;
    		drawPlayerText("Emplyers lose $300 billion anually in stress relatated health care and missed work.");
    	}
    	if(colorState == 5) {
    		stroke(223, 191, 253);
    		textYLocation = 20;
    		drawPlayerText("Top causes of stress in the US are, job pressure, money, health, relationships, poor nutrition, media overload and sleep deprevation");
    	}
    	if(colorState == 6) {
    		stroke(191, 191, 253);
    		textYLocation = 21;
    		drawPlayerText("Psychological symptoms of stress are, irritability or anger, nervousness, lack of energy and feeling as though you could cry.");
    	}
    	if(colorState == 7) {
    		stroke(222, 191, 253);
    		textYLocation = 22;
    		drawPlayerText("Only 36.9% of people with stress and anexiety are treated.");
    	}
    	
    	if(timer > 500 && count > 0) {
    		System.out.println("1/2 a second passed.");
    		line(catPoints[count][0],catPoints[count][1],catPoints[count-1][0], catPoints[count-1][1]);
    		count --;
    		startTime = millis();
    	}
    }
    public void drawPlayerText (String text) {
    	textFont (playerFont);
    	fill (0,0,0);
    	text (text, 15, 50 + (textYLocation * 20));
    	textYLocation += 1;
    }
    public void keyReleased() {
    	if(key == ' ') {
    		if(colorState < 7) {
    			colorState ++;
    		}
    	}
    }
 
}
