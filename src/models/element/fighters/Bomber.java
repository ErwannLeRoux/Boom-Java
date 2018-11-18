/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element.fighters;


/**
 *
 *
 */
public class Bomber extends Fighter {
    public Bomber(int pEnergy, String pName, int pNb_shield, int pNb_shot, int pNb_bomb, int pNb_mine, String pColor) {
        super(pEnergy, pName, pNb_shield, pNb_shot, pNb_bomb, pNb_mine,pColor);
    }
    
    public Bomber(String pName,String pColor){
        super(pName,pColor);
        this.energy = 80;
        this.nb_bomb=5;
        this.nb_mine=5;
        this.nb_shield=2;
        this.nb_shot=2;
    }
}
