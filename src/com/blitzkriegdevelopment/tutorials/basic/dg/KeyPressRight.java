package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.KeyEvent;

public class KeyPressRight implements IKeyEvent{
	
	private Player p;
	
	public KeyPressRight(Player p){
		this.p = p;
	}
	
	public void pressAction(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			System.out.println("Testing right key press");
			if(p.getDirection()==0){
				p.setCurimgindex(0);
				p.setDirection(1);
			}
			if(p.isWalking()){
			} else {p.startWalking();}
			Board b = p.getBoard();
			if(p.getX() >= b.getRightLimit() && b.getBgstatic())b.setBgstatic(false);
			if(b.getBgstatic()){
				p.setDx(p.getSpeed());
			} else {
				p.setDx(0);
			}
		}
	}
}
