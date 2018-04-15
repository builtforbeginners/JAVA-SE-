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
import view.DodadiNaPopust;




/**
 *
 * @author petar
 */
public class TlbArtikliBezPopustModel extends AbstractTableModel    {

    String columns[] = new String[]{"Артикал шифра","Објект","Назив","На Попуст","Датум од","Датум до"};
    
    public ArrayList<Integer> artikal_sifra = new ArrayList<>();
   
    //public List<Artikal> dodadinapopust= new ArrayList<>();
    
    public List<Artikal> editArtikli= new ArrayList<>();
    public List<Artikal> ArtikliBezPopustModel = new ArrayList<>();
    
    
    @Override
    public int getRowCount() 
    {
        return ArtikliBezPopustModel.size();
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
        if (col < 2) {
                return false;
            } else {
                return true;
            }
    }
    
    
       
    @Override
    public void setValueAt(Object value, int row, int col)
    {   
        Boolean true_false = ((Boolean)value);
        Artikal novartikal = new Artikal();
       
        
        if(true_false == true) 
        {
            //dodadinapopust.setNaziv(ArtikliBezPopustModel.get(row).getNaziv());
            
            novartikal.setArtikalId(ArtikliBezPopustModel.get(row).getArtikalId());
            //novatikal.setArtikalSifra(ArtikliBezPopustModel.get(row).get());   Barkod da se stavi get
            novartikal.setNaziv(ArtikliBezPopustModel.get(row).getNaziv());
            novartikal.setNaPopust(true_false);
            editArtikli.add(novartikal); 
            //dodadinapopust.add(novartikal);
        }
        else
        {
            novartikal.setArtikalId(ArtikliBezPopustModel.get(row).getArtikalId());
            //novatikal.setArtikalSifra(ArtikliBezPopustModel.get(row).getArtikalSifra());    Barkod da se stavi get
            novartikal.setNaziv(ArtikliBezPopustModel.get(row).getNaziv());
            novartikal.setNaPopust(true_false);
            editArtikli.remove(novartikal); 
        }
        fireTableCellUpdated(row, col);
        
    }
    
   
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {    
        switch(columnIndex)
        {
            case 0:
                return ArtikliBezPopustModel.get(rowIndex).getArtikalId();
            case 1:
                return ArtikliBezPopustModel.get(rowIndex).getObjektId();
            case 2:
                return ArtikliBezPopustModel.get(rowIndex).getNaziv();
            case 3:
                if(ArtikliBezPopustModel.get(rowIndex).getNaPopust()==false)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            case 4:
                return ArtikliBezPopustModel.get(rowIndex).getDatumOd();
            case 5:
                return ArtikliBezPopustModel.get(rowIndex).getDatumDo();
            default:
                return String.class;
        }
    }  

}
