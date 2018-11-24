/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gamestate;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import models.element.EnergyShard;
import models.element.Wall;
import models.element.explosives.Bomb;
import models.element.explosives.Explosive;
import models.element.explosives.Mine;
import models.element.fighters.*;
import models.factories.FighterFactory;
import models.strategies.fighterstrat.AgressiveStrategy;
import models.strategies.fighterstrat.BalancedStrategy;
import models.strategies.fighterstrat.DefensiveStrategy;
import models.strategies.fighterstrat.FighterStrategy;
import models.strategies.mapstrat.EnergyStrat;
import models.strategies.mapstrat.MapStrategy;
import models.strategies.mapstrat.WallStrat;
import models.utils.Actions;
import models.utils.AvailableColors;
import models.utils.Coord;
import models.utils.Direction;
import models.utils.Observable;
import models.utils.Observer;
import models.utils.SoundPlayer;

/**
 *
 * @author antoine
 */
public class GameState extends AbstractModel implements GetGameState, Observable
{
    
    private Object[][] arena;
    
    private ArrayList<Observer> obs;
    
    private FighterFactory factory;
    
    private ArrayList<Fighter> fighterList;
    
    private int rows;
    
    private AvailableColors colors;
    
    private SoundPlayer player;
    
    public GameState(int rows)
    {
        this.colors = new AvailableColors();
        
        this.player = new SoundPlayer();
                
        this.arena = new Object[rows][rows];
        
        this.fighterList = new ArrayList();

        this.factory = new FighterFactory();
        
        this.obs = new ArrayList();
       
        
        this.rows = rows;
    }
    
    public void playRandomIA()
    {
        MapStrategy strat = new WallStrat(10,5);
        MapStrategy stratEnergy = new EnergyStrat(2);
        
        FighterStrategy balanced = new BalancedStrategy();
        FighterStrategy ag = new AgressiveStrategy();
        FighterStrategy def = new DefensiveStrategy();
        
        strat.generateItems(arena,this.fighterList);
        stratEnergy.generateItems(arena,this.fighterList);
        colors.getColorsAvailable();
        Fighter f1 = this.factory.createFighter("Arthur",'S', "Red",ag); 
        Fighter f2 = this.factory.createFighter("Arthur",'S', "Blue",ag);  
        Fighter f3 = this.factory.createFighter("Arthur",'S', "Green",ag);  
        Fighter f4 = this.factory.createFighter("Arthur",'S', "Yellow",ag);  
        Explosive b1 = new Bomb(f1);
        Explosive b2 = new Bomb(f2);
        Explosive b3 = new Bomb(f3);
        Explosive b4 = new Bomb(f4);
        
        
        this.arena[1][0] = f1;
        this.arena[2][0] = f2;
        this.arena[3][0] = f3;
        this.arena[4][0] = f4;
        
        this.arena[1][1] = b1;
        this.arena[1][2] = b2;
        this.arena[1][3] = b3;
        this.arena[1][4] = b4;
        

        this.notifyObserver(Actions.Action.nothing,f1);
        
        while(true) {
            Random r = new Random();
            int whichFighter = r.nextInt(4 + 1 - 1) + 1; 
            Fighter current = null;
            switch(whichFighter)
            {
                case 1:
                    current = f1;
                    break;
                case 2:
                    current = f2;
                    break;
                case 3:
                    current = f3;
                    break;
                case 4:
                    current = f4;
                    break;
            }
            
            System.out.println("Fighter f"+whichFighter+" has to play");
            
           
            Coord currentCoord = this.getElementPosition(current);
            Actions ac = current.getStrat().doAction();
            
            switch(ac.getAction()) 
            {
                case bomb:
                    System.out.println("Je pose une bombe");
                    break;
                case move:
                    int moveX = r.nextInt(1 + 1 + 1) - 1; 
                    System.out.println("move X : "+moveX);
                    int moveY = r.nextInt(1 + 1 + 1) - 1; 
                    System.out.println("move Y : "+moveY);
                    this.checkMoveFighter(current,new Coord(currentCoord.getX()+moveX,currentCoord.getY()+moveY));    
                    break;
                case shoot:
                    int chooseDir = r.nextInt(4 + 1 - 1) + 1; 
                   
                    switch(chooseDir)
                    {
                        case 1:
                            this.shoot(current,Direction.UP);
                             System.out.println("UP");
                            break;
                        case 2:
                            this.shoot(current,Direction.RIGHT);
                             System.out.println("Right");
                            break;
                        case 3:
                            this.shoot(current,Direction.DOWN);
                             System.out.println("down");
                            break;
                        case 4:
                            this.shoot(current,Direction.LEFT);
                             System.out.println("left");
                            break;
                    }
                    break;
                case mine:
                    System.out.println("Je pose une mine");
                    //this.mine(m);
                    break;        
                case shield:
                    System.out.println("J'utilise mon shield");
                    break;
            }
                
            System.out.println("Next ?");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        }   
    }
    
