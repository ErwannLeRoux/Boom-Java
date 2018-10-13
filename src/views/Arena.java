/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Erwann
 */
public class Arena extends JFrame 
{
    public Arena()
    {             
        this.setTitle("Boom v2");
        this.setSize(900, 900);
        this.setLocationRelativeTo(null);               

        ImageIcon img = new ImageIcon("resources/img/iconeLogiciel.png");
        this.setIconImage(img.getImage());
        
        //Instanciation d'un objet JPanel
        JPanel pan = this.generateMap(20);     
        
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);               
        this.setVisible(true);
    }
    
    private JPanel generateMap(int rows)
    {
        JPanel map = new JPanel(new GridLayout(rows,rows));
        FighterView shooter = new ShooterView("resources/img/Secret_agent.jpg");
        shooter.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        map.add(shooter);
        for(int i = 1; i < (rows*rows); i++)
        {
            JPanel pane = new JPanel();
            pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
           
            map.add(pane);
        }
        return map;
    }
}
