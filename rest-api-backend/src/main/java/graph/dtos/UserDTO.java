package graph.dtos;

import graph.entities.User;

import java.util.List;

public class UserDTO {
    private long id;
    private String username;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
