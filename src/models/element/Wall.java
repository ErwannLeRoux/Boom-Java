/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.element;

/**
 *
 * @author antoine
 */
public class Wall extends Element{
    
    boolean destructible;
   
    public Wall(int pX,int pY,boolean destructible) {
        this.x=pY;
        this.y=pX;
        this.destructible = destructible;   
    }
    
    public boolean getDestructible()
    {
        return this.destructible;
    }
}
