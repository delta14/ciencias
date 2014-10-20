/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import mx.unam.fciencias.model.dto.AlumnoDto;


public abstract class AbstractDAO<T> implements Serializable{

    protected EntityManager em;
    protected Class<T> clase;

    public AbstractDAO(Class<T> c) {
        this.em = Persistence.createEntityManagerFactory("cienciasPU").createEntityManager();
        clase = c;
    }

    
    public void create(T t) {
        em.getTransaction().begin();
        em.persist(t);
         em.getTransaction().commit();
    }

    public T find(Long id) {
        return em.find(clase, id);
    }

    public T merge(T t) {
         em.getTransaction().begin();
         T tl= em.merge(t);
         em.getTransaction().commit();
         return tl;
    }

    public void delete(Long id) {
        T t = em.find(clase, id);
        if (t != null) {
             em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }
    }

    public EntityManager getEm() {
        return em;
    }
}
