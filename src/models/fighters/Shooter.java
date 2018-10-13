/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fighters;

import java.util.ArrayList;
import models.weapons.Weapons;

/**
 *
 * @author Erwann
 */
public class Shooter extends Fighter {
    
    public Shooter(int pEnergy, float pArmor) {
        super(pEnergy, pArmor);
    }

    @Override
    protected void generateWeapons() {
        this.weapons.add(Weapons.gun);
    }
    
}
