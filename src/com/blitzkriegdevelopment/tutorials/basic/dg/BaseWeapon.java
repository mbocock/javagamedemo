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
	private String facing;
	private Image basebullit;
	private int speed=2;
	private int width = 9;
	private int height = 8;
	
	BaseWeapon(int nx, int ny, String face){
		ImageIcon i = new ImageIcon(getClass().getResource("/bullet.png"));
		basebullit = i.getImage();
		facing=face;
		startx=nx;
		starty=ny;
		
		if(facing.equals("right")){
			x = nx + (offsetx+10);
		} else if(facing.equals("left")){
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
		if(facing.equals("right")){
			x+=speed;
		} else if(facing.equals("left")){
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
