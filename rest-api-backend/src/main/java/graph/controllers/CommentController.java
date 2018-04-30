package graph.controllers;

import graph.dtos.CommentDTO;
import graph.dtos.TreeDTO;
import graph.entities.Comment;
import graph.entities.Tree;
import graph.entities.User;
import graph.repositories.CommentRepository;
import graph.repositories.TreeRepository;
import graph.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    private UserRepository userRepository;
    private TreeRepository treeRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentController(
            UserRepository userRepository,
            TreeRepository treeRepository,
            CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.treeRepository = treeRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CommentDTO comment) {
        // hardcode:, w/o auth only vasek you can post comments
        User vasek = userRepository.findByUsername("vasek");
        commentRepository.save(
            new Comment(
                comment.getText(),
                vasek,
                treeRepository.findById(comment.getTree_id())
            )
        );
    }

    @PatchMapping("/{comment_id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @RequestBody CommentDTO comment_upd,
            @PathVariable long comment_id,
            HttpServletResponse response) throws IOException {
        Comment comment = commentRepository.findById(comment_id);

        // hardcode:, w/o auth only vasek you can update comments
        User vasek = userRepository.findByUsername("vasek");
        if (comment.getAuthor() != vasek) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        comment.setText(comment_upd.getText());
        commentRepository.save(comment);
    }

    @DeleteMapping("/{comment_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable long comment_id,
            HttpServletResponse response) throws IOException {
        Comment comment = commentRepository.findById(comment_id);

        // hardcode:, w/o auth only vasek you can update comments
        User vasek = userRepository.findByUsername("vasek");
        if (comment.getAuthor() != vasek) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        commentRepository.delete(comment);
    }
}
