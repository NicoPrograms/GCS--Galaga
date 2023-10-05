package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.*;
import _08final.mvc.model.Enemys.Enemy;

public abstract class Level {
    PresentacionNaves presentacionNaves;
    Enemy enemy;
    public Level() {
    }
            public void setPresentacion(PresentacionNaves pn)
            {

                this.presentacionNaves = pn;
            }
            public void setEnemy(Enemy e)
            {

                this.enemy = e;
            }
            public void performMov(Game g, EnemyController e)
            {

                presentacionNaves.Movimiento(g, e);
            }
            public void EnemySpeed(Game g, EnemyController e)
            {
                for (Enemy en : e.getRed()) {
                    en.InSpeed();
                }
                for (Enemy en : e.getYellow()) {
                    en.InSpeed();
                }
                for (Enemy en : e.getBlue()) {
                    en.InSpeed();
                }
            }
            public void moverse(EnemyController e)
            {
                for (Enemy en : e.getBlue()) {
                    en.update();
                }
            }
}