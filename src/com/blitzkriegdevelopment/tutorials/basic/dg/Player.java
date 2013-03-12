package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener{
	private int x;
	private int y;
	private int yground;
	private int jumpspeed;
	private int dx;
	private int dy;
	private Image gfx;
	private String facing;
	private Board _board;
	private boolean inair;
	
	private ImageIcon playerimg;
	private ImageIcon iright;
	private ImageIcon ileft;
	private int jumplimit;
	
	private int dcount = 0;
	private int changeimgdelay = 50;
	private int curimg = 0;
	
	private Timer walkcycletimer;
	
	private ArrayList<ImageIcon> iwalkl = new ArrayList();
	private ArrayList<ImageIcon> iwalkr = new ArrayList();
	
	Player(Board brd) {
		
		walkcycletimer = new Timer(changeimgdelay,this);
		
		for(int i = 0; i < 9; i++){
			iwalkr.add(new ImageIcon(getClass().getResource("/r"+i+".png")));
		}
		for(int i = 0; i < 9; i++){
			iwalkl.add(new ImageIcon(getClass().getResource("/l"+i+".png")));
		}
		
		inair=false;
		_board = brd;
		playerimg = new ImageIcon();
		iright = new ImageIcon(getClass().getResource("/pstatic.png"));
		ileft = new ImageIcon(getClass().getResource("/pstaticback.png"));
		facing = "right";
		gfx = iright.getImage();
		x=10;
		y=122;
		jumplimit=y-70;
		jumpspeed = 2;
		yground=122;
	}
	
	public void move() {
		x = x+dx;
		y = y+dy;
		
		if(y == yground){
			dy = 0;
			inair = false;
		}
		if(y <= jumplimit){
			dy=1;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			if(facing.equals("right")){
				curimg=0;
				facing="left";
			}
			if(walkcycletimer.isRunning()){
			} else {walkcycletimer.start();}
			dx = -1;
		}
		if(key == KeyEvent.VK_RIGHT){
			if(facing.equals("left")){
				curimg=0;
				facing="right";
			}
			if(walkcycletimer.isRunning()){
			} else {walkcycletimer.start();}
			dx = 1;
		}
		if(key == KeyEvent.VK_SPACE){
			//limit height of jump
			if(!inair){
				dy = -jumpspeed;
				inair=true;
			} else {
				if(y>=yground){
					dy=jumpspeed;
				} else {
					dy=1;
				}
			}
		}
		// f key was pressed
		if(key == 70){
			BaseWeapon weap = new BaseWeapon(x,y,facing);
			_board.addBullit(weap);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			dx = 0;
			if(walkcycletimer.isRunning()){
				curimg=0;
				gfx = ileft.getImage();
				walkcycletimer.stop();
			} else {}
		}
		if(key == KeyEvent.VK_RIGHT){
			dx = 0;
			if(walkcycletimer.isRunning()){
				curimg=0;
				gfx = iright.getImage();
				walkcycletimer.stop();
			} else {}
		}
		if(key == KeyEvent.VK_SPACE){
			if(inair){
				//return to ground if not on ground
				if(y!=122){
					dy = 1;
				} else {
					dy = 0;
				}
			} else {
				
			}
		}
	}
	
	public int getX(){ return x; }
	public int getY(){ return y; }
	public Image getImage(){ return gfx; }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(facing.equals("right")){
			gfx = iwalkr.get(curimg).getImage();
		} else if(facing.equals("left")){
			gfx = iwalkl.get(curimg).getImage();
		}
		curimg++;
		if(curimg == iwalkr.size())curimg=0;
	}
	
}
