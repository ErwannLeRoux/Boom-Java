/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gamestate;

import java.util.ArrayList;
import models.element.Element;
import models.element.fighters.Fighter;
import models.element.explosives.Explosive;

/**
 *
 * @author antoine
 */

public class GameStateProxy implements GetGameState
{
    Fighter fighter;
    
    GameState game;
    
    public GameStateProxy(Fighter pFighter,GameState pGameState)
    {
        this.fighter=pFighter;
        
        this.game=pGameState;
    }
    
    @Override
    public ArrayList<Explosive> getExplosive() 
    {
        ArrayList<Explosive> res = new ArrayList();
        for(Element[] ligne : game.getArena()){
            for(Element e:ligne){
                if(e instanceof Explosive){
                    if(((Explosive) e).getFighter()==this.fighter){
                        res.add((Explosive) e);
                    }
                }
            }
        }
        return res;   
    }    
}
