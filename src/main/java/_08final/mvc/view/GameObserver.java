package _08final.mvc.view;

import _08final.mvc.controller.Game;
import _08final.mvc.model.GameManager;
import _08final.mvc.controller.EnemyController;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameObserver implements Observer {
    GameManager gameManager;
    int vidas;
    Game game;

    public GameObserver(GameManager gm, Game game) {
        vidas = Game.shipLife;
        this.gameManager = gm;
        gm.addObserver(this);
        this.game = game;
    }

    @Override
    public void onGameOver() {
    }

    @Override
    public void onPoints(int s, Game g) {
        int puntaje = gameManager.getPuntaje();
        puntaje += s;
        gameManager.setPuntaje(puntaje);

        if (puntaje > 2000) {
            int vidasActuales = g.getLife();
            g.setLife(vidasActuales + 1);
            puntaje = 0;
        }
    }

    /*@Override
    public void updateHealth() {
        if (Game.getLevel() % 4 == 0) {
            int currentLife = Game.HEALTH;
            int amountToIncrease = 20;
            Game.HEALTH = Game.HEALTH + amountToIncrease;

        }
    }*/
}
