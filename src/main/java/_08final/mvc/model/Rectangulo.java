package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Enemys.RedEnemy;
import _08final.mvc.model.Enemys.YellowEnemy;

import java.awt.*;

public class Rectangulo implements PresentacionNaves {
    YellowEnemy YEnemy;
    RedEnemy REnemy;
    BlueEnemy BEnemy;
    @Override
    public void Movimiento(Game game, EnemyController e) {

        for (int n = 2; n < 4; n++) {
            if (n == 2) {
                int x = 100;
                int y = 50;
                for (int i = 0; i < 7; i++) {
                    REnemy = new RedEnemy(new Point(x, 100), game,e);
                    e.addRedEnemy(REnemy);
                    Game._sprites.add(REnemy);
                    YEnemy = new YellowEnemy(new Point(x, 50), game, e);
                    e.addYellowEnemy(YEnemy);
                    Game._sprites.add(YEnemy);
                    BEnemy = new BlueEnemy(new Point(x, 0), game, e);
                    e.addBlueEnemy(BEnemy);
                    Game._sprites.add(BEnemy);
                    x += 70;
                    y += 70;
                }
            }

        }
    }


}
