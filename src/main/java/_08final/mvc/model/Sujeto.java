package _08final.mvc.model;

import _08final.mvc.view.GameObserver;
import _08final.mvc.controller.*;

public interface Sujeto {
    public void addObserver(GameObserver o);
    public void removeObserver(GameObserver o);
    public void Notify(int p, Game g);
    //public void notifyObserver();
    public void updatePoints(int p, Game g);
}
