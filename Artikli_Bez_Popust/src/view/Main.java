/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ArtikliBezPopustController;
import javax.naming.NamingException;
import javax.swing.JFrame;
import models.FindListModel;
import models.TlbArtikliBezPopustModel;
import models.TlbNoviDodadeni;

/**
 *
 * @author petar
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws NamingException, Exception 
    {
  
        TlbArtikliBezPopustModel tlbArtikliBezPopustModel = new TlbArtikliBezPopustModel();
        TlbNoviDodadeni tlbNoviDodadeni = new TlbNoviDodadeni();
        FindListModel findModel = new FindListModel();
               
        ArtikliBezPopustView view = new ArtikliBezPopustView(tlbArtikliBezPopustModel,findModel, tlbNoviDodadeni);
    
        ArtikliBezPopustController controller = new ArtikliBezPopustController(view, tlbArtikliBezPopustModel, findModel, tlbNoviDodadeni);
        
        view.setVisible(true);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    } 
}
