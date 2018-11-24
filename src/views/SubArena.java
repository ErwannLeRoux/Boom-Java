/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.element.EnergyShard;
import models.element.Wall;
import models.element.explosives.Bomb;
import models.element.explosives.Mine;
import models.element.fighters.Bomber;
import models.element.fighters.Fighter;
import models.element.fighters.Gardian;
import models.element.fighters.Shooter;
import models.utils.Actions;

/**
 *
 * @author Erwann
 */
public class SubArena extends JPanel {
    
    private Object[][] map;
    
    private String rep = "resources/imgs/";
    
    public SubArena(Object[][] map)
    {
        this.map = map;
        
        this.setLayout(new GridLayout(map.length,map.length));
    }
    
    public void paintSubArena(Actions.Action anim,Object e)
    {
        this.removeAll();
        
        for(int y = 0; y < map.length; y++) {
            
            for(int x = 0; x < map.length; x++) {
                
                String currentClass = "";
                //Dessin des Fighters
                JPanel pane = new JPanel();
                
                if(map[x][y] instanceof Fighter) {
                    
                    if(map[x][y] instanceof Bomber)
                    {
                        currentClass ="Bomber/";
                    } else if(map[x][y] instanceof Gardian)
                    {
                        currentClass ="Gardian/";
                    } if(map[x][y] instanceof Shooter) {
                        currentClass ="Shooter/";
                    }
                    
                   Fighter current = (Fighter) map[x][y];
                   
                   if(anim == Actions.Action.shoot && current.getColor().equals(((Fighter)e).getColor()))
                   {
                       System.out.println("shoot");
                        pane = new CustomView(rep+currentClass+current.getColor()+"/shoot"+current.getColor()+".png");     
                   } else {
                       
                        pane = new CustomView(rep+currentClass+current.getColor()+"/soldier"+current.getColor()+".png");
                   }
                } else if(map[x][y] instanceof Bomb) {
                   Bomb current = (Bomb) map[x][y];
                   
                   if(anim == Actions.Action.bomb && current == e)
                   {
                        pane = new CustomView(rep+"Bomb/bomb_explosion.jpg");     
                   } else {
                    
                   pane = new CustomView(rep+"Bomb/bomb"+current.getFighter().getColor()+".png");
                   }
                } else if(map[x][y] instanceof EnergyShard) {
                   pane = new CustomView(rep+"energyShard.png");
                } else if(map[x][y] instanceof Mine) {
                   Mine current = (Mine) map[x][y];
                   pane = new CustomView(rep+current.getFighter().getColor()+"/soldier"+current.getFighter().getColor()+".png");
                } else if(map[x][y] instanceof Wall) {
                   Wall current = (Wall) map[x][y]; 
                   if(current.getDestructible())
                   {
                    pane = new CustomView(rep+"Wall/wallDes.jpg");
                   } else {
                    pane = new CustomView(rep+"Wall/wall.jpg");  
                   }  
                } else {
                    pane = new CustomView(rep+"grass.jpg");
                }

                this.add(pane);
            }
        }    
    }
    
    public void setMap(Object[][] newMap)
    {
        this.map = newMap;
    }
}
