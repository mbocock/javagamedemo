package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player extends AbstractEntity implements ActionListener,IPlayer{

	@Override
	public void move() {
		x = x+dx;
		y = y+dy;
		
		if(y == yground){
			dy = 0;
		}
		if(y <= jumpmax){
			dy=1;
		}
	}

	@Override
	public int getHealth() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getMaxLife() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setHealth(int h) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setMaxLife(int ml) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			if(facing==1){
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

	@Override
	public void keyReleased(KeyEvent e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int getYground() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void setYground(int y) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	
}
