/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boom;

import controllers.AbstractController;
import controllers.IAController;
import models.gamestate.AbstractModel;
import models.gamestate.GameState;
import views.Arena;


/**
 *
 * @author Erwann
 */
public class Boom {

    private static final int players = 4;
    
    private static final int rowsOrCols = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Instanciation du modele
        AbstractModel game = new GameState(rowsOrCols,players);
        
        // Instanciation du Controlleur
        AbstractController controler = new IAController(game);
        
        // Instanciation de la vue
        Arena arena = new Arena(game,controler);
        
        ((GameState)game).addObserver(arena);
        
        ((GameState)game).playRandomIA();
    }
    
}
