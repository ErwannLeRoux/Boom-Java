/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boom;

/**
 *
 * @author Erwann
 */
public class Boom {

    private static final int players = 4;
    
    private static final int rowsOrCols = 10;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Game game = new Game(players,rowsOrCols);
        game.playRandomIA();
    }   
}
