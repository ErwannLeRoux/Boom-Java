package models.strategies.fighterstrat;

import models.utils.Actions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe permettant de creer une strategie selon des ratios parametres et un choix intelligent des actions.
 * Par exemple si aucun adversaire n'est dans la ligne de mir on ne tirera pas ou bien si on a plus de munitions on ne tirer
 * pas
 * @author Erwann
 */
public class CustomStrategy implements FighterStrategy {
    
    public CustomStrategy() {
 
    }

    @Override
    public Actions doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
