/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.GameState;

import java.util.ArrayList;
import models.Element.Fighters.Fighter;
import models.Element.Explosives.Explosive;

/**
 *
 * @author antoine
 */
interface GetGameState {
    public abstract ArrayList<Explosive> getExplosive();
}
