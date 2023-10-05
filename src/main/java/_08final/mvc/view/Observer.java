package _08final.mvc.view;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface Observer {
    public void onGameOver();
    public void onPoints(int p, Game game);
    //public void updateHealth();
}
