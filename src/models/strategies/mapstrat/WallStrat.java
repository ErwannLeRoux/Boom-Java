
package models.strategies.mapstrat;

import java.util.Random;
import models.element.Element;
import models.element.Wall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class WallStrat implements MapStrategy {

    private int wallNumber;
    
    private int nbdestructibles;
    
    public WallStrat(int pNumber, int nbdestructibles) {
       this.wallNumber = pNumber; 
       this.nbdestructibles = nbdestructibles;
    }
    
    @Override
    public Element[][] generateItems(Element[][] map) {
        Random r = new Random();
        Element[][] tmp = map;
        int x = 0,y = 0;
        int cpt = 0;
        // Murs Indestructibles
        while(cpt != this.wallNumber)
        {
           x = 0 + r.nextInt(map.length - 0);
           y = 0 + r.nextInt(map.length - 0);
           if(map[x][y] == null)
           {
               tmp[x][y] = new Wall(x,y,false); 
               cpt++;
           } 
        } 
        // Murs Destructibles
        cpt = 0;
        while(cpt != this.nbdestructibles)
        {
           x = 0 + r.nextInt(map.length - 0);
           y = 0 + r.nextInt(map.length - 0);
           if(map[x][y] == null)
           {
               tmp[x][y] = new Wall(x,y,true); 
               cpt++;
           } 
        } 
        
        return tmp;
    }   
}