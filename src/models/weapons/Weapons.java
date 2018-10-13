/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.weapons;

/**
 *
 * @author Erwann
 */
 public enum Weapons
    {

        gun(10,0.5f,100),
        magic_wand(5,0.25f,500),
        shield(1,0.95f,50),
        sword(3,0.80f,200),
        knife(2,0.15f,750);
        
        private final int range;
        private final float accuracy;
        private final int damages;
        
        Weapons(int pRange, float pAccuracy, int pDamages)
        {
            this.range = pRange;
            this.accuracy = pAccuracy;
            this.damages = pDamages;
        }
    }
    
   
