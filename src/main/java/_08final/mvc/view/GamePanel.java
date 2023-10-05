package _08final.mvc.view;

import _08final.images.SpriteTexLoader;
import _08final.mvc.controller.EnemyController;
import _08final.mvc.controller.Game;
import _08final.mvc.model.Explosion;
import _08final.mvc.model.Sprite;
import _08final.mvc.model.Ship;
import _08final.sounds.Sound;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.*;
import java.util.Scanner;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;


import javax.sound.sampled.Clip;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class GamePanel extends JPanel {

    private Game game;
    private ArrayList<Integer> score;
    private MenuPanel menuPanel = new MenuPanel();
    private int i = 1;
    private int currentLevel = 1;
    private int rectangulo=150;


    public GamePanel() {
        this.setPreferredSize(GameFrame.FRAME_DIM);
    }

    //--------------------------

    //-------------------------------------

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int currentLevel = game.getLevel();

        if (currentLevel == 1) {
            g.drawImage(SpriteTexLoader.load(SpriteTexLoader.SpriteTex.BACKGROUND), 0, 0,
                    GameFrame.FRAME_DIM.width, GameFrame.FRAME_DIM.height, this);
        } else if (currentLevel == 2) {
            g.drawImage(SpriteTexLoader.load(SpriteTexLoader.SpriteTex.BACKGROUND), 0, 0,
                    GameFrame.FRAME_DIM.width, GameFrame.FRAME_DIM.height, this);
        } else if (currentLevel == 3) {
            g.drawImage(SpriteTexLoader.load(SpriteTexLoader.SpriteTex.BACKGROUND), 0, 0,
                    GameFrame.FRAME_DIM.width, GameFrame.FRAME_DIM.height, this);
        }
        else if (currentLevel == 4) {
            g.drawImage(SpriteTexLoader.load(SpriteTexLoader.SpriteTex.BACKGROUND2), 0, 0,
                    GameFrame.FRAME_DIM.width, GameFrame.FRAME_DIM.height, this);
        }
        else if (currentLevel > 4) {
            g.drawImage(SpriteTexLoader.load(SpriteTexLoader.SpriteTex.BACKGROUND2), 0, 0,
                    GameFrame.FRAME_DIM.width, GameFrame.FRAME_DIM.height, this);
        }


        ArrayList<Sprite> sprites = Game.getDrawableSprites();

        for (Sprite sprite : sprites) {
            if (Game.status == Game.STATUS.MENU) {
                menuPanel.mainMenu(g);
                g.setColor(Color.white);
                //volumen
                g.fillRect(280, 620, rectangulo, 30);
            } else if (Game.status == Game.STATUS.HELP) {
                menuPanel.helpMenu(g);
            } else if (Game.status == Game.STATUS.GAME_OVER) {
                Font fnt2 = new Font("Matura MT Script Capitals", Font.ITALIC, 80);
                g.setFont(fnt2);
                g.setColor(Color.red);
                g.drawString("Game Over!", 130, 350);
                Font fnt4 = new Font("Courier New", Font.ITALIC, 30);
                g.setFont(fnt4);
                g.setColor(Color.lightGray);
                g.drawString("Play again?", 280, 450);
                g.drawString("Y/N", 330, 500);
                try {
                    int s = Game.score;
                    if (i == 1) {
                        FileWriter fw = new FileWriter("src/main/java/_08final/mvc/view/score.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String st = Integer.toString(s);
                        bw.append("\n" + st);
                        bw.close();
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    score = new ArrayList<>();
                    File inputFile = new File("src/main/java/_08final/mvc/view/score.txt");
                    Scanner in = new Scanner(inputFile);
                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        int num = Integer.parseInt(line);
                        score.add(num);
                    }
                    Collections.sort(score, Collections.reverseOrder());
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int gap = 135;
                for (int i = 0; i < score.size(); i++) {
                    g.drawString("" + score.get(i), 5, gap);
                    gap += 20;
                }

                Font originalFont = g.getFont();
                Color originalColor = g.getColor();
                g.drawString("Health: ", 5, 20);
                Font scoreFont = new Font("Impact", Font.BOLD, 25);
                g.setFont(scoreFont);
                g.setColor(Color.RED);
                g.drawString("SCORE: " + game.getScore(), 290, 30);
                g.setFont(originalFont);
                g.setColor(originalColor);
                Font LifeFont = new Font("Arial", Font.BOLD, 20);
                g.setFont(LifeFont);
                g.drawString("Ship Life: " + game.getLife(), 5, 80);
                g.setFont(originalFont);
                g.drawString("Score List: ", 5, 110);
                Font LevelFont = new Font("Courier New", Font.BOLD, 15);
                g.setFont(LevelFont);
                g.drawString("LEVEL " + game.getLevel(), 600, 20);
                g.setFont(originalFont);
                //g.drawString("HIGH SCORE" ,310, 20);
                //g.setColor(Color.gray);
                //g.fillRect(5, 25, 100, 25);
                g.setColor(Color.green);
                g.fillRect(5, 25, game.HEALTH, 25);
                //g.setColor(Color.white);
                //g.drawRect(5, 25, 100, 25);

                sprite.draw(g);
            }
        }

        // Mostrar mensaje de nivel si corresponde
        /*if (Game.status == Game.STATUS.GAME && currentLevel >= 1) {
            showLevelMessage(g, currentLevel);
            currentLevel++;
        }*/
    }


    public void setRec(int p)
    {
        this.rectangulo+=p;
    }
    public int getRec()
    {
        return rectangulo;
    }

    /*private void showLevelMessage(Graphics g, int level) {
        Font levelFont = new Font("Arial", Font.BOLD, 40);
        g.setFont(levelFont);
        g.setColor(Color.white);
        g.drawString("Level " + level, 200, 400);  // Cambia "Level 2" por el mensaje que desees mostrar
    }*/
}