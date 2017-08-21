import java.util.List;

import fedorabots.client.Robot;
import fedorabots.client.sensor.DetectedEntity;
import fedorabots.client.sensor.DetectedObstacle;
import fedorabots.client.sensor.DetectedRobot;
import javafx.scene.paint.Color;

public class BotBase extends Robot {
	
	//Using constants is good style, no magic numbers
	public static final Color green = Color.CHARTREUSE;
	public static final int DIFFICULTY = 1;
	
	public static void main(String[] args){
		new BotBase().run();
	}
	
	public void run(){
		//Set a unique color so we can tell you apart
		setColor(BOT_COLOR);
		//Swap to a networked game when you want to compete with others
		joinLocalGame(DIFFICULTY);
		Robot bot = new Robot();

		List<DetectedEntity> nearby = bot.nearbyEntities();

		for(DetectedEntity e: nearby)
		  System.out.println(e.getX() + ", " + e.getY());

		DetectedEntity entity = nearby.get(0);


		if(entity instanceof DetectedObstacle){

		  DetectedObstacle ob = (DetectedObstacle) entity;

		  System.out.println(ob.getType());

		} else if(entity instanceof DetectedRobot){
		  DetectedRobot ro = (DetectedRobot) entity;
		  System.out.println(ro.getColor());
		}
		while(!isDead()){
			//Do something, how will your robot work?
		}
	}
	
	
}

