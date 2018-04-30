package graph.repositories;

import graph.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(long id);
    List<Comment> findAllByAuthor_Username(String username);
    List<Comment> findAllByTree_Id(long tree_id);
}