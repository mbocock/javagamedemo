package com.blitzkriegdevelopment.tutorials.basic.dg;

public abstract class AbstractKeyEvent implements IKeyEvent{
	protected Player p;
	protected Board b;
	public AbstractKeyEvent(Player p) {
		this.p = p;
		this.b = p.getBoard();
	}
}
