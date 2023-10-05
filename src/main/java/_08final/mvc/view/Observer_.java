package _08final.mvc.view;

import _08final.mvc.controller.Game;

public interface Observer_ {
    public void update_(int heal);
    public void update_ShipLife(int life, Game game);
}
