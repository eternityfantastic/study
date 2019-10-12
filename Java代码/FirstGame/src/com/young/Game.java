package com.young;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JFrame {
    //photo
    public BufferedImage photo1;

    {
        try {
            photo1 = ImageIO.read(Game.class.getResource("hero2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建窗口；
        JFrame jframe = new JFrame("窗口名");
        jframe.setSize(100,200);
        jframe.setVisible(true);
        //创建面板；
        Panel panel = new Panel();
        //面板加到窗口上
        jframe.add(panel);
        //重画
        jframe.repaint();
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(photo1,100,100,null);
        //super.paint(g);
    }
}
