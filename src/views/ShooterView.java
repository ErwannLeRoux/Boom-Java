/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author Erwann
 */
public class ShooterView extends FighterView {
    
    public ShooterView(String path) {
       try {                
          image = ImageIO.read(new File(path));
       } catch (IOException ex) {
           System.out.println("Impossible de charger l'image");
       }
    }  
}
