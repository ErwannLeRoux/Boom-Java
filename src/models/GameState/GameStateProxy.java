/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.GameState;

import java.util.ArrayList;
import models.Element.Element;
import models.Element.Fighters.Fighter;
import models.Element.Explosives.Explosive;

/**
 *
 * @author antoine
 */

public class GameStateProxy implements GetGameState{
    Fighter fighter;
    GameState game;
    
    public GameStateProxy(Fighter pFighter,GameState pGameState){
        this.fighter=pFighter;
        this.game=pGameState;
    }
    
    @Override
    public ArrayList<Explosive> getExplosive() {
                ArrayList<Explosive> res=new ArrayList();
        for(Element[] ligne:game.arena){
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
