package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;

import java.util.List;

public interface UserDAO {
    public void insert(User user);

    public List<User> list();

    public List<User> listFilter(Integer id);

    public User get(String name);

    public void delete(String name);

    public List<User> listOlder();

    public int avarageAge();

    public List<User> page(int page);
    public List<User> listUserByNativeSQL();
    public void addBatch();

}
