package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Enemys.RedEnemy;
import _08final.mvc.model.Enemys.YellowEnemy;
import java.util.Random;
import java.awt.*;



public class Aleatorio implements PresentacionNaves{
    @Override
    public void Movimiento(Game game, EnemyController e) {
        YellowEnemy YEnemy;
        RedEnemy REnemy;
        BlueEnemy BEnemy;

        Random random = new Random();
        int areaWidth = 500;  // Ancho del área de generación aleatoria
        int areaHeight = 310;  // Alto del área de generación aleatoria

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(areaWidth);
            int y = random.nextInt(areaHeight);

            REnemy = new RedEnemy(new Point(x, y + 100), game, e);
            e.addRedEnemy(REnemy);
            Game._sprites.add(REnemy);

            YEnemy = new YellowEnemy(new Point(x, y + 50), game, e);
            e.addYellowEnemy(YEnemy);
            Game._sprites.add(YEnemy);

            BEnemy = new BlueEnemy(new Point(x, y), game, e);
            e.addBlueEnemy(BEnemy);
            Game._sprites.add(BEnemy);
        }

    }

}
