/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gamestate;

import java.util.ArrayList;
import java.util.Scanner;
import models.element.Element;
import models.element.Wall;
import models.element.explosives.Bomb;
import models.element.explosives.Explosive;
import models.element.fighters.*;
import models.factories.FighterFactory;
import models.strategies.mapstrat.EnergyStrat;
import models.strategies.mapstrat.MapStrategy;
import models.strategies.mapstrat.WallStrat;
import models.utils.AnimationType;
import models.utils.AvailableColors;
import models.utils.Coord;
import models.utils.Observable;
import models.utils.Observer;
import models.utils.SoundPlayer;
import models.utils.SoundPlayer.SoundType;

/**
 *
 * @author antoine
 */
public class GameState extends AbstractModel implements GetGameState, Observable
{
    
    private ArrayList<Fighter> fighterList;
    
    private Element[][] arena;
    
    private ArrayList<Observer> obs;
    
    private FighterFactory factory;
    
    private int nbPlayers;
    
    private int rows;
    
    private AvailableColors colors;
    
    public GameState(int rows, int nbPlayer)
    {
        this.colors = new AvailableColors();
        
        this.arena = new Element[rows][rows];
        
        this.fighterList = new ArrayList();

        this.factory = new FighterFactory();
        
        this.obs = new ArrayList();
        
        this.nbPlayers = nbPlayer;
        
        this.rows = rows;
    }
    
    public void playRandomIA()
    {
        MapStrategy strat = new WallStrat(10,5);
        MapStrategy stratEnergy = new EnergyStrat(2);
        
        this.arena = strat.generateItems(arena);
        this.arena = stratEnergy.generateItems(arena);
        colors.getColorsAvailable();
        Fighter f1 = this.factory.createFighter("Arthur",'G', "Red"); 
        Fighter f2 = this.factory.createFighter("Arthur",'G', "Blue");  
        Fighter f3 = this.factory.createFighter("Arthur",'G', "Green");  
        Fighter f4 = this.factory.createFighter("Arthur",'G', "Yellow");  
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
        

        this.notifyObserver(AnimationType.none,f1);
        
        while(true) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            this.checkMoveFighter(f1,new Coord(x,y));
            
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
                && Math.abs(currentY - newY) <= 1 && Math.abs(currentX - newX) <= 1)
        {
            if(this.arena[coord.getX()][coord.getY()] != null)
            {
                if(this.arena[coord.getX()][coord.getY()].getClass() != Wall.class)
                {
                    this.moveFighter(f, coord);
                }
            }
            this.moveFighter(f,coord);
        } else {
            System.out.println("I can't move, X : "+currentX+",Y : "+currentY);
        }
    }
    
    public void moveFighter(Fighter f,Coord coord)
    {
        Coord current = this.getElementPosition(f);
        this.arena[coord.getX()][coord.getY()] = f;
        this.arena[current.getX()][current.getY()] = null;
        this.notifyObserver(AnimationType.move, f);
    }

    
    public void shoot(Fighter f)
    {
        //doStuff
        SoundPlayer player = new SoundPlayer();
       
        this.notifyObserver(AnimationType.shoot,f);
        player.playSound(SoundType.bomb);
        try {    
            System.out.println("sleep");
            Thread.sleep(2000);                  
        } catch (InterruptedException ex) {
            System.out.println("Can't Stop");
        
        }
        this.notifyObserver(AnimationType.none,f);
    }
    
    public void bomb(Bomb b){
        //doStuff
        SoundPlayer player = new SoundPlayer();
       
        this.notifyObserver(AnimationType.bomb,b);
        player.playSound(SoundType.bomb);
        try {    
            System.out.println("sleep");
            Thread.sleep(2000);                  
        } catch (InterruptedException ex) {
            System.out.println("Can't Stop");
        }
        Coord coord = this.getElementPosition(b);
        this.arena[coord.getX()][coord.getY()] = null;
        this.notifyObserver(AnimationType.none,b);
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
    public Coord getElementPosition(Element element)
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
    public void notifyObserver(AnimationType anim, Element f) {
        for(Observer ob : this.obs) {
            ob.update(anim,f);
        }
    }
    
    
    @Override
    public ArrayList<Explosive> getExplosive()
    {
        ArrayList<Explosive> res=new ArrayList();
        for(Element[] ligne:this.arena)
        {
            for(Element e:ligne)
            {
                if(e instanceof Element)
                {
                    res.add((Explosive) e);
                }
            }
        }    
        return res;
    }
    
    // GUETTERS
    
    public ArrayList<Fighter> getFighter()
    {
        return this.fighterList;
    }
  
    public Element[][] getArena()
    {
        return this.arena;
    }
    
    public ArrayList<Fighter> getFighters()
    {
        return this.fighterList;
    }
}