    public void checkMoveFighter(Fighter f, Coord coord)
    {
        Coord current = this.getElementPosition(f);
        // Calcul des deltas
        int currentX = current.getX();
        int currentY = current.getY();
        int newX = coord.getX();
        int newY = coord.getY();
        if(Math.abs(currentY - newY) <= 1 && Math.abs(currentX - newX) <= 1
                && Math.abs(currentY - newY) <= 1 && Math.abs(currentX - newX) <= 1
                && newY >= 0 && newX >= 0 && newY <= this.rows && newX <= this.rows)
        {
            if(this.arena[coord.getX()][coord.getY()] != null)
            {
                if(!(this.arena[coord.getX()][coord.getY()] instanceof Wall) && !(this.arena[coord.getX()][coord.getY()] instanceof Fighter))
                {
                    this.moveFighter(f, coord);
                }
            } else {
                this.moveFighter(f, coord);
            }
        } else {
            System.out.println("I can't move, X : "+currentX+",Y : "+currentY);
        }
    }
    
    public void moveFighter(Fighter f,Coord coord)
    {
        Coord current = this.getElementPosition(f);
        Object element = this.arena[coord.getX()][coord.getY()];
        if(element instanceof Bomb) 
        {
            this.bomb((Bomb) element);
        }
        else if(element instanceof Mine) 
        {
            this.mine((Mine) element);
        }
        else if(element instanceof EnergyShard)
        {
            this.heal(f);
        }; 
        this.arena[current.getX()][current.getY()] = null;
        this.arena[coord.getX()][coord.getY()] = f;
        this.notifyObserver(Actions.Action.nothing, f);
    }

    public void heal(Fighter f)
    {
        f.setEnergy(f.getEnergy()+50);
        Coord coord = this.getElementPosition(f);
        this.arena[coord.getX()][coord.getY()] = null;
        this.notifyObserver(Actions.Action.nothing,f);
        this.player.playSound(Actions.Action.heal);
    }
    
    /**
     * Cette fonction va permettre de tirer selon une direction et va frapper le premier combattant
     * rencontre 
     * @param shooter
     * @param dir 
     */
    public void shoot(Fighter shooter,Direction dir)
    {
        this.notifyObserver(Actions.Action.nothing,shooter);
        player.playSound(Actions.Action.shoot);
        Coord fighterPosition = this.getElementPosition(shooter);
        int fighterX = fighterPosition.getX();
        int fighterY = fighterPosition.getY();
        switch(dir)
        {
            case UP:
                for(int y = fighterY-1; y >= 0; y--) 
                {
                    Object e = this.arena[fighterX][y];
                    if(e instanceof Fighter)
                    {
                        ((Fighter) e).setEnergy(((Fighter) e).getEnergy() - 30);
                        break;
                    }
                    else if(e instanceof Wall)
                    {
                        System.out.println("Nice one, you shooted a wall !");
                        break;
                    }
                }
                break;
            case DOWN:
                for(int y = fighterY+1; y <= this.rows; y++) 
                {
                    Object e = this.arena[fighterX][y];
                    if(e instanceof Fighter)
                    {
                        ((Fighter) e).setEnergy(((Fighter) e).getEnergy() - 30);
                        break;
                    }
                    else if(e instanceof Wall)
                    {
                        System.out.println("Nice one, you shooted a wall !");
                        break;
                    }
                }
                break;
            case RIGHT:
                for(int x = fighterX+1; x <= this.rows; x++) 
                {
                    Object e = this.arena[x][fighterY];
                    if(e instanceof Fighter)
                    {
                        ((Fighter) e).setEnergy(((Fighter) e).getEnergy() - 30);
                        break;
                    }
                    else if(e instanceof Wall)
                    {
                        System.out.println("Nice one, you shooted a wall !");
                        break;
                    }
                    
                }
                break;
            case LEFT:
                for(int x = fighterX-1; x >= 0; x--) 
                {
                    Object e = this.arena[x][fighterX];
                    if(e instanceof Fighter)
                    {
                        ((Fighter) e).setEnergy(((Fighter) e).getEnergy() - 30);
                        break;
                    }else if(e instanceof Wall)
                    {
                        System.out.println("Nice one, you shooted a wall !");
                        break;
                    }
                    
                }
                break;
        }
        try {    
            Thread.sleep(2000);                  
        } catch (InterruptedException ex) {
            System.out.println("Can't Stop");        
        }
        this.notifyObserver(Actions.Action.nothing,shooter);
    }
    
