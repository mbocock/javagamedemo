package com.blitzkriegdevelopment.tutorials.basic.dg;

public class KeyF extends AbstractKeyEvent{
	
	public KeyF(Player p) {
		super(p);
	}
	
	@Override
	public void pressAction(int key) {
		if(key == 70){
			BaseWeapon weap = new BaseWeapon(p.getX(),p.getY(),p.getDirection());
			b.addBullit(weap);
		}
	}

	@Override
	public void releaseAction(int key) {
		//nothing here yet
	}

}
