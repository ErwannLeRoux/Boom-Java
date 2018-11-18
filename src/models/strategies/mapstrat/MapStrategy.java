
package models.strategies.mapstrat;

import models.element.Element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erwann
 */
public interface MapStrategy {
    public Element[][] generateItems(Element[][] map);
}
