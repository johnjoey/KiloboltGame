package kiloboltgame;

import java.awt.Image;

public class Tile {
	private int tileX, tileY, speedX, type;
	private Image tileImage;
	private Background bg = StartingClass.getBg1();

	public Tile(int x, int y, int type) {
		tileX = x*40;
		tileY = y*40;
		this.type = type;
		
		if(type == 1)
			tileImage = StartingClass.tileocean;
		else if(type == 2)
			tileImage = StartingClass.tiledirt;
	}

	public void update() {
		if (type == 1) {
			if (bg.getSpeedX() == 0) {
				speedX = -1;
			} else {
				speedX = -2;
			}
		}else{
			speedX = bg.getSpeedX()*5;
		}
		tileX += speedX;
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
