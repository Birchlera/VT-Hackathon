package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Enemy {
	
	private DisplayAnimation gif;
	private File file;
	private String name;
	private String currAction;
	private int health;
	private boolean isAttacking;
	private boolean isDead;
	
	public Enemy(String n, int h) {
		gif = new DisplayAnimation(name, currAction);
		file = new File("src/Sprites/" + name + "_" + currAction + ".gif");
		name = n;
		health = h;
		isDead = false;
	}

	
	public String getName() {
		return name;
	}
	
	public void setCurrAction() {
		if (this.isRunning()) {
			currAction = "running";
		} else if (this.isAttacking) {
			currAction = "attacking";
		} else {
			currAction = "standing";
		}
	}
	
	public void setCurrAction(String action) {
		currAction = action;
	}
	
	public String getCurrAction() {
		return currAction;
	}
	
	public boolean isRunning() {

		return false;
	}
	
	public boolean isAttacking() {
		return false;
	}
	
	public String toString() {
		return this.getName() + "is" + this.getCurrAction();
	}
	
	public static void main(String[] args) {

	}
	
	public BufferedImage bufferIt() throws IOException {
		BufferedImage image = ImageIO.read(file);
		
		return image;
	}

	/*
	public void followCharacter() {
		int step = steps[level];
		int x = _target.getLocation().getX() - _location.getX();
		int y = _target.getLocation().getY() - _location.getY();
		double h = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		
		int xMove = (int)(x / h * step);
		int yMove = (int)(y / h * step);
		
		Location newLoc = new Location(_location.getX() + xMove, _location.getY() + yMove);
	}
	*/
	
	
}
