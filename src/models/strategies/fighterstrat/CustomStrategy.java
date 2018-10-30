
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe permettant de creer une strategie selon des ratios parametres et un choix intelligent des actions.
 * Par exemple si aucun adversaire n'est dans la ligne de mir on ne tirera pas ou bien si on a plus de munitions on ne tirer
 * pas
 * @author Erwann
 */
public class CustomStrategy extends GeneralStrategy {
    
    public CustomStrategy(double move, double shot, double shield, double bomb, double mine) {
        super(move, shot, shield, bomb, mine);
    }

    
    /*
    public Actions doAction(ArrayList<Elements> objs, ArrayList<Explosives> stuff, int shotNumber)
    {
        return Actions.nothing;
    }
    */
    
}
