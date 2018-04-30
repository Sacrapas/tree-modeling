package graph;

import graph.entities.Comment;
import graph.entities.Tree;
import graph.entities.User;
import graph.repositories.CommentRepository;
import graph.repositories.TreeRepository;
import graph.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository    userRepository;
    private TreeRepository    treeRepository;
    private CommentRepository commentRepository;

    @Autowired
    public DataLoader(
            UserRepository    userRepository,
            TreeRepository    treeRepository,
            CommentRepository commentRepository) {
        this.userRepository    = userRepository;
        this.treeRepository    = treeRepository;
        this.commentRepository = commentRepository;
    }

    public void run(ApplicationArguments args) throws IOException, URISyntaxException {

        // some users
        User vasek   = new User("vasek"  );
        User sundar  = new User("sundar" );
        User jared   = new User("jared"  );
        User richard = new User("richard");
        userRepository.save(vasek);
        userRepository.save(sundar);
        userRepository.save(jared);
        userRepository.save(richard);


        // some trees TODO: read tree's values from /resources/tree_?.json
        String tree_1_value = "{\"key\": 1}";
        String tree_2_value = "{\"key\": 2}";
        String tree_3_value = "{\"key\": 3}";
        String tree_4_value = "{\"key\": 4}";
        Tree tree_1 = new Tree("tree_1", tree_1_value, vasek);
        Tree tree_2 = new Tree("tree_1", tree_1_value, vasek);
        Tree tree_3 = new Tree("tree_1", tree_1_value, sundar);
        Tree tree_4 = new Tree("tree_1", tree_1_value, jared);
        userRepository.save(vasek);
        userRepository.save(sundar);
        userRepository.save(jared);

//        treeRepository.save(tree_1);
//        treeRepository.save(tree_2);
//        treeRepository.save(tree_3);
//        treeRepository.save(tree_4);


        // some comments
        Comment comment_1 = new Comment("this is my first tree", vasek , tree_1);
        Comment comment_2 = new Comment("cool tree, man!"      , vasek , tree_3);
        Comment comment_3 = new Comment("waiting for update"   , vasek , tree_4);
        Comment comment_4 = new Comment("this is nice"         , sundar, tree_1);
        Comment comment_5 = new Comment("this is bad"          , sundar, tree_4);
        Comment comment_6 = new Comment("Bro, I don't have any trees now, where's the button to create it?", richard, tree_1);
        treeRepository.save(tree_1);
        treeRepository.save(tree_3);
        treeRepository.save(tree_4);

        userRepository.save(vasek);
        userRepository.save(sundar);
        userRepository.save(richard);


        //
//        userRepository.save(vasek);
//        userRepository.save(sundar);
//        userRepository.save(richard);
//
//        commentRepository.save(comment_1);
//        commentRepository.save(comment_2);
//        commentRepository.save(comment_3);
//        commentRepository.save(comment_4);
//        commentRepository.save(comment_5);
//        commentRepository.save(comment_6);


        // String tree_1 = new String(Files.readAllBytes(Paths.get(getClass().getResource("ad.txt").toURI())));
        // String tree_1 = new String(Files.readAllBytes(Paths.get(getClass().getResource("tree_1.json").toURI())));
        // String tree_1 = new String(Files.readAllBytes(Paths.get("../tree_1.json")), StandardCharsets.UTF_8);
        // System.out.println(tree_1);
    }
}
