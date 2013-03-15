package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.KeyEvent;

public class KeyLeft extends AbstractKeyEvent{
	
	public KeyLeft(Player p) {
		super(p);
	}

	@Override
	public void pressAction(int key) {
		if(key == KeyEvent.VK_LEFT){
			if(p.getDirection()==1){
				p.setCurimgindex(0);
				p.setDirection(0);
			}
			if(p.isWalking()){
			} else {p.startWalking();}
			if(b.getBgstatic()){
				p.setDx(-p.getSpeed());
			} else {
				p.setDx(0);
			}
		}
	}

	@Override
	public void releaseAction(int key) {
		if(key == KeyEvent.VK_LEFT){
			p.setDx(0);
			if(p.isWalking()){
				p.setCurimgindex(0);
				p.setGFX(null);
				p.setGFX(p.getStaticimg().get(0).getImage());
				p.stopWalking();
			} else {}
			if(p.getX() <= b.getLeftLimit() && !b.getBgstatic()){
				System.out.println("Left released, setting player above board's leftLimit");
				p.setX(b.getLeftLimit()+1);
			}
		}
	}

}
