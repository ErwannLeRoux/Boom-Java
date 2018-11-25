/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element.explosives;

import models.element.fighters.Fighter;

/**
 *
 * @author antoine
 */
public class Bomb extends Explosive{
    
    private int nbTour;
    
    public Bomb(Fighter pFighter){
        super(pFighter);
        this.cost = 5;
        this.nbTour = 3;
    }
    
    public Bomb(Fighter pFighter, int pCost, int nbtour) {
        super(pFighter, pCost);
        this.nbTour = nbtour;
    }
    
    public void addTour()
    {
        this.nbTour--;
    }
    
    public int getTour()
    {
        return this.nbTour;
    }
}
