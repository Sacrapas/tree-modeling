package graph.controllers;

import graph.dtos.CommentDTO;
import graph.dtos.TreeDTO;
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
import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;

@RestController
@RequestMapping("/trees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TreeController {

    private UserRepository userRepository;
    private TreeRepository treeRepository;
    private CommentRepository commentRepository;

    @Autowired
    public TreeController(
            UserRepository userRepository,
            TreeRepository treeRepository,
            CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.treeRepository = treeRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TreeDTO> getAll() {
        return treeRepository.findAll()
            .stream()
            .map(tree -> new TreeDTO(tree, true))
            .collect(Collectors.toList());
    }

    @GetMapping("/{tree_id}")
    @ResponseStatus(HttpStatus.OK)
    public TreeDTO getOne(@PathVariable long tree_id) {
        return new TreeDTO(treeRepository.findById(tree_id));
    }

    @GetMapping("/{tree_id}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getComments(@PathVariable long tree_id) {
        return commentRepository.findAllByTree_Id(tree_id)
            .stream()
            .map(CommentDTO::new)
            .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TreeDTO tree) {
        // hardcode:, w/o auth only vasek you can create trees
        User vasek = userRepository.findByUsername("vasek");
        treeRepository.save(new Tree(tree.getTitle(), tree.getValue(), vasek));
    }

    @PatchMapping("/{tree_id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @RequestBody TreeDTO tree_upd,
            @PathVariable long tree_id,
            HttpServletResponse response) throws IOException {
        Tree tree = treeRepository.findById(tree_id);

        // hardcode:, w/o auth only vasek you can update trees
        User vasek = userRepository.findByUsername("vasek");
        if (tree.getUser() != vasek) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        tree.setTitle(tree_upd.getTitle());
        tree.setValue(tree_upd.getValue());
        treeRepository.save(tree);
    }

    @DeleteMapping("/{tree_id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable long tree_id,
            HttpServletResponse response) throws IOException {
        Tree tree = treeRepository.findById(tree_id);

        // hardcode:, w/o auth only vasek you can update trees
        User vasek = userRepository.findByUsername("vasek");
        if (tree.getUser() != vasek) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        treeRepository.delete(tree);
    }

}
