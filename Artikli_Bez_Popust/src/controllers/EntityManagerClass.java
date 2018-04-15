/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.Serializable;
import javax.persistence.EntityManager;
/**
 *
 * @author petar
 */
public class EntityManagerClass implements Serializable {
    
    public EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    /*
    public EntityManagerClass(EntityManagerFactory emf) 
    {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() 
    {
        return emf.createEntityManager();
    }

    public void create(Barkod newEntity) 
    {
        EntityManager em = null;
        try 
        {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(newEntity);
            em.getTransaction().commit();
        } 
        finally 
        {
            if (em != null) 
            {
                em.close();
            }
        }
    }
    */
    
    
    public Object saveChanges(Object objectToSave)
    {
        try 
        {
            entityManager.getTransaction().begin();
            entityManager.merge(objectToSave);
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
        }
        return objectToSave;
        
    }
    
}
