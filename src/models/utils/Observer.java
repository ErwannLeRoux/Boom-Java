
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.utils;

import models.element.Element;
import models.element.explosives.Bomb;



/**
 *
 * @author Erwann
 */
public interface Observer {
    public void update(AnimationType anim, Element e);
}
