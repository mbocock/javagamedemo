package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Enemy {
	private int x;
	private int y;
	private int yground;
	private int dx;
	private int dy;
	private Image gfx;
	private boolean inair;
	private int width = 84;
	private int height = 85;
	
	private ImageIcon enemyimg;
	private int jumplimit;
	private String facing;
	private int jumpspeed;
	private int movespeed;;
	
	private ArrayList<ImageIcon> iwalkl = new ArrayList();
	private ArrayList<ImageIcon> iwalkr = new ArrayList();
	
	Enemy(Board brd,int speed) {
		movespeed=speed;
		dx=speed;
		enemyimg = new ImageIcon(getClass().getResource("/enemy.png"));
		facing = "left";
		gfx = enemyimg.getImage();
		x=820;
		y=122;
		jumplimit=y-70;
		jumpspeed = 2;
		yground=122;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public void move() {
		x = x-dx;
		y = y+dy;
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public Image getImage(){ return gfx; }
	
}
