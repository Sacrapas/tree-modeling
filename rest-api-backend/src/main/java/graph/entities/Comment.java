package graph.entities;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String text;
    @ManyToOne
    private User author;
    @ManyToOne
    private Tree tree;

    public Comment() {
    }

    public Comment(String text, User author, Tree tree) {
        this.text = text;
        this.author = author;
        this.tree = tree;
        author.addComment(this);
        tree.addComment(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User user) {
        this.author = user;
    }

    public Tree getTree() {
        return tree;
    }
}

