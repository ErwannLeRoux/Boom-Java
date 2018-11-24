/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.gamestate.AbstractModel;
import models.gamestate.GameState;

/**
 *
 * @author Erwann
 */
public class IAController extends AbstractController {
    
    public IAController(AbstractModel model)
    {
        super(model);
    }
    
    public void nextButtonClicked()
    {
        GameState game = (GameState)this.model;
        game.playRandomIA();
    }
    
    
    
}
