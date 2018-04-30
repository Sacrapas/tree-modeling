package graph.dtos;

import graph.entities.Comment;

public class CommentDTO {
    private long id;
    private String author;
    private long tree_id;
    private String tree_title;
    private String text;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor().getUsername();
        this.tree_id = comment.getTree().getId();
        this.tree_title = comment.getTree().getTitle();
        this.text = comment.getText();
    }

    public CommentDTO(long tree_id, String text) {
        this.tree_id = tree_id;
        this.text = text;
    }

    public CommentDTO() {
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public long getTree_id() {
        return tree_id;
    }

    public String getTree_title() {
        return tree_title;
    }

    public String getText() {
        return text;
    }
}
