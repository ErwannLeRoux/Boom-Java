/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AbstractController;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.element.EnergyShard;
import models.element.Element;
import models.element.Wall;
import models.element.explosives.Bomb;
import models.element.explosives.Mine;
import models.element.fighters.Fighter;
import models.gamestate.AbstractModel;
import models.gamestate.GameState;
import models.utils.AnimationType;
import models.utils.Observer;

/**
 *
 * @author Erwann
 */
public class Arena extends JFrame implements Observer
{
    AbstractModel model;
    
    AbstractController controler;
    
    private String rep = "resources/imgs/";
    
    public Arena(AbstractModel model, AbstractController controler)
    {             
        this.model = model;
        
        this.controler = controler;
        
        this.setTitle("Boom v2");
        
        this.setSize(900, 900);
        
        this.setLocationRelativeTo(null);               

        ImageIcon img = new ImageIcon(rep+"wall.jpg");
        
        this.setIconImage(img.getImage());
                   
        this.setVisible(true);
    }
    
    private JPanel generateMapElement()
    {
        return null;
    }

    @Override
    public void update(AnimationType anim, Element e) {
        
        Element[][] map = ((GameState)this.model).getArena();
        
        int len = map.length;
        
        this.getContentPane().removeAll();
        JPanel grille = new JPanel(new GridLayout(len,len));
        
        for(int y = 0; y < len; y++) {
            for(int x = 0; x < len; x++) {
                
                JPanel pane = null;
                if(map[x][y] instanceof Fighter) {
                    
                   Fighter current = (Fighter) map[x][y];
                   if(anim == AnimationType.shoot && current.getColor().equals("Red"))
                   {
                        System.out.println("Anim");
                        pane = new CustomView(rep+current.getColor()+"/shoot"+current.getColor()+".png");     
                   } else {
                   pane = new CustomView(rep+current.getColor()+"/soldier"+current.getColor()+".png");
                   System.out.println(rep+current.getColor()+"/soldier"+current.getColor()+".png");
                   }
                } else if(map[x][y] instanceof Bomb) {
                   Bomb current = (Bomb) map[x][y];
                   
                   if(anim == AnimationType.bomb && current == e)
                   {
                        System.out.println("Anim");
                        pane = new CustomView(rep+"bomb_explosion.jpg");     
                   } else {
                   pane = new CustomView(rep+current.getFighter().getColor()+"/bomb"+current.getFighter().getColor()+".png");
                   }
                } else if(map[x][y] instanceof EnergyShard) {
                   pane = new CustomView(rep+"energyShard.jpg");
                } else if(map[x][y] instanceof Mine) {
                   Mine current = (Mine) map[x][y];
                   pane = new CustomView(rep+current.getFighter().getColor()+"/soldier"+current.getFighter().getColor()+".png");
                } else if(map[x][y] instanceof Wall) {
                   Wall current = (Wall) map[x][y]; 
                   if(current.getDestructible())
                   {
                    pane = new CustomView(rep+"wallDes.jpg");
                   } else {
                    pane = new CustomView(rep+"wall.jpg");  
                   }  
                } else {
                    pane = new CustomView(rep+"grass.jpg");
                }
                pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grille.add(pane);
            }
        }
        this.add(grille);
        
        this.revalidate();
        this.repaint();
    }
}
