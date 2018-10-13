/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boom;

import models.factories.FighterFactory;
import models.factories.GardianFactory;
import models.fighters.Fighter;
import views.Arena;

/**
 *
 * @author Erwann
 */
public class Boom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FighterFactory gardianFactory = new GardianFactory();
        Fighter gardian = gardianFactory.getGardian();
        
        Arena arena = new Arena();
    }
    
}
