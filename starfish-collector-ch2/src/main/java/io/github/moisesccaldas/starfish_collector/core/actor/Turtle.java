package io.github.moisesccaldas.starfish_collector.core.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Turtle extends ActorBeta {
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		if (Gdx.input.isKeyPressed(Keys.A)) this.moveBy(-2, 0);
		if (Gdx.input.isKeyPressed(Keys.D)) this.moveBy(2, 0);
		if (Gdx.input.isKeyPressed(Keys.W)) this.moveBy(0, 2);
		if (Gdx.input.isKeyPressed(Keys.S)) this.moveBy(0, -2);
	}
}
