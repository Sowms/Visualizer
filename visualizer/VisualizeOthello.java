/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;

/**
 *
 * @author sowmya
 */
public class VisualizeOthello extends javax.swing.JFrame {
    /**
     * @param args the command line arguments which are ignored
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        VisualizeOthello v = new VisualizeOthello();
        v.setExtendedState(v.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        v.setTitle("Othello Visualizer");
        OthelloPanel op = new OthelloPanel(new String[]{""});
        v.add(op);
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] moves = new String[200];
        int i = 0;
        Thread.sleep(1000);
        try (BufferedReader br = new BufferedReader(new FileReader(new File("game.log")))) {
            String line;
            while ((line = br.readLine()) != null) {
                moves[i] = line;
                System.out.println(line);
                op.config = moves;
                v.repaint();
                Thread.sleep(2000);
                i++;
            }
        } catch (Exception e) {
            
        }
    }
    
}