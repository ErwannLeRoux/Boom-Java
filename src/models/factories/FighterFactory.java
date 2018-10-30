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
    
    public Fighter createFighter(char type ,int pX,int pY, int pEnergy ,String pName,int pNb_shield,int pNb_shot,int pNb_bomb,int pNb_mine){
        switch (type){
            case 'G' : return new Gardian(pX,pY,pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine);
            case 'S' : return new Shooter(pX,pY,pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine);
            case 'B' : return new Bomber(pX,pY,pEnergy,pName,pNb_shield,pNb_shot,pNb_bomb,pNb_mine);
        }
        return null;
    }
    
    public Fighter createFighter(String pName,int pX,int pY, char type){
        switch (type){
            case 'G' : return new Gardian(pX,pY,pName);
            case 'S' : return new Shooter(pX,pY,pName);
            case 'B' : return new Bomber(pX,pY,pName);
        }
        return null;
    }
}
