package kiloboltgame;

import java.awt.Rectangle;

public class Enemy {

	private int power, speedX, centerX, centerY;
	private Background bg = StartingClass.getBg1();
	public Rectangle r = new Rectangle(0,0,0,0);
	
	public int health = 5;

	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = bg.getSpeedX()*5;
		r.setBounds(centerX-25, centerY-25, 50, 60);
		if(r.intersects(Robot.collisionSpace)){
			checkCollision();
		}
	}

	public void die() {

	}

	public void attack() {

	}
	
	private void checkCollision(){
		if(r.intersects(Robot.rectTop) || r.intersects(Robot.rectBot) || r.intersects(Robot.rectLeft) || r.intersects(Robot.rectRight)){
			System.out.println("This nigga in ma face yo.");
		}
	}


	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}