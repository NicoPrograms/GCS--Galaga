package _08final.mvc.model.Enemys;

import _08final.mvc.controller.*;
import _08final.mvc.model.Sprite;

public interface Enemy {
    void InSpeed();
    void SacarMasVida(Game game, EnemyController e);
    void update();

}
