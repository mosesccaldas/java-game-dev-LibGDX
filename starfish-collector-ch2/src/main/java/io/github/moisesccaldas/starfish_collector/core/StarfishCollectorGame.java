package io.github.moisesccaldas.starfish_collector.core;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import io.github.moisesccaldas.starfish_collector.core.actor.ActorBeta;
import io.github.moisesccaldas.starfish_collector.core.actor.Shark;
import io.github.moisesccaldas.starfish_collector.core.actor.Turtle;

public class StarfishCollectorGame extends GameBeta {

	private ActorBeta ocean;
	private Turtle turtle;
	private ActorBeta starfish;
	private ActorBeta winMessage;
	private ActorBeta gameover;
	private List<Shark> sharks;
	
	private boolean win;
	
	@Override
	void initialize() {
		sharks = new ArrayList<Shark>();
		
		ocean = new ActorBeta();
		ocean.setTexture(new Texture(Gdx.files.classpath("assets/ocean.jpg")));
		mainStage.addActor(ocean);
		
		starfish = new ActorBeta();
		starfish.setTexture(new Texture(Gdx.files.classpath("assets/estrela.png")));
		starfish.setPosition(1100, 900);
		mainStage.addActor(starfish);
		
		turtle = new Turtle();
		turtle.setTexture(new Texture(Gdx.files.classpath("assets/tartaruga.png")));
		mainStage.addActor(turtle);
		
		Shark shark1 = new Shark(5, 0);
		shark1.setTexture(new Texture(Gdx.files.classpath("assets/shark.png")));
		shark1.setPosition(0, Gdx.graphics.getHeight() * 0.8f);
		mainStage.addActor(shark1);
		
		Shark shark2 = new Shark(5, 0);
		shark2.setTexture(new Texture(Gdx.files.classpath("assets/shark.png")));
		shark2.setPosition(0, Gdx.graphics.getHeight() * 0.4f);
		mainStage.addActor(shark2);
		
		Shark shark3 = new Shark(0, 5);
		shark3.setTexture(new Texture(Gdx.files.classpath("assets/shark.png")));
		shark3.setPosition(Gdx.graphics.getWidth() * 0.8f, 0);
		mainStage.addActor(shark3);
		
		Shark shark4 = new Shark(0, 5);
		shark4.setTexture(new Texture(Gdx.files.classpath("assets/shark.png")));
		shark4.setPosition(Gdx.graphics.getWidth() * 0.4f, 0);
		mainStage.addActor(shark4);
		
		Shark shark5 = new Shark(5, 4);
		shark5.setTexture(new Texture(Gdx.files.classpath("assets/shark.png")));
		shark5.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		mainStage.addActor(shark5);
		
		sharks.add(shark1);
		sharks.add(shark2);
		sharks.add(shark3);
		sharks.add(shark4);
		sharks.add(shark5);
		
		winMessage = new ActorBeta();
		winMessage.setTexture(new Texture(Gdx.files.classpath("assets/youwin.png")));
		winMessage.setVisible(false);
		winMessage.setPosition((Gdx.graphics.getWidth() - winMessage.getWidth())/2, (Gdx.graphics.getHeight() - winMessage.getHeight())/2);
		mainStage.addActor(winMessage);
		
		gameover = new ActorBeta();
		gameover.setTexture(new Texture(Gdx.files.classpath("assets/gameover.png")));
		gameover.setVisible(false);
		gameover.setPosition((Gdx.graphics.getWidth() - gameover.getWidth())/2, (Gdx.graphics.getHeight() - gameover.getHeight())/2);
		mainStage.addActor(gameover);
		
		win = false;
	}

	@Override
	void update(float dt) {
		
		if (turtle.overlaps(starfish)) {
			turtle.remove();
			starfish.remove();
			winMessage.setVisible(true);
			win = true;
		}
		
		for (Shark shark: sharks) {
			if (!win && turtle.overlaps(shark)) {
				turtle.remove();
				starfish.remove();
				gameover.setVisible(true);
			}
		}
	}
}
