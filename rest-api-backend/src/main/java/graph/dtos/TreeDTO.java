package graph.dtos;

import graph.entities.Tree;

public class TreeDTO {

    private long id;
    private String username;
    private String title;
    private int comments;
    private String value;

    public TreeDTO(Tree tree) {
        this.id = tree.getId();
        this.username = tree.getUser().getUsername();
        this.title = tree.getTitle();
        this.comments = tree.getComments().size();
        this.value = tree.getValue();
    }

    public TreeDTO(Tree tree, boolean short_version) {
        this.id = tree.getId();
        this.username = tree.getUser().getUsername();
        this.title = tree.getTitle();
        this.comments = tree.getComments().size();
    }

    public TreeDTO(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public TreeDTO() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public int getComments() {
        return comments;
    }

    public String getValue() {
        return value;
    }
}
