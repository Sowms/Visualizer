/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizer;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Visualizer extends JFrame {

    /**
     * @param args the command line arguments which are ignored
     */
    public static void main(String[] args) {
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
        Visualizer v = new Visualizer();
        v.setExtendedState(v.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        v.setTitle("N Queens Visualizer");
        v.add(new VisualizePanel(new int[]{2,4,1,3}));
        v.setVisible(true);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
