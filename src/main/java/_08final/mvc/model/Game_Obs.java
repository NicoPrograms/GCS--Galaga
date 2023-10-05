package _08final.mvc.model;

import _08final.mvc.controller.Game;
import _08final.mvc.view.Observer_;

public class Game_Obs implements Observer_ {

    private int health;
    private int life;
    private Game game;
    private Subject game_Sub;

    public Game_Obs(Subject game_Sub){
        this.game_Sub = game_Sub;
        game_Sub.addObserver(this);
    }

    @Override
    public void update_(int health) {
        this.health = health;
    }

    @Override
    public void update_ShipLife(int life, Game game) {
        this.life = life;
        this.game = game;
    }
}
