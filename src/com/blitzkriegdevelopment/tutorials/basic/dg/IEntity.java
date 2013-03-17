package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public interface IEntity {
	public void move();
	
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public int getSpeed();
	public int getDirection();
	public int getYground();
	public int getHealth();
	public int getMaxHealth();
	public int getJumpspeed();
	public int getDx();
	public int getDy();
	public int getCurimgindex();
	public boolean inAir();
	public boolean isWalking();
	public Image getImage();
	public Image getGFX();
	public ArrayList<ImageIcon> getStaticimg();
	public Rectangle getBounds();
	public Board getBoard();
	
	public void setX(int x);
	public void setY(int y);
	public void setWidth(int w);
	public void setHeight(int h);
	public void setSpeed(int s);
	public void setDirection(int dir);
	public void setYground(int y);
	public void setHealth(int h);
	public void setMaxHealth(int mh);
	public void setDx(int dx);
	public void setDy(int dy);
	public void setInAir(boolean b);
	public void setJumpspeed(int j);
	public void setGFX(Image i);
	public void setStaticimg(ArrayList<ImageIcon> si);
	public void startWalking();
	public void stopWalking();
        public void startJumping();
	public void stopJumping();
	public void setCurimgindex(int cii);
	
	public void setStaticImg(ArrayList al);
	public void setCycleImg(ArrayList all,ArrayList alr);
	public ArrayList getCycleImg(int i);
        public ArrayList getJumpCycleImg(int i);
}
