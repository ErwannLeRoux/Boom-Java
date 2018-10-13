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
public abstract class Fighter {
    
    protected int energy;
    
    protected float armor;
    
    protected ArrayList<Weapons> weapons;
    
    public Fighter(int pEnergy, float pArmor)
    {
        this.weapons = new ArrayList();
        this.energy = pEnergy;
        this.armor = pArmor;
        this.generateWeapons();
        this.weapons.add(Weapons.shield);
    }
    
    protected abstract void generateWeapons();
}
