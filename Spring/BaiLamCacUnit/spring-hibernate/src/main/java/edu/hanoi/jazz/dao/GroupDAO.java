package edu.hanoi.jazz.dao;

import edu.hanoi.jazz.dao.model.Group;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface GroupDAO {
    public void insert(Group group);
    public List<Group> list();
    public void delete(int id);
    public void update(Group group);
    public Group get(int id);
    public List<Group> listFilter(String filter);
}