    public void bomb(Bomb b){       
        this.notifyObserver(Actions.Action.nothing,b);
        player.playSound(Actions.Action.bomb);
        try {    
            Thread.sleep(1000);                  
        } catch (InterruptedException ex) {
            System.out.println("Error while sleep");
        }
        //Parcours des cases voisines
        Coord coord = this.getElementPosition(b);
        ArrayList<Object> elements = this.getVoisins(coord);
        for(Object e : elements)
        {
            if(e instanceof Fighter)
            {
                ((Fighter) e).setEnergy(((Fighter) e).getEnergy() - 50);
            }
        }
        
        this.arena[coord.getX()][coord.getY()] = null;
        this.notifyObserver(Actions.Action.nothing,b);
    }
    
    public ArrayList getVoisins(Coord coord)
    {
        //Parcours des cases voisines
        ArrayList<Object> elements = new ArrayList();
        int x = coord.getX();
        int y = coord.getY();
        if(y - 1 <= 0)
        {
           Object top = this.arena[x][y-1]; 
           elements.add(top);
           if(x - 1 <= 0)
           {
                Object topLeft = this.arena[x-1][y-1];
                elements.add(topLeft);
           }
           if( x + 1 <= this.rows)
           {
               Object topRight = this.arena[x+1][y-1];
               elements.add(topRight);
           }  
        }
        
        if(y + 1 <= this.rows) 
        {
            Object bot = this.arena[x][y+1];
            elements.add(bot);
            if(x - 1 <= 0)
            {
                Object botLeft = this.arena[x-1][y+1];
                elements.add(botLeft);
            }
            if( x + 1 <= this.rows)
            {
                Object botRight = this.arena[x+1][y+1];
                elements.add(botRight);
            }
        }
        
        if(x - 1 <= 0)
        {
            Object left = this.arena[x-1][y];
            elements.add(left);
        }
        
        if(x + 1 <= this.rows) 
        {
            Object right = this.arena[x+1][y];
            elements.add(right);
        }  
        return elements;
    }
    
    public void mine(Mine m){
        //doStuff
       
        this.notifyObserver(Actions.Action.nothing,m);
        player.playSound(Actions.Action.bomb);
        try {    
            Thread.sleep(2000);                  
        } catch (InterruptedException ex) {
            System.out.println("Can't Stop");
        }
        Coord coord = this.getElementPosition(m);
        this.arena[coord.getX()][coord.getY()] = null;
        this.notifyObserver(Actions.Action.nothing,m);
    }
    
    public FighterFactory getFactory() 
    {
        return this.factory;
    }
    public void display()
    {
        for(int y = 0; y < this.rows; y++) 
        {
             for(int x = 0; x < this.rows; x++) 
            {
                System.out.println(this.arena[x][y]+" in "+(x+","+y));  
            }
        }
    }
    
    /**
     * Permet de retourner les coordonnees X et Y de l'element
     * @param element
     *  l'element dont on veut les coordonnes
     * @return
     * Retourne les coordonnes de l'element
     */
    public Coord getElementPosition(Object element)
    {
        for(int y = 0; y < this.arena.length; y++)
        {
            for(int x = 0; x < this.arena.length; x++)
            {
                if(this.arena[x][y] == element)
                {
                    return new Coord(x,y);
                }
            }
        }
        return null;
    }
    
    @Override
    public void addObserver(Observer o) {
        this.obs.add(o);
        
    }

    @Override
    public void removeObserver(Observer o) {
        this.obs.remove(o);
    }

    @Override
    public void notifyObserver(Actions.Action anim, Object f) {
        for(Observer ob : this.obs) {
            ob.update(anim,f);
        }
    }
    
    
    @Override
    public ArrayList<Explosive> getExplosive()
    {
        ArrayList<Explosive> res=new ArrayList();
        for(Object[] ligne:this.arena)
        {
            for(Object e:ligne)
            {
                if(e instanceof Object)
                {
                    res.add((Explosive) e);
                }
            }
        }    
        return res;
    }
    
    // GUETTERS
 
  
    @Override
    public Object[][] getArena()
    {
        return this.arena;
    }
    
    public ArrayList<Fighter> getFighters()
    {
        return this.fighterList;
    }
    
    public void setFighterList(ArrayList<Fighter> f)
    {
        this.fighterList = f;
    }
}
