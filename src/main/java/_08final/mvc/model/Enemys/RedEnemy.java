package _08final.mvc.model.Enemys;

import _08final.images.SpriteTexLoader;
import _08final.mvc.controller.Game;
import _08final.mvc.controller.EnemyController;
import _08final.mvc.model.Explosion;
import _08final.mvc.model.Physics;
import _08final.mvc.model.Sprite;
import _08final.sounds.Sound;

import java.awt.*;

public class RedEnemy extends Sprite implements Enemy {

    private double speed = 100.0;
    private Game game;
    private EnemyController c;
    private double xv;

    private final static Dimension ENEMY_DIM = new Dimension(20,30);

    public RedEnemy(Point initPos, Game game, EnemyController c) {
        super(initPos, ENEMY_DIM, SpriteTexLoader.load(SpriteTexLoader.SpriteTex.RED_FIGHTER));
        this.game = game;
        this.c = c;
    }

    @Override
    public void InSpeed() {
        this.speed += 50;
    }

    public void tick(long deltaTime, RedEnemy TempEnemy) {
        final double MILS_TO_SECS = 0.001f;
        double deltaTimeInSecs = deltaTime * MILS_TO_SECS;

        int y = getY()+(int)(speed * deltaTimeInSecs);
        if (y > 800) {
            y = 0;
        }
        TempEnemy.setY(y);

        if (Physics.Collision(this, c.getBullet())) {
            Game.e1 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.EN_EX1));
            Game.e2 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.EN_EX2));
            Game.e3 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.EN_EX3));
            Game.e4 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.EN_EX4));
            Game.e5 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.EN_EX5));

            c.addEx(Game.e1);
            c.addEx(Game.e2);
            c.addEx(Game.e3);
            c.addEx(Game.e4);
            c.addEx(Game.e5);

            c.removeRedEnemy(this);
            c.removeBullet(c.getBullet().get(0));
        }

        if (Physics.Collision(this, game.mShip)) {
            c.removeRedEnemy(this);
            String s = "/_08final/sounds/explosion.wav";
            Sound.playSound(s);
            Game.f1 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.FI_EX1));
            Game.f2 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.FI_EX2));
            Game.f3 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.FI_EX3));
            Game.f4 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.FI_EX4));
            Game.f5 = new Explosion(new Point(this.getX(), this.getY()), SpriteTexLoader.load(SpriteTexLoader.SpriteTex.FI_EX5));

            c.addEx(Game.f1);
            c.addEx(Game.f2);
            c.addEx(Game.f3);
            c.addEx(Game.f4);
            c.addEx(Game.f5);

            Game.HEALTH -= 50;

            if (Game.shipLife <= 0) {
                Game.status = Game.STATUS.GAME_OVER;
            }

            if (Game.HEALTH <= 0) {
                Game.shipLife -= 1;
                Game._sprites.remove(game.mShip);
            }
        }
    }
    public double getSpeed()
    {
        return speed;
    }
    public Dimension getSize()
    {
        return ENEMY_DIM;
    }
    public double getXV() {
        return xv;
    }

    public void setXV(double xv) {
        this.xv = xv;
    }
    @Override
    public void SacarMasVida(Game game, EnemyController e) {
        game.HEALTH -=100;
    }

    @Override
    public void update() {
    }
}
