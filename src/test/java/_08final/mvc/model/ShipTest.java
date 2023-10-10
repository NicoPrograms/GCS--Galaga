package _08final.mvc.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;

public class ShipTest {

    @Test
    public void testMoveLeft() {
        Ship ship = new Ship(new Point(0,0));
        ship.moveLeft(1);
        Assertions.assertEquals(-ship.getS(), ship.getVelx(), 0.001);
    }

    @Test
    public void testMoveRight() {
        Ship ship = new Ship(new Point(0,0));
        ship.moveRight(1);
        Assertions.assertEquals(ship.getS(), ship.getVelx(), 0.001);
    }

    @Test
    public void testMoveDown() {
        Ship ship = new Ship(new Point(0,0));
        ship.moveDown(1);
        Assertions.assertEquals(ship.getS(), ship.getVelY(), 0.001);
    }

    @Test
    public void testMoveUp() {
        Ship ship = new Ship(new Point(0,0));
        ship.moveUp(1);
        Assertions.assertEquals(-ship.getS(), ship.getVelY(), 0.001);
    }
    @Test
    public void testSetVelX() {
        Ship ship = new Ship(new Point(0, 0));
        ship.setVelX(1.0);
        Assertions.assertEquals(300.0, ship.getVelx(), 0.001);
    }

    @Test
    public void testSetVelY() {
        Ship ship = new Ship(new Point(0, 0));
        ship.setVelY(-1.0);
        Assertions.assertEquals(-300.0, ship.getVelY(), 0.001);
    }

}
