package graph.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tree {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;
    private String value;
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public Tree() {
    }

    public Tree(String title, String value, User user) {
        this.title = title;
        this.value = value;
        this.user  = user;
        this.comments = new HashSet<>();
        user.addTree(this);
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

