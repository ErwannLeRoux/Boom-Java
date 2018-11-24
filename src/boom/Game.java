/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boom;

import controllers.AbstractController;
import controllers.IAController;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import models.element.explosives.Bomb;
import models.element.explosives.Explosive;
import models.element.fighters.Fighter;
import models.gamestate.AbstractModel;
import models.gamestate.GameState;
import models.gamestate.GameStateProxy;
import models.strategies.fighterstrat.AgressiveStrategy;
import models.strategies.fighterstrat.BalancedStrategy;
import models.strategies.fighterstrat.DefensiveStrategy;
import models.strategies.fighterstrat.FighterStrategy;
import models.strategies.mapstrat.EnergyStrat;
import models.strategies.mapstrat.MapStrategy;
import models.strategies.mapstrat.WallStrat;
import models.utils.Actions;
import models.utils.Coord;
import models.utils.Direction;
import models.utils.JTableModel;
import views.Arena;
import views.MainArena;

/**
 *
 * @author Erwann
 */
public class Game {

    public int players;
    
    public int rowsOrCols;
    
    Game(int players, int rowsOrCols) {
        this.players = players;
        this.rowsOrCols = rowsOrCols;
    }
    
    public void playRandomIA()
    {
        ArrayList<Fighter> f = new ArrayList();
        // Instanciation du modele
        AbstractModel game = new GameState(rowsOrCols);
        
        MapStrategy strat = new WallStrat(10,5);
        MapStrategy stratEnergy = new EnergyStrat(2);
        
        FighterStrategy balanced = new BalancedStrategy();
        FighterStrategy ag = new AgressiveStrategy();
        FighterStrategy def = new DefensiveStrategy();
        
        //Generation de la map
        GameState gameState = (GameState) game;
        strat.generateItems(gameState.getArena(),gameState.getFighters());
        stratEnergy.generateItems(gameState.getArena(),gameState.getFighters());
        //Instanciation des joueurs
        GameStateProxy p1 = null;
        GameStateProxy p2 = null;
        GameStateProxy p3 = null;
        GameStateProxy p4 = null;
        Fighter f1 = null;
        Fighter f2 = null;
        Fighter f3 = null;
        Fighter f4 = null;

            f1 = gameState.getFactory().createFighter("Arthur",'B', "Red",ag); 
            p1 = new GameStateProxy(f1,gameState);
           
      
            f2 = gameState.getFactory().createFighter("Arthur",'B', "Blue",ag);
            p2 = new GameStateProxy(f2,gameState);
       
            f3 = gameState.getFactory().createFighter("Arthur",'B', "Green",ag);  
            p3 = new GameStateProxy(f3,gameState);
     
            f4 = gameState.getFactory().createFighter("Arthur",'B', "Yellow",ag);
            p4 = new GameStateProxy(f4,gameState);
        
            f.add(f1);
            f.add(f2);
            f.add(f3);
            f.add(f4);
            
            gameState.setFighterList(f);
        
        // Instanciation du Controlleur
        AbstractController controler = new IAController(game);
        
        // Instanciation de la vue
        Arena arena0 = new Arena(gameState,controler);
        Arena arena = new Arena(p1,controler);
        arena.setTitle(""+f1.getColor());
        Arena arena1 = new Arena(p2,controler);
        arena1.setTitle(""+f2.getColor());
        Arena arena2 = new Arena(p3,controler);
        arena2.setTitle(""+f3.getColor());
        Arena arena3 = new Arena(p4,controler);
        arena3.setTitle(""+f4.getColor());
        
        JTableModel m = new JTableModel(gameState.getFighters());
        MainArena a = new MainArena(m,gameState);
        
        
        gameState.addObserver(arena);
        gameState.addObserver(a);
        gameState.addObserver(arena1);
        gameState.addObserver(arena2);
        gameState.addObserver(arena3);
        gameState.addObserver(arena0);
        
        Explosive b1 = new Bomb(f1);
        Explosive b2 = new Bomb(f2);
        Explosive b3 = new Bomb(f3);
        Explosive b4 = new Bomb(f4);
        
        
        gameState.getArena()[4][4] = f1;
        gameState.getArena()[5][5] = f2;
        gameState.getArena()[5][4] = f3;
        gameState.getArena()[4][5] = f4;
        
        gameState.getArena()[1][1] = b1;
        gameState.getArena()[1][2] = b2;
        gameState.getArena()[1][3] = b3;
        gameState.getArena()[1][4] = b4;
        
        
        
        gameState.notifyObserver(Actions.Action.nothing,f3);
        
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
            
           
            Coord currentCoord = gameState.getElementPosition(current);
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
                    gameState.checkMoveFighter(current,new Coord(currentCoord.getX()+moveX,currentCoord.getY()+moveY));    
                    break;
                case shoot:
                    int chooseDir = r.nextInt(4 + 1 - 1) + 1; 
                   
                    switch(chooseDir)
                    {
                        case 1:
                            gameState.shoot(current,Direction.UP);
                             System.out.println("UP");
                            break;
                        case 2:
                            gameState.shoot(current,Direction.RIGHT);
                             System.out.println("Right");
                            break;
                        case 3:
                            gameState.shoot(current,Direction.DOWN);
                             System.out.println("down");
                            break;
                        case 4:
                            gameState.shoot(current,Direction.LEFT);
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
    
    
}
