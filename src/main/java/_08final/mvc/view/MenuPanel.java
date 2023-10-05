package _08final.mvc.view;

import _08final.images.SpriteTexLoader;
import _08final.mvc.model.Sprite;
import _08final.mvc.controller.Game;
import _08final.sounds.Sound;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuPanel extends JPanel {
    private BufferedImage image;


    public MenuPanel() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        try {
            image = ImageIO.read(new File("src/main/java/_08final/images/Galaga.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mainMenu(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(image, 185, 60, 340, 180, null);
        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play: Hit P", 280, 270);
        g.drawString("Help: Hit H", 280, 370);
        g.drawString("Quit: Hit Q", 280, 470);
        g.drawString("Volumen", 280, 570);

    }

    public void helpMenu(Graphics g) {
        Font fnt1 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("Instruction", 295, 50);
        g.drawString("Space Bar: Launch Missile", 220, 130);
        g.drawString("Up arrow: Move up", 220, 200);
        g.drawString("Right arrow: Move right", 220, 270);
        g.drawString("Down arrow: Move down", 220, 340);
        g.drawString("Left arrow: Move up", 220, 410);
        g.drawString("I: Increase volume", 220, 480);
        g.drawString("D: Decrease volume", 220, 550);
        g.drawString("Esc: Return to Main", 220, 620);
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (Game.status == Game.STATUS.MENU) {
            mainMenu(g);
        } else if (Game.status == Game.STATUS.HELP) {
            helpMenu(g);
        }
    }
}
