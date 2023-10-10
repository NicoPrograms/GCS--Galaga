package _08final.mvc.model;

import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Enemys.RedEnemy;
import _08final.mvc.model.Enemys.YellowEnemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.Point;

public class AleatorioTest {

    @Test
    public void testMovimiento() {
        Game game = new Game();
        EnemyController enemyController = new EnemyController(game);
        Aleatorio aleatorio = new Aleatorio();

        // Llama al método Movimiento para generar enemigos
        aleatorio.Movimiento(game, enemyController);

        // Verifica que se hayan generado enemigos y se hayan agregado a las listas correspondientes
        Assertions.assertTrue(enemyController.getRed().size() > 0);
        Assertions.assertTrue(enemyController.getYellow().size() > 0);

        // Verifica que se hayan agregado enemigos a la lista de sprites del juego
        for (RedEnemy redEnemy : enemyController.getRed()) {
            Assertions.assertTrue(Game._sprites.contains(redEnemy));
        }
        for (YellowEnemy yellowEnemy : enemyController.getYellow()) {
            Assertions.assertTrue(Game._sprites.contains(yellowEnemy));
        }

        // Puedes seguir el mismo patrón para verificar BlueEnemy si lo necesitas.
    }
}
