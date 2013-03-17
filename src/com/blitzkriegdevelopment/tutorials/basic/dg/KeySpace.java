package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.KeyEvent;

public class KeySpace extends AbstractKeyEvent{
	
	public KeySpace(Player p) {
		super(p);
	}

	@Override
	public void pressAction(int key) {
		if(key == KeyEvent.VK_SPACE){
			//limit _height of jump
			if(!p.inAir()){
                            System.out.println("Jump");
				p.setDy(-p.getJumpspeed());
				p.setInAir(true);
			} else {
				if(p.getY()>=p.getYground()){
					p.setDy(p.getJumpspeed());
				} else {
					p.setDy(1);
				}
			}
                        
                        if(p.isJumping()){
			} 
                        else {
                            p.startJumping();
                        }
//			Board b = p.getBoard();
			
//                        if(b.getBgstatic()){
//				p.setDx(p.getSpeed());
//			} else {
//				p.setDx(0);
//			}
		}
	}

	@Override
	public void releaseAction(int key) {
		if(key == KeyEvent.VK_SPACE){
			if(p.inAir()){
				//return to ground if not on ground
				if(p.getY()!=p.getYground()){
					p.setDy(1);
				} else {
					p.setDy(0);
				}
			} else {
				
			}
		}
	}
	
}
