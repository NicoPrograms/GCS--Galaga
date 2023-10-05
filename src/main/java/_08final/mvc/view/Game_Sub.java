package _08final.mvc.view;

import _08final.mvc.controller.Game;
import _08final.mvc.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class Game_Sub implements Subject {

    private ArrayList observers;
    //private int health = Game.HEALTH;
    private boolean healthIncremented;
    private boolean shipLifeAdded;

    public Game_Sub() {
        observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer_ observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer_ observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer_ observer = (Observer_)observers.get(i);
            observer.update_(Game.HEALTH);
        }
    }

    @Override
    public void notifyObserversShipLife(int life, Game game){
        for (int i = 0; i < observers.size(); i++) {
            Observer_ observer = (Observer_)observers.get(i);
            observer.update_ShipLife(Game.shipLife, game);
        }
    }

    public void incrementHealth(int amount) {
        if (Game.getLevel() % 5 == 0 && !healthIncremented) {
            Game.HEALTH += amount;
            notifyObservers();
            healthIncremented = true;
        } else if (Game.getLevel() % 5 != 0) {
            healthIncremented = false;
        }
    }

    public int getHealth(){
        return Game.HEALTH;
    }

    public void incremetShipLife(int life, Game game){
        if(Game.getLevel() % 10 == 0 && !shipLifeAdded){
            Game.shipLife += life;
            //game.setLife(life);
            notifyObserversShipLife(life, game);
            shipLifeAdded = true;
        } else if (Game.getLevel() % 10 != 0) {
            shipLifeAdded = false;
        }
    }
}
