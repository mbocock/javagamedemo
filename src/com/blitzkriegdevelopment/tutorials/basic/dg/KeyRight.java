package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.KeyEvent;

public class KeyRight extends AbstractKeyEvent{
	
	public KeyRight(Player p) {
		super(p);
	}
	
	public void pressAction(int key) {
		if(key == KeyEvent.VK_RIGHT){
			if(p.getDirection()==0){
				p.setCurimgindex(0);
				p.setDirection(1);
			}
			if(p.isWalking() && !p._inair ){
			} else {p.startWalking();}
			Board b = p.getBoard();
			if(b.getBgstatic()){
				p.setDx(p.getSpeed());
			} else {
				p.setDx(0);
			}
		}
	}
	
	public void releaseAction(int key ) {
		if(key == KeyEvent.VK_RIGHT){
			p.setDx(0);
			if(p.isWalking()){
				p.setCurimgindex(0);
				p.setGFX(p.getStaticimg().get(1).getImage());
				p.stopWalking();
			} else {}
			if(p.getX() >= b.getRightLimit() && !b.getBgstatic()){
				p.setX(b.getRightLimit()-1);
			}
		}
	}
}
