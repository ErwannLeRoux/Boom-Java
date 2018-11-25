/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element.fighters;

import java.util.HashMap;
import models.strategies.fighterstrat.FighterStrategy;

/**
 *
 * @author Erwann
 */
public class Shooter extends Fighter {
    
    public Shooter(int pEnergy, String pName, int pNb_shot, int pNb_bomb, int pNb_mine, String pColor,FighterStrategy strat) {
        super(pEnergy, pName, pNb_shot, pNb_bomb, pNb_mine, pColor,strat);
    }
    
    public Shooter(String pName,String pColor, HashMap<String,Integer> pParameter,FighterStrategy strat){
        this(pName,pColor,strat);
        this.energy = pParameter.get("energy");
        this.nb_mine = pParameter.get("nb_mine");
        this.nb_bomb = pParameter.get("nb_bomb");
        this.nb_shot = pParameter.get("nb_shot");
    }
     
    public Shooter(String pName,String pColor,FighterStrategy strat){
        super(pName,pColor,strat);
        this.energy = 80;
        this.nb_bomb=2;
        this.nb_mine=2;
        this.shield=false;
        this.nb_shot=5;
    }
}
