/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Element.Explosives;
import models.Element.Element;
import models.Element.Fighters.Fighter;

/**
 *
 * @author antoine
 */

public abstract class Explosive extends Element{
    protected Fighter fighter;
    protected int cost;
    protected int damage;
    protected boolean visible;
    
    public Explosive(int pX,int pY,Fighter pFighter){
        this.x=pX;
        this.y=pY;
        this.fighter=pFighter;
    }
    
    public Explosive(int pX,int pY,Fighter pFighter, int pCost,int pDamage){
        this(pX,pY,pFighter);
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

