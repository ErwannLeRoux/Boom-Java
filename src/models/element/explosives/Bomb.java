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
    public Bomb(Fighter pFighter){
        super(pFighter);
        this.cost=5;
        this.damage=20;
    }
    
    public Bomb(Fighter pFighter, int pCost, int pDamage) {
        super(pFighter, pCost, pDamage);
    }
}
