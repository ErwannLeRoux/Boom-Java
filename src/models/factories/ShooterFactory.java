/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.factories;

import models.fighters.Fighter;
import models.fighters.Shooter;

/**
 *
 * @author Erwann
 */
public class ShooterFactory extends FighterFactory {

    @Override
    protected Fighter createGardian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Fighter createShooter() {
        return new Shooter(1,1);
    }

    @Override
    protected Fighter createWizard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
