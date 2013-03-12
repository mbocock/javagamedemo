package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Rectangle;
import java.util.ArrayList;

public interface IEntity {
	public void move();
	
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public int getSpeed();
	public int getDirection();
	public int getYground();
	
	public Rectangle getBounds();
	
	public void setX(int x);
	public void setY(int y);
	public void setWidth(int w);
	public void setHeight(int h);
	public void setSpeed(int s);
	public void setDirection(int dir);
	public void setYground(int y);
	
	public void setStaticImg(ArrayList al);
	public void setCycleImg(ArrayList all,ArrayList alr);
	public ArrayList getCycleImg(int i);
}
