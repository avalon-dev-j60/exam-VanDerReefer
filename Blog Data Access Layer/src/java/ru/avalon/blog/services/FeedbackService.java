package ru.avalon.blog.services;

import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import ru.avalon.blog.entities.Feedback;

@Stateless
public class FeedbackService {
    
    @PersistenceContext(unitName = "Blog-PU")
    EntityManager em;
    
    public void create (Feedback feedback) {
        em.persist(feedback);
    }
    
    public void update (Feedback feedback) {
        em.merge(feedback);  
    }
    
    public void delete (Feedback feedback) {
        em.remove(feedback);  
    }
    
    public Feedback find(long id) {
        try {return em.createNamedQuery("find-feedbacks-by-id", Feedback.class)
                .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Feedback> all() {
        try {
            return em.createNamedQuery("find-all-feedbacks", Feedback.class)
                    .getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    } 
}