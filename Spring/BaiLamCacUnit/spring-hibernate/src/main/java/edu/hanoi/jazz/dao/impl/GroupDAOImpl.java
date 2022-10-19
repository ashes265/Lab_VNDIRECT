package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.dao.model.Group;
import org.apache.derby.vti.Restriction;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {
    private final static Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(Group group) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.save(group);
//            session.flush();
//            session.getTransaction().begin();
//            session.saveOrUpdate(group);
//            session.getTransaction().commit();
            LOGGER.info("Save group " + group.getName() + " done!");
        } finally {
            session.close();
        }
        System.out.println(sessionFactory + " : Insert group " + group.getId() + " successfull");
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getObject().openSession();
        Query query = session.createQuery("from Group");
        try {
            return (List<Group>) query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getObject().openSession();
        Group group = session.get(Group.class, id);
        if (group == null) return;
        session.getTransaction().begin();
        session.delete(group);
        session.flush();
        session.getTransaction().commit();

        LOGGER.info("Delete group " + group.getName() + " successfull");
        session.close();
    }

    @Override
    public void update(Group group) {
        Session session = sessionFactory.getObject().openSession();
        group = (Group) session.merge(group);
        session.getTransaction().begin();
        session.save(group);
        session.flush();
        session.getTransaction().commit();
        LOGGER.info("Update group: " + group.getName() + " successfull!");
        session.close();
    }

    @Override
    public Group get(int id) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(Group.class, id);
    }

    @Override
    public List<Group> listFilter(String filter) {
        Session session = sessionFactory.getObject().openSession();
        if (filter == null || filter.length() < 1) {
            Query query = session.createQuery("from Group");
            return (List<Group>) query.list();
        }
//        Criteria criteria=session.createCriteria(Group.class);
//        criteria.add(Restrictions.like("name","%"+filter+"%", MatchMode.ANYWHERE));
        //        return new ArrayList<Group>(criteria.list());

        Query query = session.createQuery("from Group where name like :groupName");
        query.setParameter("groupName", "%" + filter + "%");
        return (List<Group>) query.list();
    }
}
