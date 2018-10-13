/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.factories;

import models.fighters.Fighter;

/**
 *
 * @author Erwann
 */
public abstract class FighterFactory {
    
    public Fighter getGardian()
    {
        return createGardian();
    }
    
    public Fighter getShooter()
    {
        return createShooter();
    }
    
    public Fighter getWizard()
    {
        return createWizard();
    }
    
    protected abstract Fighter createGardian();
    protected abstract Fighter createShooter();
    protected abstract Fighter createWizard();
}
