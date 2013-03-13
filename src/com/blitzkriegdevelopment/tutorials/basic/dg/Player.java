package com.blitzkriegdevelopment.tutorials.basic.dg;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

public class Player extends AbstractEntity implements IPlayer{
	
	public Player(Board brd, int yground, int cyclestart, int cycleend, String staticl, String staticr, String preleft, String preright, String suffix, int cyclespeed, int dir, int speed) {
		super(brd,yground,cyclestart,cycleend,staticl,staticr,preleft,preright,suffix,cyclespeed,dir,speed);
		
		_x=brd.getPlayerStartX();
		_y=brd.getPlayerStartY();
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
		if(_direction==1){
			_gfx = _cycleimgRight.get(curimgindex).getImage();
		} else if(_direction==0){
			_gfx = _cycleimgLeft.get(curimgindex).getImage();
		}
		curimgindex++;
		if(curimgindex == _cycleimgRight.size())curimgindex=0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			if(_direction==1){
				curimgindex=0;
				_direction=0;
			}
			if(_walkcycletimer.isRunning()){
			} else {_walkcycletimer.start();}
			if(_x <= _board.getLeftLimit())_board.setBgstatic(false);
			if(_board.getBgstatic()){
				_dx = -_speed;
			} else {
				_dx = 0;
			}
		}
		if(key == KeyEvent.VK_RIGHT){
			if(_direction==0){
				curimgindex=0;
				_direction=1;
			}
			if(_walkcycletimer.isRunning()){
			} else {_walkcycletimer.start();}
			if(_x >= _board.getRightLimit() && _board.getBgstatic())_board.setBgstatic(false);
			if(_board.getBgstatic()){
				_dx = _speed;
			} else {
				_dx = 0;
			}
		}
		if(key == KeyEvent.VK_SPACE){
			//limit _height of jump
			
			if(!_inair){
				_dy = -_jumpspeed;
				_inair=true;
			} else {
				if(_y>=_yground){
					_dy=_jumpspeed;
				} else {
					_dy=1;
				}
			}
		}
		// f key was pressed
		if(key == 70){
			BaseWeapon weap = new BaseWeapon(_x,_y,_direction);
			_board.addBullit(weap);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		_board.setBgstatic(true);
		if(key == KeyEvent.VK_LEFT){
			_dx = 0;
			if(_walkcycletimer.isRunning()){
				curimgindex=0;
				_gfx = _staticimg.get(0).getImage();
				_walkcycletimer.stop();
			} else {}
			if(_x <= _board.getLeftLimit() && _board.getBgstatic()){
				_x = _board.getLeftLimit()+1;
			}
		}
		if(key == KeyEvent.VK_RIGHT){
			System.out.println("RELEASED RIGHT");
			_dx = 0;
			if(_walkcycletimer.isRunning()){
				curimgindex=0;
				_gfx = _staticimg.get(1).getImage();
				_walkcycletimer.stop();
			} else {}
			if(_x >= _board.getRightLimit() && _board.getBgstatic()){
				_x = _board.getRightLimit()-1;
			}
			//_board.setBgstatic(true);
		}
		if(key == KeyEvent.VK_SPACE){
			if(_inair){
				//return to ground if not on ground
				if(_y!=_yground){
					_dy = 1;
				} else {
					_dy = 0;
				}
			} else {
				
			}
		}
	}

	public boolean isWalking() {
		return _walkcycletimer.isRunning();
	}
	
	
}
