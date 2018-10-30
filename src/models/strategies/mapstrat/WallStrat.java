/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class WallStrat implements MapStrategy {

    int wallNumber;
    
    public WallStrat(int pNumber) {
       this.wallNumber = pNumber; 
    }
    
    @Override
    public void generateItems(Element[][] map) {

    }
    
}