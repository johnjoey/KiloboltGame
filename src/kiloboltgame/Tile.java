package kiloboltgame;

import java.awt.Image;
import java.awt.Rectangle;

public class Tile {
	private int tileX, tileY, speedX, type;
	private Image tileImage;
	private Robot robot = StartingClass.getRobot();
	private Background bg = StartingClass.getBg1();
	private Rectangle r;

	public Tile(int x, int y, int typeInt) {
		tileX = x * 40;
		tileY = y * 40;
		type = typeInt;
		r = new Rectangle();

		if (type == 5) {
			tileImage = StartingClass.tiledirt;
		} else if (type == 8) {
			tileImage = StartingClass.tilegrassTop;
		} else if (type == 4) {
			tileImage = StartingClass.tilegrassLeft;

		} else if (type == 6) {
			tileImage = StartingClass.tilegrassRight;

		} else if (type == 2) {
			tileImage = StartingClass.tilegrassBot;
		} else {
			type = 0;
		}

	}

	public void update() {
		speedX = bg.getSpeedX() * 5;
		tileX += speedX;
		r.setBounds(tileX, tileY, 40, 40);
		if (type != 0 && r.intersects(Robot.collisionSpace))
			checkVerticalCollision(Robot.rectTop, Robot.rectBot);
		checkHorizontalCollision(Robot.rectLeft, Robot.rectRight, Robot.footleft, Robot.footright);
	}

	public void checkVerticalCollision(Rectangle rtop, Rectangle rbot) {
		if (rtop.intersects(r)) {

		}
		if (rbot.intersects(r) && type == 8) {
			robot.setJumped(false);
			robot.setSpeedY(0);
			robot.setCenterY(tileY - 63);
		}
	}

	public void checkHorizontalCollision(Rectangle rLeft, Rectangle rRight, Rectangle leftFoot, Rectangle rightFoot) {
		if(type != 5 && type != 2 && type != 0) {
			if(rLeft.intersects(r)) {
				robot.setCenterX(tileX+102);
				robot.setSpeedX(0);
			} else if (leftFoot.intersects(r)) {
				robot.setCenterX(tileX+85);
				robot.setSpeedX(0);
			}
			
			if(rRight.intersects(r)) {
				robot.setCenterX(tileX-62);
				robot.setSpeedX(0);
			} else if (rightFoot.intersects(r)) {
				robot.setCenterX(tileX - 45);
				robot.setSpeedX(0);
			}
		}
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Image getTileImage() {
		return tileImage;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}
}
