/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element.explosives;

import models.element.Element;
import models.element.fighters.Fighter;

/**
 *
 * @author antoine
 */

public abstract class Explosive extends Element{
    
    protected Fighter fighter;
    protected int cost;
    protected int damage;
    protected boolean visible;
    
    public Explosive(Fighter pFighter){

        this.fighter=pFighter;
    }
    
    public Explosive(Fighter pFighter, int pCost,int pDamage){
        this(pFighter);
        this.cost=pCost;
        this.damage=pDamage;
        this.visible=false;
    }

    public Fighter getFighter() {
        return fighter;
    }
    
    @Override
    public String toString(){
        String type;
        if(this instanceof Mine){
            type="Mine";
        }else{
            type="Bomb";
        }
        return "[Type"+this.fighter+","+this.cost+","+this.damage+"]"; 
    }
}

