package models.strategies.mapstrat;

import java.util.ArrayList;
import models.element.fighters.Fighter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class FightersInMiddle implements MapStrategy {

    int rangeBetweenFighters;
    
    public FightersInMiddle(int pNumber) {
        this.rangeBetweenFighters = pNumber;
    }
    
    @Override
    public void generateItems(Object[][] map, ArrayList<Fighter> f) {

    }
    
}