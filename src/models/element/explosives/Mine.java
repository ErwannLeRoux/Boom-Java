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
public class Mine extends Explosive{

    public Mine(Fighter pFighter){
        super(pFighter);
        
        this.cost=5;
        this.damage=10;
    }
    
    public Mine(Fighter pFighter, int pCost, int pDamage) {
        super(pFighter, pCost, pDamage);
    }
}

