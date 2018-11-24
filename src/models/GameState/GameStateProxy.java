/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gamestate;

import models.element.fighters.Fighter;
import models.element.explosives.Explosive;

/**
 *
 * @author antoine
 */

public class GameStateProxy extends AbstractModel
{
    Fighter fighter;
    
    GameState game;
    
    public GameStateProxy(Fighter pFighter,GameState pGameState)
    {
        this.fighter=pFighter;
        
        this.game=pGameState;
    }
    
    @Override
    public Object[][] getArena()
    {
        int len = this.game.getArena().length;
        
        Object[][] proxyMap = new Object[len][len];
        
        for(int y = 0; y < len; y++)
        {
            for(int x = 0; x < len; x++)
            {
                proxyMap[x][y] = this.game.getArena()[x][y];
            }
        }
        
        for(int y = 0; y < proxyMap.length; y++)
        {
            for(int x = 0; x < proxyMap.length; x++)
            {
               if(proxyMap[x][y] instanceof Explosive)
               {
                   if(this.fighter != ((Explosive)proxyMap[x][y]).getFighter())
                   {
                       proxyMap[x][y] = null;
                   }
               }
            }
        }
        
      
        return proxyMap;
    }
    
    public void display()
    {
        for(int y = 0; y < this.game.getArena().length; y++) 
            
        {
             for(int x = 0; x < this.game.getArena().length; x++) 
            {
                if(this.game.getArena()[x][y] instanceof Explosive)
                {
                    System.out.println(this.game.getArena()[x][y]+" in "+(x+","+y)); 
                }
                 
            }
        }
    }
}
