package models.strategies.mapstrat;

import java.util.Random;
import models.element.Element;
import models.element.EnergyShard;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class EnergyStrat implements MapStrategy {

    int energyNb;
    
    public EnergyStrat(int pNumber)
    {
        this.energyNb = pNumber;
    }
    //Ici on va placer des pastilles d'energies aleatoirement sur la map
    @Override
    public Element[][] generateItems(Element[][] map) {
        Random r = new Random();
        Element[][] tmp = map;
        int x = 0,y = 0;
        int cpt = 0;
        
        while(cpt != this.energyNb)
        {   
            x = 0 + r.nextInt(map.length - 0);
            y = 0 + r.nextInt(map.length - 0);
            if(tmp[x][y] == null)
            {
               tmp[x][y] = new EnergyShard(); 
               cpt++;
            } 
        }
        return tmp;
    }
    
    
}
