/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fighters;

import models.weapons.Weapons;

/**
 *
 * @author Erwann
 */
public class Gardian extends Fighter {
    
    public Gardian(int pEnergy, float pArmor) {
        super(pEnergy, pArmor);
    }

    @Override
    protected void generateWeapons() {
        this.weapons.add(Weapons.sword);
    }
    
}
