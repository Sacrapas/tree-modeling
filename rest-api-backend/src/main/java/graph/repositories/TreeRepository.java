package graph.repositories;

import graph.entities.Tree;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TreeRepository extends CrudRepository<Tree, Long> {
    Tree findById(long id);
    List<Tree> findAll();
    List<Tree> findAllByUser_Username(String username);
}
