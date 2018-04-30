package graph.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Tree> trees;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public User() {
    }

    public User(String username) {
        this.username = username;
        this.trees = new HashSet<>();
        this.comments = new HashSet<>();
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public void addTree(Tree tree) {
        this.trees.add(tree);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Set<Tree> getTrees() {
        return trees;
    }

    public void setTrees(Set<Tree> trees) {
        this.trees = trees;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
