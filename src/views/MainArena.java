/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.gamestate.GameState;
import models.utils.Actions;
import models.utils.JTableModel;
import models.utils.Observer;

/**
 *
 * @author Erwann
 */
public class MainArena extends JFrame implements Observer{
    
    private JButton bNext;
    private JTableModel JTablemodel ;
    private JTable jTable;
    private GameState model;
    
    public MainArena(JTableModel fL,GameState model){
        super();
        this.bNext    = new JButton("next");
        
        this.JTablemodel =fL;
        this.model = model;
        
        
        dessiner();
        
        
    }
    
    
    private void dessiner(){

        this.setTitle("Tir au Tour");
        this.setMinimumSize(new Dimension(1000, 700));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().add(this.bNext,BorderLayout.SOUTH);
        
        jTable = new JTable(this.JTablemodel);
        jTable.setSize(10, 10);
        
        JScrollPane js = new JScrollPane(jTable);
        js.setPreferredSize(new Dimension(350, 300));
      
        this.getContentPane().add(js,BorderLayout.EAST);
        
        this.setVisible(true);
        
    }

    @Override
    public void update(Actions.Action anim, Object e) {
        System.out.println(this.model);
        jTable.setModel(new JTableModel(this.model.getFighters()));
        jTable.revalidate();
        jTable.repaint();
    }
    
    
}
