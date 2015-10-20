/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class VisualizePanel extends JPanel {
    int[] config;
    public VisualizePanel(int[] config) {
        this.config = config;
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int startX = 100, startY = 100;
        //chessboard
        for (int i = 0; i < config.length; i++) 
            for (int j = 0; j < config.length; j++) {
                int x = startX + (i * 50);
                int y = startY + (j * 50);
                if ( (i + j) % 2 == 0)
                    g2.setColor(Color.white);
                else
                    g2.setColor(Color.black);
                Rectangle2D rect= new Rectangle2D.Double(x,y,50,50);
                g2.draw(rect);
                g2.fill(rect);
            }
        //config
        for (int i = 0; i < config.length; i++) {
            int row = i;
            int col = config[i] - 1;
            int x = startX + (row * 50) + 25;
            int y = startY + (col * 50) + 25;
            Ellipse2D ellipse = new Ellipse2D.Double(x-10, y-10, 20, 20);
            g2.setColor(Color.gray);
            g2.draw(ellipse);
            g2.fill(ellipse);
        }
        
    }
}
