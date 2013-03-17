package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends AbstractEntity implements IPlayer{
	
	private ArrayList<IKeyEvent> keyevents = new ArrayList();
	
	public Player(Board brd, int yground, int cyclestart, int cycleend, String staticl, String staticr, String preleft, String preright, String suffix, int cyclespeed, int dir, int speed, int jumpcycle,String jumpright, String jumpleft) {
		super(brd,yground,cyclestart,cycleend,staticl,staticr,preleft,preright,suffix,cyclespeed,dir,speed,jumpcycle,jumpright,jumpleft);
		
		_x=brd.getPlayerStartX();
		_y=brd.getPlayerStartY();
		
		AbstractKeyEvent kright = new KeyRight(this);
		AbstractKeyEvent kleft = new KeyLeft(this);
		AbstractKeyEvent kspace = new KeySpace(this);
		AbstractKeyEvent kf = new KeyF(this);
		addKeyEvent(kright);
		addKeyEvent(kleft);
		addKeyEvent(kspace);
		addKeyEvent(kf);
	}
	
	public void addKeyEvent(IKeyEvent ike){
		keyevents.add(ike);
	}
	public void removeKeyEvent(IKeyEvent ike) {
		keyevents.remove(ike);
	}

	@Override
	public void move() {
		_x = _x+_dx;
		_y = _y+_dy;
		if(_x >= _board.getRightLimit() && _board.getBgstatic()){
			_board.setBgstatic(false);
			_dx=0;
		}
		if(_x <= _board.getLeftLimit() && _board.getBgstatic()){
			_board.setBgstatic(false);
			_dx=0;
		}
		if(_y == _yground){
			_dy = 0;
			_inair = false;
		}
		if(_y <= _yground-_jumplimit){
			_dy=1;
		}
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
            
            if(_inair){
                if(_direction==1){
			_gfx = _jumpcycleimgRight.get(curimgindexjump).getImage();
		} else if(_direction==0){
			_gfx = _jumpcycleimgLeft.get(curimgindexjump).getImage();
		}
		curimgindex++;
		if(curimgindexjump == _jumpcycleimgRight.size())curimgindexjump=0;
            }
            else{
                if(_direction==1){
			_gfx = _cycleimgRight.get(curimgindex).getImage();
		} else if(_direction==0){
			_gfx = _cycleimgLeft.get(curimgindex).getImage();
		}
		curimgindex++;
		if(curimgindex == _cycleimgRight.size())curimgindex=0;
            }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0; i < keyevents.size(); i++){
			IKeyEvent ike = keyevents.get(i);
			ike.pressAction(key);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i=0; i < keyevents.size(); i++){
			IKeyEvent ike = keyevents.get(i);
			ike.releaseAction(key);
		}
		_board.setBgstatic(true);
	}
	
}
