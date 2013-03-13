package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class BaseWeapon {
	
	private int startx;
	private int starty;
	private int x;
	private int y;
	private int offsetx = 25;
	private int offsety = 10;
	private int direction;
	private Image basebullit;
	private int speed=2;
	private int width = 9;
	private int height = 8;
	
	BaseWeapon(int nx, int ny, int dir){
		ImageIcon i = new ImageIcon(getClass().getResource("/bullet.png"));
		basebullit = i.getImage();
		direction=dir;
		startx=nx;
		starty=ny;
		
		if(direction==1){
			x = nx + (offsetx+10);
		} else if(direction==0){
			x = nx - (offsetx-15);
		}
		y = ny + offsety;
		fireProjectile();
	}
	
	public void fireProjectile(){
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public int getX() {
		if(direction==1){
			x+=speed;
		} else if(direction==0){
			x-=speed;
		}
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return basebullit;
	}
	
}
