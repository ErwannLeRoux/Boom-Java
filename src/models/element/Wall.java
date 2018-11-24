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
public class Wall{
    
    private boolean destructible;
    private int hp;
   
    public Wall(boolean destructible) {

        this.destructible = destructible;   
        if(destructible)
        {
            this.hp = 50;
        }
    }
    
    public boolean getDestructible()
    {
        return this.destructible;
    }
    
    public int getHp()
    {
        return this.hp;
    }
}
