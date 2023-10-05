package _08final.mvc.model;

import _08final.mvc.controller.Game;
import _08final.mvc.view.GameObserver;
import _08final.mvc.view.Observer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameManager implements Sujeto {
    private ArrayList<GameObserver> observers;
    private int puntaje;

    public GameManager() {
        puntaje = 0;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(GameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GameObserver o) {
        observers.remove(o);
    }

    @Override
    public void Notify(int p, Game game) {
        for (GameObserver observer : observers) {
            observer.onPoints(p, game);
        }
    }

    /*@Override
    public void notifyObserver() {
        for (GameObserver observer : observers) {
            observer.updateHealth();
        }
    }*/

    @Override
    public void updatePoints(int p, Game g) {
        puntaje += p;
        Notify(puntaje, g);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
