/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element.fighters;

import models.strategies.fighterstrat.FighterStrategy;

/**
 *
 * @author Erwann
 */

public abstract class Fighter {
    protected int energy;      
    protected String name;     
    protected int nb_bomb;            
    protected int nb_shield;           
    protected int nb_shot;            
    protected int nb_mine;  
    protected String color;
    protected FighterStrategy strat;
    //protected FitherStrategy behavior;
   
    public Fighter(int pEnergy,String pName,int pNb_shield,int pNb_shot,int pNb_bomb,int pNb_mine,String pColor,FighterStrategy pStrat){
        this(pName,pColor,pStrat);
        this.energy = pEnergy;
        this.nb_bomb=pNb_bomb;
        this.nb_mine=pNb_mine;
        this.nb_shield=pNb_shield;
        this.nb_shot=pNb_shot;
    }
    
    public Fighter(String pName,String pColor,FighterStrategy strat){
        this.name=pName;
        this.color = pColor;
        this.strat = strat;
    }
    
    public FighterStrategy getStrat()
    {
        return this.strat;
    }
    
    public String getColor()
    {
        return this.color;
    }
    
    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }

    public int getNb_bomb() {
        return nb_bomb;
    }

    public int getNb_mine() {
        return nb_mine;
    }

    public int getNb_shield() {
        return nb_shield;
    }

    public int getNb_shot() {
        return nb_shot;
    }

    public void setEnergy(int energy) {
        if(energy < this.getEnergy())
        {
            System.out.println("OUTCH !! I took damages");
        }
        this.energy = energy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNb_bomb(int nb_bomb) {
        this.nb_bomb = nb_bomb;
    }

    public void setNb_mine(int nb_mine) {
        this.nb_mine = nb_mine;
    }

    public void setNb_shot(int nb_shot) {
        this.nb_shot = nb_shot;
    }

    public void setNb_shield(int nb_shield) {
        this.nb_shield = nb_shield;
    }  
}