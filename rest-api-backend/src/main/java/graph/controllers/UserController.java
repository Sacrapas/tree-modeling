package graph.controllers;

import graph.dtos.CommentDTO;
import graph.dtos.UserDTO;
import graph.repositories.CommentRepository;
import graph.repositories.TreeRepository;
import graph.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private UserRepository userRepository;
    private TreeRepository treeRepository;
    private CommentRepository commentRepository;

    @Autowired
    public UserController(
            UserRepository userRepository,
            TreeRepository treeRepository,
            CommentRepository commentRepository) {
        this.userRepository    = userRepository;
        this.treeRepository    = treeRepository;
        this.commentRepository = commentRepository;
    }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public void create(@RequestBody Map<String, String> jsonBody) {
    //     userRepository.save(new User(jsonBody.get("username")));
    // }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAll() {
        return userRepository.findAll()
            .stream()
            .map(UserDTO::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{username}/trees")
    @ResponseStatus(HttpStatus.OK)
    public List<Long> getTrees(@PathVariable String username) {
        return treeRepository.findAllByUser_Username(username)
            .stream()
            .map(m -> m.getId())
            .collect(Collectors.toList());
    }

    @GetMapping("/{username}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getComments(@PathVariable String username) {
        return commentRepository.findAllByAuthor_Username(username)
            .stream()
            .map(CommentDTO::new)
            .collect(Collectors.toList());
    }

}
