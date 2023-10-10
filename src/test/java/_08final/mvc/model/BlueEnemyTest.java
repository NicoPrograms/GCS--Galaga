package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Explosion;
import _08final.sounds.Sound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;

public class BlueEnemyTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        // Inicializa la instancia de Game antes de cada prueba
        game = new Game();
    }

    @Test
    public void testInSpeed() {
        // Crea una instancia simulada de EnemyController
        EnemyController enemyController = new EnemyController(game);

        BlueEnemy blueEnemy = new BlueEnemy(new Point(100, 100), game, enemyController);

        // Registra la velocidad inicial
        double initialSpeed = blueEnemy.getSpeed();

        // Llama al método InSpeed para aumentar la velocidad
        blueEnemy.InSpeed();

        // Verifica que la velocidad se haya incrementado
        Assertions.assertTrue(blueEnemy.getSpeed() > initialSpeed);
    }
}
