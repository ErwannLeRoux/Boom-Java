/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class EnergyStrat implements MapStrategy {

    int energyStrat;
    
    public EnergyStrat(int pNumber)
    {
        this.energyStrat = pNumber;
    }
    //Ici on va placer des pastilles d'energies aleatoirement sur la map
    @Override
    public void generateItems(Element[][] map) {

    }
    
    
}
