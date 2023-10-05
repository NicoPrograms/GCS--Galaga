package _08final.mvc.model;

import _08final.mvc.controller.Game;
import _08final.mvc.view.Observer_;

public interface Subject {

    public void addObserver(Observer_ observer);

    public void removeObserver(Observer_ observer);

    public void notifyObservers();

    public void notifyObserversShipLife(int life, Game game);

}
