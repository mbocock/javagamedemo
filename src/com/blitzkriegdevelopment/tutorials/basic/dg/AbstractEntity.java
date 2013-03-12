package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class AbstractEntity implements IEntity,IKillable{
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int speed;
	protected int direction;
	protected int dy;
	protected int dx;
	protected int yground;
	protected int jumpmax;
	protected ArrayList staticimg;
	protected ArrayList cycleimgLeft;
	protected ArrayList cycleimgRight;
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}

	@Override
	public void setX(int x) {
		x = x;
	}

	@Override
	public void setY(int y) {
		y = y;
	}

	@Override
	public void setWidth(int w) {
		width = w;
	}

	@Override
	public void setHeight(int h) {
		height = h;
	}

	@Override
	public void setSpeed(int s) {
		speed = s;
	}

	@Override
	public void setDirection(int dir) {
		direction = dir;
	}
	
	@Override
	public void setStaticImg(ArrayList al){
		staticimg = al;
	}
	
	@Override
	public void setCycleImg(ArrayList all,ArrayList alr){
		cycleimgLeft = all;
		cycleimgRight = alr;
	}
	
	@Override
	public ArrayList getCycleImg(int i){
		if(i == 0){
			return cycleimgLeft;
		} else if(i == 1){
			return cycleimgRight;
		}
		return null;
	}
	
}
