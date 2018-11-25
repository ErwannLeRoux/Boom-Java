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

public abstract class Explosive{
    
    protected Fighter fighter;
    protected int cost;
    protected boolean visible;
    
    public Explosive(Fighter pFighter){

        this.fighter=pFighter;
    }
    
    public Explosive(Fighter pFighter, int pCost){
        this(pFighter);
        this.cost=pCost;
        this.visible=false;
    }

    public Fighter getFighter() {
        return fighter;
    }
    
    public int getCost()
    {
        return this.cost;
    }
    
    /*@Override
    public String toString(){
        String type;
        if(this instanceof Mine){
            type="Mine";
        }else{
            type="Bomb";
        }
        return "[Type"+this.fighter+","+this.cost+","+this.damage+"]"; 
    }*/
}

