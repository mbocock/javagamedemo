package com.blitzkriegdevelopment.tutorials.basic.dg;

public class PlayerBuilder {
	
	private Board _board;
	private int _yground = 122;
	private int _cyclestart = 0;
	private int _cycleend = 9;
	private int _cyclespeed = 60;
	private String _preleft = "l";
	private String _preright = "r";
	private String _cyclesuffix = ".png";
	private int _dir = 1;
	private String _staticleft = "pstaticback.png";
	private String _staticright = "pstatic.png";
	private int _speed = 1;
	
	public PlayerBuilder(Board brd) {
		_board = brd;
	}
	
	public Player buildPlayer(){
		return new Player(_board, _yground, _cyclestart, _cycleend, _staticleft, _staticright, _preleft, _preright, _cyclesuffix, _cyclespeed, _dir, _speed);
	}
	
	public PlayerBuilder board(Board brd) {
		_board = brd;
		return this;
	}
	
	public PlayerBuilder yground(int y) {
		_yground = y;
		return this;
	}
	
	public PlayerBuilder cyclestart(int c) {
		_cyclestart = c;
		return this;
	}
	
	public PlayerBuilder preleft(String pl) {
		_preleft = pl;
		return this;
	}
	
	public PlayerBuilder preright(String pr) {
		_preright = pr;
		return this;
	}
	
	public PlayerBuilder cyclesuffix(String cs) {
		_cyclesuffix = cs;
		return this;
	}
	
	public PlayerBuilder dir(int d) {
		_dir = d;
		return this;
	}
	
	public PlayerBuilder staticleft(String sl) {
		_staticleft = sl;
		return this;
	}
	
	public PlayerBuilder staticright(String sr) {
		_staticright = sr;
		return this;
	}
	
	public PlayerBuilder cyclespeed(int cs) {
		_cyclespeed = cs;
		return this;
	}
	
	public PlayerBuilder cycleend(int ce) {
		_cycleend = ce;
		return this;
	}
	
	public PlayerBuilder speed(int s) {
		_speed = s;
		return this;
	}
}
