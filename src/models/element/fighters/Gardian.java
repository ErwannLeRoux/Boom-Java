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
public class Gardian extends Fighter {
    
    public Gardian(int pEnergy, String pName, int pNb_shield, int pNb_shot, int pNb_bomb, int pNb_mine, String pColor,FighterStrategy strat) {
        super(pEnergy, pName, pNb_shield, pNb_shot, pNb_bomb, pNb_mine,pColor,strat);
    }
    
    public Gardian(String pName,String pColor,FighterStrategy strat){
        super(pName,pColor,strat);
        this.energy = 100;
        this.nb_bomb=2;
        this.nb_mine=2;
        this.nb_shield=5;
        this.nb_shot=2;
    }
}
