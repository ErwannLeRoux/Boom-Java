/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.factories;

import models.fighters.Fighter;
import models.fighters.Gardian;

/**
 *
 * @author Erwann
 */
public class GardianFactory extends FighterFactory{

    @Override
    protected Fighter createGardian() {
        return new Gardian(1,1);
    }

    @Override
    protected Fighter createShooter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Fighter createWizard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
