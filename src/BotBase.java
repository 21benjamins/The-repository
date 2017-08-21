import javafx.scene.paint.Color;

import java.util.List;

import fedorabots.client.Robot;
import fedorabots.client.sensor.DetectedEntity;
import fedorabots.client.sensor.DetectedObstacle;
import fedorabots.client.sensor.DetectedRobot;

public class BotBase extends Robot {
	
	//Using constants is good style, no magic numbers
	public static final Color BOT_COLOR = Color.CHARTREUSE;
	public static final int DIFFICULTY = 1;
	
	public static void main(String[] args){
		new BotBase().run();
	}
	static Robot bot = new Robot();

	List<DetectedEntity> nearby = bot.nearbyEntities();{

	for(DetectedEntity e: nearby)
	  System.out.println(e.getX() + "," + e.getY());

	DetectedEntity entity = nearby.get(0);


	if(entity instanceof DetectedObstacle){


	  DetectedObstacle ob = (DetectedObstacle) entity;

	  System.out.println(ob.getType());

	} else if(entity instanceof DetectedRobot){
	  DetectedRobot ro = (DetectedRobot) entity;
	  System.out.println(ro.getColor());
	}
	}
	public void shootAt(double x, double y){
		if(this.canShoot()){
			throw new IllegalStateException("Robot cannot shoot yet.");
		}
		this.setBlasterRotation(90 - 180 * Math.atan2(-y + this.getY(), x - this.getX()) / Math.PI);
		this.shoot();
	}


	public void run(){
		//Set a unique color so we can tell you apart
		setColor(BOT_COLOR);
		//Swap to a networked game when you want to compete with others
		joinLocalGame(DIFFICULTY);
		while(!isDead()){
			//Do something, how will your robot work?
			if(canShoot())
			{
				nearbyEntities();
				shootAt(bot.getX(), bot.getY());
			}
		}
	}
}