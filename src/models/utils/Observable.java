/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.utils;

import models.element.Element;


/**
 *
 * @author Erwann
 */
public interface Observable {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver(AnimationType anim, Element f);
}
