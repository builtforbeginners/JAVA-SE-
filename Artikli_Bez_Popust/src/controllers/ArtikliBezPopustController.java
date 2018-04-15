/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entity.Artikal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.FindListModel;
import models.TlbArtikliBezPopustModel;
import models.TlbNoviDodadeni;

import view.ArtikliBezPopustView;

/**
 *
 * @author petar
 */
public class ArtikliBezPopustController extends EntityManagerClass {
    
    public ArtikliBezPopustView view;
    public TlbArtikliBezPopustModel tlbartiklibezpopustModel;
    public TlbNoviDodadeni tlbnovidodadeni;
    
    public FindListModel findModel;
    public Artikal artikal;
        
    public List<Artikal> filterList = null;
    public List<Artikal> chekedList = null;
    List<Object> allObject = new ArrayList<>();
    ArrayList<String> lista_sifri = new ArrayList<>();
   
    public String path = "/Users/petarpetrov/Documents/artikli_bez_popust.dat";
    public int artikal_id;
    int index;
    int artikalid;
    int br_marketi = 1;
    
    List<Artikal> findListArtikli = entityManager.createNamedQuery("Artikal.findAll").getResultList();
    
    
    
    public ArtikliBezPopustController(ArtikliBezPopustView view, TlbArtikliBezPopustModel tlbartiklibezpopustModel, FindListModel findModel, TlbNoviDodadeni tlbNoviDodadeni) throws FileNotFoundException, IOException {
               
        this.view = view;
        this.tlbartiklibezpopustModel = tlbartiklibezpopustModel;
        this.findModel = findModel;      
        this.tlbnovidodadeni = tlbNoviDodadeni;
        
              
        findModel.allObjects.addAll(entityManager.createNamedQuery("Artikal.findAll").getResultList());
        
        
      //  while(br_marketi < 2)
      //  {
        
            try ( // New BufferedReader.

                BufferedReader reader = new BufferedReader
                    (new FileReader("/Users/petarpetrov/Documents/artikli_bez_popust/artikli_bez_popust_sp"+br_marketi+".dat"))) {


                while (true) 
                {
                    String line = reader.readLine();
                    //Ako e prazna linija
                    if (line == null)
                    {
                        break;
                    }

                    if(!line.equalsIgnoreCase(""))
                    {
                        index = Integer.parseInt(line);

                        findModel.allObjects.get(index-1).setNaPopust(true);
                       // findModel.allObjects.get(artikalid).setNaPopust(Boolean.TRUE);
                       //Artikal a = (Artikal) findModel.allObjects.stream().filter(u -> u.getArtikalId().equals(artikalid)).findFirst().get();
                      // a.setNaPopust(true);
                    }

                    if(!line.equals(""))
                    {
                        lista_sifri.add(line);
                    }
                }
                // Close it.
            }
          //  br_marketi++;
        //}
        
        tlbartiklibezpopustModel.ArtikliBezPopustModel=findModel.allObjects;   
        
        this.view.btnSearch(new search());
        this.view.txtSearchEnter(new searchEnter());
        this.view.tblShowItem(new ShowItemClick());
        this.view.btnGenerirajArtikli(new GenerirajArtikli());
        this.view.btnSave(new Confirmed());
        
    }
    
    
    public class Confirmed implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            tlbnovidodadeni.NoviDodadeniArtikli= tlbartiklibezpopustModel.editArtikli;
            tlbnovidodadeni.fireTableDataChanged();
            view.gettblArtikliSmeneti().repaint();
            view.gettblShowItem().repaint();
        }
        
    }
    
    //Enter search
    public class searchEnter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {     
            if(view.gettxtSearch().length() > 0)
            {
                int txtSearchint = Integer.parseInt(view.gettxtSearch());
                filterList = findListArtikli.stream().filter(u -> u.getArtikalId().equals(txtSearchint)).collect(Collectors.toList());
                tlbartiklibezpopustModel.ArtikliBezPopustModel = filterList;
                tlbartiklibezpopustModel.fireTableDataChanged();
            }
         
            else if(view.gettxtSearch().isEmpty())
            {
                tlbartiklibezpopustModel.ArtikliBezPopustModel = findListArtikli;
                tlbartiklibezpopustModel.fireTableDataChanged();
            }
        }
        
    }
    
        
    //Button search
    public class search implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(view.gettxtSearch().length() > 0)
            {
                int txtSearchint = Integer.parseInt(view.gettxtSearch());
                filterList = findListArtikli.stream().filter(u -> u.getArtikalId().equals(txtSearchint)).collect(Collectors.toList());
                tlbartiklibezpopustModel.ArtikliBezPopustModel = filterList;
                tlbartiklibezpopustModel.fireTableDataChanged();
            }
         
            else if(view.gettxtSearch().isEmpty())
            {
                tlbartiklibezpopustModel.ArtikliBezPopustModel = findListArtikli;
                tlbartiklibezpopustModel.fireTableDataChanged();
            }
        }
    }
    
    public class ShowItemClick implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e) 
        {                         
            view.setlblNazivClear();
            if(tlbartiklibezpopustModel.editArtikli.size()>1)
            {
                view.setlblNaziv(tlbartiklibezpopustModel.editArtikli.get
                    (tlbartiklibezpopustModel.editArtikli.size()-1).getNaziv());
            }
        }
    }
    
    public class GenerirajArtikli implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            for(int i =0; i < tlbartiklibezpopustModel.editArtikli.size(); i++) 
            {
                lista_sifri.add(String.valueOf(tlbartiklibezpopustModel.editArtikli.get(i).getArtikalId()));
            }
            
            File f = new File(path);
            f.delete(); 
            
            try 
            {
                    boolean createNewFile = f.createNewFile();
                      
                    try (BufferedWriter buf = new BufferedWriter(new FileWriter(path))) 
                    {
                        for(String sifri : lista_sifri)
                        {
                            buf.write(sifri);
                            buf.newLine();
                        }

                        buf.flush();
                        buf.close();
                    }
                        
            } 
            
            catch (IOException ex) 
            {
                Logger.getLogger(ArtikliBezPopustController.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }   
    }
}
