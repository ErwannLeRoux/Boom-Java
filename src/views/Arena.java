/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AbstractController;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.element.EnergyShard;
import models.element.Wall;
import models.element.explosives.Bomb;
import models.element.explosives.Mine;
import models.element.fighters.Bomber;
import models.element.fighters.Fighter;
import models.element.fighters.Gardian;
import models.element.fighters.Shooter;
import models.gamestate.AbstractModel;
import models.utils.Actions;
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
        
        this.setSize(300, 300);
        
        this.setLocationRelativeTo(null);               

        ImageIcon img = new ImageIcon(rep+"wall.jpg");
        
        this.setIconImage(img.getImage());
                   
        this.setVisible(true);
    }
    
    
    @Override
    public void update(Actions.Action anim, Object e) {

        Object[][] map = this.model.getArena();
        
        int len = map.length;
        
        this.getContentPane().removeAll();
        JPanel grille = new JPanel(new GridLayout(len,len));
        
        for(int y = 0; y < len; y++) {
            for(int x = 0; x < len; x++) {
                
                JPanel pane = null;
                String currentClass = "";
                //Dessin des Fighters
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
                //pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grille.add(pane);
            }
        }
        this.add(grille);
        
        this.revalidate();
        this.repaint();
    }
    
    
}
