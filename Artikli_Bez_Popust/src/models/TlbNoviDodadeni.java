/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.Artikal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author petar
 */
public class TlbNoviDodadeni extends AbstractTableModel { 
    
    String columns[] = new String[]{"Артикал шифра","Назив"};
    
    public List<Artikal> NoviDodadeniArtikli = new ArrayList<>();
        
    @Override
    public int getRowCount() 
    {
        return NoviDodadeniArtikli.size();
    }
    
    @Override
    public Class getColumnClass(int c) 
    {
        return getValueAt(0, c).getClass();   
    }

    @Override
    public int getColumnCount() 
    {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) 
    {
        return columns[column];
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
    {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) 
            {
                return false;
            } 
            else 
            {
                return true;
            }
    }
       
    @Override
    public void setValueAt(Object value, int row, int col)
    {    
        fireTableCellUpdated(row, col);   
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0:
                return NoviDodadeniArtikli.get(rowIndex).getArtikalId();
            case 1:
                return NoviDodadeniArtikli.get(rowIndex).getNaziv();
            default:
                return String.class;
        }
   
    }  
    
}
