package models.factories;

import models.fighters.Fighter;
import models.fighters.Wizard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Erwann
 */
public class WizardFactory extends FighterFactory {

    @Override
    protected Fighter createGardian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Fighter createShooter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Fighter createWizard() {
        return new Wizard(1,1);
    }
    
}
