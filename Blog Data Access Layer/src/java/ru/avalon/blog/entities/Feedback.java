package ru.avalon.blog.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@NamedQueries({
@NamedQuery(
name = "find-all-feedbacks",
        query = "SELECT item " +
                "FROM Feedback AS item"
        ),
 
    @NamedQuery(
name = "find-feedbacks-by-id",
        query = "SELECT item "
            + "FROM Feedback AS item "
            + "WHERE item.id = :id "
        )
        
})

@Entity
public class Feedback  implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "LONG VARCHAR")
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
     protected Feedback() {
    }
     
    public Feedback( User author, String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

  
    
            
    
}
