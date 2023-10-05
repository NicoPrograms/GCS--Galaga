package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Enemys.RedEnemy;
import _08final.mvc.model.Enemys.YellowEnemy;
import java.awt.*;

public class Triangulo implements PresentacionNaves{

    @Override
    public void Movimiento(Game game, EnemyController e) {
        YellowEnemy YEnemy;
        RedEnemy REnemy;
        BlueEnemy BEnemy;

        int numRows = 4;  // Número de filas del triángulo
        int startX = 220;  // Posición inicial en el eje X
        int startY = 100;  // Posición inicial en el eje Y
        int spacingX = 70;  // Espaciado entre enemigos en el eje X
        int spacingY = 50;  // Espaciado entre enemigos en el eje Y

        for (int row = 0; row < numRows; row++) {
            int numEnemiesInRow = numRows - row;
            int rowX = startX + row * spacingX / 2;
            int rowY = startY + row * spacingY;

            for (int i = 0; i < numEnemiesInRow; i++) {
                REnemy = new RedEnemy(new Point(rowX + i * spacingX, rowY), game, e);
                e.addRedEnemy(REnemy);
                Game._sprites.add(REnemy);

                YEnemy = new YellowEnemy(new Point(rowX + i * spacingX, rowY + spacingY), game, e);
                e.addYellowEnemy(YEnemy);
                Game._sprites.add(YEnemy);

                BEnemy = new BlueEnemy(new Point(rowX + i * spacingX, rowY + 2 * spacingY), game, e);
                e.addBlueEnemy(BEnemy);
                Game._sprites.add(BEnemy);
            }
        }


    }

}
