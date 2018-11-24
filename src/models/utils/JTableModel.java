/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.utils;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import models.element.fighters.Fighter;
/**
 *
 * @author Erwann
 */
public class JTableModel extends AbstractTableModel{
    
    private ArrayList<Fighter> fighterList;
    
    private String[] entetes = { "Pseudo","Vie","balles","bombes","mines"};
    
    public JTableModel(ArrayList<Fighter> f)
    {
        this.fighterList = f;
    }

    @Override
    public int getRowCount() {
        return this.fighterList.size();
    }

    @Override
    public int getColumnCount() {
        return this.entetes.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: 
                return this.fighterList.get(rowIndex).getName();
            case 1:
                return this.fighterList.get(rowIndex).getEnergy();
            case 2:
                return this.fighterList.get(rowIndex).getNb_shot();
            case 3:
                return this.fighterList.get(rowIndex).getNb_bomb();
            case 4:
                return this.fighterList.get(rowIndex).getNb_mine();   
           
        }
        return null;
    }
}
