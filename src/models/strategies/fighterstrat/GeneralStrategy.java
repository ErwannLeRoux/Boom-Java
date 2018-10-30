
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Erwann
 */
public abstract class GeneralStrategy implements FighterStrategy {
 
    protected double move;
    protected double shot;
    protected double shield;
    protected double mine;
    protected double bomb;
            
    public GeneralStrategy(double move, double shot, double shield, double bomb, double mine)
    {
        this.move = move;
        this.shot = shot;
        this.shield = shield;
        this.bomb = bomb;
        this.mine = mine;
    }
    
    /**
     * Tirage aleatoire de l'action a realiser selon les ratios de chaque action
     * @return 
     *  Retourne l'action a realiser
     */
    @Override
    public Actions doAction() {
        Random r = new Random();
        double random = 0.0 + r.nextDouble() * (1.0 - 0.0);
        System.out.println(random);
        if(random <= this.move)
        {
            return Actions.move;
        } else if(random <= this.move+this.shot) {
            return Actions.shot;
        } else if(random <= this.move+this.shot+this.shield) {
            return Actions.shield;
        } else if(random <= this.move+this.shot+this.shield+this.bomb) {
            return Actions.mine;
        } else {
            return Actions.bomb;
        } 
    }
    
    /*@Override
    public Actions doAction(String objs, String stuff)
    {
        return Actions.nothing;
    }*/
            
}
