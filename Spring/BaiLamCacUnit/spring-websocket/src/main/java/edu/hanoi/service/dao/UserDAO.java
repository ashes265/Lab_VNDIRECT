package edu.hanoi.service.dao;

import edu.hanoi.spring.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> list();
//    public void addBatch();
    public String insert(User user);
    public User get(String username);
    public void delete(String name);
    public void update(User user);
}
