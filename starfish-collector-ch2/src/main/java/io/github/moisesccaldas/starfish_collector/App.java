package io.github.moisesccaldas.starfish_collector;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import io.github.moisesccaldas.starfish_collector.core.StarfishCollectorGame;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Starfish Collector");
        configuration.setWindowedMode(1250, 1000);

        new Lwjgl3Application(new StarfishCollectorGame(), configuration);
    }
}
