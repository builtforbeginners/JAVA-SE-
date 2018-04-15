/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import entity.Artikal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author petar
 */
public class FindListModel extends AbstractListModel 
{
    public List<Artikal> allObjects = new  ArrayList<>();
    public List<Artikal> findObjectsList = new ArrayList<>();
    
    @Override
    public int getSize() 
    {
      return allObjects.size();
    }
    @Override
    public Object getElementAt(int index) 
    {
     return allObjects.get(index);
    }
}
