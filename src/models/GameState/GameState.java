/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.GameState;

import models.Element.Explosives.Explosive;
import java.util.ArrayList;
import models.Element.Element;
import models.Element.Explosives.Mine;
import models.Element.Fighters.*;
import models.factories.FighterFactory;

/**
 *
 * @author antoine
 */
public class GameState implements GetGameState{
    ArrayList<Fighter> fighterList;
    Element[][] arena;

    public GameState(){
        this.arena = new Element[3][3];
        fighterList = new ArrayList();
        FighterFactory myfactory;
        myfactory = new FighterFactory();
        Fighter f1=myfactory.createFighter("Gandalf", 0, 0, 'B');
        Fighter f2=myfactory.createFighter("Gandalf2", 0, 0, 'B');
        Explosive ex1 = new Mine(1,1,f1);
        this.arena[1][0] = ex1;
        fighterList.add(f1);
        fighterList.add(f2);
    }
    
    /*public generateArena(ArrayList<Strategy> strat)
    {
        
    }*/
    
    @Override
    public ArrayList<Explosive> getExplosive(){
        ArrayList<Explosive> res=new ArrayList();
        for(Element[] ligne:this.arena){
            for(Element e:ligne){
                if(e instanceof Element){
                    res.add((Explosive) e);
                }
            }
        }
        
        return res;
    }
    
    public ArrayList<Fighter> getFighter()
    {
        return this.fighterList;
    }
    
    /*public void addElement(Element e, int x, int y){
        arena[y][x]=e;
        e.setX(x);
        e.setY(y);
    }*/
}
