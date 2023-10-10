package _08final.mvc.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.ArrayList;
import _08final.mvc.model.Enemys.RedEnemy;
import _08final.mvc.model.Enemys.BlueEnemy;
import _08final.mvc.model.Enemys.YellowEnemy;

public class PhysicsTest {
    @Test
    public void testShipCollisionWithRedEnemy() {
        // Arrange
        Ship ship = new Ship(new Point(100, 100));
        RedEnemy redEnemy = new RedEnemy(new Point(100, 100), null, null);
        ArrayList<RedEnemy> redEnemies = new ArrayList<>();
        redEnemies.add(redEnemy);

        // Act
        boolean collisionRed = Physics.Collision(ship, redEnemies);

        // Assert
        Assertions.assertTrue(collisionRed, "Ship should collide with RedEnemy");
    }


    @Test
    public void testRedEnemyCollisionWithBullet() {
        // Arrange
        RedEnemy redEnemy = new RedEnemy(new Point(100, 100), null, null);
        Bullet bullet = new Bullet(new Point(100, 100), null);
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.add(bullet);

        // Act
        boolean collision = Physics.Collision(redEnemy, bullets);

        // Assert
        Assertions.assertTrue(collision, "RedEnemy should collide with Bullet");
    }

    @Test
    public void testRedEnemyCollisionWithShip() {
        // Arrange
        RedEnemy redEnemy = new RedEnemy(new Point(100, 100), null, null);
        Ship ship = new Ship(new Point(100, 100));

        // Act
        boolean collision = Physics.Collision(redEnemy, ship);

        // Assert
        Assertions.assertTrue(collision, "RedEnemy should collide with Ship");
    }
//----------------------------------------------------------------

    @Test
    public void testBlueEnemyCollisionWithBullet() {
        // Arrange
        BlueEnemy blueEnemy = new BlueEnemy(new Point(100, 100), null, null);
        Bullet bullet = new Bullet(new Point(100, 100), null);
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.add(bullet);

        // Act
        boolean collision = Physics.Collision(blueEnemy, bullets);

        // Assert
        Assertions.assertTrue(collision, "BlueEnemy should collide with Bullet");
    }

    @Test
    public void testBlueEnemyCollisionWithShip() {
        // Arrange
        BlueEnemy blueEnemy = new BlueEnemy(new Point(100, 100), null, null);
        Ship ship = new Ship(new Point(100, 100));

        // Act
        boolean collision = Physics.Collision(blueEnemy, ship);

        // Assert
        Assertions.assertTrue(collision, "BlueEnemy should collide with Ship");
    }

    //------------------------------------------

    @Test
    public void testYellowEnemyCollisionWithBullet() {
        // Arrange
        YellowEnemy yellowEnemy = new YellowEnemy(new Point(100, 100), null, null);
        Bullet bullet = new Bullet(new Point(100, 100), null);
        ArrayList<Bullet> bullets = new ArrayList<>();
        bullets.add(bullet);

        // Act
        boolean collision = Physics.Collision(yellowEnemy, bullets);

        // Assert
        Assertions.assertTrue(collision, "YellowEnemy should collide with Bullet");
    }

    @Test
    public void testYellowEnemyCollisionWithShip() {
        // Arrange
        YellowEnemy yellowEnemy = new YellowEnemy(new Point(100, 100), null, null);
        Ship ship = new Ship(new Point(100, 100));

        // Act
        boolean collision = Physics.Collision(yellowEnemy, ship);

        // Assert
        Assertions.assertTrue(collision, "YellowEnemy should collide with Ship");
    }

}
