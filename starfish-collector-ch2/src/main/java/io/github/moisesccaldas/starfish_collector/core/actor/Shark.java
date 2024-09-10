package io.github.moisesccaldas.starfish_collector.core.actor;

import com.badlogic.gdx.Gdx;

public class Shark extends ActorBeta {
	
	private float moveX;
	private float moveY;

	public Shark(float moveX, float moveY) {
		super();
		this.moveX = moveX;
		this.moveY = moveY;
	}

	@Override
	public void act(float dt) {
		super.act(dt);
		
		float newX = getX() + moveX;
		float newY = getY() + moveY;
		
		if (newX < 0 || newX > (Gdx.graphics.getWidth() - getWidth())) moveX = -moveX;
		if (newY < 0 || newY > (Gdx.graphics.getHeight() - getHeight())) moveY = -moveY;
		
		this.moveBy(moveX, moveY);
	}
}
