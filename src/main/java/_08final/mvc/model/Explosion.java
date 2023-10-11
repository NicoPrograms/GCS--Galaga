package _08final.mvc.model;

import _08final.images.SpriteTexLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends Sprite {

    private final static Dimension EXPLOSION_DIM = new Dimension(50,90);

    public Explosion(Point initPos, BufferedImage texture) {
        super(initPos, EXPLOSION_DIM, texture);
    }

}
