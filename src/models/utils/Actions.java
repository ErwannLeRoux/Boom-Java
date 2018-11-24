

package models.utils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public class Actions {
    
    public enum Action {
        shoot,
        move,
        shield,
        mine,
        bomb,
        nothing,
        heal
    }
    
    private Direction dir;
    
    private Action action;
    
    public Actions(Action action,Direction dir)
    {
        this.dir = dir;
        this.action = action;
    }
    
    public Action getAction()
    {
        return this.action;
    }
    
    
}
