/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Element.Explosives;
import models.Element.Fighters.Fighter;

/**
 *
 * @author antoine
 */
public class Mine extends Explosive{
    public Mine(int pX, int pY,Fighter pFighter){
        super(pX, pY, pFighter);
        this.cost=5;
        this.damage=10;
    }
    
    public Mine(int pX, int pY, Fighter pFighter, int pCost, int pDamage) {
        super(pX, pY, pFighter, pCost, pDamage);
    }
}

