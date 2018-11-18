/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.factories;
import models.element.fighters.Shooter;
import models.element.fighters.Gardian;
import models.element.fighters.Bomber;
import models.element.fighters.Fighter;

/**
 *
 * @author Erwann
 */
public class FighterFactory {
    public FighterFactory(){
        
    }
    
    public Fighter createFighter(char type, int pEnergy ,String pName,int pNb_shield,int pNb_shot,int pNb_bomb,int pNb_mine,String pColor){
        switch (type){
            case 'G' : return new Gardian(pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine,pColor);
            case 'S' : return new Shooter(pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine,pColor);
            case 'B' : return new Bomber(pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine,pColor);
        }
        return null;
    }
    
    public Fighter createFighter(String pName, char type,String pColor){
        switch (type){
            case 'G' : return new Gardian(pName,pColor);
            case 'S' : return new Shooter(pName,pColor);
            case 'B' : return new Bomber(pName,pColor);
        }
        return null;
    }
}
